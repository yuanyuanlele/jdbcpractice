package person;

public class TestRegister {
    public static void main(String[] args) {
        PersonServiceImpl personService=new PersonServiceImpl();
        Person person=new Person(4,"红火",21,DateUtils.strToUtil("2008-11-16"),"hdwqeio@.com","无敌的都市");
        personService.Register(person);
    }
}
