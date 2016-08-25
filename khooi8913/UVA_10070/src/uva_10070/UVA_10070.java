package uva_10070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class UVA_10070 {
    
    static final BigInteger bi4 = new BigInteger("4");
    static final BigInteger bi15 = new BigInteger("15");
    static final BigInteger bi55 = new BigInteger("55");
    static final BigInteger bi100 = new BigInteger("100");
    static final BigInteger bi400 = new BigInteger("400");
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int z=0;
        while((s=br.readLine())!=null && !s.isEmpty()){
            
            BigInteger x = new BigInteger(s);
            
            if(z>0)
                System.out.println("");
            
            boolean leapyear = false;
            boolean huluculu = false;
            boolean bulukulu = false;
            
            if( ((x.mod(bi4).equals(BigInteger.ZERO)) && !(x.mod(bi100).equals(BigInteger.ZERO))) || (x.mod(bi400).equals(BigInteger.ZERO))){
                System.out.println("This is leap year.");
                leapyear=true;
            }          
            if(x.mod(bi15).equals(BigInteger.ZERO)){
                System.out.println("This is huluculu festival year.");
                huluculu=true;
            }
            if(leapyear && x.mod(bi55).equals(BigInteger.ZERO)){
                System.out.println("This is bulukulu festival year.");
                bulukulu=true;
            }
            
            if(!bulukulu && !leapyear && !huluculu)
                System.out.println("This is an ordinary year.");
            
            z++;
        }
        
    }
    
}
