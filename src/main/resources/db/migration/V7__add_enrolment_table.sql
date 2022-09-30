create table enrolment(
    id bigint auto_increment primary key,
    student_id bigint not null,
    course_id bigint not null,
    created_at datetime
);
