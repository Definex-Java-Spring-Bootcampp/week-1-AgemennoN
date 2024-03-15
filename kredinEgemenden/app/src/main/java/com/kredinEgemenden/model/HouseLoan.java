package com.kredinEgemenden.model;

import com.kredinEgemenden.enums.LoanType;
import java.math.BigDecimal;


public class HouseLoan extends Loan {

    public HouseLoan(String name, LoanType loanType, BigDecimal amount, Integer installment, BigDecimal interestRate) {
        super(name, loanType, amount, installment, interestRate);
    }
    
}
