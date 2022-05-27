package data;

import IO.io;
import interfaces.Printer;

import java.util.Arrays;

public class PersonDatabase implements Printer {
    private static final int INITIAL_LENGTH = 1;
    private int currentLength = 0;
    io inOut = new io();

    public Person[] createArray() {
        return new Person[INITIAL_LENGTH];
    }

    public Person[] addPerson(Person[] persons) {
        currentLength++;
        Person person = inOut.createPerson();
        if (person == null)
            throw new NullPointerException("Wrzuciłeś pusty obiekt!?");

        if (currentLength == persons.length) {
            persons = Arrays.copyOf(persons, (persons.length * 2));
        }
        persons[currentLength - 1] = person;
        return persons;
    }

    public void printArray(Person[] persons) {
        for (int i = 0; i < currentLength; i++) {
            System.out.println(persons[i]);
        }
    }

    public void size(Person[] person){
        int counter = 0;
        for (int i = 0; i< person.length; i++){
            if (person[i] != null)
                counter++;
        }
        print(counter);
    }

    public void get(Person[] people, int index){
        print(people[index]);
    }

    public Person[] remove(Person[] people, Person person){
        if (person == null){
            throw new NullPointerException("Wrzuciłęś mi NUlla!?");
        }
        final int INITIAL_INDEX = -1;
        int currentIndex = INITIAL_INDEX;
        for (int i=0; i<currentLength && currentIndex == INITIAL_INDEX; i++){
            if (people[i].equals(person)){
                currentIndex = i;
            }
        }
        if (currentIndex != INITIAL_INDEX){
            int newLength = people.length-currentIndex-1;
            System.arraycopy(people,currentIndex+1, people, currentIndex, newLength);
            currentLength--;
            people[currentLength] = null;

        }
        return people;
    }

}
