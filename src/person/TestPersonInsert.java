package person;

public class TestPersonInsert {
    public static void main(String[] args) {
        PersonDaoImpl personDao=new PersonDaoImpl();
        Person person=new Person(3,"啊丢",18,DateUtils.strToUtil("2002-02-17"),"14111@.com","山崖");
        int result=personDao.insert(person);
        if(result==1)
            System.out.println("新增成功");
        else
            System.out.println("新增失败");

    }
}
