package com.advancia;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ApacheITextApplication  {
	
	private static final String FILE_PATH = "C:/Users/marco/_Advancia/Formazione/1-JAVA/APACHE-POI-AND-ITEXT/apache-itext/file.pdf";
	private static final Font FIRST_FONT = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD, BaseColor.RED);
	private static final Font SECOND_FONT = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
	
    public static void main( String[] args ) {
    	
    	java.util.List<Prodotto> prodottoList = ProdottoSeeder.getProdottoList();
    	
    	try {
    		Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(FILE_PATH));
			document.open();
			
			// METADATI
			document.addTitle("Apache IText PDF");
			document.addAuthor("Marco Busacca");
			document.addSubject("Creazione PDF con IText");
			document.addKeywords("PDF, Java, IText");
			document.addCreator("IText");
			
			// TABELLA CONTENENTE LOGO E QR CODE
			PdfPTable headerTable = new PdfPTable(2);
			headerTable.setWidthPercentage(100);

			// LOGO
			Image logo = Image.getInstance("image.png");
			logo.scaleToFit(100, 100);
			PdfPCell logoCell = new PdfPCell(logo);
			logoCell.setBorder(Rectangle.NO_BORDER);
			logoCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			logoCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			headerTable.addCell(logoCell);

			// QR CODE
			BarcodeQRCode qrCode = new BarcodeQRCode("https://www.youtube.com/watch?v=dQw4w9WgXcQ", 100, 100, null);
			Image qrCodeImage = qrCode.getImage();
			PdfPCell qrCodeCell = new PdfPCell(qrCodeImage);
			qrCodeCell.setBorder(Rectangle.NO_BORDER);
			qrCodeCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			logoCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			headerTable.addCell(qrCodeCell);

			// AGGIUNGO LA HEADER_TABLE AL DOCUMENTO
			document.add(headerTable);

			// SPAZIO VUOTO
			document.add(new Paragraph("\n\n"));
			
			// TITOLO PDF
			Paragraph titoloPdf = new Paragraph("Apache IText PDF", FIRST_FONT);
			titoloPdf.setAlignment(Element.ALIGN_CENTER);
			document.add(titoloPdf);
			
			// SPAZIO VUOTO
			document.add(new Paragraph("\n\n"));
			
			// TABELLA CON RIEPILOGO DATI
			PdfPTable table = new PdfPTable(5);
			
			// CREAZIONE TABLE HEADER ROW AND CELLS
			table.setHeaderRows(1);
			
			PdfPCell c1 = new PdfPCell(new Phrase("Codice", SECOND_FONT));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			
			PdfPCell c2 = new PdfPCell(new Phrase("Nome", SECOND_FONT));
			c2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c2);
			
			PdfPCell c3 = new PdfPCell(new Phrase("Quantità in magazzino", SECOND_FONT));
			c3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c3);
			
			PdfPCell c4 = new PdfPCell(new Phrase("Quantità venduta", SECOND_FONT));
			c4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c4);
			
			PdfPCell c5 = new PdfPCell(new Phrase("Quantità totale", SECOND_FONT));
			c5.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c5);
			
			// INSERIMENTO DATI NEL CORPO DELLA TABELLA
			for (Prodotto prodotto : prodottoList) {
				table.addCell(prodotto.getCodice());
				table.addCell(prodotto.getNome());
				table.addCell(String.valueOf(prodotto.getQuantitaInMagazzino()));
				table.addCell(String.valueOf(prodotto.getQuantitaVenduta()));
				table.addCell(String.valueOf(prodotto.getQuantitaTotale()));
			}
			
			// AGGIUNGO LA TABELLA DATI AL DOCUMENTO
			document.add(table);
			
			// SPAZIO VUOTO
			document.add(new Paragraph("\n\n"));
			
			// LISTA
			List list = new List(true, false);
			list.add(new ListItem("Primo elemento"));
			list.add(new ListItem("Secondo elemento"));
			list.add(new ListItem("Terzo elemento"));
			document.add(list);
			
			document.close();
			
		} catch (Exception e) { // FileNotFoundException || DocumentException
			e.printStackTrace();
		}
    }
}
