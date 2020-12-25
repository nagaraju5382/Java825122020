public class Multi {

    public static int multi(int n){
        int sum =0 ;
       for(int i=1;i<=n;i++){
           if(n%3 == 0 || n%5 == 0){
                sum+=i;
           }
       }
        return sum;
    }
    public static void main(String[] args) {
       System.out.println( ""+Multi.multi(10));
    }
}
