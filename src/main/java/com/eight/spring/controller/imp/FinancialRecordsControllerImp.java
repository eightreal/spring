package com.eight.spring.controller.imp;

import com.eight.spring.controller.FinancialRecordsController;
import com.eight.spring.service.FinancialRecordsService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/financial")
public class FinancialRecordsControllerImp implements FinancialRecordsController {

    private FinancialRecordsService financialRecordsService;

    @Autowired
    public FinancialRecordsControllerImp(
            FinancialRecordsService financialRecordsService){
        this.financialRecordsService = financialRecordsService;
    }

    @Override
    @RequestMapping(value = "/add_new/{num}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity addNewItemController(@PathVariable("num") int num) {
        return this.financialRecordsService.addNewItem(num);
    }

    @Override
    @RequestMapping(value = "/get_by_id",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity getItemById(@RequestBody ObjectNode requestBody) {
        return this.financialRecordsService.getItemByItem(requestBody);
    }

    @Override
    @RequestMapping(value = "/get_last_item",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity getLastItem() {
        return this.financialRecordsService.getLastItem();
    }

    @Override
    @RequestMapping(value = "/delete_by_id",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity deleteItemById(@RequestBody ObjectNode requestBody) {
        return this.financialRecordsService.deleteItemById(requestBody);
    }
}
