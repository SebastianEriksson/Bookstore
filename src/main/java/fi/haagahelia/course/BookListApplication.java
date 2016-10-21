package fi.haagahelia.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.domain.Book;
import fi.haagahelia.course.domain.BookRepository;

@SpringBootApplication
public class BookListApplication {
	private static final Logger log = LoggerFactory.getLogger(BookListApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookListApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			
			log.info("Add a couple of book to the database");
			repository.save(new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 
					1995, "0345391802", 7.19));
			repository.save(new Book("Java For Dummies", "Barry A. Burd",
					2014, "1118407806", 23.73));
			
			log.info("show all the books in the database");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
