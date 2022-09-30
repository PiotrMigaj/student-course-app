package pl.migibud.studentcourseapp.student;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.migibud.studentcourseapp.book.Book;

import java.util.Set;

@Component
@RequiredArgsConstructor
class StudentWarmup implements ApplicationListener<ContextRefreshedEvent> {

    private final StudentServiceImpl studentService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (studentService.getAllStudents().size()==0){
            studentService.createStudent(Student.builder()
                    .firstName("Piotr")
                    .lastName("Migaj")
                    .age(30)
                    .email("pmigaj@gmail.com")
                    .books(Set.of(new Book("Java, First Guide."), new Book("SQL Masterclass")))
                    .studentIdCard(new StudentIdCard("AAE123"))
                    .build());
        }
    }
}
