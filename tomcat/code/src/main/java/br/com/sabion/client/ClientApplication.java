package br.com.sabion.client;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EntityScan(
        basePackageClasses = {ClientApplication.class, Jsr310JpaConverters.class}
)
@EnableJpaAuditing
public class ClientApplication {


	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
	
    @PostConstruct
    void setUTCTimezone(){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

}
