package person;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestTimes {
    public static void main(String[] args) {
        System.out.println(new java.util.Date());
        String str="2010-01-01";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date date=simpleDateFormat.parse(str);
            System.out.println(date);
            System.out.println(simpleDateFormat.format(new java.util.Date()));
            String dates=simpleDateFormat.format(date);
            System.out.println(dates);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
