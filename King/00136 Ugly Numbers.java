import java.util.Arrays;

class Main {
	
	public static void main (String [] abc) throws IOException  {
		int count=1;
		int [] primes={2,3,5};
		long [] values=new long [1500];
		values[0]=1;
		int valuesCount=1;
		int min=0;
		
		while (count<1500) {
			for (int i=min;i<valuesCount;i++) {
				min=valuesCount; //we only multiply to new values that was just created.
				for (int i2=0;i2<primes.length;i2++) {
					long v=values[i]*primes[i2];
					if (Arrays.binarySearch(values, 0, valuesCount, v)<0) {
						if (valuesCount<1500) {
							values[valuesCount++]=v;
							count++;
						} else if (v<values[valuesCount-1]) {
							values[valuesCount-1]=v;
							count++;
						}
					}
					Arrays.sort(values,0,valuesCount);
				}
			}
		}
		
		System.out.println("The 1500'th ugly number is "+values[1499]+".");
	}
}