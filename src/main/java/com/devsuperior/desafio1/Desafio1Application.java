package com.devsuperior.desafio1;

import com.devsuperior.desafio1.entities.Order;
import com.devsuperior.desafio1.service.OrderService;
import com.devsuperior.desafio1.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class Desafio1Application implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(Desafio1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner le = new Scanner(System.in);
		le.useLocale(Locale.US);

		System.out.println("Digite o código do pedido:");
		int code = le.nextInt();
		System.out.println("Digite o valor básico:");
		double basic = le.nextDouble();
		System.out.println("Digite o desconto:");
		double discount = le.nextDouble();

		Order order = new Order(code, basic, discount);
		double total = orderService.total(order);

		System.out.println("Pedido código " + order.getCode());
		System.out.printf(Locale.US,"Valor total: R$ %.2f%n", total);

		le.close();
		System.exit(0);
	}
}
