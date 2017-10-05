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
            int numParticipant = Integer.parseInt(st.nextToken());
            int budget = Integer.parseInt(st.nextToken());
            int hotels = Integer.parseInt(st.nextToken());
            int weekends = Integer.parseInt(st.nextToken());
            int cost=0;
            int temp=0;
            boolean OK = false;
            for(int i=0;i<hotels;i++){
                int hotelPrice = Integer.parseInt(systemInput.readLine());
                String b = systemInput.readLine();
                st = new StringTokenizer(b);
                for(int j=0;j<weekends;j++){
                    if(Integer.parseInt(st.nextToken())>=numParticipant){
                        cost=numParticipant*hotelPrice;
                        if(temp==0) {
                            temp=cost;
                        }
                        else{
                            if(cost<temp){
                                temp=cost;
                            }
                        }
                        if(temp<budget){
                            OK = true;
                        }
                    }
                }
           }
            if(OK)  System.out.println(temp);
            else    System.out.println("stay home");
        }
            
        
    }
    
}
