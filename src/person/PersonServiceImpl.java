package person;

public class PersonServiceImpl {
    public void Register(Person person) {
        PersonDaoImpl personDao = new PersonDaoImpl();
        Person person1 = personDao.select(person.getName());
        if (person1 == null) {
            System.out.println("不存在，新增");
            if (personDao.insert(person) == 1) {
                System.out.println("新增成功");
            } else {
                System.out.println("新增失败");
            }
        } else {
            System.out.println("已存在");
        }
    }
}
