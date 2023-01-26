package uz.backweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.backweb.fileupload.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
@EnableEurekaClient
public class BackwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackwebApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean(name="entityManagerFactory")
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//
//        return sessionFactory;
//    }
}
