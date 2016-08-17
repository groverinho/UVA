package uva_11507;
//Not solved
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA_11507 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while(!(s=br.readLine()).equals("0")){
            int length = Integer.parseInt(s);
            String t = br.readLine();
            StringTokenizer st = new StringTokenizer(t);
            char startingAxis=0;
            int position=0;
            int bend=0;
            
            while(st.hasMoreTokens()){
                String starting=st.nextToken();
                if(!starting.equals("No")){
                    if(bend==0){
                        startingAxis = starting.charAt(1);
                        bend++;
                    }
                    if(startingAxis == starting.charAt(1)){
                        if(starting.charAt(0)=='+'){
                            position++;
                        }
                        else{
                            position--;
                        }
                    }
                }
            }
            
            if(startingAxis=='y'){
                int finalPos = position%4;
                switch(finalPos){
                    case 1: System.out.println("+y");   break;
                    case 2: System.out.println("-x");   break;
                    case 3: System.out.println("-y");   break;
                    case 0: System.out.println("+x");   break;    
                }
            }
            else{
                int finalPos = position%4;
                switch(finalPos){
                    case 1: System.out.println("+z");   break;
                    case 2: System.out.println("-x");   break;
                    case 3: System.out.println("-z");   break;
                    case 0: System.out.println("+x");   break;    
                }
            }
        }
    }
    
}
