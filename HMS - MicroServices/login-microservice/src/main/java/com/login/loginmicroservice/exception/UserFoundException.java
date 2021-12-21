package com.login.loginmicroservice.exception;

public class UserFoundException extends Exception{

    public UserFoundException(){
        super("User already exist!!");
    }

    public UserFoundException(String msg){
        super(msg);
    }
}
