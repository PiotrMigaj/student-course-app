package pl.migibud.studentcourseapp.course;

import org.springframework.data.jpa.repository.JpaRepository;

interface CourseRepository extends JpaRepository<Course,Long> {
}
