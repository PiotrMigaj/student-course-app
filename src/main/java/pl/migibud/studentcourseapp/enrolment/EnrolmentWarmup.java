package pl.migibud.studentcourseapp.enrolment;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.migibud.studentcourseapp.course.Course;
import pl.migibud.studentcourseapp.course.CourseServiceImpl;
import pl.migibud.studentcourseapp.student.Student;
import pl.migibud.studentcourseapp.student.StudentServiceImpl;

@Component
@RequiredArgsConstructor
class EnrolmentWarmup implements ApplicationListener<ContextRefreshedEvent> {

    private final EnrolmentServiceImpl enrolmentService;
    private final CourseServiceImpl courseService;
    private final StudentServiceImpl studentService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (enrolmentService.getAllEnrolments().size()==0){
            Student student = studentService.getStudentById(1L);
            Course course = courseService.getCourseById(1L);
            enrolmentService.addEnrolment(new Enrolment(student,course));
        }
    }
}
