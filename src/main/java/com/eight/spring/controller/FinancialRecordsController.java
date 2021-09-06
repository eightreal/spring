package com.eight.spring.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;

public interface FinancialRecordsController {
    public ResponseEntity addNewItemController (int num);
    public ResponseEntity getItemById (ObjectNode requestBody);
    public ResponseEntity getLastItem ();
    public ResponseEntity deleteItemById (ObjectNode requestBody);
}
