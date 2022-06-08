package uz.pdp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import uz.pdp.repositorhy.StudentReporistiary;
import uz.pdp.repository.StudentRepositoryImpl;

import java.sql.DriverManager;

@Configuration //nimanidur bean ishlata ooladi
@ComponentScan("uz.pdp")
public class WebMvcConfig {
    @Bean
    InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/web/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    @Bean
    DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("123");
        return dataSource;

    }
    @Bean
    public StudentReporistiary getGetStudentDAO(){
        return new StudentRepositoryImpl(getDataSource());
}
}