package com.pdf;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pdf.utility.*;

@SpringBootTest
class PdfGenerationExampleApplicationTests {

	@Test
	void contextLoads() {
		PDFGenerator pdf=new PDFGenerator();
		pdf.writeUsingIText();
	}
	@Test
	void readExcel() {
		ExcelReader excel=new ExcelReader();
		excel.readExcel();
	}

}
