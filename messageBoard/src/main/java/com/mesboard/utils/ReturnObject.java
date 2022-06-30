package com.mesboard.utils;
import java.util.HashMap;

/**
 * 2021/9/16
 */
public class ReturnObject extends HashMap<String,Object> {


    public static ReturnObject success() {
        ReturnObject returnObject = new ReturnObject();
        returnObject.put("code", 1);

        return returnObject;
    }

    public static ReturnObject success(String message) {
        ReturnObject returnObject = new ReturnObject();
        returnObject.put("code", 1);
        returnObject.put("message", message);
        return returnObject;
    }

    public static ReturnObject success(Object object) {
        ReturnObject returnObject = new ReturnObject();
        returnObject.put("code", 1);
        returnObject.put("data",object);
        return returnObject;
    }

    public static ReturnObject fail(String message) {
        ReturnObject returnObject = new ReturnObject();
        returnObject.put("code", 0);
        returnObject.put("message", message);

        return returnObject;
    }
}
