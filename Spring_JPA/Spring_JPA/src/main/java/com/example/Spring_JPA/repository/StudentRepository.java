package com.example.Spring_JPA.repository;

import com.example.Spring_JPA.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{
    //declaring custom methods for fetching data which jpa will understand using name convention
    Student findByName(String name);

    Student findByNameAndMail(String name, String email);

//    @Query("select s from Student s where s.name=?1")
    @Query( name="student.findByName")
    Student findByNameJPQL(String name);

    @NativeQuery("select * from Student where Student.name=:name")
    Student findByNameNative(String name);

    @Query("update Student s set s.name=:newname where s.name=:oldname")
    @Modifying
    @Transactional
    void updateName(String oldname, String newname);
}
