import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Timer {
    static String[] currentTime;
    static String[] TimeShift;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("input.txt"));
        currentTime = bf.readLine().split(":");
        TimeShift = bf.readLine().split(":");
        if(TimeShift.length == 2){
            String one = TimeShift[0];
            String two = TimeShift[1];
            TimeShift = new String[]{"00", one, two};
        }
        else if(TimeShift.length == 1){
            String one = TimeShift[0];
            TimeShift = new String[]{"00", "00", one};
        }
        Calendar cal = new GregorianCalendar(1970, 0, 1, Integer.parseInt(currentTime[0]), Integer.parseInt(currentTime[1]), Integer.parseInt(currentTime[2]));
        Calendar alarm = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        alarm.add(Calendar.HOUR_OF_DAY, Integer.parseInt(TimeShift[0]));
        alarm.add(Calendar.MINUTE, Integer.parseInt(TimeShift[1]));
        alarm.add(Calendar.SECOND, Integer.parseInt(TimeShift[2]));
        System.out.println(df.format(alarm.getTime()));
    }

}
