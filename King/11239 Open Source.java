import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

class Main {
	
	private static class Project implements Comparable<Project> {
		String name;
		int count;
		
		public int compareTo(Project p) {
			int diffCount=p.count-this.count;
			if (diffCount!=0) return diffCount;
			else return this.name.compareTo(p.name);
		}
	}
	
	public static void main (String [] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,HashSet<String>> studentMap=new HashMap<>();
		HashMap<String,Integer> projectStdCount=new HashMap<>();
		
		String s;
		String lastProjName=null;
		while (!(s=br.readLine()).equals("0")) {
			if (!s.equals("1")) {
				if (Character.isUpperCase(s.charAt(0))) {
					lastProjName=s;
					projectStdCount.put(lastProjName,0);
				} else {
					String stdName=s;
					if (!studentMap.containsKey(stdName)) studentMap.put(stdName, new HashSet<>());
					if (!studentMap.get(stdName).contains(lastProjName)) {
						studentMap.get(stdName).add(lastProjName);
						projectStdCount.put(lastProjName, projectStdCount.get(lastProjName)+1);
					}
				}
			} else {
				for (String stdName : studentMap.keySet()) if (studentMap.get(stdName).size()>1) {
					for (String projName : studentMap.get(stdName)) projectStdCount.put(projName, projectStdCount.get(projName)-1);
				}
				
				ArrayList<Project> list=new ArrayList<>();
				for (String projName : projectStdCount.keySet()) {
					Project p=new Project();
					p.name=projName;
					p.count=projectStdCount.get(p.name);
					list.add(p);
				}
				Collections.sort(list);
				
				for (Project p : list) {
					System.out.println(p.name+" "+p.count);
				}
				
				studentMap.clear();
				projectStdCount.clear();
			}
		}
	}

}