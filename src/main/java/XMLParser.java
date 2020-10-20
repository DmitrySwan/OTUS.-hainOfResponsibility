import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import model.Person;
import model.PersonList;

import java.io.File;
import java.io.FileReader;
import java.util.List;

public class XMLParser extends Parser {
    @Override
    public List<Person> parse(File file) {
        log.info("# handler " + this.getClass().getName() + " gets file " + file.getName());

        final XStream xStream = new XStream(new StaxDriver());
        XStream.setupDefaultSecurity(xStream);
        xStream.allowTypes(new Class[]{Person.class, PersonList.class});
        xStream.alias("Person", Person.class);
        xStream.alias("Persons", PersonList.class);
        xStream.addImplicitCollection(PersonList.class, "persons");

        try (FileReader fileReader = new FileReader(file)) {
            PersonList personList = (PersonList) xStream.fromXML(fileReader);
            return personList.getPersons();
        } catch (Exception e) {
            log.error("File " + file + " can't be parsed in XML format.");
        }
        return parseNext(file);
    }
}
