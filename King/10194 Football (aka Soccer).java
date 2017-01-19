import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	
	public static class Team implements Comparable<Team> {
		private String name;
		int points, gamesPlayed, wins, ties, losses, goalDiff, goalScored, goalsAgainst;
		
		public Team (String n) {
			this.name=n;
		}
		
		public String getName () {
			return this.name;
		}
		
		public int compareTo(Team t) {
			int [] cValues=new int [7];
			cValues[0]=this.points-t.points;
			cValues[1]=this.wins-t.wins;
			cValues[2]=this.goalDiff-t.goalDiff;
			cValues[3]=this.goalScored-t.goalScored;
			cValues[4]=t.gamesPlayed-this.gamesPlayed;
			cValues[5]=t.name.toLowerCase().compareTo(this.name.toLowerCase());
			cValues[6]=t.name.compareTo(this.name);
			for (int i=0;i<cValues.length;i++) if (cValues[i]!=0) return cValues[i];
			return 0;
		}
	}
	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1")); //Wtf?
		PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1"))); //Wtf?
		int testCaseCount=Integer.parseInt(br.readLine());
		
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			String tourName=br.readLine();
			Team [] teams=new Team[Integer.parseInt(br.readLine())];
			HashMap<String,Team> map=new HashMap<>();
			for (int i=0;i<teams.length;i++) {
				teams[i]=new Team(br.readLine());
				map.put(teams[i].getName(),teams[i]);
			}
			
			int G=Integer.parseInt(br.readLine());
			for (int i=0;i<G;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				Team team1=map.get(st.nextToken("#"));
				int score1=Integer.parseInt(st.nextToken("@").replace("#",""));
				int score2=Integer.parseInt(st.nextToken("#").replace("@",""));
				Team team2=map.get(st.nextToken().replace("#",""));
				
				team1.gamesPlayed++; team1.goalScored+=score1; team1.goalsAgainst+=score2; team1.goalDiff+=(score1-score2);
				team2.gamesPlayed++; team2.goalScored+=score2; team2.goalsAgainst+=score1; team2.goalDiff+=(score2-score1);
				 
				if (score1==score2) {
					team1.points++; team1.ties++;
					team2.points++; team2.ties++;
				} else if (score1>score2) {
					team1.points+=3; team1.wins++;
					team2.losses++;
				} else if (score2>score1) {
					team1.losses++;
					team2.points+=3; team2.wins++;
				}
			}
			
			Arrays.sort(teams);
			StringBuilder sb=new StringBuilder();
			sb.append(tourName); sb.append("\n");
			for (int i=0;i<teams.length;i++) {
				Team t=teams[teams.length-i-1];
				sb.append(i+1);
				sb.append(") ");
				sb.append(t.getName());
				sb.append(' ');
				sb.append(t.points);
				sb.append("p, ");
				sb.append(t.gamesPlayed);
				sb.append("g (");
				sb.append(t.wins);
				sb.append('-');
				sb.append(t.ties);
				sb.append('-');
				sb.append(t.losses);
				sb.append("), ");
				sb.append(t.goalDiff);
				sb.append("gd (");
				sb.append(t.goalScored);
				sb.append('-');
				sb.append(t.goalsAgainst);
				sb.append(")\n");
			}
			if (testCase<testCaseCount-1) pw.println(sb.toString());
			else pw.print(sb.toString());
			
			pw.flush();
		}
		pw.close();
	}
}