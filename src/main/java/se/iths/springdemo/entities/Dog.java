package se.iths.springdemo.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; // unique value - genereras av databasen
    private String name;
    private String type;
    private int age;
    private String gender;

    public Dog() {
    }

    public Dog(int id, String name, String type, int age, String gender) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

