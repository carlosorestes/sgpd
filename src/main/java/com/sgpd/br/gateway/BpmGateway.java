package com.sgpd.br.gateway;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgpd.br.dto.VariableExecution;

@Component
public class BpmGateway {
	
	private final RestTemplate restTemplate;

	public BpmGateway(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}	
	
	public Map<String, String> startProcessDefinitionKey(String processDefinitionKey,String renavam, Long orderId) throws IOException {
		String url = String.format("http://localhost:9595/engine-rest/process-definition/key/%s/start",
				processDefinitionKey);
		Map<String, String> responseMap = new HashMap<String, String>();
		
		 // create headers
	    HttpHeaders headers = new HttpHeaders();
	    // set `accept` header
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    
	    // set `accept` header
	    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	    
	    Map<String, Object> variableMap = new HashMap<String, Object>();
	    variableMap.put("variables", buildVariableExecution(Arrays.asList(new VariableExecution("orderId", orderId.toString(), "long"),
	    		new VariableExecution("renavam", renavam, "String"))));
	    
	    
	    // build the request
	    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(variableMap, headers);
	    
	    // send POST request
	    ResponseEntity<String> response = this.restTemplate.postForEntity(url, entity, String.class);
	    if(response.getStatusCode() == HttpStatus.OK) {
	    	ObjectMapper mapper = new ObjectMapper();
	    	JsonNode actualObj = mapper.readTree(response.getBody());
	    	responseMap.put("requestBbpmId", actualObj.get("id").textValue());
	    } 

	    return responseMap;
	}
	
	private Map<String, Object> buildVariableExecution(List<VariableExecution> variableExecution){
		Map<String, Object> variableMap = new HashMap<String, Object>();
		for(VariableExecution varExecution: variableExecution) {
			Map<String, Object> definitionMap = new HashMap<String, Object>() {{
		        put("value", varExecution.getValue());
		        put("type", varExecution.getType());
		    }};
		    variableMap.put(varExecution.getVariableName(), definitionMap);
		}
		return variableMap;
	}

}
