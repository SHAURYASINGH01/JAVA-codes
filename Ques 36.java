import java.util.*;

@FunctionalInterface
interface LongestStringFinder {
    //..... YOUR CODE STARTS HERE .....
   
    String findLongest(List<String> strings);
    
     //..... YOUR CODE ENDS HERE .....
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }
        //..... YOUR CODE STARTS HERE .....
   
        LongestStringFinder finder = (strings) -> {
            String longest = "";
            for (String str : strings) {
                if (str.length() > longest.length()) {
                    longest = str;
                }
            }
            return longest;
        };

        String longestString = finder.findLongest(list);
        System.out.println(longestString.length());
   
        //..... YOUR CODE ENDS HERE .....
    }
}