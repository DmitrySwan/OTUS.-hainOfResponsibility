import model.Person;
import model.PersonList;
import model.PersonListObject;

import java.io.File;
import java.util.Scanner;

public class TxtParser extends Parser {

    @Override
    public PersonList parse(File file) {
        log.info("# handler " + this.getClass().getName() + " gets file " + file.getName());

        PersonListObject persons = new PersonListObject();
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                Person person = new Person();
                person.setName(input.next());
                person.setAge(input.nextInt());
                person.setCountry(input.next());
                person.setProfession(input.next());
                persons.add(person);
            }
            return persons;
        } catch (Exception e) {
            log.error("File " + file + " can't be parsed in TXT format.");
        }
        return parseNext(file);
    }
}
