/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kredinEgemenden.model;

import com.kredinEgemenden.enums.LoanType;
import com.kredinEgemenden.enums.ProductType;
import java.math.BigDecimal;


public abstract class Loan implements Product {
    
    private String name;
    private final LoanType loanType;
    private BigDecimal amount;
    private Integer installment;
    private Bank bank;
    private BigDecimal interestRate;
    private final ProductType productType = ProductType.Loan;
    // private Campaign campaign;

    public Loan(String name, LoanType loanType, BigDecimal amount, Integer installment, BigDecimal interestRate) {
        this.name = name;
        this.loanType = loanType;
        this.amount = amount;
        this.installment = installment;
        this.interestRate = interestRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public LoanType getLoanType() {
        return loanType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getInstallment() {
        return installment;
    }

    public void setInstallment(Integer installment) {
        this.installment = installment;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public ProductType getProductType() {
        return productType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Loan{");
        sb.append("name=").append(name);
        sb.append(", loanType=").append(loanType);
        sb.append(", amount=").append(amount);
        sb.append(", installment=").append(installment);
        sb.append(", interestRate=").append(interestRate);
        sb.append(", bank=").append(bank.getName());
        sb.append('}');
        return sb.toString();
    }


    
}
