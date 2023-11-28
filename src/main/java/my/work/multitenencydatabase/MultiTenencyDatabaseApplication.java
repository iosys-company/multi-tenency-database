package my.work.multitenencydatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class MultiTenencyDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiTenencyDatabaseApplication.class, args);
	}

}
