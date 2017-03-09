package fi.haagahelia.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.domain.Book;
import fi.haagahelia.course.domain.BookRepository;
import fi.haagahelia.course.domain.CategoryRepository;
import fi.haagahelia.course.domain.Category;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository){
		return (args) -> {
			log.info("save a couple of categories");
			crepository.save(new Category("IT"));
			crepository.save(new Category("Business"));
			crepository.save(new Category("Law"));
			crepository.save(new Category("Novel"));
			
			
			brepository.save(new Book("AAA", "aaa", 1990, "a123", 10, crepository.findByName("IT").get(0)));
			brepository.save(new Book("BBB", "bbb", 2009, "c900", 15, crepository.findByName("Novel").get(0)));
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()){
				log.info(book.toString());
			}
		};
	}
}
