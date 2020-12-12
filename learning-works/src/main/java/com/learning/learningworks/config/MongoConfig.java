package com.learning.learningworks.config;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.learning.learningworks.bean.CreditCard;
import com.learning.learningworks.bean.Transaction;
import com.learning.learningworks.bean.User;
import com.learning.learningworks.repo.ICreditCardRepository;
import com.learning.learningworks.repo.ITransactionRepository;
import com.learning.learningworks.repo.IUserRepository;

@Configuration
@EnableMongoRepositories(basePackageClasses = IUserRepository.class)
public class MongoConfig {

	@Bean
	public CommandLineRunner commandLineRunner(IUserRepository userRepo, ICreditCardRepository ccRepo,
			ITransactionRepository tRepo) {

		return String -> {
			ccRepo.save(new CreditCard("112233", "09/09/2024", "123"));
			ccRepo.save(new CreditCard("223344", "02/04/2023", "189"));
			ccRepo.save(new CreditCard("334455", "28/02/2029", "985"));

			ccRepo.save(new CreditCard("445566", "18/03/2022", "884"));
			ccRepo.save(new CreditCard("556677", "26/12/2025", "762"));

			List<String> user1CreditCard = new ArrayList<String>();
			List<String> user2CreditCard = new ArrayList<String>();

			user1CreditCard.add("112233");
			user1CreditCard.add("223344");
			user1CreditCard.add("334455");

			user2CreditCard.add("445566");
			user2CreditCard.add("556677");

			userRepo.save(new User(201, "c1@gmail.com", "A1B2C3", "Chandan", "Reddy", "Male", LocalDate.of(1998, 9, 9),
					user1CreditCard, "India", "SomeAddress_1", "Costumer"));

			userRepo.save(new User(202, "s2@gmail.com", "D1D3C4", "Suresh", "Reddy", "Female",
					LocalDate.of(1998, 2, 13), user2CreditCard, "USA", "SomeAddress_2", "Costumer"));

			userRepo.save(new User(203, "a2@gmail.com", "M2M7N8", "Nani", "Kumar", "Male", LocalDate.of(1996, 9, 23),
					null, "India", "SomeAddress_3", "Admin"));

			tRepo.save(new Transaction("901", "112233", 234.6, "debit", "online", LocalDate.of(2020, 9, 19),
					LocalTime.of(13, 34, 42), "hyd", "192.168.32.109", "success", "501", "for food"));
			tRepo.save(new Transaction("902", "112233", 134.3, "debit", "online", LocalDate.of(2020, 10, 12),
					LocalTime.of(1, 35, 42), "hyd", "192.168.32.109", "success", "502", "paying bill"));
			tRepo.save(new Transaction("903", "112233", 33223.5, "debit", "atm", LocalDate.of(2020, 7, 24),
					LocalTime.of(15, 34, 42), "hyd", "192.168.44.12", "success", "503", "for debt"));

			tRepo.save(new Transaction("904", "223344", 360.0, "debit", "online", LocalDate.of(2020, 8, 2),
					LocalTime.of(3, 8, 42), "hyd", "192.168.32.109", "success", "504", "for A1"));
			tRepo.save(new Transaction("907", "223344", 124.33, "debit", "online", LocalDate.of(2020, 10, 6),
					LocalTime.of(1, 34, 42), "hyd", "192.168.32.109", "success", "505", "for A2"));

			tRepo.save(new Transaction("905", "334455", 12000.0, "debit", "pos", LocalDate.of(2020, 7, 7),
					LocalTime.of(13, 11, 42), "hyd", "192.168.32.109", "success", "506", "for A3"));
			tRepo.save(new Transaction("906", "334455", 9856.8, "debit", "atm", LocalDate.of(2020, 2, 9),
					LocalTime.of(23, 33, 42), "hyd", "192.168.32.109", "success", "507", "for A4"));

			tRepo.save(new Transaction("908", "445566", 2000.0, "debit", "online", LocalDate.of(2020, 7, 19),
					LocalTime.of(13, 34, 42), "hyd", "192.168.32.109", "success", "508", "for A5"));
		};

	}

}
