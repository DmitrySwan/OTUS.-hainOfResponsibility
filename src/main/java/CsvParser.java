import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import model.PersonList;
import model.PersonListObject;
import model.PersonObject;

import java.io.File;
import java.io.FileReader;

public class CsvParser extends Parser {
    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public PersonList parse(File file) {
        log.info("# Обработчик " + this.getClass().getName() + " получил файл " + file.getName());
        try (FileReader fileReader = new FileReader(file)) {
            CSVReader csvReader = new CSVReader(fileReader);
            return (PersonListObject) new CsvToBean().parse(setColumnMapping(), csvReader);
        } catch (Exception e) {
            log.error("File " + file + " can't be parsed in CSV format.");
        }
        return parseNext(file);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static ColumnPositionMappingStrategy setColumnMapping() {   //Set column mapping strategy
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(PersonObject.class);
        String[] columns = new String[]{"name", "age", "country", "profession"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}
