
class MyThread extends Thread {

    int x;

    @Override
    public void run() {

        synchronized (this) {
            for (int i = 1; i <= 10; i++) {
                x += i;
            }
        }

        //10k lines of code
    }
}

class synced2 {

    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();
        t.join();
        System.out.println(t.x);
    }
}
