package uva_11565;

import java.util.Scanner;

public class UVA_11565 {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        int numCase = sn.nextInt();
        
        for(int i=0;i<numCase;i++){
            int A = sn.nextInt();
            int B = sn.nextInt();
            int C = sn.nextInt();
            boolean solved = false;
            for(int x=-21;x<=21;x++)
                if(!solved)
                    for(int y=-100;y<=100;y++)
                        if(y!=x && (x*x)+(y*y)<=B && !solved)
                            for(int z=-100;z<=100;z++)
                                if(z!=x && z!=y && x+y+z==A && x*y*z ==B && x*x+y*y+z*z==C && !solved){
                                    solved=true;
                                    System.out.printf("%d %d %d\n",x,y,z);
                                }
            if(!solved)
                System.out.println("No solution.");
        }
        
        
            
    }
    
}
