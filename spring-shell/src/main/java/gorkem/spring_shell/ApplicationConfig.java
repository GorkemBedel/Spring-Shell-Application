package gorkem.spring_shell;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.Command;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Configuration
public class ApplicationConfig {

    @Bean
    CommandExceptionHandler exceptionHandler(ShellPrinter shellPrinter){
        return new CommandExceptionHandler(shellPrinter);
    }

}
