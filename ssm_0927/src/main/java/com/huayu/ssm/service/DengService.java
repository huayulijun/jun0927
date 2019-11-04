package com.huayu.ssm.service;

import com.huayu.ssm.bean.Login;
import com.huayu.ssm.mapper.DengLuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DengService {
    @Autowired
    private DengLuMapper dengLuMapper;

    public Login denglu(Login login){
        return dengLuMapper.denglu(login);
    }

}
