import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(br.readLine());
        for(int i=0;i<numCases;i++){
            boolean done=false;
            int numIteration=1;
            long num1 = Integer.parseInt(br.readLine());
            long num2 = Integer.parseInt(reverse(num1+""));
            long _num3=0;
            String num3="";
            String num4="";
            while(!done){
                _num3 = num1+num2;
                num3 = _num3+"";
                num4 = reverse(num3);
                if(num3.equals(num4)){
                    done = true;
                }
                else{
                    num1 = Integer.parseInt(num3);
                    num2 = Integer.parseInt(num4);
                    numIteration++;
                }
            }
            System.out.println(numIteration+" "+_num3);
        }
    }
    
    public static String reverse(String a){
        String b="";
        for(int j=a.length()-1;j>=0;j--){
            b+=(a+"").charAt(j);
        }
        return b;
    }
    
}
