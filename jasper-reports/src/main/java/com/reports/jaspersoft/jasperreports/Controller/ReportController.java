package com.reports.jaspersoft.jasperreports.Controller;

import net.sf.jasperreports.engine.JRException;
import org.springframework.ui.Model;
import com.reports.jaspersoft.jasperreports.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping("/")
    public String showEmployee(Model model){
        model.addAttribute("employee",reportService.findAllEmployee());
        return "employee";
    }

    @PostMapping("/report")
    public String generateReport(@RequestParam("date") String date,
                                 @RequestParam("fileFormat") String fileFormat) throws JRException, IOException {
        LocalDate localDate = LocalDate.parse(date);
        String fileLink = reportService.generateReport(localDate, fileFormat);
        return "redirect:/"+fileLink;
    }
}
