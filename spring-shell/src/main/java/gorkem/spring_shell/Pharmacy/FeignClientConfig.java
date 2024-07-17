package gorkem.spring_shell.Pharmacy;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    RequestInterceptor requestInterceptor(@Value("${api.key}") String apiKey){
        return requestTemplate -> requestTemplate.header("authorization", apiKey);
    }
}
