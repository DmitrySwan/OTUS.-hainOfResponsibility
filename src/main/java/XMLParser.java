import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import model.Person;
import model.PersonList;
import model.PersonListObject;

import java.io.File;
import java.io.FileReader;

public class XMLParser extends Parser {
    @Override
    public PersonList parse(File file) {
        log.info("# handler " + this.getClass().getName() + " gets file " + file.getName());

        final XStream xStream = new XStream(new StaxDriver());
        XStream.setupDefaultSecurity(xStream);
        xStream.allowTypes(new Class[]{Person.class, PersonListObject.class});
        xStream.alias("Person", Person.class);
        xStream.alias("Persons", PersonListObject.class);
        xStream.addImplicitCollection(PersonListObject.class, "persons");

        try (FileReader fileReader = new FileReader(file)) {
            return (PersonListObject) xStream.fromXML(fileReader);
        } catch (Exception e) {
            log.error("File " + file + " can't be parsed in XML format.");
        }
        return parseNext(file);
    }
}
