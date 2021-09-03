package com.example.hajibootjpa;

import com.example.hajibootjpa.domain.Customer;
import com.example.hajibootjpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootApplication
public class HajibootJpaApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public void run(String... strings) throws Exception {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		Customer created = customerRepository.save(new Customer(null, "Hidetoshi", "Dekisugi"));
		
		System.out.println(created + "is created!");
		
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		Pageable pageable = PageRequest.of(0, 3);
		Page<Customer> page = customerRepository.findAllOrderByName(pageable);
		
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		
		System.out.println("1ページのデータ数=" + page.getSize());
		System.out.println("現在のページ=" + page.getNumber());
		System.out.println("全ページ数=" + page.getTotalPages());
		System.out.println("全データ数=" + page.getTotalElements());
		page.getContent().forEach(System.out::println);
		
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	} 

	public static void main(String[] args) {
		SpringApplication.run(HajibootJpaApplication.class, args);
	}
}