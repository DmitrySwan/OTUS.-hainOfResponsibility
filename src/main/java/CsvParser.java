import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import model.Person;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileReader;
import java.util.List;

public class CsvParser extends Parser {
    private static final String CSV_EXTENSION = "csv";

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<Person> parse(File file) {
        log.info("# Handler " + this.getClass().getName() + " gets file " + file.getName());
        try (FileReader fileReader = new FileReader(file)) {
            if (!CSV_EXTENSION.equalsIgnoreCase(FilenameUtils.getExtension(file.getName())))  //problem: txt, xml is parsed by CSV without exceptions
                throw new Exception();
            CSVReader csvReader = new CSVReader(fileReader);
            CsvToBean bean = new CsvToBean();
            bean.setCsvReader(csvReader);
            bean.setMappingStrategy(setColumnMapping());
            return bean.parse();
        } catch (Exception e) {
            log.error("File " + file + " can't be parsed in CSV format.");
        }
        return parseNext(file);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static ColumnPositionMappingStrategy setColumnMapping() {   //Set column mapping strategy
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Person.class);
        String[] columns = new String[]{"name", "age", "country", "profession"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}
