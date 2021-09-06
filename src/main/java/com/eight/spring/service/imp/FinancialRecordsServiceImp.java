package com.eight.spring.service.imp;

import com.eight.spring.dao.FinancialRecordsDao;
import com.eight.spring.service.FinancialRecordsService;
import com.eight.spring.util.FinancialRecords;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FinancialRecordsServiceImp implements FinancialRecordsService {
    private FinancialRecordsDao financialRecordsDao;
    @Autowired
    public FinancialRecordsServiceImp(FinancialRecordsDao financialRecordsDao){
        this.financialRecordsDao = financialRecordsDao;
    }

    @Override
    public ResponseEntity addNewItem(int num) {
        FinancialRecords financialRecords = new FinancialRecords();
        financialRecords.setNum(num);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date date = new Date();
        financialRecords.setDateTime(date);
        String time  = df.format(date);
        financialRecordsDao.save(financialRecords);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.valueToTree(financialRecords);
        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.remove("dateTime");
        objectNode.put("datetime", time);
        return ResponseEntity.ok(objectNode);
    }

    @Override
    public ResponseEntity getItemByItem(ObjectNode requestBody) {
        return null;
    }

    @Override
    public ResponseEntity getLastItem() {
        return null;
    }

    @Override
    public ResponseEntity deleteItemById(ObjectNode requestBody) {
        return null;
    }
}
