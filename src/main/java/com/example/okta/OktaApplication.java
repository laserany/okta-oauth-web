package com.example.okta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class OktaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OktaApplication.class, args);
	}

}



@RestController
class OktaController {
	@GetMapping("/")
	public String securedHello(@AuthenticationPrincipal OidcUser user) {
		return "hello " + user.getFullName();
	}
}