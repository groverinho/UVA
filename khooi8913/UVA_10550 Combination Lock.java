import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader systemInput = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while(!(s=systemInput.readLine()).equals("0 0 0 0")){
            int angleRotated=0;
            StringTokenizer st = new StringTokenizer(s);
            int initialPost = Integer.parseInt(st.nextToken());
            int pass1 = Integer.parseInt(st.nextToken());
            int pass2 = Integer.parseInt(st.nextToken());
            int pass3 = Integer.parseInt(st.nextToken());
            
            //turn2dial
            angleRotated+=720;
            
            //turnFirst
            int angleNeeded = initialPost - pass1;
            if(angleNeeded<0)
                angleNeeded+=40;
            
            angleRotated+=(angleNeeded*9);            
            
            //turn1fulldial
            angleRotated+=360;
            
            //turnSecond
            angleNeeded = pass2-pass1;
            if(angleNeeded<0)
                angleNeeded+=40;
            
            angleRotated+=(angleNeeded*9);            
            
            //turnThird
            angleNeeded = pass2-pass3;
            if(angleNeeded<0)
                angleNeeded+=40;
            
            angleRotated+=(angleNeeded*9);
            
            System.out.println(angleRotated);
            
        }
    }
}
