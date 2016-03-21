import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String[]args) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//pre-generate numbers.
		int [][][] numbers=new int [6][60000][6]; //9^5 max
		int [] numbersCount=new int [6];
		numbers[1]=new int [][] {new int [] {1},new int [] {2},new int [] {3},new int [] {4},new int [] {5},new int [] {6},new int [] {7},new int [] {8},new int [] {9}};
		numbersCount[1]=numbers[1].length;
		for (int i=2;i<numbers.length;i++) {
			for (int i2=0;i2<numbersCount[i-1];i2++) {
				for (int i3=1;i3<10;i3++) {
					numbers[i][numbersCount[i]]=Arrays.copyOf(numbers[i-1][i2], i);
					numbers[i][numbersCount[i]][i-1]=i3;
					numbersCount[i]++;
				}
			}
		}
		
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int input=Integer.parseInt(st.nextToken());
			int reqStrongCount=Integer.parseInt(st.nextToken());
			int reqWeakCount=Integer.parseInt(st.nextToken());
			int inputLength=(int)Math.log10(input)+1;
			
			int [] inputAry=new int [inputLength];
			for (int i=inputAry.length-1;i>=0;i--) {
				inputAry[i]=input%10;
				input/=10;
			}
			
			boolean [] inputFlag=new boolean [inputLength];
			boolean [] checkFlag=new boolean [inputLength];
			int currStrongCount=0;
			int currWeakCount=0;
			int count=0;
			for (int i=0;i<numbersCount[inputLength];i++) {
				currStrongCount=0;
				currWeakCount=0;
				Arrays.fill(inputFlag,false);
				Arrays.fill(checkFlag,false);
				
				for (int i2=0;i2<inputLength;i2++) {
					if (inputAry[i2]==numbers[inputLength][i][i2]) {
						currStrongCount++;
						inputFlag[i2]=true;
						checkFlag[i2]=true;
					}
				}
				
				for (int i2=0;i2<inputLength;i2++) {
					if (!inputFlag[i2]) {
						for (int i3=0;i3<inputLength;i3++) {
							if (!checkFlag[i3] && inputAry[i2]==numbers[inputLength][i][i3]) {
								currWeakCount++;
								inputFlag[i2]=true;
								checkFlag[i3]=true;
								break;
							}
						}
					}
				}
				
				if (currStrongCount==reqStrongCount && currWeakCount==reqWeakCount) {
					count++;
				}
			}
			
			System.out.println(count);
		}
	}
}