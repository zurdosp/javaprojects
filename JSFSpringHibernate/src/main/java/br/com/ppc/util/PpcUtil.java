  package br.com.ppc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.MaskFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.ppc.controller.bean.DadosPF;

/**
 *
 * @author Christian Oscar Tejada Pacheco
 *
 */
public class PpcUtil {

	public static Gson gson = new GsonBuilder().disableInnerClassSerialization().create();

	private static Logger logger = LoggerFactory.getLogger(PpcUtil.class);

	public final static Locale FINAL_GLOBAL_LOCAL = new Locale("pt", "BR");

	public final static String FINAL_GLOBAL_PATTERN_NUMBER_FORMAT = "#,###,###.00";

	public final static int FINAL_GLOBAL_PATTERN_NUMBER_FORMAT_GROUPING_SIZE = 3;

	public final static int FINAL_GLOBAL_PATTERN_NUMBER_FORMAT_DECIMALS_QUANTITY = 2;

	public final static char FINAL_GLOBAL_PATTERN_NUMBER_DECIMAL_SEPARATOR = ',';

	public final static char FINAL_GLOBAL_PATTERN_NUMBER_GROUPING_SEPARATOR = '.';

	public final static String USUARIO_MEGA_MASTER = "ppc";

	/**
	 * Arquivos gerados para o documento contrato
	 */
	public static final String PATH_FILE_CONTRATO_HTML_GERADO = "c:\\temp\\contrato\\teste1.html";
	public static final String PATH_FILE_CONTRATO_PDF_A_GERAR = "c:\\temp\\contrato\\";
	public static final String PATH_FILE_HTML_CONTRATO_MODELO = "c:\\temp\\contrato\\CONTRATO_MODELO_1.html";
	public static final String PATH_FILE_HTML_CONTRATO_MODELO_TAXAS = "c:\\temp\\contrato\\CONTRATO_MODELO_TAXAS.html";
	public static final String PATH_FILE_HTML_CONTRATO_MODELO_DADOSPJ = "c:\\temp\\contrato\\CONTRATO_MODELO_DADOSPJ.html";

	/**
	 * Arquivos gerados para o documento PROPOSTA
	 */
	public static final String PATH_FILE_HTML_PROPOSTA_MODELO = "c:\\temp\\proposta\\PROPOSTA_MODELO_1.html";
	public static final String PATH_FILE_PROPOSTA_HTML_GERADO = "c:\\temp\\proposta\\teste1.html";
	public static final String PATH_FILE_PROPOSTA_PDF_A_GERAR = "c:\\temp\\proposta\\";
	public static final String PATH_FILE_HTML_PROPOSTA_MODELO_TAXAS = "c:\\temp\\proposta\\PROPOSTA_MODELO_TAXAS.html";
	public static final String PATH_FILE_HTML_PROPOSTA_MODELO_DADOSPJ = "c:\\temp\\proposta\\PROPOSTA_MODELO_DADOSPJ.html";

	/**
	 * Arquivos gerados para o documento PROSPECTO
	 */
	public static final String PATH_FILE_HTML_PROSPECTO_MODELO = "c:\\temp\\prospecto\\PROSPECTO_MODELO_1.html";  // FIXME. AINDA NAO USADO.
	public static final String PATH_FILE_PROSPECTO_HTML_GERADO = "c:\\temp\\prospecto\\teste1.html";
	public static final String PATH_FILE_PROSPECTO_PDF_A_GERAR = "c:\\temp\\prospecto\\";
	public static final String PATH_FILE_HTML_PROSPECTO_MODELO_TAXAS = "c:\\temp\\prospecto\\PROSPECTO_MODELO_TAXAS.html";
	public static final String PATH_FILE_HTML_PROSPECTO_MODELO_DADOSPJ = "c:\\temp\\prospecto\\DADOS_PJ.html";

	/*
	 * Dados do contrato para gerar html e pdf
	 */
	public static final String EMPRESA_CLIENTE_DADOS_PJ_NOME = "##EMPRESA_CLIENTE##";
	public static final String EMPRESA_CLIENTE_ENDERECO_TIPO_LOGRADOURO = "##EMPRESA_CLIENTE_ENDERECO_TIPO_LOGRADOURO##";
	public static final String EMPRESA_CLIENTE_ENDERECO_LOGRADOURO = "##EMPRESA_CLIENTE_ENDERECO_LOGRADOURO##";
	public static final String EMPRESA_CLIENTE_ENDERECO_NRO = "##EMPRESA_CLIENTE_ENDERECO_NRO##";
	public static final String EMPRESA_CLIENTE_ENDERECO_COMPLEMENTO = "##EMPRESA_CLIENTE_ENDERECO_COMPLEMENTO##";
	public static final String EMPRESA_CLIENTE_ENDERECO_CIDADE = "##EMPRESA_CLIENTE_ENDERECO_CIDADE##";
	public static final String EMPRESA_CLIENTE_ENDERECO_ESTADO = "##EMPRESA_CLIENTE_ENDERECO_ESTADO##";
	public static final String EMPRESA_CLIENTE_REPRESENTANTE_CARGO = "##EMPRESA_CLIENTE_REPRESENTANTE_CARGO##";
	public static final String EMPRESA_CLIENTE_REPRESENTANTE_NOME = "##EMPRESA_CLIENTE_REPRESENTANTE_NOME##";

