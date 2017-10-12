import java.util.*;
import java.io.*;

//UVA_00144

public class Main {
	
	private static class Student{
		int id;
		int require;
		Student(int id, int require){
			this.id = id;
			this.require = require;
		}
	}

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(System.out);
		
		
		String _input = "";
		while(!((_input = br.readLine()).equals("0 0"))){
			String [] _params = _input.split(" ");
			int _numStudent = Integer.parseInt(_params[0]);
			int _cashLimit = Integer.parseInt(_params[1]);
			
			Queue<Student> a = new LinkedList<Student>();
			
			for(int i=0; i<_numStudent; i++)
				a.add(new Student(i+1, 40));
			
			while(!a.isEmpty()){
				for(int i=1; i<=_cashLimit; i++){
					int currentOutput = i;
					while(currentOutput!=0 && !a.isEmpty()){
						Student currentStudent = a.poll();
						if(currentStudent.require > currentOutput){
							currentStudent.require -= currentOutput;
							currentOutput = 0;
							a.add(currentStudent);
						}else{
							currentOutput -= currentStudent.require;
							pr.printf("%3d",currentStudent.id);
						}
					}
						
				}
			}
			pr.println();
		}
		pr.close();
	}
	
}
