package uva_01237;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_01237 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        int numCases = Integer.parseInt(br.readLine());
        for(int i=0;i<numCases;i++){
            int numRecord = Integer.parseInt(br.readLine());
            StringTokenizer st;
            Car[] A = new Car[numRecord];
            for(int j=0;j<numRecord;j++){
                String s = br.readLine();
                st = new StringTokenizer(s);
                A[j]=new Car(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            
            int numQuery = Integer.parseInt(br.readLine());
            
            
            for(int j=0;j<numQuery;j++){
                int found = 0;
                int answer = 0;
                int Query = Integer.parseInt(br.readLine());
                for(int k=0;k<A.length;k++){
                    if(Query>=A[k].minPrice && Query<=A[k].maxPrice){
                        found++;
                        answer=k;
                    }
                }
                if(found==1){
                    pr.println(A[answer].name);
                }else{
                    pr.println("UNDETERMINED");
                }
            }
            if(i!=numCases-1)
                pr.println("");
        }
        pr.close();
    }
}

class Car{
    String name;
    int minPrice;
    int maxPrice;
    
    Car(String name, int minPrice, int maxPrice){
        this.name = name;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }   
}
