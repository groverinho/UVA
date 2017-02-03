import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        int X=0;
        while((X=Integer.parseInt(br.readLine()))!=0){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            ArrayList<Integer> age = new ArrayList();
            for(int i=0;i<X;i++){
                age.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(age);
            StringBuilder sb = new StringBuilder();
            String z = age.toString();
            for(int i=0;i<z.length();i++){
                if(Character.isDigit(z.charAt(i))||Character.isSpaceChar(z.charAt(i))){
                    sb.append(z.charAt(i));
                }
            }
            pr.println(sb.toString());
        }
        pr.close();
        
    }
    
}
