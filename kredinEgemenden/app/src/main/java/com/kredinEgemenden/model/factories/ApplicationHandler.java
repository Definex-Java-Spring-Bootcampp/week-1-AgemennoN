

package com.kredinEgemenden.model.factories;

import com.kredinEgemenden.enums.ProductType;
import com.kredinEgemenden.model.Application;
import com.kredinEgemenden.model.Loan;
import com.kredinEgemenden.model.Product;
import com.kredinEgemenden.model.User;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ApplicationHandler {
    public static List<Application> applicationList = new ArrayList<>();
    
    public static Application createApplication(Product product, User user, LocalDateTime applicationDate){
        Application application = new Application(product, user, applicationDate);
        
        applicationList.add(application);
        return application;
    }

    public static Application getLoanApplicationWithMostAmount(){
        Application maxAmountApplication = applicationList.stream()
                .filter(appplication -> appplication.getProduct().getProductType() == ProductType.Loan)
                .max(Comparator.comparing(application -> ((Loan)application.getProduct()).getAmount()))
                .orElse(null);
        
        return maxAmountApplication;
    }
    
    public static List<Application> getApplicationsForLastMonths(int monthNumber){
        LocalDateTime thresholdDate = LocalDateTime.now().minusMonths(monthNumber);
        List<Application> appList;
        appList = applicationList.stream()
                .filter(app -> app.getApplicationDate().isAfter(thresholdDate))
                .toList();
        return appList;
    }
    
    public static ArrayList<Application> getApplicationsOfTheUserByEmail(String email){
        return UserHandler.getApplicationsOfTheUserByEmail(email);
    }
    
}
