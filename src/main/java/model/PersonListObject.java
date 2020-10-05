package model;

import java.util.ArrayList;
import java.util.List;

public class PersonListObject implements PersonList {

    private List<Person> persons;

    public PersonListObject() {
        persons = new ArrayList<>();
    }

    public PersonListObject(List<Person> persons) {
        this.persons = persons;
    }

    public void add(Person person) {
        persons.add(person);
    }

    @Override
    public String toString() {
        return persons.toString();
    }
}