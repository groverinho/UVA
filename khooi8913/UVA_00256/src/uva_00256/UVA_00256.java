package uva_00256;

import java.util.ArrayList;
import java.util.Scanner;

public class UVA_00256 {

    public static void main(String[] args) {
        
        ArrayList<Long> a = new ArrayList<>();
        for(int i=0;i<10000;i++){
            long x = i*i;
            a.add(x);
        }
        
        Scanner sn = new Scanner(System.in);
        while(sn.hasNext()){
            int N = sn.nextInt();
                for(int i=0;i<a.size();i++){
                    if(a.get(i) >= Math.pow(10, N))
                        break;
                    //LHS
                    long LHS = a.get(i) / (long) Math.pow(10, N/2);
                    //RHS
                    long RHS = a.get(i) % (long) Math.pow(10, N/2);

                    if(Math.pow(LHS+RHS, 2) == a.get(i)){
                        String s = a.get(i)+"";
                        while(s.length()<N){
                            s="0"+s;
                        }
                        System.out.println(s);
                    }
                }
        }
        
    }
    
}
