package com.Sajor.meeting.util;

import javax.servlet.http.*;

public class CounterListener implements HttpSessionListener{
	public static int count;
	public CounterListener(){
		count = 0;
	}
	
	public void sessionCreated(HttpSessionEvent se){
		count++;
		System.out.println("chuanjiang");
	}
	
	public void sessionDestroyed(HttpSessionEvent se){
		System.out.println("xiaohui");
		if(count>0){
			count--;	
		}
	}
}
