package com.huayu.ssm.service;

import com.huayu.ssm.bean.Emp;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
    public class FileUploadService<T>{
        public List<T> fileUpload(InputStream inputStream,Class<T> cla) throws IOException, IllegalAccessException, InstantiationException {
            //获取excel表格
            Workbook workbook=new HSSFWorkbook(inputStream);
            //获取第一页sheet
            Sheet sheet=workbook.getSheetAt(0);
            //获取一共几行
            int rowNum=sheet.getLastRowNum();
            List<T> list=new ArrayList<>();
            Field[] fields = cla.getDeclaredFields();
            //循环遍历所有行 如果excel有表格头 那么循环就从第二页开始 excel行下标是从0开始
            for(int i=1;i<=rowNum;i++){
                T  object = cla.newInstance();
                //获取每一行
                Row row=sheet.getRow(i);
                //循环表格内容
                for(int j=0;j<fields.length-1;j++){
                    Cell cell = row.getCell(j);
                    String value = getCellValue(cell);
                    if(fields[j+1].getType()==Integer.class){
                        fields[j+1].set(object,Integer.parseInt(value));
                    }else {
                        fields[j+1].set(object,value);
                    }
                    System.out.print(value);
                    System.out.println();
                }

                list.add(object);

            }
            return list;
        }

    public static String getCellValue(Cell cell) {
        String cellValue = "";
        // 以下是判断数据的类型
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC: // 数字
                if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    cellValue = sdf.format(org.apache.poi.ss.usermodel.DateUtil.getJavaDate(cell.getNumericCellValue())).toString();
                } else {
                    DataFormatter dataFormatter = new DataFormatter();
                    cellValue = dataFormatter.formatCellValue(cell);
                }
                break;
            case Cell.CELL_TYPE_STRING: // 字符串
                cellValue = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN: // Boolean
                cellValue = cell.getBooleanCellValue() + "";
                break;
            case Cell.CELL_TYPE_FORMULA: // 公式
                cellValue = cell.getCellFormula() + "";
                break;
            case Cell.CELL_TYPE_BLANK: // 空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: // 故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }


    //下载
    public HSSFWorkbook outPutExcel(String filename,String[] tol,List<T> emplist) throws IllegalAccessException, InstantiationException {
        HSSFWorkbook workbook=new HSSFWorkbook();
        Sheet sheet=workbook.createSheet(filename);
        Row row=sheet.createRow(0);
        int a=0;
        for(int i=0;i<tol.length;i++){
            a++;
            row.createCell(i).setCellValue(tol[i]);
        }
        for(int j=1;j<=emplist.size();j++){
            Row row1=sheet.createRow(j);
            T emp=emplist.get(j-1);
            Field[] fields=emp.getClass().getDeclaredFields();
            for(int c=0;c<a;c++){
                fields[c+1].setAccessible(true);
                row1.createCell(c).setCellValue(fields[c+1].get(emp).toString());
            }
        }
        return workbook;
    }
}
