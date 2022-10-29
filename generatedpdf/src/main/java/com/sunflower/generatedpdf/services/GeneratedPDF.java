package com.sunflower.generatedpdf.services;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class GeneratedPDF {

	public GeneratedPDF() {

	}

	public void generated(HttpServletResponse response) {

		try {
			Document documentPDF = new Document();
			PdfWriter.getInstance(documentPDF, response.getOutputStream());
			documentPDF.open();
			Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA);
			fontTitle.setSize(18);
			Paragraph title = new Paragraph("O que é Lorem Ipsum?", fontTitle);

			Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
			fontParagraph.setSize(12);

			Paragraph paragraph = new Paragraph(
					"Lorem Ipsum é simplesmente um texto fictício da indústria tipográfica e de impressão. "
							+ "Lorem Ipsum tem sido o texto fictício padrão da indústria desde os anos 1500, quando"
							+ " um impressor desconhecido pegou uma cozinha de tipos e embaralhou-a para fazer um "
							+ "livro de espécimes de tipos. Ele sobreviveu não apenas cinco séculos, mas também o salto"
							+ " para a composição eletrônica, permanecendo essencialmente inalterado. Foi popularizado "
							+ "na década de 1960 com o lançamento de folhas Letraset contendo passagens de Lorem Ipsum e, "
							+ "mais recentemente, com software de editoração eletrônica como Aldus PageMaker, incluindo versões de Lorem Ipsum.", fontParagraph);
			documentPDF.add(title);
			documentPDF.add(paragraph);
			documentPDF.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
