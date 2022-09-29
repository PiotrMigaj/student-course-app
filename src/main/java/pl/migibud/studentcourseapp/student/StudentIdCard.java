package pl.migibud.studentcourseapp.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "student_id_card")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentIdCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String cardNumber;
    @OneToOne
    @JoinColumn(name = "student_id")
    Student student;

    public StudentIdCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
