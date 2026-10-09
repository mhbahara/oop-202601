package id.ac.upb.asetpinjam.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** DISEDIAKAN dosen. Jalankan: mvn -pl api spring-boot:run. Swagger UI: http://localhost:8080/swagger-ui.html */
@SpringBootApplication
public class AsetPinjamApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsetPinjamApplication.class, args);
    }
}
