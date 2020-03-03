package com.vitechinc.model;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
		OrderService service=(OrderService)context.getBean("oderService");
		Customer customer=new Customer();
		customer.setFirstName("Java");
		customer.setLastName("Technology");
		customer.setId(123);
		customer.setOrderNumber("DC154789");
		service.placeOrder(customer);

	}

}
