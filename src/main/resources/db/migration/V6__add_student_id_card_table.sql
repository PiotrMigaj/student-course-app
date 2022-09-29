create table student_id_card(
    id bigint auto_increment primary key,
    card_number varchar(255) not null,
    student_id bigint,
    FOREIGN KEY (student_id) REFERENCES student(id)
);
