package com.sunflower.generatedpdf.resources;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunflower.generatedpdf.services.GeneratedPDF;

@RestController
@RequestMapping(value = "/api/rel")
public class GeneratedResource {

	private GeneratedPDF generatedPDF;

	public GeneratedResource(GeneratedPDF generatedPDF) {
		this.generatedPDF = generatedPDF;
	}

	@GetMapping(value = "test")
	public ResponseEntity<Void> generetadTest(HttpServletResponse response) {
		response.setContentType("application/pdf");
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd:hh:mm:ss");
		String currentDateTime = format.format(new Date());
		String headerKey = "Content-Disposition";
		String headerValue = "attachnent; filename=test_rel_"+ currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);
		generatedPDF.generated(response);
		return ResponseEntity.ok().build();
	}

}
