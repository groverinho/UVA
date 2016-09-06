package uva_00102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA_00102 {
    
    static int [] bin = new int[9];
    
    public static int count_Moves(int a, int b, int c){
        int moves=0;
        for(int i=0;i<bin.length;i++){
            if(i!=a && i!=b && i!=c){
                moves+=bin[i];
            }
        }
        return moves;
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader sn = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=sn.readLine())!=null){
            StringTokenizer st = new StringTokenizer(s);
            for(int i=0;i<bin.length;i++){
                bin[i]=Integer.parseInt(st.nextToken());
            }
//            System.out.println("array print check: ");
//            for(int i=0;i<bin.length;i++){
//                System.out.print(bin[i]+" ");
//            }
//            System.out.println("");
            //BGC in everyBin
            //Given 3 bins, just count all possible movements
            //B G C
            //0 1 2 b1
            //3 4 5 b2
            //6 7 8 b3
            int [] _bin = new int[6];
            String [] binName = {"bcg","bgc","cbg","cgb","gbc","gcb"};
            _bin[0] = count_Moves(0, 5, 7);
            _bin[1] = count_Moves(0, 4, 8);
            _bin[2] = count_Moves(2, 3, 7);
            _bin[3] = count_Moves(2, 4, 6);
            _bin[4] = count_Moves(1, 3, 8);
            _bin[5] = count_Moves(1, 5, 6);
//                    
//            System.out.println("array print check 2: ");
//            for(int i=0;i<_bin.length;i++){
//                System.out.print(_bin[i]+" ");
//            }
//            System.out.println("");
            
            int temp=Integer.MAX_VALUE;
            int binNum=0;
            
            for(int i=0;i<_bin.length;i++){
                if(_bin[i]<temp){
                    temp=_bin[i];
                    binNum=i;
                }
            }
            
            System.out.printf("%s %d\n",binName[binNum].toUpperCase(),temp);
        }
    }
    
    
}
