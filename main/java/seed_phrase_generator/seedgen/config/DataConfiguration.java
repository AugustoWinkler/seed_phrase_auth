package seed_phrase_generator.seedgen.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * DataConfiguration class is responsible for setting up the configuration
 * related to the PostgreSQL database connection.
 * 
 * This configuration can be reused for applications that need to connect to a
 * PostgreSQL database with Hibernate as the JPA provider.
 * 
 * @author Augusto Winkler
 * @version 1.1
 * @since 2025-04-05
 */
@Configuration
public class DataConfiguration {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/banco");
		dataSource.setUsername("postgres");
		dataSource.setPassword("123456");
		return dataSource;
	}
}
