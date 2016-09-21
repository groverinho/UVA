package uva_10656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_10656 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        int sizeSet = Integer.parseInt(br.readLine());
        
        while((sizeSet!=0)){    
            int [] X = new int [sizeSet];
            for(int i=0;i<sizeSet;i++){
                X[i]=Integer.parseInt(br.readLine());
            }
            boolean flag=false;
            for(int i=0;i<sizeSet;i++){
                if(X[i]>0){
                    if(flag)    pr.print(" ");
                    pr.printf("%d",X[i]);
                    flag = true;
                }
            }
            if(!flag)
                pr.printf("0");

            pr.printf("\n");
            sizeSet = Integer.parseInt(br.readLine());
        }

        pr.close();
    }
    
}
