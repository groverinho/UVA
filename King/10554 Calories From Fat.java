import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	String s;
    	int [] cpg = {9,4,4,4,7};
		double [] calories=new double [5];
		int dashCount=0;
    	while (dashCount<2) {
    		s=br.readLine();
    		if (!s.equals("-")) {
    			dashCount=0;
		    	StringTokenizer st=new StringTokenizer(s);
		    	String [] data=new String [5];
		    	double caloriesKnown=0;
		    	double percentageKnown=100;
		    	double [] currCalories=new double[5];
		    	for (int i=0;i<5;i++) {
		    		data[i]=st.nextToken();
		    		if (data[i].endsWith("%")) {
		    			percentageKnown-=Integer.parseInt(data[i].substring(0, data[i].length()-1));
		    		} else if (data[i].endsWith("g")) {
		    			currCalories[i]=Integer.parseInt(data[i].substring(0, data[i].length()-1))*cpg[i];
		    			caloriesKnown+=currCalories[i];
		    		} else if (data[i].endsWith("C")) {
		    			currCalories[i]=Integer.parseInt(data[i].substring(0, data[i].length()-1));
		    			caloriesKnown+=currCalories[i];
		    		}
		    	}
		    	double percentPerC=caloriesKnown/percentageKnown;
		    	for (int i=0;i<5;i++) {
		    		if (data[i].endsWith("%")) {
		    			currCalories[i]=percentPerC*(Double.parseDouble(data[i].substring(0, data[i].length()-1)));
		    		}
		    	}
		    	
		    	for (int i=0;i<5;i++) {
		    		calories[i]+=currCalories[i];
		    	}
    		} else {
    			if (dashCount==0) {
        	    	double caloriesSum=0;
        	    	for (int i=0;i<5;i++) {
        	    		caloriesSum+=calories[i];
        	    	}
        	    	caloriesSum=(calories[0]*100)/caloriesSum;
        	    	System.out.println(Math.round(caloriesSum)+"%");
        	    	calories=new double [5];
    			}
    			dashCount++;
    		}
    	}
    }
	
}