package uz.dsk.docflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DocflowApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocflowApplication.class, args);
    }

}
