package com.example.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example.rest")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.rest.repository")
public class AppConfig implements WebMvcConfigurer {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://127.0.0.1:33061/testdb?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
		ds.setUsername("summarydb");
		ds.setPassword("Docker#Root99");
		return ds;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		emf.setPackagesToScan("com.example.rest.model");
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(vendorAdapter);
		Properties jpaProps = new Properties();
		jpaProps.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		jpaProps.put("hibernate.hbm2ddl.auto", "update");
		jpaProps.put("hibernate.show_sql", "true");
		emf.setJpaProperties(jpaProps);
		return emf;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager tx = new JpaTransactionManager();
		tx.setEntityManagerFactory(emf);
		return tx;
	}

}
