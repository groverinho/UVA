package uva_12015;

import java.util.Scanner;

public class UVA_12015 {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        int numCases = sn.nextInt();
        for(int i=1;i<=numCases;i++){
            int max=0;
            String[] url = new String[10];
            int [] urlrelevance = new int[10];
            for(int j=0;j<10;j++){
                url[j]=sn.next();
                urlrelevance[j]=sn.nextInt();
                if(urlrelevance[j]>max)
                    max=urlrelevance[j];
            }
            
            System.out.printf("Case #%d:\n", i);
            for(int j=0;j<10;j++){
                if(urlrelevance[j]==max)
                    System.out.println(url[j]);
            }
        }
    }
}
