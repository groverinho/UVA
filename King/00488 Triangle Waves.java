import java.io.*;

public class Main {
    
    public static void main(String [] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int testCases=Integer.parseInt(br.readLine());
    	int cacheCount=52; //Magic number! Gives the best performance among n numbers...
    	String [] waves={"1\n","22\n","333\n","4444\n","55555\n","666666\n","7777777\n","88888888\n","999999999\n"};
    	String [][] wavesWhole=new String [10][cacheCount+1];
    	for (int i=1;i<10;i++) {
    		wavesWhole[i][1]="";
    		for (int i2=1;i2<=i;i2++) {
    			wavesWhole[i][1]+=waves[i2-1];
    		}
    		for (int i2=i-1;i2>0;i2--) {
    			wavesWhole[i][1]+=waves[i2-1];
    		}
    		for (int i2=2;i2<=cacheCount;i2++) {
    			wavesWhole[i][i2]=wavesWhole[i][i2-1]+"\n"+wavesWhole[i][1];
    		}
    	}
    	for (int i=0;i<testCases;i++) {
    		br.readLine();//blank stuff.
    		int amp=Integer.parseInt(br.readLine());
    		int times=Integer.parseInt(br.readLine());
			int loopCount=times/cacheCount;
    		if (i!=testCases-1) {
    			if (times%cacheCount==0) {
    				for (int i2=0;i2<loopCount;i2++) {
        				System.out.println(wavesWhole[amp][cacheCount]);
    				}
    			} else {
    				for (int i2=0;i2<loopCount;i2++) {
        				System.out.println(wavesWhole[amp][cacheCount]);
    				}
    				System.out.println(wavesWhole[amp][times%cacheCount]);
    			}
    		} else {
    			if (times%cacheCount==0) {
    				for (int i2=0;i2<loopCount-1;i2++) {
        				System.out.println(wavesWhole[amp][cacheCount]);
    				}
    				System.out.print(wavesWhole[amp][cacheCount]);
    			} else {
    				for (int i2=0;i2<loopCount;i2++) {
        				System.out.println(wavesWhole[amp][cacheCount]);
    				}
    				System.out.print(wavesWhole[amp][times%cacheCount]);
    			}
    		}
    	}
    }
}