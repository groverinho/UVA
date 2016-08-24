//NOT SOLVED, FURTHER OPTIMIZATION REQUIRED
//TLE 
package uva_11571;

import java.util.Scanner;

public class UVA_11571 {

    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        int numCase = sn.nextInt();
        
        for(int i=0;i<numCase;i++){
            long A = sn.nextLong();
            long B = sn.nextLong();
            long C = sn.nextLong();
            
            long smallA = (long)A/3;
            System.out.println(smallA);
            
            long sqrtB = (long)Math.sqrt(B);
            System.out.println(sqrtB);
            
            long sqrtC = (int)Math.sqrt(C/3);
            System.out.println(sqrtC);
            
            boolean solved = false;
            
            for(long x=-smallA;x<=smallA;x++)
                if(!solved)
                    for(long y=-sqrtC;y<=sqrtC;y++)
                        if(y!=x &&(x*x+y*y<=B) && !solved)
                            for(long z=-sqrtC;z<=sqrtC;z++)
                                if(z!=x && z!=y && x+y+z==A && x*y*z ==B && x*x+y*y+z*z==C && !solved){
                                    solved=true;
                                    System.out.printf("%d %d %d\n",x,y,z);
                                }
            if(!solved)
                System.out.println("No solution.");
            
        }
        
        
    }
    
}
