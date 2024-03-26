package com.ms.dgpinnacle.business.clients;

import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.ms.dgpinnacle.business.clients.dto.EncompassResponseDto;
import com.ms.dgpinnacle.business.clients.dto.EncompassTokenResponseDto;
import com.ms.dgpinnacle.utils.Utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Service
public class EncompassClientClientImpl implements EncompassClient {

	/**
	 * RestTemplateMs restTemplateMs
	 */
	/*@Autowired
	public RestTemplate restTemplate;*/

	@Value("${dgpinnacle.token}")
	private String tokenUrl;
	
	@Value("${dgpinnacle.client_secret}")
	private String clientSecret;
	
	@Value("${dgpinnacle.client_id}")
	private String clientId;
	
	@Value("${dgpinnacle.loan}")
	private String loanUrl;
	
	@Value("${dgpinnacle.user}")
	private String username;
	
	@Value("${dgpinnacle.pass}")
	private String password;

	@Override
	public EncompassTokenResponseDto getToken() {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));

		// Parámetros de la solicitud
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
	    requestBody.add("grant_type", "password");
	    requestBody.add("username", username);
	    requestBody.add("password", password);
	    requestBody.add("client_id", clientId);
	    requestBody.add("client_secret", clientSecret);

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

		ResponseEntity<EncompassTokenResponseDto> response = new RestTemplate().exchange(
	            tokenUrl,
	            HttpMethod.POST,
	            requestEntity,
	            EncompassTokenResponseDto.class
	    );
		
        System.out.println(Utils.printCurlEquivalent(tokenUrl, HttpMethod.POST, requestEntity));
        
		EncompassTokenResponseDto responseBody = null;
		if (response.getStatusCode().is2xxSuccessful()) {
			responseBody = response.getBody();
		} else {
			throw new RuntimeException("Error al obtener el token de acceso: " + response.getStatusCode());
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return responseBody;
	}
	
	
	/**
	 * Getting a full Loan data
	 */
	
	@Override
	public EncompassResponseDto getLoan(String eToken, String loanId) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    //headers.setBearerAuth(eToken);
	    headers.set("Authorization", "Bearer " + eToken);

		HttpEntity<String> requestEntity = new HttpEntity<>(headers);
	
		log.info(loanUrl + "/" + loanId);	
		log.info(headers.getContentType() + " & " + headers.getValuesAsList("Authorization"));
  
		ResponseEntity<EncompassResponseDto> response = new RestTemplate().exchange(
				loanUrl + "/" + loanId,
	            HttpMethod.GET,
	            requestEntity,
	            EncompassResponseDto.class
	    );
		
        System.out.println(Utils.printCurlEquivalent(loanUrl, HttpMethod.GET, requestEntity));
        
        EncompassResponseDto responseBody = null;
		if (response.getStatusCode().is2xxSuccessful()) {
			responseBody = response.getBody();
		} else {
			throw new RuntimeException("Error al obtener el Loan: " + response.getStatusCode());
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return responseBody;
	}
	
	

}
