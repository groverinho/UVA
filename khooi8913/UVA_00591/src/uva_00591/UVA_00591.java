package uva_00591;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVA_00591 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s="";
        int i=1;
        while(!(s=br.readLine()).equals("0")){
            String[] t = br.readLine().split(" ");
            int[] bricks = new int[t.length];
            for(int j=0;j<bricks.length;j++){
                bricks[j]=Integer.parseInt(t[j]);
            }
            int sum=0;
            int average=0;
            for(int j=0;j<bricks.length;j++){
                sum+=bricks[j];
            }
            average=sum/bricks.length;
            int moves=0;
            for(int j=0;j<bricks.length;j++){
                if(bricks[j]<average){
                    moves+=(average-bricks[j]);
                }
            }
            System.out.println("Set #"+i);
            System.out.println("The minimum number of moves is "+ moves+".");
            System.out.println("");
            i++;
        }
    }
    
}
