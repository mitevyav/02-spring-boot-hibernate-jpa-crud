package com.yavor.cruddemo;

import com.yavor.cruddemo.dao.StudentDAO;
import com.yavor.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {

//            createStudent(studentDAO);

            createMultipleStudents(studentDAO);

//            readStudent(studentDAO);

//            queryForStudents(studentDAO);

//            queryForStudentsByLastName(studentDAO);

//            updateStudent(studentDAO);

//            deleteStudent(studentDAO);

//            deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students...");
        studentDAO.deleteAll();
        System.out.println("All students deleted.");
        queryForStudents(studentDAO);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        System.out.println("Deleting student with id 1...");
        studentDAO.deleteById(1);

        System.out.println("Student with id 1 deleted.");
    }

    private void updateStudent(StudentDAO studentDAO) {
        System.out.println("Updating student with id 1...");
        Student student = studentDAO.findById(1);

        System.out.println("Student before update: " + student);

        System.out.println("Updating student...");
        student.setFirstName("Frodo");
        student.setLastName("Baggins");

        System.out.println("Saving student...");
        studentDAO.update(student);

        System.out.println("Student after update: " + studentDAO.findById(1));
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByLastName("Baggins");

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        System.out.println("Querying for all students...");
        List<Student> students = studentDAO.findAll();

        System.out.println("Students: ");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void readStudent(StudentDAO studentDAO) {

        System.out.println("Creating student...");
        Student student = new Student("Daffy", "Duck", "daffy@looneytunes.com");

        System.out.println("Saving student...");
        studentDAO.save(student);

        int id = student.getId();
        System.out.println("Saved student with id: " + id);

        System.out.println("Reading student with id: " + id);
        Student studentFromDB = studentDAO.findById(id);

        System.out.println("Student from DB: " + studentFromDB);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        System.out.println("Creating 3 students...");
        Student student1 = new Student("Frodo", "Baggins", "frodo@lotr.com");
        Student student2 = new Student("Bilbo", "Baggins", "bilbo@lotr.com");
        Student student3 = new Student("Gandalf", "The Grey", "gandalf@lotr.com");


        System.out.println("Saving students...");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);

        System.out.println("Saved students.");
    }


    private void createStudent(StudentDAO studentDAO) {

        System.out.println("Creating student...");
        Student student = new Student("Frodo", "Baggins", "frodo@lotr.com");

        System.out.println("Saving student...");
        studentDAO.save(student);

        int id = student.getId();
        System.out.println("Saved student with id: " + id);
    }

}
