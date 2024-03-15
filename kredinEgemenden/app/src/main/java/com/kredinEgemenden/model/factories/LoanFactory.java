

package com.kredinEgemenden.model.factories;

import com.kredinEgemenden.enums.LoanType;
import com.kredinEgemenden.model.Bank;
import com.kredinEgemenden.model.Product;
import com.kredinEgemenden.model.ConsumerLoan;
import com.kredinEgemenden.model.HouseLoan;
import com.kredinEgemenden.model.VehicleLoan;
import com.kredinEgemenden.model.Loan;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class LoanFactory extends ProductFactory {
    private static LoanFactory instance = null;
    public static List<Loan> loanList = new ArrayList<>();
    
    private LoanFactory() {} //private constructor
    
    public static LoanFactory getInstance(){
        if (instance == null){
            instance = new LoanFactory();
        }
        return instance;
    }

    public Loan createLoan(String name, LoanType lType, BigDecimal amount, Integer installment, BigDecimal interestRate, Bank bank){
        Loan loan;
        switch (lType) {
            case CONSUMER_LOAN -> loan = new ConsumerLoan(name, lType, amount, installment, interestRate);
            case HOUSE_LOAN -> loan = new HouseLoan(name, lType, amount, installment, interestRate);
            case VEHICLE_LOAN -> loan = new VehicleLoan(name, lType, amount, installment, interestRate, Boolean.FALSE);
            default -> throw new AssertionError();
        }
        loan.setBank(bank);
        addToBank(bank, loan);
        
        ProductFactory.productList.add(loan);
        loanList.add(loan);
        return loan;
    }
    
    public Loan createLoan(String name, LoanType lType, BigDecimal amount, Integer installment, BigDecimal interestRate, Boolean isSecondHand, Bank bank){
        Loan loan = new VehicleLoan(name, lType, amount, installment, interestRate, isSecondHand);
        loan.setBank(bank);
        addToBank(bank, loan);
        
        ProductFactory.productList.add(loan);
        loanList.add(loan);
        return loan;
    }
    @Override
    public void addToBank(Bank bank, Product product) {
        bank.getLoanMap()
                .get(((Loan)product).getLoanType())
                .add((Loan)product);
    }
    
}
