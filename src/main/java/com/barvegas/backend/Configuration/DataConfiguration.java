package com.barvegas.backend.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;


@Configuration
public class DataConfiguration {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/barapp?useTimezone=true&serverTimezone=UTC");//Porta e nome do banco
        dataSource.setUsername("Kleveson");//Login root MySQL
        dataSource.setPassword("6806952763");
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);//Tipo de database
        adapter.setShowSql(true);//Mostra as etapas da movimentação no banco
        adapter.setGenerateDdl(true);//Hibernete cria as tabelas automaticamente
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
        adapter.setPrepareConnection(true);//Hibernet preparar a conexão automaticamente
        return adapter;
    }
}
