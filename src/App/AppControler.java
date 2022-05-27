package App;

import IO.Loop;
import data.Person;
import data.PersonDatabase;

public class AppControler {
Loop loop = new Loop();
    public void AppControler(){
        PersonDatabase database = new PersonDatabase();
        Person[] persons = database.createArray();
        loop.loop(persons);
    }

}
