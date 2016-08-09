import java.io.IOException;
import java.util.Scanner;

class Main {

	public static int sumOfDivisors (int num) {
		int count=1;
		for (int i=2;i*i<num;i++) {
			if (num%i==0) {
				count+=(i+(num/i));
			}
		}
		int sqrt=(int)Math.sqrt(num);
		if (sqrt*sqrt==num){
			count+=sqrt;
		}
		return count;
	}
	
	public static void main(String[] args)  throws IOException {  
        Scanner sc=new Scanner(System.in);
        int num;
    	StringBuilder sb=new StringBuilder();
        sb.append("PERFECTION OUTPUT\n");
        String blank="     ";
        while ((num=sc.nextInt())!=0) {
        	String ans="";
        	int sod=sumOfDivisors(num);
        	if (num==1) {
        		sod=0;
        	}
        	if (sod<num) {
        		ans="DEFICIENT";
        	} else if (sod==num) {
        		ans="PERFECT";
        	} else {
        		ans="ABUNDANT";
        	}
        	

        	String v=String.valueOf(num);
        	sb.append(blank.substring(0,5-v.length()));
        	sb.append(v);
        	sb.append("  ");
        	sb.append(ans);
        	sb.append("\n");
        }
        sb.append("END OF OUTPUT");
        System.out.println(sb.toString());
        sc.close();
	}  
}