package person;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class TestPersonSelect {
    public static void main(String[] args) {
        PersonDaoImpl personDao=new PersonDaoImpl();
        Person person=personDao.select(1);
        if(person!=null){
            System.out.println(person);
        }
        else
            System.out.println("没有");
    }
}
