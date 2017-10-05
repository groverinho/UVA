import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final char L_Paren = '(';
    private static final char R_Paren = ')';
    private static final char L_Bracket = '[';
    private static final char R_Bracket = ']';
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(br.readLine());
        for(int i=0;i<numCases;i++){
            boolean check = isBalanced(br.readLine());
            if(check){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
    }
    
    public static boolean isBalanced(String check){
        //Stack Parentheses
        Stack<Character> a = new Stack();
        for(int i=0;i<check.length();i++){
            if(check.charAt(i)== L_Paren)   a.push(L_Paren);
            else if(check.charAt(i) == L_Bracket)   a.push(L_Bracket);
            else if(check.charAt(i) == R_Paren){
                if(a.isEmpty()) return false;
                if(a.pop()!=L_Paren)  return false;
            }
            else if(check.charAt(i) == R_Bracket){
                if(a.isEmpty()) return false;
                if(a.pop()!=L_Bracket)  return false;
            }
        }
        return a.isEmpty();
    }
    
}

