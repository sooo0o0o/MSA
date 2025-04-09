package kr.co.tkdenddl1324;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudService3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudService3Application.class, args);
    }

}
