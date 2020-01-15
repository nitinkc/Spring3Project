package com.spring.training.spring3to5.beans.b4javaConfigBeans.javaConfig.implementation;

/**
 * Created by nitin on 12/12/15.
 */
public class HelloWorld {

    private String name;

    public void greetings(String name){
        this.name = name;
        System.out.println("Hi" + name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
