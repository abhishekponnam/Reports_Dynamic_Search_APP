package in.abhishek.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.abhishek.entity.CitizenPlan;

@Component
public class PdfGenerator {
 
	public void generate(HttpServletResponse response,List<CitizenPlan> records,File f) throws Exception {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(f));
		document.open();
		// Paragraph p=new Paragraph("CITIZEN PLAN INFO");
		// document.add(p);

		// Setting font style and size
		Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTiltle.setSize(20);

		// Creating paragraph
		Paragraph paragraph = new Paragraph("CITIZEN PLAN INFO", fontTiltle);

		// Aligning the paragraph in document
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);

		// Adding the created paragraph in document
		document.add(paragraph);
		
		PdfPTable table = new PdfPTable(7);
		table.setSpacingBefore(5);


		table.addCell("CITIZEN ID");
		table.addCell("CITIZEN NAME");
		table.addCell("PLAN NAME");
		table.addCell("PLAN STATUS");
		table.addCell("PLAN START DATE");
		table.addCell("PLAN END DATE");
		table.addCell("BENEFIT AMOUNT");

		for (CitizenPlan plan : records) {
			table.addCell(plan.getCitizenId() + "");
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getPlanStartDate() + "");
			table.addCell(plan.getPlanEndDate() + "");
			table.addCell(plan.getBenefitAmt() + "");
		}
		document.add(table);
		document.close();
	}
}
