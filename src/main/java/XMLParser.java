import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import model.PersonList;
import model.PersonListObject;
import model.PersonObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class XMLParser extends Parser {
    @Override
    public PersonList parse(File file) {
        log.info("# Обработчик " + this.getClass().getName() + " получил файл " + file.getName());

        final XStream xStream = new XStream(new StaxDriver());
        XStream.setupDefaultSecurity(xStream);
        xStream.allowTypes(new Class[]{PersonObject.class, PersonListObject.class});
        xStream.alias("Person", PersonObject.class);
        xStream.alias("Persons", PersonListObject.class);
        xStream.addImplicitCollection(PersonListObject.class, "persons");

        try (FileReader fileReader = new FileReader(file)) {
            return (PersonListObject) xStream.fromXML(fileReader);
        } catch (IOException e) {
            log.error("File " + file + " can't be parsed in XML format.");
        }
        return parseNext(file);
    }
}
