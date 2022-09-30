package pl.migibud.studentcourseapp.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public
class StudentServiceImpl {

    private final StudentRepository studentRepository;

    List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    Student getStudentById(Long id){
        return studentRepository
                .findById(id)
                .orElseThrow(()->new IllegalArgumentException("Student id does not exist: "+id));
    }

    Student createStudent(Student student){
        return studentRepository.save(student);
    }

}
