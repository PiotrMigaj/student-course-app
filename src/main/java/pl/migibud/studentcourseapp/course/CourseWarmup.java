package pl.migibud.studentcourseapp.course;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.migibud.studentcourseapp.book.Book;
import pl.migibud.studentcourseapp.student.Student;
import pl.migibud.studentcourseapp.student.StudentIdCard;
import pl.migibud.studentcourseapp.student.StudentServiceImpl;

import java.util.Set;

@Component
@RequiredArgsConstructor
class CourseWarmup implements ApplicationListener<ContextRefreshedEvent> {

    private final CourseServiceImpl courseService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (courseService.getAllCourses().size()==0){
            courseService.createCourse(new Course("Java fundamentals","IT"));
        }
    }
}
