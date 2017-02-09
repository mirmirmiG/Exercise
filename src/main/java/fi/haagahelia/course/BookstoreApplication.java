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
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository){
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book(1, "AAA", "aaa", 1990, "a123", 10));
			repository.save(new Book(4, "BBB", "bbb", 2009, "c900", 15));
			
			for (Book book : repository.findAll()){
				log.info(book.toString());
			}
		};
	}
}
