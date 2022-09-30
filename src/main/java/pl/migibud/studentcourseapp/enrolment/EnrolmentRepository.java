package pl.migibud.studentcourseapp.enrolment;

import org.springframework.data.jpa.repository.JpaRepository;

interface EnrolmentRepository extends JpaRepository<Enrolment,Long> {
}
