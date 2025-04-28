package ec.sasf.prueba.Josue.Lapo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("ec.sasf.prueba.Josue.Lapo.model")
public class MsCompPruebaJosueLapoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCompPruebaJosueLapoApplication.class, args);
    }
}
