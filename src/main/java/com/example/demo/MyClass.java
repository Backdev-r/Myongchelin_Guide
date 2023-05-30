package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyClass {

    private static final Logger logger = LoggerFactory.getLogger(MyClass.class);

    public void myMethod() {
        // 로그 출력

        logger.error("Error log message");
    }
}

