package pl.migibud.studentcourseapp.enrolment;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import pl.migibud.studentcourseapp.course.Course;
import pl.migibud.studentcourseapp.student.Student;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
class Enrolment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "student_id")
    Student student;
    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "course_id")
    Course course;
    @CreationTimestamp
    LocalDateTime createdAt;

    Enrolment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }
}
