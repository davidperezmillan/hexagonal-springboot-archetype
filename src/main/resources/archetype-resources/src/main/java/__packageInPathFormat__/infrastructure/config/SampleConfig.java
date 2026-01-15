package ${package}.infrastructure.config;

import ${package}.domain.port.in.SampleUseCase;
import ${package}.domain.port.out.SampleRepository;
import ${package}.domain.service.SampleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleConfig {

    @Bean
    public SampleUseCase sampleUseCase(SampleRepository sampleRepository) {
        return new SampleService(sampleRepository);
    }

}
