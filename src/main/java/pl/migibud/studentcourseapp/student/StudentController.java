package pl.migibud.studentcourseapp.student;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
class StudentController {

    private final StudentServiceImpl studentServiceImpl;

    @GetMapping
    ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(studentServiceImpl.getAllStudents());
    }

    @GetMapping("/{id}")
    ResponseEntity<Student> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentServiceImpl.getStudentById(id));
    }

    @PostMapping
    ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student created = studentServiceImpl.createStudent(student);
        return ResponseEntity.created(URI.create("/api/student/"+created.getId())).body(created);
    }

}
