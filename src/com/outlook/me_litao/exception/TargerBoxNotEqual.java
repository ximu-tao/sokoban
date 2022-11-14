package com.outlook.me_litao.exception;

/**
 * TargerBoxNotEqual
 */
public class TargerBoxNotEqual extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    int targerCount , boxCount;

    public TargerBoxNotEqual(int targerCount, int boxCount){
        this.targerCount = targerCount;
        this.boxCount = boxCount;
    }

    public String getMessage(){
        return "targerCount="+targerCount+",boxCount="+boxCount;
    } 
}