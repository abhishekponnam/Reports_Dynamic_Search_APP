package in.abhishek.service.impl;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.abhishek.entity.CitizenPlan;
import in.abhishek.repo.CitizenPlanRepo;
import in.abhishek.request.SearchRequest;
import in.abhishek.service.ReportService;
import in.abhishek.utils.EmailUitils;
import in.abhishek.utils.ExcelGenerator;
import in.abhishek.utils.PdfGenerator;

@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	private CitizenPlanRepo repo;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private ExcelGenerator excelGenerator;
	
	@Autowired
	private EmailUitils  emailUtils;

	public List<String> getPlanNames() {

		return repo.getPlanNames();
	}

	public List<String> getPlanStatuses() {
		return repo.getPlanStatus();
	}

	public List<CitizenPlan> search(SearchRequest request) {
		CitizenPlan entity = new CitizenPlan();
		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		if (null != request.getStartDate() && !"".equals(request.getStartDate())) {
			String startDate = request.getStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate parse = LocalDate.parse(startDate, formatter);

			entity.setPlanStartDate(parse);
		}
		if (null != request.getEndDate() && !"".equals(request.getEndDate())) {
			String endDate = request.getEndDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate parse = LocalDate.parse(endDate, formatter);

			entity.setPlanStartDate(parse);
		}
		return repo.findAll(Example.of(entity));

	}

	public boolean exportExcel(HttpServletResponse response) throws Exception {
		       File f= new File("Plans.xlsx");
               List<CitizenPlan> plans = repo.findAll();
               String subject="Test Mail Subject";
               String body="<h1> Test the mail</h1>";
               String to="abhishekp5510@gmail.com";
               
               excelGenerator.generate(response, plans,f);
               
               
               emailUtils.sendEmail(subject, body, to,f);
               
               f.delete();
		
		return true;
	}

	public boolean exportPdf(HttpServletResponse response) throws Exception {
		File f= new File("Plans.pdf");
		List<CitizenPlan> plans = repo.findAll(); 
		
        
        
        pdfGenerator.generate(response, plans,f);
        String subject="Test Mail Subject";
        String body="<h1> Test the mail</h1>";
        String to="abhishekp5510@gmail.com";
        
        
        emailUtils.sendEmail(subject, body, to,f);
        
        f.delete();
	
		
		return true;
	}

}
