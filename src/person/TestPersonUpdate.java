package person;

public class TestPersonUpdate {
    public static void main(String[] args) {
        PersonDaoImpl personDao=new PersonDaoImpl();
        Person person=new Person(3,"dengai",18,null,"14111@.com","xinye");
        int result=personDao.update(person);
        if(result==1)
            System.out.println("修改成功");
        else
            System.out.println("修改失败");

    }
}
