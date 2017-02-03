import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(br.readLine());
        for(int i=0;i<numCases;i++){
            int numShop = Integer.parseInt(br.readLine());
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            
            int [] shopNum = new int[numShop];
            for(int j=0;j<numShop;j++){
                shopNum[j]=Integer.parseInt(st.nextToken());
            }
            for(int k=0;k<numShop-1;k++){
                for(int j=0;j<numShop-1;j++){
                    if(shopNum[j]>shopNum[j+1]){
                        int temp=shopNum[j];
                        shopNum[j]=shopNum[j+1];
                        shopNum[j+1]=temp;
                    }
                }
            }
            
            System.out.println((shopNum[numShop-1]-shopNum[0])*2);
            
        }
        
    }
    
}
