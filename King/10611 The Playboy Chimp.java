import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

class Main {
	
	public static int binarySearch(int [] value, int target) {
		int min=0;
		int max=value.length;
		while (min<max) {
			int mid=(min+max)/2;
			if (value[mid]==target) {
				return mid;
			} else if (value[mid]>target) {
				max=mid-1;
			} else {
				min=mid+1;
			}
		}
		return Math.min(value.length-1,(min+max)/2);
	}
	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int heightsCount=Integer.parseInt(br.readLine());
		ArrayList<Integer> heightList=new ArrayList<>();
		StringTokenizer st=new StringTokenizer(br.readLine());
		for (int i=0;i<heightsCount;i++) {
			int h=Integer.parseInt(st.nextToken());
			if (i==0 || heightList.get(heightList.size()-1)!=h) {
				heightList.add(h);
			}
		}
		int [] heights=new int [heightList.size()];
		Iterator<Integer> it=heightList.iterator();
		int lel=0;
		while (it.hasNext()) {
			heights[lel++]=it.next();
		}	
				
		int queries=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		for (int i=0;i<queries;i++) {
			int queryValue=Integer.parseInt(st.nextToken());
			int index=binarySearch(heights,queryValue);
			if (heights[index]==queryValue) {
				if (index>0 && index<heights.length-1) {
					System.out.println(heights[index-1]+" "+heights[index+1]);
				} else if (index==0) {
					System.out.println("X "+heights[1]);
				} else {
					System.out.println(heights[index-1]+" X");
				}
			} else {
				if (heights[index]>queryValue) {
					index--;
				}
				if (index==0) {
					System.out.println("X "+heights[0]);
				} else if (index==heights.length-1) {
					System.out.println(heights[heights.length-1]+" X");
				} else {
					System.out.println(heights[index]+" "+heights[index+1]);
				}
			}
		}
	}
	
}