	public static final String EMPRESA_NOSSA_EMPRESA_NOME = "##EMPRESA_NOSSA_EMPRESA_NOME##";
	public static final String EMPRESA_NOSSA_EMPRESA_CNPJ = "##EMPRESA_NOSSA_EMPRESA_CNPJ##";
	public static final String EMPRESA_NOSSA_EMPRESA_ENDERECO_TIPO_LOGRADOURO = "##EMPRESA_NOSSA_EMPRESA_ENDERECO_TIPO_LOGRADOURO##";
	public static final String EMPRESA_NOSSA_EMPRESA_ENDERECO_LOGRADOURO = "##EMPRESA_NOSSA_EMPRESA_ENDERECO_LOGRADOURO##";
	public static final String EMPRESA_NOSSA_EMPRESA_ENDERECO_NRO = "##EMPRESA_NOSSA_EMPRESA_ENDERECO_NRO##";
	public static final String EMPRESA_NOSSA_EMPRESA_ENDERECO_COMPLEMENTO = "##EMPRESA_NOSSA_EMPRESA_ENDERECO_COMPLEMENTO##";
	public static final String EMPRESA_NOSSA_EMPRESA_ENDERECO_CIDADE = "##EMPRESA_NOSSA_EMPRESA_ENDERECO_CIDADE##";
	public static final String EMPRESA_NOSSA_EMPRESA_ENDERECO_ESTADO = "##EMPRESA_NOSSA_EMPRESA_ENDERECO_ESTADO##";

	public static final String COND_COMER1_PROSPECTO_VALOR = "##COND_COMER1_PROSPECTO_VALOR##";
	public static final String COND_COMER2_PROSPECTO_VALOR = "##COND_COMER2_PROSPECTO_VALOR##";
	public static final String COND_COMER3_PROSPECTO_VALOR = "##COND_COMER3_PROSPECTO_VALOR##";
	public static final String COND_COMER4_PROSPECTO_VALOR = "##COND_COMER4_PROSPECTO_VALOR##";
	public static final String COND_COMER5_PROSPECTO_VALOR = "##COND_COMER5_PROSPECTO_VALOR##";

	public static final String COND_COMER1_PROSPECTO_NOME = "##COND_COMER1_PROSPECTO_NOME##";
	public static final String COND_COMER2_PROSPECTO_NOME = "##COND_COMER2_PROSPECTO_NOME##";
	public static final String COND_COMER3_PROSPECTO_NOME = "##COND_COMER3_PROSPECTO_NOME##";
	public static final String COND_COMER4_PROSPECTO_NOME = "##COND_COMER4_PROSPECTO_NOME##";
	public static final String COND_COMER5_PROSPECTO_NOME = "##COND_COMER5_PROSPECTO_NOME##";

	/**
	 * Dados das taxas do contrato e proposta
	 */
	public static final String LISTA_DE_TAXAS = "##LISTA_DE_TAXAS##";
	public static final String TAXA_DESCRICAO = "##TAXAS_DESCRICAO##";

