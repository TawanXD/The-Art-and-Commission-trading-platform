package Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000")
                        .exposedHeaders("x-total-count");
                registry.addMapping("/users")
                        .allowedOrigins("http://localhost:3000");
                registry.addMapping("/users/*")
                        .allowedOrigins("http://localhost:3000");
                registry.addMapping("/update/*")
                        .allowedOrigins("http://localhost:3000");
                registry.addMapping("/artists")
                        .allowedOrigins("http://localhost:3000");
                registry.addMapping("/artists/*")
                        .allowedOrigins("http://localhost:3000");
                registry.addMapping("/updateArtists/*")
                        .allowedOrigins("http://localhost:3000");
                registry.addMapping("/uploadFile/*")
                        .allowedOrigins("http://localhost:3000");
                registry.addMapping("/uploadFile")
                        .allowedOrigins("http://localhost:3000");
            }
        };
    }
}
