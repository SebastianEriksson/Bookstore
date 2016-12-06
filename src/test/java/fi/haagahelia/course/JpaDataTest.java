package fi.haagahelia.course;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.course.domain.Book;
import fi.haagahelia.course.domain.BookRepository;
import fi.haagahelia.course.domain.CategoryRepository;
import fi.haagahelia.course.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaDataTest {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository repository2;
	
	@Autowired UserRepository repository3;
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("");
		assertThat(books).hasSize(1);
	}
}
