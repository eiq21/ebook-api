package com.ecommerce.ebookapi.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class User {
    public  User(){
        this.createAt = LocalDateTime.now();
    }

    @Id
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    private String password;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    public String getFullName(){
        String fullName = "";
        if(notEmpty(firstName))
           fullName = addToFullName(fullName, firstName);
        if(notEmpty(middleName))
            fullName = addToFullName(fullName, middleName);
        if(notEmpty(lastName))
            fullName = addToFullName(fullName, lastName);
       return fullName;
    };

    private boolean notEmpty(String value){
        return value != null && !value.isEmpty();
    }

    private String addToFullName(String fullName,String name){
        return fullName + name + " ";
    }

}
