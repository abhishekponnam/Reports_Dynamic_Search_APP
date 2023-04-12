package in.abhishek.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.abhishek.entity.CitizenPlan;
import in.abhishek.repo.CitizenPlanRepo;

@Component
public class DataLoader implements ApplicationRunner {
	@Autowired
	private CitizenPlanRepo repo;

	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
            repo.deleteAll();
		// cash plan
		CitizenPlan c1 = new CitizenPlan();
		c1.setCitizenName("Ram");
		c1.setGender("male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenefitAmt(10000.0);

		// cash plan denied
		CitizenPlan c2 = new CitizenPlan();
		c2.setCitizenName("Smith");
		c2.setGender("male");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denied");
		c2.setDenialReason("Rental Income");

		// cash plan Terminated
		CitizenPlan c3 = new CitizenPlan();
		c3.setCitizenName("Ismaiel");
		c3.setGender("male");
		c3.setPlanName("Cash");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now().minusMonths(4));
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setBenefitAmt(10000.0);
		c3.setTerminatedDate(LocalDate.now());
		c3.setTerminationReason("Employeed");

		// Food Plan Data

		CitizenPlan c4 = new CitizenPlan();
		c4.setCitizenName("David");
		c4.setGender("male");
		c4.setPlanName("Food");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenefitAmt(6000.0);

		// Food plan denied
		CitizenPlan c5 = new CitizenPlan();
		c5.setCitizenName("Robert");
		c5.setGender("male");
		c5.setPlanName("Food");
		c5.setPlanStatus("Denied");
		c5.setDenialReason("Property Income");

		// FOOD plan Terminated
		CitizenPlan c6 = new CitizenPlan();
		c6.setCitizenName("Orlien");
		c6.setGender("Female");
		c6.setPlanName("Food");
		c6.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now().minusMonths(4));
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setBenefitAmt(8000.0);
		c6.setTerminatedDate(LocalDate.now());
		c6.setTerminationReason("Employeed");

		// medical Plan
		CitizenPlan c7 = new CitizenPlan();
		c7.setCitizenName("Charles");
		c7.setGender("male");
		c7.setPlanName("Medical");
		c7.setPlanStatus("Approved");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenefitAmt(10000.0);

		// Medical plan denied
		CitizenPlan c8 = new CitizenPlan();
		c8.setCitizenName("leela");
		c8.setGender("Female");
		c8.setPlanName("Medical");
		c8.setPlanStatus("Denied");
		c8.setDenialReason("Rental Income");

		// Medical plan Terminated
		CitizenPlan c9 = new CitizenPlan();
		c9.setCitizenName("Neel");
		c9.setGender("male");
		c9.setPlanName("Medical");
		c9.setPlanStatus("Terminated");
		c9.setPlanStartDate(LocalDate.now().minusMonths(4));
		c9.setPlanEndDate(LocalDate.now().plusMonths(6));
		c9.setBenefitAmt(20000.0);
		c9.setTerminatedDate(LocalDate.now());
		c9.setTerminationReason("Govt Job");

		// Employment plan
		CitizenPlan c10 = new CitizenPlan();
		c10.setCitizenName("Butller");
		c10.setGender("male");
		c10.setPlanName("Employment");
		c10.setPlanStatus("Approved");
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(6));
		c10.setBenefitAmt(12000.0);

		// Employment plan denied
		CitizenPlan c11 = new CitizenPlan();
		c11.setCitizenName("Steve");
		c11.setGender("male");
		c11.setPlanName("Employment");
		c11.setPlanStatus("Denied");
		c11.setDenialReason("Rental Income");

		// Employment plan Terminated
		CitizenPlan c12 = new CitizenPlan();
		c12.setCitizenName("Cathy");
		c12.setGender("Female");
		c12.setPlanName("Employment");
		c12.setPlanStatus("Terminated");
		c12.setPlanStartDate(LocalDate.now().minusMonths(4));
		c12.setPlanEndDate(LocalDate.now().plusMonths(6));
		c12.setBenefitAmt(10000.0);
		c12.setTerminatedDate(LocalDate.now());
		c12.setTerminationReason("Employeed");

		List<CitizenPlan> list = Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12);

		repo.saveAll(list);

	}

}
