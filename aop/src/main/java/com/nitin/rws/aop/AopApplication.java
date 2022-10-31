package com.nitin.rws.aop;
import com.nitin.rws.aop.services.PaymentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
		ApplicationContext context= new ClassPathXmlApplicationContext("config.xml");
		PaymentService paymentObject = context.getBean("payment", PaymentService.class);

		//		Auth, print:PaymentStarted
		paymentObject.makePayment(100);

	}
}
