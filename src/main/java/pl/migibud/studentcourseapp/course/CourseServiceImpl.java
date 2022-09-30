package pl.migibud.studentcourseapp.course;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl {

    private final CourseRepository courseRepository;

    List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Course createCourse(Course course){
        return courseRepository.save(course);
    }

    public Course getCourseById(Long id){
        return courseRepository
                .findById(id)
                .orElseThrow(()->new IllegalArgumentException("Course id does not exist: "+id));
    }
}
