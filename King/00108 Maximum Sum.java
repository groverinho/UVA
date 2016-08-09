import java.io.IOException;
import java.util.Scanner;

class Main {
	
	public static int maximumSubmatrixSum(int [][] matrix) {
		for (int i=0;i<matrix.length;i++) {
			for (int i2=0;i2<matrix.length;i2++) {
				if (i>0) {
					matrix[i][i2]+=matrix[i-1][i2];
				}
				if (i2>0) {
					matrix[i][i2]+=matrix[i][i2-1];
				}
				if (i>0 && i2>0) {
					matrix[i][i2]-=matrix[i-1][i2-1];
				}
			}
		}
		
		int max=Integer.MIN_VALUE;
		for (int xStart=0;xStart<matrix.length;xStart++) {
			for (int yStart=0;yStart<matrix.length;yStart++) {
				for (int xEnd=xStart;xEnd<matrix.length;xEnd++) {
					for (int yEnd=yStart;yEnd<matrix.length;yEnd++) {
						int value=matrix[xEnd][yEnd];
						if (xStart>0) {
							value-=matrix[xStart-1][yEnd];
						}
						if (yStart>0) {
							value-=matrix[xEnd][yStart-1];
						}
						if (xStart>0 && yStart>0) {
							value+=matrix[xStart-1][yStart-1];
						}
						max=Math.max(value, max);
					}
				}
			}
		}
		
		return max;
	}
	
	public static void main(String[]args) throws IOException {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int [][] matrix=new int [N][N];
		for (int i=0;i<N;i++) {
			for (int i2=0;i2<N;i2++) {
				matrix[i][i2]=sc.nextInt();//Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(maximumSubmatrixSum(matrix));
	}
}