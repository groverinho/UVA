class Main {                                                                                                                                                                                                                                                                             
	public static void main (String[]args) throws Exception {
		/*
		 * Use the formula for arithmetic progression.
		 * Formula 1 : a=1, n=h-1, d=1;
		 * Formula 2 : a=l+1, n=l-n, d=1;
		 * 
		 * Where h=house number, l=last house number.
		 * 
		 * Equal up both formula then we will get :
		 * 2(h^2) = l^2 + l
		 * h^2 = (l^2+1)/2;
		 * h is an integer, so (l^2+1)/2 must be a perfect square.
		 * 
		 * 
		 */
		int count=0;

		for (long l=8;count<10;l++) {
			double result=Math.sqrt((l*l+l)/2);
			if (result==(long)result) {
				System.out.printf("%10d%10d\n",(long)result,l);
				count++;
			}
		}
	}
}