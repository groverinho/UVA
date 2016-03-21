import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s=br.readLine()).equals("0 0")) {
            StringTokenizer st=new StringTokenizer(s);
            int n=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            
            st=new StringTokenizer(br.readLine());
            int [] balls=new int [b];
            for (int i=0;i<b;i++) {
                balls[i]=Integer.parseInt(st.nextToken());
            }
            
            boolean [] flag=new boolean [n+1];
            for (int i=0;i<b;i++) {
                for (int i2=0;i2<b;i2++) {
                    int diff=Math.abs(balls[i]-balls[i2]);
                    if (diff<flag.length) {
                        flag[diff]=true;
                    }
                }
            }
            
            boolean hasFalse=false;
            for (int i=0;i<flag.length && !hasFalse;i++) {
                hasFalse=!flag[i];
            }
            if (hasFalse) {
                System.out.println('N');
            } else {
                System.out.println('Y');
            }
        }
    }
    
}
