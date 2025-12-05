package com.example.producingwebservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;

@Configuration(proxyBeanMethods = false)
public class WebServiceConfig {

	@Bean
	public DefaultWsdl11Definition countries(SimpleXsdSchema countriesWs) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("CountriesPort");
		wsdl11Definition.setLocationUri("/services");
		wsdl11Definition.setTargetNamespace("https://spring.io/guides/gs-producing-web-service");
		wsdl11Definition.setSchema(countriesWs);
		return wsdl11Definition;
	}

}
