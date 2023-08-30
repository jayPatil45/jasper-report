package com.reports.jaspersoft.jasperreports.service;

import com.reports.jaspersoft.jasperreports.EmployeeRepository;
import com.reports.jaspersoft.jasperreports.ReportService;
import com.reports.jaspersoft.jasperreports.entities.employee;
//import com.reports.jaspersoft.jasperreports.model.Product;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    private JasperPrint getJasperPrint(List<employee> phoneCollection, String resourceLocation) throws FileNotFoundException, JRException {
        File file = ResourceUtils.getFile(resourceLocation);
        JasperReport jasperReport = JasperCompileManager
                .compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new
                JRBeanCollectionDataSource(phoneCollection);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy","Jaywant");

        JasperPrint jasperPrint = JasperFillManager
                .fillReport(jasperReport,parameters,dataSource);

        return jasperPrint;
    }
    private Path getUploadPath(String fileFormat, JasperPrint jasperPrint, String fileName) throws IOException, JRException {
        String uploadDir = StringUtils.cleanPath("./generated-reports");
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }
        //generate the report and save it in the just created folder
        if (fileFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(
                    jasperPrint, uploadPath+fileName
            );
        }

        return uploadPath;
    }

    private String getPdfFileLink(String uploadPath){
        return uploadPath+"/"+"employee.pdf";
    }

    @Override
    public String generateReport(LocalDate localDate, String fileFormat) throws JRException, IOException {
        List<employee> phoneCollection = EmployeeRepository.findAllByCreatedAt(localDate);
        //load the file and compile it
        String resourceLocation = "classpath:employee.jrxml";
        JasperPrint jasperPrint = getJasperPrint(phoneCollection,resourceLocation);
        //create a folder to store the report
        String fileName = "/"+"employee.pdf";
        Path uploadPath = getUploadPath(fileFormat, jasperPrint, fileName);
        //create a private method that returns the link to the specific pdf file

        return getPdfFileLink(uploadPath.toString());
    }

    @Override
    public List<employee> findAllEmployee() {
        return null;
    }

}
