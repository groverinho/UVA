import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader systemInput=new BufferedReader(new InputStreamReader(System.in));
        String a;
        while((a=systemInput.readLine())!=null){
            StringTokenizer st = new StringTokenizer(a);
            double heightWell = Double.parseDouble(st.nextToken());
            if(heightWell==0)   break;
            double canClimb = Double.parseDouble(st.nextToken());
            double slide = Double.parseDouble(st.nextToken());
            double fatique = Double.parseDouble(st.nextToken())/100;
            double fatiqueDecrement = canClimb*(fatique);
            
            //define day 1
            int day=0;
            double climbedDistance=0;
            
            while(true){
                ++day;
                climbedDistance+=canClimb;
                
                if(climbedDistance>heightWell){
                    System.out.println("success on day " + day);
                    break;
                }
                
                climbedDistance-=slide;
                if(climbedDistance<0){
                    System.out.println("failure on day " + day);
                    break;
                }
                
                canClimb-=fatiqueDecrement;
                if(canClimb<0){
                    canClimb=0;
                }
            }
        }
        
    }
    
}
