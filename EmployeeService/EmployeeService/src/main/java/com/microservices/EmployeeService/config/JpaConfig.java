/*
 * package com.microservices.EmployeeService.config;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.data.jpa.repository.config.EnableJpaRepositories; import
 * org.springframework.orm.jpa.JpaTransactionManager; import
 * org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean; import
 * org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter; import
 * org.springframework.transaction.PlatformTransactionManager;
 * 
 * import jakarta.persistence.EntityManagerFactory;
 * 
 * @Configuration
 * 
 * @EnableJpaRepositories(basePackages = "com.microservices.EmployeeService")
 * public class JpaConfig {
 * 
 * @Bean public LocalContainerEntityManagerFactoryBean
 * entityManagerFactory(DataSource dataSource) {
 * LocalContainerEntityManagerFactoryBean em = new
 * LocalContainerEntityManagerFactoryBean(); em.setDataSource(dataSource);
 * em.setPackagesToScan("com.microservices.EmployeeService.model");
 * 
 * HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
 * em.setJpaVendorAdapter(vendorAdapter);
 * 
 * return em; }
 * 
 * @Bean public PlatformTransactionManager
 * transactionManager(EntityManagerFactory emf) { JpaTransactionManager
 * transactionManager = new JpaTransactionManager();
 * transactionManager.setEntityManagerFactory(emf); return transactionManager; }
 * }
 */