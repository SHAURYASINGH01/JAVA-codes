import java.util.*;
import java.util.function.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }
        //..... YOUR CODE STARTS HERE .....
        
        Predicate<String> isPalindrome = str -> str.equals(new StringBuilder(str).reverse().toString());
        boolean hasPalindrome = list.stream().anyMatch(isPalindrome);
        
        System.out.println(hasPalindrome ? "Yes" : "No");
        
        //..... YOUR CODE ENDS HERE .....
    }
}
