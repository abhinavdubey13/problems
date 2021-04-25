
class thread1 {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.join();
        for (int i = 0; i < 3; i++) {
            System.out.println("main");
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("CHILD");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}
