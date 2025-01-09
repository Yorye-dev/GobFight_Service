package dev.yorye.gobfight_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GobfightBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GobfightBackendApplication.class, args);
	}

}
