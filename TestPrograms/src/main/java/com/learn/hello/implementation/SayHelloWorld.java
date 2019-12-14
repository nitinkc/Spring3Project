package com.learn.hello.implementation;

import com.learn.hello.HelloWorld;

public class SayHelloWorld implements HelloWorld {
	
	public void greetings(String name){
		System.out.println("Welcome to the Leaning Session of Spring!!! " + name);
	}
}
