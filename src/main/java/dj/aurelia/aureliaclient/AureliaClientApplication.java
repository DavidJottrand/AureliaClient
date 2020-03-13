package dj.aurelia.aureliaclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@Configuration
@EnableSwagger2
@CrossOrigin("*")
public class AureliaClientApplication {

//    @Autowired
//    private static AuthorityRepository authorityRepository;

    public static Logger logger = LoggerFactory.getLogger(AureliaClientApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(AureliaClientApplication.class, args);

//        Authority admin = new Authority();
//        admin.setName(AuthorityName.ROLE_ADMIN);
//        authorityRepository.save(admin);
//        Authority user = new Authority();
//        user.setName(AuthorityName.ROLE_USER);
//        authorityRepository.save(user);

    }

//    @Bean
//    public AddRequestHeaderFilter addRequestHeaderFilter(){
//        return new AddRequestHeaderFilter();
//    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
