package gorkem.spring_shell.Pharmacy;

import gorkem.spring_shell.ShellPrinter;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;

import java.util.Objects;

@RequiredArgsConstructor
@Command(group = "Pharmacy Commands")
public class PharmacyCommand {

    private final PharmacyApiClient pharmacyApiClient;
    private final ShellPrinter shellPrinter;
    private final PharmacyFormatter pharmacyFormatter;

    @Command(command = "pharmacy")
    void pharmacy(
            @Option(required = true, shortNames ='c', longNames = "city") String city,
            @Option(required = false, shortNames = 'd', longNames = "district") String district)
    {
        var data = Objects.requireNonNull(pharmacyApiClient.getPharmacies(city, district)
                .getBody()).result();
        shellPrinter.printSuccess(pharmacyFormatter.convertToTable(data));
    }


}
