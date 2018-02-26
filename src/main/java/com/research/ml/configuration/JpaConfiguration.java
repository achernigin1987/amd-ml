package com.research.ml.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class JpaConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        // mandatory parameters
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(environment.getRequiredProperty("com.research.ml.db.driver"));
        hikariConfig.setJdbcUrl(environment.getRequiredProperty("com.research.ml.db.jdbcUrl"));
        hikariConfig.setUsername(environment.getRequiredProperty("com.research.ml.db.username"));
        hikariConfig.setPassword(environment.getRequiredProperty("com.research.ml.db.password"));
        // optional parameters
        hikariConfig.setMaximumPoolSize(
                environment.getProperty("com.research.ml.db.maximumPoolSize", Integer.class, 5));
        hikariConfig.setConnectionTimeout(
                environment.getProperty("com.research.ml.db.connectionTimeout", Long.class, 30000L));
        hikariConfig.setPoolName("HikariCP4ML");

        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.research.ml.model");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(hibernateProperties());
        return em;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.default_schema", "ml");
        return properties;
    }

    @Bean
    @Autowired
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf);
        return txManager;
    }
}

