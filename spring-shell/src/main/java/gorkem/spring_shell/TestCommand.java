package gorkem.spring_shell;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;

@RequiredArgsConstructor
@Command(group = "Test Commands")
public class TestCommand {

    private final ShellPrinter shellPrinter;

    @Command(command = "hi", description = "That command is going to return 'hello' ")
    void hello(
            @NotBlank
            @Size(min = 3, max = 10)
            @Option(shortNames = 'n', longNames = "name", description = "name input")
            String name,


            @NotBlank
            @Size(min = 3, max = 10)
            @Option(shortNames = 's', longNames = "surname", description = "surname input")
            String surname
    )

    {
     shellPrinter.printSuccess("Hello  %s %s".formatted(name,surname));
    }
}
