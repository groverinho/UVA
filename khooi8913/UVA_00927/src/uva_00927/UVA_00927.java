package uva_00927;
//NOT SOLVED 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVA_00927 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        int numCases = Integer.parseInt(br.readLine());
        for(int i=0;i<numCases;i++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            ArrayList<Integer> a = new ArrayList<>();
            while(st.hasMoreTokens()){
                a.add(Integer.parseInt(st.nextToken()));
            }
            
            
        }
    }
    
    public static int findN(int d, int k){
        int p =0;
        for(int n=1;;n++){
            int previousp = p;
            p+= n*d;
            if(k>previousp && k<=p)
                return n;
        }
        
    }
}
