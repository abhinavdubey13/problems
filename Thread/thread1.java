
class thread1 {

    
    public static void main(String[] args) {

        Thread.currentThread().setName("ramu kaka");

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable, "shamu kaka");
        thread.start();

        System.out.println("main : " + Thread.currentThread().getName());
    }

}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("child : " + Thread.currentThread().getName());
    }

}
