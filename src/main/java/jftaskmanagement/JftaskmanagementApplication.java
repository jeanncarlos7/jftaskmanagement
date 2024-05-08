	package jftaskmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@Controller
@EnableCaching
@OpenAPIDefinition(
	info = @Info(
		title = "JF Task Management",
		summary = "API do App JF Task Management",
		description = "Um app de gerenciamento de tarefas",
		version = "1.0.0",
		contact = @Contact(name = "Jean Carlos", email = "jean@gmail.com")
	)
)
public class JftaskmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(JftaskmanagementApplication.class, args);
	}

	@RequestMapping
	@ResponseBody
	public String home (){
		return "JF Task Management";
	}

}