package com.perscholas.listeners;

import java.time.LocalDateTime;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletListener implements ServletRequestAttributeListener{
	
	@Override
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
        System.out.println("Request attribute added at: " + LocalDateTime.now());
    }

	@Override
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
        System.out.println("Request attribute removed at: " + LocalDateTime.now());
    }

	@Override
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
        System.out.println("Attribute replaced at: " + LocalDateTime.now());
    }
}
