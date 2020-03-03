package com.vitechinc.model;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class OrderServiceImpl implements OrderService {
	private MailSender mailSender;
	private SimpleMailMessage mailMessage;
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setMailMessage(SimpleMailMessage mailMessage) {
		this.mailMessage = mailMessage;
	}


	@Override
	public void placeOrder(Customer customer) {
		SimpleMailMessage msg = new SimpleMailMessage(this.mailMessage);
		msg.setTo("suresh96037@gmail.com");
		msg.setText(
		"Dear " + customer.getFirstName()
		+ customer.getLastName()
		+ ", thank you for placing order. Your order number is "
		+ customer.getOrderNumber());
		try{
		this.mailSender.send(msg);
		}
		catch(MailException ex) {
		// simply log it and go on...
		System.err.println(ex.getMessage());
		}
		
	}

}
