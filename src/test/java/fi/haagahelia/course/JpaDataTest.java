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
import fi.haagahelia.course.domain.Category;
import fi.haagahelia.course.domain.CategoryRepository;
import fi.haagahelia.course.domain.User;
import fi.haagahelia.course.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaDataTest {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository repository2;
	
	@Autowired 
	private UserRepository repository3;
	
	// Test searching
	@Test
	public void findByTitle() {
		List<Book> books = repository.findByTitle("The Hitchhiker's Guide to the Galaxy");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Douglas Adams");
	}
	@Test
	public void findByCategory() {
		List<Category> categories = repository2.findByName("Science fiction");
		assertThat(categories.get(0).getName()).isEqualTo("Science fiction");
	}
	@Test
	public void findByUser() {
		User users = repository3.findByUsername("user");
		assertThat(users.getRole()).isEqualTo("USER");
	}	
	
	// Test creating
	@Test
	public void createNewBook() {
		Book book = new Book("Test", "Test", 0000, "012345", 12.34, new Category("Test"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	@Test
	public void createNewCategory() {
		Category category = new Category("Category");
		repository2.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}
	@Test
	public void createNewUser() {
		User user = new User("test", 
				"$2a$10$co9kWslF6lNGQMFzTZUCdeGnJ/d7mNhXAIXM7QcnvcfRpj.Lwjsda", "USER");
		repository3.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	// Test deleting
	@Test
	public void deleteBook() {
		List<Book> book = repository.findByTitle("Test");
		
		if(book != null) {
			repository.delete(book);
		}
	}
	@Test
	public void deleteCategory() {
		List<Category> category = repository2.findByName("Category");
		
		if(category != null) {
			repository2.delete(category);
		}
	}
	@Test
	public void deleteUser() {
		User user = repository3.findByUsername("test");
		
		if(user != null) {
			repository3.delete(user);
		}
	}
}
