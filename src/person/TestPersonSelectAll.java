package person;

import java.util.ArrayList;
import java.util.List;

public class TestPersonSelectAll {
    public static void main(String[] args) {
        PersonDaoImpl personDao=new PersonDaoImpl();
        List<Person> personList=new ArrayList<>();
        personList=personDao.selectall();
        for(Person t:personList)
            System.out.println(t);
    }
}
