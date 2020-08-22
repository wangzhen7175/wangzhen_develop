package com.example.demo.service.impl;

import com.example.demo.entity.GenerateId;
import com.example.demo.mapper.GenerateIdMapper;
import com.example.demo.service.GenerateIdService;
import com.example.demo.utils.StringUtil;
import com.example.demo.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
public class GenerateIdServiceImpl implements GenerateIdService {

    @Autowired
    private GenerateIdMapper generateIdMapper;

    @Transactional
    @Override
    public synchronized String  generateId (String idType) {

        //获取当日8位日期格式
        String dateStr = TimeUtil.getDateString8(new Date());
        Date date = TimeUtil.getDate8(new Date());

        GenerateId generateId =  generateIdMapper.getOneByIdType(idType);
        Integer maxCode = 1;
        if(date.compareTo(generateId.getDate())== 0){//日期相等

            maxCode = generateId.getMaxCode();

            generateIdMapper.updateMaxCode(idType, maxCode + 1);
        }else {
            generateId.setDate(date);

            generateId.setIdType(idType);

            generateId.setMaxCode(maxCode + 1);

            generateIdMapper.updateOne(generateId);
        }

        String maxCodeStr = String.format("%05d", maxCode);

        String id = StringUtil.joinString(idType, dateStr, maxCodeStr);

        return id;
    }
}
