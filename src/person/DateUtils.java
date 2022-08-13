package person;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {
    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    //字符串转utildate
    public static java.util.Date strToUtil(String str){
        try {
            java.util.Date date =sdf.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    //utildate转sqldate
    public static java.sql.Date utilToSql(java.util.Date date){
        return new java.sql.Date(date.getTime());
    }
    //utildate转str
    public static String utilToStr(java.util.Date date){
        return sdf.format(date);
    }
}
