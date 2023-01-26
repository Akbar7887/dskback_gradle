package uz.dsk.docflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/doc/")
public class DocflowApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocflowApplication.class, args);
    }

    @GetMapping("test")
    private String contextLoads1() {
        return "ekjhgerklhfe";
    }

}
