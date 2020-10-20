import model.Person;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TxtParser extends Parser {

    @Override
    public List<Person> parse(File file) {
        log.info("# handler " + this.getClass().getName() + " gets file " + file.getName());

        List<Person> persons = new LinkedList<>();
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
