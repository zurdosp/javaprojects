package br.com.ppc.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;

import br.com.ppc.controller.PpcController;
import br.com.ppc.util.PpcUtil;

/**
 *
 * @author Christian Oscar Tejada Pacheco
 *
 */
@Service
public class PpcFilesBuilderService {

	private static final Logger logger = LoggerFactory.getLogger(PpcController.class);

	/**
	 * Processa html to string.
	 *
	 * @param textMioloString
	 *            the text miolo string
	 * @return the string
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public String processaHTMLtoString(String textMioloString, final String modeloHtmlDadosPJ, final String modeloHtmlTaxas) throws IOException {
		String fileDadosPJContent = PpcUtil.getFileContentAsString(modeloHtmlDadosPJ);
		String fileTaxasContent = PpcUtil.getFileContentAsString(modeloHtmlTaxas);

		textMioloString = textMioloString.replace("##MODELO_DADOSPJ##", fileDadosPJContent);
		textMioloString = textMioloString.replace("##MODELO_TAXAS##", fileTaxasContent);
		return textMioloString;
	}

	/**
	 * Write miolo html file.
	 *
	 * @param textMioloContrato
	 *            the text miolo contrato
	 */
	public void writeMioloHtmlFile(final String textMioloContrato, final String documentoHtml) {
		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(documentoHtml), "UTF-8"));
			String htmlTratado = trataHTML(textMioloContrato);
			writer.write(buildHTML(htmlTratado));
		} catch (IOException e) {
			logger.error("erro ao excrever arquivo", e);
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				logger.error("Erro 1 ao tentar escrver arquivo", e);
			}
		}
	}

	/**
	 * Metodo que escreve o PDF a partir de um xhtml bem formado gerado anteriormente.
	 */
	public void writePDF(final String htmlGerado, final String outputFile) {
		OutputStream os = null;
		try {
			String url = new File(htmlGerado).toURI().toURL().toString();
			os = new FileOutputStream(outputFile);
			ITextRenderer renderer = new ITextRenderer();
			renderer.setDocument(url);
			renderer.layout();
			renderer.createPDF(os);
		} catch (FileNotFoundException e) {
			logger.error("Erro ao tentar escrever pdf, arquivo nao encontrato", e);
		} catch (DocumentException e) {
			logger.error("Erro ao tentar escrever pdf", e);
		} catch (IOException e) {
			logger.error("Erro ao tentar escrever pdf", e);
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				logger.error("Erro ao tentar escrever pdf", e);
			}
		}
	}

	/**
	 * Trata html.
	 *
	 * @param textMioloContrato
	 *            the text miolo contrato
	 * @return the string
	 */
	private String trataHTML(String textMioloContrato) {
		textMioloContrato = textMioloContrato.replaceAll("&nbsp;", "").replaceAll("<br>", "<br />");

		return textMioloContrato;
	}

	/**
	 * Builds the html.
	 *
	 * @param textMioloContrato
	 *            the text miolo contrato
	 * @return the string
	 */
	private String buildHTML(final String textMioloContrato) {
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<head><meta charset='UTF-8'/></head>");
		sb.append("<body>");
		sb.append(textMioloContrato);
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}

}
