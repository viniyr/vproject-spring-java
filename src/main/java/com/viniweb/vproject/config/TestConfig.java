package com.viniweb.vproject.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.viniweb.vproject.entities.Category;
import com.viniweb.vproject.entities.Order;
import com.viniweb.vproject.entities.OrderItem;
import com.viniweb.vproject.entities.Payment;
import com.viniweb.vproject.entities.Product;
import com.viniweb.vproject.entities.User;
import com.viniweb.vproject.entities.enums.OrderStatus;
import com.viniweb.vproject.repositories.CategoryRepository;
import com.viniweb.vproject.repositories.OrderItemRepository;
import com.viniweb.vproject.repositories.OrderRepository;
import com.viniweb.vproject.repositories.ProductRepository;
import com.viniweb.vproject.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Swords");
		
		Product p1 = new Product(null, "Night Sword", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Enchiridion", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Neptur", "Nam eleifend maximus tortor, at mollis.", 9999.0, ""); 
		Product p4 = new Product(null, "Finn Sword", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Adventure time, Vol. 1", "Cras fringilla convallis sem vel faucibus.", 400.96, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat3);
		p2.getCategories().add(cat2);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat1);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		User u1 = new User(null, "Finn Mertens", "finn@gmail.com", "999999999", "123456"); 
		User u2 = new User(null, "Jake the Dog", "jake@gmail.com", "999999992", "123456");
		
		Order o1 = new Order(null, Instant.parse("2021-04-04T19:53:07Z"), OrderStatus.PAID, u1); 
		Order o2 = new Order(null, Instant.parse("2021-03-22T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2); 
		Order o3 = new Order(null, Instant.parse("2021-03-01T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice()); 
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice()); 
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice()); 
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2021-04-04T21:53:07Z"), o1);
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
		
	}
	
	
}
