import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
//import javax.inject.Inject;

public class WebsiteClass {
   private List<String> urlList ;

    public WebsiteClass() {
        urlList = new ArrayList<>();
    }

    public void printURLs() {
        urlList.add("https://pluralsight.com/search?q=java");
        urlList.add("https://medium.com/search?q=java");
        urlList.add("https://stackoverflow.com/questions/tagged/java");
        urlList.add("https://stackoverflow.com/search?q=java+list");
        urlList.add("https://reddit.com/r/java");
        urlList.add("https://reddit.com/r/javahelp");

        System.out.println("Links from stackoverflow.com:");
        //urlList.stream().forEach(System.out::println);
      //  List<String> temp = urlList.stream().filter(s -> s.contains("stackoverflow.com")).collect(Collectors.toList());
       // urlList.stream().filter(s -> s.contains("stackoverflow.com")).collect(Collectors.toList());

       urlList.remove("https://medium.com/search?q=java");

        urlList.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        WebsiteClass sfs = new WebsiteClass();
        sfs.printURLs();
    }
}