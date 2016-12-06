package fi.haagahelia.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.domain.Book;
import fi.haagahelia.course.domain.BookRepository;
import fi.haagahelia.course.domain.Category;
import fi.haagahelia.course.domain.CategoryRepository;
import fi.haagahelia.course.domain.User;
import fi.haagahelia.course.domain.UserRepository;

@SpringBootApplication
public class BookListApplication {
	private static final Logger log = LoggerFactory.getLogger(BookListApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookListApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("Add a couple of book to the database");
			
			crepository.save(new Category("Science fiction"));
			crepository.save(new Category("Satire"));
			crepository.save(new Category("Drama"));
			crepository.save(new Category("Action and Adventure"));
			crepository.save(new Category("Romance"));
			crepository.save(new Category("Mystery"));
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Self help"));
			crepository.save(new Category("Health"));
			crepository.save(new Category("Guide"));
			crepository.save(new Category("Science"));
			crepository.save(new Category("Children's"));
			crepository.save(new Category("History"));
			crepository.save(new Category("Poetry"));
			crepository.save(new Category("Comics"));
			crepository.save(new Category("Encyclopedias"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Autobiographies"));
			crepository.save(new Category("Journals"));
			
			// Create pre-made test books
			repository.save(new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 
					1995, "0345391802", 7.19, crepository.findByName("Science fiction").get(0)));
			repository.save(new Book("Java For Dummies", "Barry A. Burd",
					2014, "1118407806", 23.73, crepository.findByName("Science").get(0)));
			
			// Create pre-made test users
			User user1 = new User("user", 
					"$2a$10$pw6Z8aFUI6T94OauF08U7ubXlKK9yFubDj1jubtn4QuH3z1Epf8Hu", "USER");
			User user2 = new User("admin", 
					"$2a$10$GZ6VDMDq6LuOS.DyCeOxzujWCGGnkPq7nMwkpvLgysf3.hI81wQg.", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("show all the books in the database");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
