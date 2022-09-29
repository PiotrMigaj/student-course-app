alter table book add student_id bigint;
ALTER TABLE book ADD FOREIGN KEY (student_id) REFERENCES student(id);

