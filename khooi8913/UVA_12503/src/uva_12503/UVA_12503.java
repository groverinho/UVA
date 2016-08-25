package uva_12503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVA_12503 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(br.readLine());
        for(int i=0;i<numCases;i++){
            int numIns = Integer.parseInt(br.readLine());
            String [] a = new String[numIns];
            for(int j=0;j<numIns;j++){
                a[j] = br.readLine();
            }
            int p=0;
            for(int j=0;j<numIns;j++){
                if(a[j].equals("LEFT")){
                    p--;
//                    System.out.println(p);
                }
                else if(a[j].equals("RIGHT")){
                    p++;
//                    System.out.println(p);
                }
                else{
                    p+=MoveRobot(a[j],a);
                }
            }
            System.out.println(p);
        }
    }
    
    public static int MoveRobot(String Ins, String[] a){
        if(Ins.equals("LEFT")){
            return -1;
        }
        else if(Ins.equals("RIGHT")){
            return 1;   
        }
        else{
//            System.out.println(Ins);
            String [] b = Ins.split(" ");
            int numIns = Integer.parseInt(b[2])-1;
//            System.out.println(a[numIns]);
            return MoveRobot(a[numIns], a);
        }
    }
    
}
