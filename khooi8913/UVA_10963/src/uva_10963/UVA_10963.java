package uva_10963;

import java.util.Scanner;

public class UVA_10963 {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        
        int numCases = sn.nextInt();
        sn.nextLine();
        for(int i=0;i<numCases;i++){
            int numCol = sn.nextInt();
            int [] col = new int [numCol*2];
            for(int j=0;j<col.length;j++){
                col[j]=sn.nextInt();
            }
            int diff=0;
            int constant=0;
            boolean check=true;
            for(int j=0;j<col.length-1;j+=2){
                diff=Math.abs(col[j]-col[j+1]);
                if(j==0){
                    constant=diff;
                }else{
                    if(constant!=diff){
                        check=false;
                        break;
                    }
                }
            }
            if(i>0)
                System.out.println("");
            
            if(check)  
                System.out.println("yes");
            else
                System.out.println("no");
            
        }
    }
    
}
