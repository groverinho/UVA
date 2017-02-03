import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader systemInput=new BufferedReader(new InputStreamReader(System.in));
        String a;
        while((a=systemInput.readLine())!=null){
            double n = Double.parseDouble(a);
            double p = Double.parseDouble(systemInput.readLine());
            double k = Math.pow(p, 1/n);
            int kfinal = (int) (k+0.5);
            System.out.println(kfinal);
        }
    }
    
}
