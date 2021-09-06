package com.eight.spring.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;

public interface FinancialRecordsService {
    public ResponseEntity addNewItem(int num);
    public ResponseEntity getItemByItem(ObjectNode requestBody);
    public ResponseEntity getLastItem();
    public ResponseEntity deleteItemById(ObjectNode requestBody);
}
