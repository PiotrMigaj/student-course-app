package pl.migibud.studentcourseapp.enrolment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.migibud.studentcourseapp.student.Student;

import java.util.List;

@Service
@RequiredArgsConstructor
class EnrolmentServiceImpl {

    private final EnrolmentRepository enrolmentRepository;

    List<Enrolment> getAllEnrolments(){
        return enrolmentRepository.findAll();
    }

    public Enrolment addEnrolment(Enrolment enrolment){
        return enrolmentRepository.save(enrolment);
    }

    Enrolment getEnrolmentById(Long id){
        return enrolmentRepository
                .findById(id)
                .orElseThrow(()->new IllegalArgumentException("Enrolment id does not exist: "+id));
    }
}
