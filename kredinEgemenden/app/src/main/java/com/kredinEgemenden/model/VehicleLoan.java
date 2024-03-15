/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kredinEgemenden.model;

import com.kredinEgemenden.enums.LoanType;
import java.math.BigDecimal;

public class VehicleLoan extends Loan {

    private Boolean isVehicleSecondHand;

    public VehicleLoan(String name, LoanType loanType, BigDecimal amount, Integer installment, BigDecimal interestRate, Boolean isVehicleSecondHand) {
        super(name, loanType, amount, installment, interestRate);
        this.isVehicleSecondHand = isVehicleSecondHand;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VehicleLoan{");
        sb.append("isVehicleSecondHand=").append(isVehicleSecondHand);
        sb.append('}');
        return sb.toString();
    }
    
    

}
