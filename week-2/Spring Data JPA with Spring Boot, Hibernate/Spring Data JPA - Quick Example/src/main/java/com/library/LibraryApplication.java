package com.library;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Optional;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository repository) {
        return (args) -> {
            System.out.println("\n=== EXECUTING DML OPERATIONS ===");

            // 1. SAVE (Insert)
            repository.save(new Book("Effective Java", "Joshua Bloch"));
            repository.save(new Book("Clean Code", "Robert C. Martin"));
            Book savedBook = repository.save(new Book("Spring in Action", "Craig Walls"));
            System.out.println("Books saved successfully!\n");

            // 2. FIND BY ID (Select)
            Optional<Book> bookOpt = repository.findById(savedBook.getId());
            bookOpt.ifPresent(book -> System.out.println("Found Book by ID: " + book + "\n"));

            // 3. CUSTOM QUERY METHODS
            System.out.println("Finding books by Joshua Bloch:");
            repository.findByAuthor("Joshua Bloch").forEach(book -> System.out.println("-> " + book));
            System.out.println();

            // 4. UPDATE
            if(bookOpt.isPresent()) {
                Book bookToUpdate = bookOpt.get();
                bookToUpdate.setTitle("Spring in Action - 6th Edition");
                repository.save(bookToUpdate);
                System.out.println("Updated Book: " + repository.findById(bookToUpdate.getId()).get() + "\n");
            }

            // 5. DELETE
            repository.deleteById(1L);
            System.out.println("Book with ID 1 deleted. Total dynamic count remaining: " + repository.count());
            System.out.println("================================\n");
        };
    }
}