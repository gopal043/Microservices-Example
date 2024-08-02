package com.microservices.ConfigServer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {


	@Value("${message.from.github}")
	private static String msgFromGithub;
	
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
		
		System.out.println("msgFromGithub ::"+msgFromGithub);
	}
	
	

}

/* http://localhost:8888/Config_Server_Application/default 
 * 
 * config-server dependency
 *
 * @EnableConfigServer 
 * 
 * remaining properties file
 * 
 * */
