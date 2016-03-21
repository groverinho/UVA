import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    
    static int [] cache = new int [1000001];
    static boolean [] cacheFlag = new boolean [1000001];
    
    static int f91 (int n) {
        if (!cacheFlag[n]) {
            if (n<=100) {
                cache[n]=f91(f91(n+11));
            } else {
                cache[n]=n-10;
            }
            cacheFlag[n]=true;
        }
        return cache[n];
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s=br.readLine())!=null && !s.equals("0")) {
            int n=Integer.parseInt(s);
            StringBuilder sb=new StringBuilder("f91(");
            sb.append(n);
            sb.append(") = ");
            sb.append(f91(n));
            System.out.println(sb.toString());
        }
    }
    
}
