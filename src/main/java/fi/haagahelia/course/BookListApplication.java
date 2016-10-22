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

@SpringBootApplication
public class BookListApplication {
	private static final Logger log = LoggerFactory.getLogger(BookListApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookListApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
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
			
			
			repository.save(new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 
					1995, "0345391802", 7.19, crepository.findByName("Science fiction").get(0)));
			repository.save(new Book("Java For Dummies", "Barry A. Burd",
					2014, "1118407806", 23.73, crepository.findByName("Science").get(0)));
			
			log.info("show all the books in the database");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
