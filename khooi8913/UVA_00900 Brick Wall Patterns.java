import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        while(true){
            int length = sn.nextInt();
            if(length==0)
                break;
            
            pw.println(fibonacci(length));
        }
        pw.close();
    }
    
    public static long fibonacci(long length){
        if(length<=1)
            return 1;
        else{
            return (fibonacci(length-2) + fibonacci(length-1));
        }
    }
    
}
