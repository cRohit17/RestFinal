package com.spring.rest.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration  //it represetns this bean configurations -- bean.xml
@EnableWebMvc  // this is not a normal app but mvc app
@ComponentScan(basePackages = { "com.spring.rest.*" })//this represents base packageToScan <context:component-scan base-package="com.clc.*">
public class WebSpringBeanJavaConfig {

	
	String hbmDialectProperty = "hibernateDialect";
	String hbmDdlAutoProperty = "hibernate.hbm2ddl.auto";
	String hbmShowSqlProperty = "hibernate.show_sql";
	String hbmFormatSqlProperty = "hibernate.format_sql";

    
    static{System.out.println("spring bean configuration"); }

    @Bean  //create object with new -- to spring container madhe add kara -- LocalsessionFactory
    public LocalSessionFactoryBean sessionFactory() {
    	
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] {"com.spring.rest.entity" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }
    
    
    @Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/rest_info");
		
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
    
    
    @Bean
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put(hbmDialectProperty, "org.hibernate.dialect.MySQL5Dialect");
		properties.put(hbmDdlAutoProperty, "update");
		properties.put(hbmShowSqlProperty, "true");
		properties.put(hbmFormatSqlProperty, "true");
		return properties;
	}

}