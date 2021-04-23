-- CREATE USER gradeuser PASSWORD '1111';
-- ALTER ROLE gradeuser createrole createdb;

\c postgres
DROP
DATABASE gradebook_desktop;
CREATE
DATABASE gradebook_desktop OWNER gradeuser;
\c gradebook_desktop

CREATE TABLE Institutes
(
    id     SERIAL       NOT NULL PRIMARY KEY,
    name   VARCHAR(255) NOT NULL,
    rector VARCHAR(255) NOT NULL
);

CREATE TABLE Admins
(
    id       SERIAL       NOT NULL PRIMARY KEY,
    login    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    fullname VARCHAR(255) NOT NULL
);

CREATE TABLE Teachers
(
    id         SERIAL      NOT NULL PRIMARY KEY,
    name       VARCHAR(50) NOT NULL,
    surname    VARCHAR(50) NOT NULL,
    fathername VARCHAR(50) NOT NULL
);

CREATE TABLE Faculties
(
    id            SERIAL       NOT NULL PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    dean          VARCHAR(255) NOT NULL,
    institutes_id INT          NOT NULL REFERENCES Institutes (id) ON DELETE CASCADE
);

CREATE TABLE Specialties
(
    id           SERIAL       NOT NULL PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    number_name  INT          NOT NULL,
    faculties_id INT          NOT NULL REFERENCES Faculties (id) ON DELETE CASCADE
);

CREATE TABLE Students
(
    id                 SERIAL       NOT NULL PRIMARY KEY,
    fullname           VARCHAR(255) NOT NULL,
    gradebook_number   INT          NOT NULL,
    login              VARCHAR(255) NOT NULL,
    password           VARCHAR(255) NOT NULL,
    training_direction VARCHAR(255) NOT NULL,
    educational_level  VARCHAR(255) NOT NULL,
    form_education     VARCHAR(255) NOT NULL,
    course_admission   INT          NOT NULL,
    date_entry         TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    date_issue         TIMESTAMP NULL,
    specialtie_id      INT          NOT NULL REFERENCES Specialties (id) ON DELETE CASCADE
);

CREATE TABLE Practices
(
    id         SERIAL       NOT NULL PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    course     INT          NOT NULL,
    place      VARCHAR(255) NOT NULL,
    worked     VARCHAR(255) NOT NULL,
    from_date  TIMESTAMP    NOT NULL,
    to_date    TIMESTAMP    NOT NULL,
    mark       INT          NOT NULL,
    ects       VARCHAR(70)  NOT NULL,
    date       TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    student_id INT          NOT NULL REFERENCES Students (id) ON DELETE CASCADE,
    teacher_id INT          NOT NULL REFERENCES Teachers (id) ON DELETE CASCADE
);

CREATE TABLE Estimates
(
    id           SERIAL       NOT NULL PRIMARY KEY,
    species_name VARCHAR(50)  NOT NULL,
    subject      VARCHAR(255) NOT NULL,
    hours        INT          NOT NULL,
    loans        INT          NOT NULL,
    mark         INT          NOT NULL,
    ects         VARCHAR(70)  NOT NULL,
    date         TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    semester     INT          NOT NULL,
    student_id   INT          NOT NULL REFERENCES Students (id) ON DELETE CASCADE,
    teacher_id   INT          NOT NULL REFERENCES Teachers (id) ON DELETE CASCADE
);

CREATE TABLE Thesis
(
    id              SERIAL       NOT NULL PRIMARY KEY,
    topic           VARCHAR(255) NOT NULL,
    submission_date TIMESTAMP NULL,
    date_protection TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    decision        TEXT         NOT NULL,
    honors          bool         NOT NULL DEFAULT false,
    number          INT UNIQUE   NOT NULL, --!!!
    mark            INT          NOT NULL,
    ects            VARCHAR(70)  NOT NULL,
    date_issue      TIMESTAMP NULL,
    student_id      INT          NOT NULL REFERENCES Students (id) ON DELETE CASCADE
);

CREATE TABLE Thesis_members
(
    id         SERIAL NOT NULL PRIMARY KEY,
    thesis_id  INT    NOT NULL REFERENCES Thesis (id) ON DELETE CASCADE,
    teacher_id INT    NOT NULL REFERENCES Teachers (id) ON DELETE CASCADE
);

CREATE TABLE Certification
(
    id         SERIAL      NOT NULL PRIMARY KEY,
    date       TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    mark       INT         NOT NULL,
    ects       VARCHAR(70) NOT NULL,
    student_id INT         NOT NULL REFERENCES Students (id) ON DELETE CASCADE
);

CREATE TABLE Certification_members
(
    id               SERIAL NOT NULL PRIMARY KEY,
    certification_id INT    NOT NULL REFERENCES Certification (id) ON DELETE CASCADE,
    teacher_id       INT    NOT NULL REFERENCES Teachers (id) ON DELETE CASCADE
);

INSERT INTO Admins (login, password, fullname) VALUES ('GMt8U5b427b3xUm2xPUh', '47MxdPRTYEt22tj88hy9', 'root');