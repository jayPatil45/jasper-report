package com.reports.jaspersoft.jasperreports;

import com.reports.jaspersoft.jasperreports.entities.employee;
import net.sf.jasperreports.engine.JRException;
//import com.reports.jaspersoft.jasperreports.model.Product;
//import net.sf.jasperreports.engine.JRException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface ReportService {
    String generateReport(LocalDate localDate, String fileFormat) throws  IOException, JRException;
    List<employee> findAllEmployee();
}

//The first method returns the report link,
// given the date and the file format. The other method returns a collection of products from the database.