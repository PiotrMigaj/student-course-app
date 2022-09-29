package pl.migibud.studentcourseapp.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import pl.migibud.studentcourseapp.student.Student;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String bookName;
    @CreationTimestamp
    LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    Student student;

    public Book(String bookName) {
        this.bookName = bookName;
    }
}
