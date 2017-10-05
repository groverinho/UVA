import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader systemInput = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while(!(s=systemInput.readLine()).equals("0 0 0 0")){
            StringTokenizer st = new StringTokenizer(s);
            int dayS = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            
            //1 31 12 2016
            
            Calendar c = new GregorianCalendar();
            switch(month){
                case(1):    c.set(year, Calendar.JANUARY, day);
                    break;
                case(2):    c.set(year, Calendar.FEBRUARY, day);
                    break;
                case(3):    c.set(year, Calendar.MARCH, day);
                    break;
                case(4):    c.set(year, Calendar.APRIL, day);
                    break;
                case(5):    c.set(year, Calendar.MAY, day);
                    break;
                case(6):    c.set(year, Calendar.JUNE, day);
                    break;
                case(7):    c.set(year, Calendar.JULY, day);
                    break;
                case(8):    c.set(year, Calendar.AUGUST, day);
                    break;
                case(9):    c.set(year, Calendar.SEPTEMBER, day);
                    break;
                case(10):    c.set(year, Calendar.OCTOBER, day);
                    break;
                case(11):    c.set(year, Calendar.NOVEMBER, day);
                    break;
                case(12):    c.set(year, Calendar.DECEMBER, day);
                    break;
                    
            }
            
            c.add(Calendar.DATE, dayS);
            Date date = c.getTime();
            SimpleDateFormat a = new SimpleDateFormat("d M yyyy");
            String date1 = a.format(date);
            
            System.out.println(date1);
            
        }
    }
    
}
