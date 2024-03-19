package com.assignment.tf.configuration;

import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class RestConfiguration {

  @Bean
  public RestTemplate restTemplateConfig(){
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.setMessageConverters(Collections.singletonList(new MappingJackson2HttpMessageConverter()));
    return restTemplate;
  }

}
