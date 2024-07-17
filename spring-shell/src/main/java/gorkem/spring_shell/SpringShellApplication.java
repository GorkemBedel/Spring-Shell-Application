package gorkem.spring_shell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.shell.command.annotation.CommandScan;

@CommandScan
@EnableFeignClients
@SpringBootApplication
public class SpringShellApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringShellApplication.class, args);
	}

}
