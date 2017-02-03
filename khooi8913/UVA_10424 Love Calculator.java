import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=br.readLine())!=null&&!s.isEmpty()){
            String s1 = s.toLowerCase();
            String s2 = br.readLine().toLowerCase();
            
            int sumS1=0;
            for(int i=0;i<s1.length();i++){
                if(Character.isAlphabetic(s1.charAt(i))){
                    sumS1+=(s1.charAt(i)-96);
                }
            }
            String _sumS1 = sumS1+"";
            
            int sumS2=0;
            for(int i=0;i<s2.length();i++){
                if(Character.isAlphabetic(s2.charAt(i))){
                    sumS2+=(s2.charAt(i)-96);
                }
            }
            String _sumS2 = sumS2+"";
            
            while(_sumS1.length()!=1){
                sumS1=0;
                for(int i=0;i<_sumS1.length();i++){
                    sumS1+=Integer.parseInt(_sumS1.charAt(i)+"");
                }
                _sumS1 = sumS1+"";
            }
            
            while(_sumS2.length()!=1){
                sumS2=0;
                for(int i=0;i<_sumS2.length();i++){
                    sumS2+=Integer.parseInt(_sumS2.charAt(i)+"");
                }
                _sumS2 = sumS2+"";
            }
            
            int a = Integer.parseInt(_sumS1);
//            System.out.println(a);
            int b = Integer.parseInt(_sumS2);
//            System.out.println(b);
            
            double ratio=0;
            if(a>b){
                ratio = (b*1.0/a*1.0)*100;
                System.out.printf("%.2f %s\n",ratio,"%");
            }
            else if(a<b){
                ratio = (a*1.0/b*1.0)*100;
                System.out.printf("%.2f %s\n",ratio,"%");
            }
            else{
                System.out.println("100.00 %");
            }   
        }
    }
    
}
