package com.example.producingwebservice;

import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.webservices.client.WebServiceTemplateBuilder;
import org.springframework.ws.client.core.WebServiceTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProducingWebServiceApplicationIntegrationTests {

	@LocalServerPort
	private int port = 0;

	@Test
	public void testSendAndReceive(@Autowired WebServiceTemplateBuilder builder) {
		WebServiceTemplate template = builder.build();
		GetCountryRequest request = new GetCountryRequest();
		request.setName("Spain");

		GetCountryResponse response = (GetCountryResponse) template
				.marshalSendAndReceive("http://localhost:%d/services".formatted(port), request);
		assertThat(response.getCountry().getCapital()).isEqualTo("Madrid");
    }

}
