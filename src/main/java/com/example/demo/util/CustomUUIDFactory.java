package com.example.demo.util;

public class CustomUUIDFactory {

    private static volatile CustomUUIDFactory instance = null;
    private CustomUUID customUUID = new CustomUUID(0);

    private CustomUUIDFactory() {

    }

    public synchronized static CustomUUIDFactory get() {
        if (instance == null) {
            synchronized (CustomUUIDFactory.class) {
                if (instance == null) {
                    instance = new CustomUUIDFactory();
                }
            }
        }
        return instance;
    }

    public String generate() {
        return customUUID.generate() + "";
    }

}
