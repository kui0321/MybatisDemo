package com.wsk.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class commonDemo {
    private final static Log logger = LogFactory.getLog(commonDemo.class);

    public static void main(String[] args) {
        String Str = "common";
        logger.debug(Str);
        try{
            String temo = null;
            temo.length();

        }catch (Exception e){
            logger.error(e + "error");
            logger.debug(e + "debug");
        }
    }

}
