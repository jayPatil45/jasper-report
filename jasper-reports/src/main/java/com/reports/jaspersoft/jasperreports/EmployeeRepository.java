package com.reports.jaspersoft.jasperreports;

import com.reports.jaspersoft.jasperreports.entities.employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<employee,Long> {
    static List<employee> findAllByCreatedAt(LocalDate localDate) {
        return null;
    }
}

//Create a employee repository to find all employee by date
//Create an interface named employee Repository that extends JpaRepository.
// Then, create a method that returns a collection of employee queried by date in the interface: