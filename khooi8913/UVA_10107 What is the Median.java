import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        int i=1;
        ArrayList<Long> a = new ArrayList<>();
        while(sn.hasNext()){
            a.add(sn.nextLong());
            Collections.sort(a);
            int median;
            
            if(i%2!=0){
                median=i/2;
//                System.out.println("i="+i+"median="+median);
                System.out.println(a.get(median));
            }else{
                median=i/2;
//                System.out.println("i="+i+"median="+median);
                long _median = (a.get(median-1)+a.get(median))/2;
                System.out.println(_median);
            }
            i++;
        }
    }
    
}
