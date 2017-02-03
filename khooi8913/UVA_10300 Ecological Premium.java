import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(br.readLine());
        for(int i=1;i<=numCases;i++){
            int numFarm = Integer.parseInt(br.readLine());
            int sum=0;
            for(int j=0;j<numFarm;j++){
                String s = br.readLine();
                StringTokenizer st = new StringTokenizer(s);
                int size =Integer.parseInt(st.nextToken());
                int numAnimal =Integer.parseInt(st.nextToken());
                int environmental =Integer.parseInt(st.nextToken());
                
                double prem = (size) * environmental;
                int finalAns = (int)prem;
                sum+=finalAns;
            }

            System.out.println(sum);
            
        }
    }
    
}
