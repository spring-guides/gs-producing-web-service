package com.example.producingwebservice;

import io.spring.guides.gs_producing_web_service.GetCountryRequest;

import org.springframework.boot.webservices.client.WebServiceTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.util.ClassUtils;

@Configuration(proxyBeanMethods = false)
class WebServiceTemplateConfiguration {

	@Bean
	WebServiceTemplateCustomizer marshallerCustomizer(Marshaller marshaller) {
		return (webServiceTemplate) -> webServiceTemplate.setMarshaller(marshaller);
	}

	@Bean
	WebServiceTemplateCustomizer unmarshallerCustomizer(Unmarshaller unmarshaller) {
		return (webServiceTemplate) -> webServiceTemplate.setUnmarshaller(unmarshaller);
	}

	@Bean
	Jaxb2Marshaller createJaxbMarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan(ClassUtils.getPackageName(GetCountryRequest.class));
		return marshaller;
	}

}
