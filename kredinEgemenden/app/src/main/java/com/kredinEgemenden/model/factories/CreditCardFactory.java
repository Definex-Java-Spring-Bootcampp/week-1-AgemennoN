

package com.kredinEgemenden.model.factories;

import com.kredinEgemenden.model.Bank;
import com.kredinEgemenden.model.Campaign;
import com.kredinEgemenden.model.Product;
import com.kredinEgemenden.model.CreditCard;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CreditCardFactory extends ProductFactory {
    private static CreditCardFactory instance = null;
    public static List<CreditCard> creditCardList = new ArrayList<>();
    
    private CreditCardFactory() {} //private constructor
    
    public static CreditCardFactory getInstance(){
        if (instance == null){
            instance = new CreditCardFactory();
        }
        return instance;
    }

    public CreditCard createCreditCard(String name, BigDecimal fee ,Bank bank){
        CreditCard cc = new CreditCard(name, fee);
        addToBank(bank, cc);
        cc.setBank(bank);
        
        ProductFactory.productList.add(cc);
        creditCardList.add(cc);
        return cc;
    }
    
    @Override
    public void addToBank(Bank bank, Product product) {
        bank.getCreditCards().add((CreditCard) product);
    }
    
    public static void addCampaignToCreditCard(Campaign campaign, CreditCard cc){
        cc.addCampaign(campaign);
    }
    
    public static List<CreditCard> getSortedCreditCardListByCampaignDescending(){
        List<CreditCard> sortedList;
        sortedList = new ArrayList<>(creditCardList);
        sortedList.sort(Comparator.comparingInt((CreditCard card) -> card.getCampaignList().size())
                          .reversed());
        
        return sortedList;
    }
    
}
