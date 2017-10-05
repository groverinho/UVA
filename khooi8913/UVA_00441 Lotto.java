import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        int t=0;
        while(true){
            int k = sn.nextInt();
            if(k==0)    System.exit(0);
            if(t>0) System.out.println("");
            
            int [] lotto = new int [k];
            for(int i=0;i<lotto.length;i++){
                lotto[i]=sn.nextInt();
            }
            
            for(int a=0;a<k-5;a++)
                for(int b=a+1;b<k-4;b++)
                    for(int c=b+1;c<k-3;c++)
                        for(int d=c+1;d<k-2;d++)
                            for(int e=d+1;e<k-1;e++)
                                for(int f=e+1;f<k;f++)
                                    System.out.printf("%d %d %d %d %d %d\n",lotto[a],lotto[b],lotto[c],lotto[d],lotto[e],lotto[f]);
            
            t++;
        }
    }
    
}
