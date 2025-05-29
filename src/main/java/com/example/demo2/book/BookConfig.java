package com.example.demo2.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class BookConfig {


   /* @Bean
    CommandLineRunner commandLineRunner(BookRepository repository) {
        return args -> {
            Student dario = new Book("dario", LocalDate.of(2001, Month.OCTOBER, 4), "dario@gmail.com"
            );
            Student raquel = new Book("raquel", LocalDate.of(2000, Month.NOVEMBER, 11), "raquel@gmail.com"
            );
            repository.saveAll(
                    List.of(dario, raquel)
            );
        };
    } */


}
