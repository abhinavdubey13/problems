
class Display {
    synchronized void disp_num() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }

    synchronized void disp_char() {
        for (int i = 65; i <= 70; i++) {
            System.out.println((char) i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}

class MyThread_num extends Thread {
    Display d;

    MyThread_num(Display d) {
        this.d = d;
    }

    @Override
    public void run() {
        d.disp_num();
    }
}

class MyThread_char extends Thread {
    Display d;

    MyThread_char(Display d) {
        this.d = d;
    }

    @Override
    public void run() {
        d.disp_char();
    }
}

class synced1 {
    public static void main(String[] args) throws InterruptedException {
        Display d = new Display();

        MyThread_num t1 = new MyThread_num(d);
        MyThread_char t2 = new MyThread_char(d);

        t1.start();
        t2.start();
    }
}