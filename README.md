# Gradebook desktop

(This project is a laboratory work on the subject of "Java Language")

### Description

The use of paper student's record books for grading is available not only in Ukraine but also in many other countries. Unfortunately, the scope of the project does not allow to fully show all the possibilities of development of this database, User Interface and backend. However, based on the tasks, it was possible to create a prototype of the record book, which can fully duplicate the paper record book.
In the course of the course work was studied the design of the database from the task, and to its physical implementation. An application was also created that uses data that was added to the database at the stage of physical design.

### Technology

To create a frontend, the Java programming language is used, namely the JavaFX framework, which allows to conveniently create a User Interface for this application.

The programming language Java and Java script were used to create the backend, namely the Spring boot framework for Java and the shvidko(mine) library for Java script.

DBMS postgres is used to create a database

### API

#### Authorization

description | url | method | {body}/params | need token | result
----|----|--------|-------------|------------|-------
create new student gradebook| /users/registration/student | POST | {login, password, fullname, gradebook_number, course_admission, photoURL, group_id} | YES | ok/error
create new admin account| /users/registration/admin | POST | {login, password, fullname} | YES | ok/error
create new teacher| /users/create/teacher | POST | {name, surname, fathername} | YES | ok/error
create new group| /users/create/group | POST | {name, cafedra, training_direction, educational_level, form_education, specialty_id} | YES | ok/error
create new admin account| /users/getUser | POST | {login, password} | NO | token(ok)/error

#### Gradebook (student gradebook)

description | url | method | {body}/params | need token | result
----|----|--------|-------------|------------|-------
get information page | /gradebook/information | GET | --- | YES | {fullname, gradebook_number, course_admission, date_entry, date_issue, photoURL, group, dean}/error
get marks page | /gradebook/marks | GET | page| YES | marks : [{subject, hours, loans, mark, ects, date, semester, teacher}]/error
get practice page | /gradebook/practice | GET | --- | YES | practices : [{from_date, to_date, teacher, mark, ects, date}]/error
get practice table page | /gradebook/practiceTable | GET | --- | YES | practicesTable : [name, course, place, worked]/error
get atestations page | /gradebook/atestations | GET | --- | YES | atestations : [{date, name}]/error
get exams marks page | /gradebook/examsMarks | GET | --- | YES | examMarks : [{mark, ects, teachers : [{name, surname, fathername}]}]/error
get degree project page | /gradebook/degreeProject | GET | --- | YES | {student_name, topic, submission_date, date_protection, head : {name, surname, fathername}, teachers : [{name, surname, fathername}], mark, ects }/error
get examination commission page | /gradebook/examinationCommission | GET | --- | YES | {decision, head : {name, surname, fathername}, teachers : [{name, surname, fathername}], date_issue, number, studentName, dean}/error

#### Marks (admin panel)

description | url | method | {body}/params | need token | result
----|----|--------|-------------|------------|-------
rate for exam or test | /addMarks/marks | POST | {studentId, ects, mark, teacher, page} | YES | ok/error
rate for practice | /addMarks/practice | POST | [name, course, place, worked, from_date, to_date, teacher, mark, ects, studentId] | YES | ok/error
rate for atestations | /addMarks/atestations | POST | [studentId, name, mark, ects, [teacher]] | YES | ok/error
rate for degree project | /addMarks/degreeProject | POST | {student_name, topic, submission_date, date_protection, head, [teacher], mark, ects, decision, date_issue, number} | YES | ok/error


### Results

#### Login form

![login_image](https://github.com/BohdanShmalko/Gradebook-desktop/blob/main/images/login_image.png?raw=true)

#### The gradebook

![gradebook](https://github.com/BohdanShmalko/Gradebook-desktop/blob/main/images/gradebook.png?raw=true)

![exam](https://github.com/BohdanShmalko/Gradebook-desktop/blob/main/images/exam.png?raw=true)

![degree](https://github.com/BohdanShmalko/Gradebook-desktop/blob/main/images/degree.png?raw=true)

#### Admin panel

![users_admin](https://github.com/BohdanShmalko/Gradebook-desktop/blob/main/images/users_admin.png?raw=true)

![practice_admin](https://github.com/BohdanShmalko/Gradebook-desktop/blob/main/images/practice_admin.png?raw=true)

![p_atestations_admin](https://github.com/BohdanShmalko/Gradebook-desktop/blob/main/images/p_atestations_admin.png?raw=true)

#### Database datalogic model

![datalogic](https://github.com/BohdanShmalko/Gradebook-desktop/blob/main/database/datalogicModel.png?raw=true)
