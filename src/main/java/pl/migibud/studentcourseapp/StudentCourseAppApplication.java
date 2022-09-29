package pl.migibud.studentcourseapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.migibud.studentcourseapp.book.Book;
import pl.migibud.studentcourseapp.student.Student;
import pl.migibud.studentcourseapp.student.StudentIdCard;
import pl.migibud.studentcourseapp.student.StudentServiceImpl;

import java.util.Set;

@SpringBootApplication
public class StudentCourseAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentCourseAppApplication.class, args);
    }

    @Bean
    CommandLineRunner run(StudentServiceImpl studentServiceImpl) {
        return args -> {
            studentServiceImpl.addStudent(Student.builder()
                    .firstName("Piotr")
                    .lastName("Migaj")
                    .age(30)
                    .email("pmigaj@gmail.com")
                    .books(Set.of(new Book("Java, First Guide."), new Book("SQL Masterclass")))
                    .studentIdCard(new StudentIdCard("AAE123"))
                    .build());
        };
    }
}
