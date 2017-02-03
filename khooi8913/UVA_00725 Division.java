import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        int t=0;
        while(sn.hasNext()){
            int n = sn.nextInt();
            if(n==0)    System.exit(0);
            boolean status=false;
            if(t>0) System.out.println("");
            for(int fghij=1234; fghij<=98765/n;fghij++){
                int abcde = fghij * n;
                int tmp;
                int used=0;
                if(fghij<10000) used=1;
                
                tmp = abcde;
                while(tmp>0){
                    used |= (1 << (tmp%10));
                    tmp/=10;
                }
                
                tmp = fghij;
                while(tmp>0){
                    used |= (1 << (tmp%10));
                    tmp/=10;
                }
                
                if(used == (1<<10)-1){
                    System.out.printf("%05d / %05d = %d\n", abcde, fghij, n);
                    status=true;
                }
            }
                            
            if(!status){
                System.out.printf("There are no solutions for %d.\n", n);
            }
            t++;
        }
    }
    
}
