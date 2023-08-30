package com.reports.jaspersoft.jasperreports.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "employee")  // specifies the name of the database table to be used for mapping
@Data   // generates getter and setter
@NoArgsConstructor // creates default constructor
public class employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Long id;

    @Column(name= "name")
    private String name;

    @Column(name = "description")
    private String description;

  //  @Column(name = "Mobile_Number")
  //  private Long Mobile_Number;

    @Column(name = "created_at")
    private LocalDate createdAt;

    public employee(Long id, String name, String description,  LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
       // Mobile_Number = mobile_Number;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}