	/**
	 * Dados do cliente-prospecto para gerar html pdf
	 */
	public static final String EMPRESA_CLIENTE_DADOS_PJ_PRODUTO_SELETED = "##PRODUTOSELECTED##";
	public static final String EMPRESA_CLIENTE_DADOS_PJ_CNPJ = "##CNPJ_CLIENTE##";
	public static final String EMPRESA_CLIENTE_DADOS_PJ_RAZAOSOCIAL = "##RAZAOSOCIAL##";
	public static final String EMPRESA_CLIENTE_DADOS_PJ_NOMEFANTASIA = "##NOMEFANTASIA##";
	public static final String EMPRESA_CLIENTE_DADOS_PJ_TIPOLOGRADOURO = "##TIPOLOGRADOURO##";
	public static final String EMPRESA_CLIENTE_DADOS_PJ_LOGRADOURO = "##LOGRADOURO##";
	public static final String EMPRESA_CLIENTE_DADOS_PJ_NUMERO = "##NUMERO##";
	public static final String EMPRESA_CLIENTE_DADOS_PJ_COMPLEMENTO = "##COMPLEMENTO##";
	public static final String EMPRESA_CLIENTE_DADOS_PJ_CIDADE = "##CIDADE##";
	public static final String EMPRESA_CLIENTE_DADOS_PJ_ESTADO = "##ESTADO##";
	public static final String EMPRESA_CLIENTE_DADOS_PF_NOME = "##NOME##";
	public static final String EMPRESA_CLIENTE_DADOS_PF_SOBRENOME = "##SOBRENOME##";
	public static final String EMPRESA_CLIENTE_DADOS_PF_APELIDO = "##APELIDO##";
	public static final String EMPRESA_CLIENTE_DADOS_PF_EMAIL1 = "##EMAIL1##";
	public static final String EMPRESA_CLIENTE_DADOS_PF_EMAIL2 = "##EMAIL2##";
	public static final String EMPRESA_CLIENTE_DADOS_PF_DDDTELEFONEFIXO = "##DDDTELEFONEFIXO##";
	public static final String EMPRESA_CLIENTE_DADOS_PF_TELEFONEFIXO = "##TELEFONEFIXO##";
	public static final String EMPRESA_CLIENTE_DADOS_PF_DDDTELEFONECELULAR = "##DDDTELEFONECELULAR##";
	public static final String EMPRESA_CLIENTE_DADOS_PF_TELEFONECELULAR = "##TELEFONECELULAR##";
	public static final String EMPRESA_CLIENTE_DADOS_PF_ESTADO = "##ESTADO##";


	public static String  getFileContentAsString(final String filePathAndName) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			File fileDir = new File(filePathAndName);
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));
			String str;
			while ((str = in.readLine()) != null) {
				stringBuilder.append(str);
			}
			in.close();
		}
		catch (UnsupportedEncodingException e) {
			logger.error("Ero ao ler o arquivo", e);
		}
		catch (IOException e) {
			logger.error("Ero ao ler o arquivo", e);
		}
		catch (Exception e)	{
			logger.error("Ero ao ler o arquivo", e);
		}
		return stringBuilder.toString();
	}


    public static HttpSession getSession() {
        return (HttpSession)
          FacesContext.
          getCurrentInstance().
          getExternalContext().
          getSession(false);
      }

      public static HttpServletRequest getRequest() {
       return (HttpServletRequest) FacesContext.
          getCurrentInstance().
          getExternalContext().getRequest();
      }

      public static String getUserName() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return  session.getAttribute("usuarioSistema").toString();
      }

      public static String getUserId() {
        HttpSession session = getSession();
        if ( session != null ) {
            return (String) session.getAttribute("userid");
        }else {
            return null;
        }
      }

      /**
       * Metodo que arredonda valor segundo parametros
       * @param bigDecimalValue
       * @param Scale scale
       * @param boolean roundUp
       * @return Valor BigDecimal arredondado
       */
      public static BigDecimal round(final BigDecimal bigDecimalValue, final int scale, final boolean roundUp) {
    	  int mode = roundUp ? BigDecimal.ROUND_UP : BigDecimal.ROUND_DOWN;
    	  return bigDecimalValue.setScale(scale, mode);
    	}

      /**
       * Metodo que arredonda valor segundo parametros
       * @param d
       * @param scale
       * @param roundUp
       * @return Valor BigDecimal arredondado
       */
      public static BigDecimal roundAsString(final BigDecimal bigDecimalValue, final int scale, final boolean roundUp) {
    	  return round(bigDecimalValue, scale, roundUp);
    	}


	public static String deixaSoNumeros(final String cnpj) {
		return cnpj.replaceAll("\\D", "");
	}

	public static String limpaCPF(final String cpf) {
		if (cpf != null) {
			return cpf.replaceAll("\\D", "");
		}
		return cpf;
	}


	public static CharSequence trataStringNula(final String nome) {
		if (nome== null) {
			return "";
		}
		return nome;
	}

	public static void copyDadosPFs(final DadosPF dadosPFFrom, final DadosPF dadosPFTo) throws IllegalAccessException, InvocationTargetException{
		BeanUtils.copyProperties(dadosPFFrom, dadosPFTo, new String[]{"id"});
	}

	/**
	 *
	 // CEP - resultado: 81580-200 - format("#####-###", "81580200");
	 // CPF - resultado 012.345.699-01 - format("###.###.###-##", "01234569905");
	 // CNPJ - resultado: 01.234.569/9052-34 - format("##.###.###/####-##", "01234569905234");
	  *
	 * @param pattern
	 * @param value
	 * @return
	 */
	public static String formata(final String pattern, final Object value) {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
