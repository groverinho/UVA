import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(br.readLine());
        for(int i=0;i<numCases;i++){
            int A = Integer.parseInt(br.readLine());
            int B = A-1;
            
            int [] _A = new int[A];
            int [] _B = new int[B];
            
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            for(int j=0;j<A;j++){
                _A[j]=Integer.parseInt(st.nextToken());
            }
            

            for(int j=1;j<A;j++){
                int sum=0;
                for(int y=0;y<=j;y++){
                    if(y!=j && _A[j]>=_A[y])
                        sum++;
                }
                _B[j-1]=sum;
            }
            
            int sum=0;
            for(int k=0;k<B;k++){
                sum+=_B[k];
            }
            System.out.println(sum);
            
        }
    }
    
}
