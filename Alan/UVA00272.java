import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        boolean status = false;
        String alan;
        Scanner in = new Scanner (System.in);

        while(in.hasNextLine()){
            alan = in.nextLine();
            for(int i = 0; i < alan.length(); i++) {
                if (alan.charAt(i) == '"') {
                    alan = status ? alan.replaceFirst("\"", "\'\'") : alan.replaceFirst("\"", "``");
                    status = !status;
                }
            }
            System.out.println(alan);
        }
    }
}