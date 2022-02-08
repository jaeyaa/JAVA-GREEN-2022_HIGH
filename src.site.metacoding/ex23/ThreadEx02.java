package ex23;

class NewWorker implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("뉴워커 스레드 :" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void hello() {

    }
}

public class ThreadEx02 {

    // MainThread의 타겟은 main 메서드
    public static void main(String[] args) {

        // NewWorker 생성
        Thread newWorker = new Thread(new NewWorker());
        newWorker.start(); // run() 메서드 호출

        for (int i = 1; i < 6; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("메인 스레드 :" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
