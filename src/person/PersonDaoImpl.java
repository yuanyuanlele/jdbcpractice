package person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl {

    //新增
    public int insert(Person person){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String sql="insert into person(id,name,age,bornDate,email,address) values(?,?,?,?,?,?);";
        try {
            connection=DButils.getconnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,person.getId());
            preparedStatement.setString(2,person.getName());
            preparedStatement.setInt(3,person.getAge());
            preparedStatement.setDate(4,DateUtils.utilToSql(person.getBornDate()));
            preparedStatement.setString(5,person.getEmail());
            preparedStatement.setString(6,person.getAddress());
            int result=preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.closeall(connection,preparedStatement,null);
        }

        return 0;}
    //修改
    public int update(Person person){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String sql="update person set name=?,age=?,bornDate=?,email=?,address=? where id=?";
        try {
            connection=DButils.getconnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,person.getName());
            preparedStatement.setInt(2,person.getAge());
            preparedStatement.setString(3,DateUtils.utilToStr(person.getBornDate()));
            preparedStatement.setString(4,person.getEmail());
            preparedStatement.setString(5,person.getAddress());
            preparedStatement.setInt(6,person.getId());
            int result=preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.closeall(connection,preparedStatement,null);
        }

        return 0;}
    //删除
    public int delete(int id){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String sql="delete from person where id =?";
        connection=DButils.getconnection();
        try {
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            int result=preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.closeall(connection,preparedStatement,null);
        }
        return 0;}
    //查单个
    public Person select(int id){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from person where id=?";
        connection=DButils.getconnection();
        Person person=null;
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next())
            {
                person=new Person();
                int person_id=resultSet.getInt("id");
                String person_name=resultSet.getString("name");
                int person_age=resultSet.getInt("age");
                Date person_bornDate=resultSet.getDate("bornDate");
                String person_email=resultSet.getString("email");
                String person_address=resultSet.getString("address");
                person.setId(person_id);
                person.setName(person_name);
                person.setAge(person_age);
                person.setBornDate(person_bornDate);
                person.setEmail(person_email);
                person.setAddress(person_address);
            }
            return person;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.closeall(connection,preparedStatement,resultSet);
        }
        return null;}
    //查所有
    public List<Person> selectall(){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Person person=null;
        List<Person> personList=new ArrayList<>();
        String sql="select * from person";
        try {
            connection=DButils.getconnection();
            preparedStatement= connection.prepareStatement(sql);
            resultSet= preparedStatement.executeQuery();

            while (resultSet.next())
            {
                person=new Person();
                int person_id=resultSet.getInt("id");
                String person_name=resultSet.getString("name");
                int person_age=resultSet.getInt("age");
                Date person_bornDate=resultSet.getDate("bornDate");
                String person_email=resultSet.getString("email");
                String person_address=resultSet.getString("address");
                person=new Person(person_id,person_name,person_age,person_bornDate,person_email,person_address);
                personList.add(person);
            }
            return personList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DButils.closeall(connection,preparedStatement,resultSet);
        }
        return null;};

    public Person select(String name){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from person where name =?";
        connection=DButils.getconnection();
        Person person=null;
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next())
            {
                person=new Person();
                int person_id=resultSet.getInt("id");
                String person_name=resultSet.getString("name");
                int person_age=resultSet.getInt("age");
                Date person_bornDate=resultSet.getDate("bornDate");
                String person_email=resultSet.getString("email");
                String person_address=resultSet.getString("address");
                person.setId(person_id);
                person.setName(person_name);
                person.setAge(person_age);
                person.setBornDate(person_bornDate);
                person.setEmail(person_email);
                person.setAddress(person_address);
            }
            return person;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.closeall(connection,preparedStatement,resultSet);
        }
        return null;}
}
