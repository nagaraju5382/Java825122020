import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class Solution{
    public static void solve(String a, String b){

        char[] chars = a.toCharArray();
        List<char[]> alist = Arrays.asList(chars);//.stream().forEach(x->b.contains(x));

        System.out.println("alist size: "+alist.size());
        Consumer<char[]> consumer = x ->{System.out.println(x);};
        alist.stream().forEach(consumer);

        //char[] bchars = b.toCharArray();
        //List<char[]> chars1 = Arrays.asList(bchars);

    }

    public static void main(String[] args) {
        Solution.solve("abcd","efgh");
    }
}