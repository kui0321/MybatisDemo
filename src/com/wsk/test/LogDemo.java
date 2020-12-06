package com.wsk.test;

import org.apache.log4j.Logger;

public class LogDemo {
    private final static Logger logger = Logger.getLogger(Logger.class);

    public static void main(String[] args) {
        String str = "nihao";
        logger.debug(str);
        try{
            String temp = null;
            temp.length();
        }catch (Exception e){
            logger.error(e+"error");
            logger.debug(e+"debug");
        }
    }
}
