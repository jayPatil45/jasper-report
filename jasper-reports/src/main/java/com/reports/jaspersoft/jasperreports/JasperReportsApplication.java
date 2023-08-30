package com.reports.jaspersoft.jasperreports;

import com.reports.jaspersoft.jasperreports.entities.employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JasperReportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JasperReportsApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository){
		return args -> {
			List<employee> emp = List.of(
			new employee(1L,"ajay","Java", LocalDate.now()),
			new employee(2L,"Vijay", "Python", LocalDate.now()),
			new employee(3L,"Hari", "Data Engineer", LocalDate.now().minusDays(1)),
					new employee(4L,"Jaywant","NET",LocalDate.now()),
					new employee(5L,"jitesh","Data Analyst",LocalDate.now())

              );
			employeeRepository.saveAll(emp);
		};
	}

}
