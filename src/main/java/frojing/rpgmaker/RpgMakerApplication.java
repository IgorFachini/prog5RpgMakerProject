package frojing.rpgmaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class RpgMakerApplication {

	/**
	 * Gerador inicial:
	 * https://start.spring.io/
	 * 
	 * Git:
	 * https://github.com/spring-projects/spring-boot
	 * 
	 * Exemplo:
	 * http://blog.netgloo.com/2014/10/27/using-mysql-in-spring-boot-via-spring-data-jpa-and-hibernate/
	 * https://github.com/netgloo/spring-boot-samples/tree/master/spring-boot-mysql-springdatajpa-hibernate
	 * 
	 * Documentação:
	 * http://docs.spring.io/spring-boot/docs/1.5.3.RELEASE/reference/htmlsingle/
	 * 
	 * Para executar:
	 * spring-boot:run
	 */
	
	@RequestMapping("/")
	String home() {
		return "RPG Maker!";
	}

	public static void main(String[] args) {
		SpringApplication.run(RpgMakerApplication.class, args);
	}
}
