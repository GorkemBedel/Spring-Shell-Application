package gorkem.spring_shell;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.ParameterValidationException;
import org.springframework.shell.command.CommandExceptionResolver;
import org.springframework.shell.command.CommandHandlingResult;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

public class CommandExceptionHandler implements CommandExceptionResolver {

    private final ShellPrinter shellPrinter;

    public CommandExceptionHandler(ShellPrinter shellPrinter) {
        this.shellPrinter = shellPrinter;
    }

    @Override
    public CommandHandlingResult resolve(Exception ex) {
        if(ex instanceof ParameterValidationException){
            shellPrinter.printError("------ Error ------");
            return CommandHandlingResult.of(
                    ((ParameterValidationException) ex).getConstraintViolations().stream()
                            .map(x -> x.getPropertyPath() + " " + x.getMessage())
                            .collect(Collectors.joining(". ")) + '\n');

        }
        return CommandHandlingResult.of(ex.getMessage() + "\n", 1);
    }
}
