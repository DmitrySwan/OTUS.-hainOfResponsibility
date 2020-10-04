import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.CsvToBean;

import java.io.File;
import java.io.FileReader;

public class CsvParser extends Parser {
    @Override
    public String parse(File file) {
        log.info("# Обработчик " + this.getClass().getName() + " получил файл " + file.getName());
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) throws Exception
    {
        CsvToBean csv = new CsvToBean();
        String csvFilename = "data.csv";
        CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
        //Set column mapping strategy
        List list = csv.parse(setColumMapping(), csvReader);
        for (Object object : list) {
            Employee employee = (Employee) object;
            System.out.println(employee);
        }
    }
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static ColumnPositionMappingStrategy setColumMapping()
    {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Employee.class);
        String[] columns = new String[] {"id", "firstName", "lastName", "country", "age"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}
