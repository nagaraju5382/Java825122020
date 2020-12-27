public class MultiThreadApp {

    Thread thread1;
    Thread thread2;

    public MultiThreadApp() {
        thread1 = new Thread(new Runnable() {
            @Override
            public void run(){
                System.out.println("Thread #1 is running");
            }
        });

        // Task 1
        Runnable re = ()->{System.out.println("Thread #2 is running");};
        thread2 = new Thread(re);
    }

    public void startThreads() {
        thread1.start();
        thread2.start();
        // Task 2

    }

    public static void main(String[] args) {
        MultiThreadApp as = new MultiThreadApp();
        as.startThreads();
    }
}
