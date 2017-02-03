import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(br.readLine());
        
        for(int a=0;a<numCases;a++){
            HashMap<String,Integer> z = new HashMap<>();
            int numCharge = Integer.parseInt(br.readLine());
            for(int i=0;i<numCharge;i++){
                String s = br.readLine();
                StringTokenizer st = new StringTokenizer(s);
                z.put(st.nextToken(), Integer.parseInt(st.nextToken()));
            }
            double sum=0;
            int numLine = Integer.parseInt(br.readLine());
            for(int i=0;i<numLine;i++){
                String x = br.readLine();
                for(int j=0;j<x.length();j++){
                    String temp = x.charAt(j)+"";
                    if(z.containsKey(temp)){
                        sum+=(z.get(temp));
                    }
                }
            }
            sum/=100;
            System.out.printf("%.2f$\n",sum);
        }
    }
    
}
