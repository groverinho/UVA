import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
	
	public static final int [] baseValue={1,5,10,50,100};
	public static final char [] baseText={'i','v','x','l','c'};
	public static final int [] subtract={0,1,2,1,2};
	public static final ArrayList<Integer> valueList=new ArrayList<>();
	public static final ArrayList<String> valueText=new ArrayList<>();
	
	public static void initTable() {
		for (int i=baseValue.length-1;i>=0;i--) {
			if (valueList.contains(baseValue[i])) valueText.set(valueList.indexOf(baseValue[i]), String.valueOf(baseText[i]));
			else {
				valueList.add(baseValue[i]);
				valueText.add(String.valueOf(baseText[i]));
			}
			for (int i2=i-subtract[i];i2<i;i2++) {
				if (!valueList.contains(baseValue[i]-baseValue[i2])) {
					valueList.add(baseValue[i]-baseValue[i2]);
					valueText.add(String.valueOf(baseText[i2])+String.valueOf(baseText[i]));
				}
			}
		}
	}
	
	public static int [] getRomanNumeral(int num) {
		StringBuilder sb=new StringBuilder();
		for (int i=0;i<=valueList.size() && num>0;i++) {
			while (num>=valueList.get(i)) {
				sb.append(valueText.get(i));
				num-=valueList.get(i);
			}
		}
		int [] count=new int [128];
		for (char c : sb.toString().toCharArray()) count[c]++;
		return count;
	}
	
	public static int [][] alphabetCount=new int [101][128];
	public static void calcAlphabet() {
		alphabetCount[1]['i']=1;
		for (int i=2;i<=100;i++) {
			int [] currCount=getRomanNumeral(i);
			for (int i2=0;i2<baseText.length;i2++) alphabetCount[i][baseText[i2]]=alphabetCount[i-1][baseText[i2]]+currCount[baseText[i2]];
		}
	}
	
	public static String [] solution=new String[101];
	public static void calcSolution() {
		for (int i=1;i<solution.length;i++) {
			StringBuilder sb=new StringBuilder();
			sb.append(i);
			sb.append(':');
			for (int i2=0;i2<baseText.length;i2++) {
				sb.append(' ');
				sb.append(alphabetCount[i][baseText[i2]]);
				sb.append(' ');
				sb.append(baseText[i2]);
				if (i2<baseText.length-1) sb.append(',');
			}
			solution[i]=sb.toString();
		}
	}
	
	public static void main (String[]args) throws Exception {
		initTable();
		calcAlphabet();
		calcSolution();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0")) {
			System.out.println(solution[Integer.parseInt(s)]);
		}
	}
}