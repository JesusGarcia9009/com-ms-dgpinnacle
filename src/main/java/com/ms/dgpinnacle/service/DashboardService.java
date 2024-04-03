package com.ms.dgpinnacle.service;

import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_CLIENT_NOT_EXIST;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_LETTER_NOT_EXIST;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.Objects;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.ms.dgpinnacle.dto.LetterConfigDto;
import com.ms.dgpinnacle.dto.security.DashboardDataDto;
import com.ms.dgpinnacle.entity.Client;
import com.ms.dgpinnacle.repository.ClientRepository;
import com.ms.dgpinnacle.repository.DashboardRepository;
import com.ms.dgpinnacle.repository.LetterConfigRepository;
import com.ms.dgpinnacle.repository.RealtorRepository;
import com.ms.dgpinnacle.token.UserPrincipal;
import com.ms.dgpinnacle.utils.Utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * DashboardServiceImpl clase que implementa la interfaz de servicio
 * 
 * @author Jesus Garcia
 * @version 1.0 Creacion
 * @since Java 11
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DashboardService {

	private final ClientRepository clientRepository;
	private final DashboardRepository dashboardRepository;
	private final LetterConfigRepository letterConfigRepository;
	private final RealtorRepository realtorRepository;
	private final ServletContext servletContext;
	private final TemplateEngine templateEngine;
	
	
	public DashboardDataDto getDashboardWidgetData() {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		DashboardDataDto result = new DashboardDataDto();
		dashboardRepository.findAll();
		
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return result;
	}
	
	@SuppressWarnings("deprecation")
	public byte[] getLetterDocumentByToken(UserPrincipal token, HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		//obtener el id del usuario
		Client client = clientRepository.findByEmailOrCellphone(token.getEmail(), token.getEmail());
		
		//valido que exista cliente, sino excepcion
		if (Objects.isNull(client))
			throw new Exception(MSG_CLIENT_NOT_EXIST);
		
		//obtener la carta, si existe la carta busco clientes y realtors
		LetterConfigDto letter = letterConfigRepository.findLetterDataByIdClient(client.getId());
		
		//valido carta
		if (Objects.isNull(letter))
			throw new Exception(MSG_LETTER_NOT_EXIST);
		
		//obtener realtor y clientes de la carta
		letter.setRealtors(realtorRepository.getRealtorsByLetter(letter.getId()));
		letter.setClients(clientRepository.getClientsByLetter(letter.getId()));
		
		//cargo los datos de la letter
		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("to", Utils.obtenerNombresSeparadosPorComa(letter.getClients()));
        context.setVariable("letter", letter);
        context.setVariable("now", (new Date()).toLocaleString());
        
        String orderHtml = templateEngine.process("letter.html", context);

        ByteArrayOutputStream target = new ByteArrayOutputStream();
        ConverterProperties converterProperties = new ConverterProperties();
        HtmlConverter.convertToPdf(orderHtml, target, converterProperties);

        byte[] bytes = target.toByteArray();
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return bytes;
	}

}
