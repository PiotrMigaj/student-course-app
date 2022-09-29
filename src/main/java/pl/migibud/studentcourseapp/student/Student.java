package pl.migibud.studentcourseapp.student;

import lombok.*;
import pl.migibud.studentcourseapp.book.Book;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;
    String email;
    int age;
    @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    Set<Book> books;

    Student(Long id, String firstName, String lastName, String email, int age, Set<Book> books) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.books = books;
        this.books.forEach(book -> book.setStudent(this));
    }

    public void setBooks(Set<Book> books) {
        books.forEach(book -> book.setStudent(this));
    }
}
