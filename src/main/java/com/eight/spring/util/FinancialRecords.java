package com.eight.spring.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "financial_records")
public class FinancialRecords {
    @Id
    @GeneratedValue
    private int id;
    @Column (name = "datetime")
    private Date dateTime;
    @Column (name = "num")
    private int num;
}
