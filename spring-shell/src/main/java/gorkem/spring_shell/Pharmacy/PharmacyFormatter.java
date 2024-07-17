package gorkem.spring_shell.Pharmacy;

import org.springframework.shell.table.ArrayTableModel;
import org.springframework.shell.table.BorderStyle;
import org.springframework.shell.table.TableBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PharmacyFormatter {

    private static String[] toRow(PharmacyItem pharmacyItem){
        return new String[]{pharmacyItem.name(), pharmacyItem.dist(), pharmacyItem.address(), pharmacyItem.phone()};
    }

    public String convertToTable(List<PharmacyItem> items){
        var data = items.stream()
                .map(PharmacyFormatter::toRow)
                .collect(Collectors.toList());

        data.add(0, new String[]{"name", "dist", "address", "phone"});
        ArrayTableModel tableModel = new ArrayTableModel(data.toArray(Object[][]::new));
        TableBuilder tableBuilder = new TableBuilder(tableModel);

        tableBuilder.addHeaderAndVerticalsBorders(BorderStyle.fancy_heavy_triple_dash);
        tableBuilder.addInnerBorder(BorderStyle.fancy_double);
        return tableBuilder.build().render(100);
    }
}
