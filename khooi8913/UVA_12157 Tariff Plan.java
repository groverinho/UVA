import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        int numCases = sn.nextInt();
        for(int i=1;i<=numCases;i++){
            int callNum = sn.nextInt();
            int [] calls = new int[callNum];
            
            for(int j=0;j<calls.length;j++){
                calls[j]=sn.nextInt()+1;
            }
            //Mile 30s for 10sen
            //Juice 60s for 15sen
            int Mile=0;
            int Juice=0;
            
            for(int j=0;j<calls.length;j++){
                if(calls[j]%30!=0)
                    Mile+=((calls[j]/30)+1)*10;
                else
                    Mile+=((calls[j]/30))*10;
                
                if(calls[j]%60!=0)
                    Juice+=((calls[j]/60)+1)*15;
                else
                    Juice+=((calls[j]/60))*15;
            }
            
            if(Mile<Juice)
                System.out.printf("Case %d: Mile %d\n",i,Mile);
            else if(Juice<Mile)
                System.out.printf("Case %d: Juice %d\n",i,Juice);
            else
                System.out.printf("Case %d: Mile Juice %d\n",i,Juice);
        }
    }
    
}
