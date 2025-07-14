package org.example;

import jakarta.persistence.*;

@Entity //Marking a class as Entity will make this class a database table,
// Any changes made to this class will affect corresponding columns in database table.

@Table(name = "Student_table")
public class Student {
    public Student() {
    }

    @Id //Marking this column as primary key column;
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Identity uses auto increment //Auto use database to decide the id of next inserted row
    int id;

    @Column(name = "Name") // Similar to @Table.
    String username;

    // @Transient //Marking as transient and this column won't be created in database.
    String email;

//    @Temporal(TemporalType.DATE) //used to map a java.util.Date or java.util.Calendar field to a specific temporal type in the database.
//    private Date date;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Embedded // Embedding the Address Embeddable class in Student Entity.
    Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Student(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}