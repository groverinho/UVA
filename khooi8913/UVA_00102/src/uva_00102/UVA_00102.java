package uva_00102;
//NOT SOLVED
import java.util.Scanner;

public class UVA_00102 {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        while(sn.hasNextInt()){
            int [] bin = new int[9];
            for(int i=0;i<bin.length;i++){
                bin[i]=sn.nextInt();
            }
            //BGC in everyBin
            //Given 3 bins, just count all possible movements
            //B G C
            //0 1 2
            //3 4 5
            //6 7 8
            int [] _bin = new int[6];
            String [] binName = {"bcg","bgc","cbg","cgb","gbc","gcb"};
            _bin[1] = bin[3]+bin[6]+bin[1]+bin[7]+bin[2]+bin[5];
            _bin[0] = bin[3]+bin[6]+bin[2]+bin[8]+bin[1]+bin[4];
            _bin[2] = bin[5]+bin[8]+bin[0]+bin[6]+bin[1]+bin[4];
            _bin[3] = bin[5]+bin[8]+bin[1]+bin[7]+bin[0]+bin[3];
            _bin[4] = bin[4]+bin[7]+bin[0]+bin[6]+bin[2]+bin[5];
            _bin[5] = bin[4]+bin[7]+bin[2]+bin[8]+bin[3]+bin[0];
            int temp=_bin[0];
            int binNum=0;
            for(int i=0;i<_bin.length;i++){
                if(temp>_bin[i]){
                    temp=bin[i];
                    binNum=i;
                }
            }
            
            System.out.printf("%s %d\n",binName[binNum].toUpperCase(),temp);
            
        }
    }
    
}
