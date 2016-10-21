package com.hades.scaffold.server;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.hades.scaffold.dao")
public class JpaConfig {

	@Autowired
	DataSource dataSource;
    
    @Value("${spring.jpa.database}")
    private Database database;
    @Value("${spring.jpa.hibernate.dialect}")
    private String dialect;
    @Value("${spring.jpa.generateDdl}")
    private Boolean generateDdl;
    @Value("${spring.jpa.showSql}")
    private Boolean showSql;
    @Value("${spring.jpa.persistenceUnitName}")
    private String persistenceUnitName;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String hbm2ddlAuto;
    @Value("${spring.jpa.hibernate.implicit_naming_strategy}")
    private String implicitNamingStrategy;
	
    @Bean
    public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
    	HibernateJpaVendorAdapter hjva = new HibernateJpaVendorAdapter();
    	hjva.setDatabase(database);
    	hjva.setDatabasePlatform(dialect);
    	hjva.setGenerateDdl(generateDdl);
    	hjva.setShowSql(showSql);
    	return hjva;
    }
    
	@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.hades.scaffold.**.entity");
        
        entityManagerFactoryBean.setPersistenceUnitName(persistenceUnitName);
        entityManagerFactoryBean.setPersistenceProvider(new HibernatePersistenceProvider());

        Properties jpaProperties = new Properties();
        jpaProperties.put(org.hibernate.cfg.Environment.DIALECT, dialect);
//        jpaProperties.put(org.hibernate.cfg.Environment.IMPLICIT_NAMING_STRATEGY, implicitNamingStrategy);
        jpaProperties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, hbm2ddlAuto);
        jpaProperties.put(org.hibernate.cfg.Environment.SHOW_SQL, showSql);
        // TODO 其他的属性在此处添加 
        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }
	
	@Bean(name = "transactionManager")
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new JpaTransactionManager();
    }
}
