package site.metacoding.ex23;

// 스레드가 컨텍스트 스위칭할때는 내부적으로 0.0000001초라도 졸고 넘어간다.
// 하나의 프로세스안에 여러개의 스레드가 동작한다.
// 스레드 일시 정지 하는 법

class Monster implements Runnable {
    int x = 10;
    int speed = 1; // 1초마다
    boolean isActive = true;

    @Override
    public void run() {
        while (isActive) {
            try {
                x = x + speed;
                Thread.sleep(1000);
                System.out.println("몬스터 위치 : " + x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Host implements Runnable {
    int x = 0;
    int speed = 2; // 1초마다
    boolean isActive = true;

    @Override
    public void run() {
        while (isActive) {
            try {
                x = x + speed;
                Thread.sleep(1000);
                System.out.println("호스트 위치 : " + x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

// 실습 -> Monster와 Host는 1초마다 각자의 speed 만큼 움직이는 run()을 가진다.
// -> 둘의 x좌표가 동일해지면 게임은 종료된다.

public class ThreadEx05 {
    public static void main(String[] args) {
        Monster monster = new Monster();
        Host host = new Host();

        Thread monsterThread = new Thread(monster);
        Thread hostThread = new Thread(host);

        monsterThread.start();
        hostThread.start();

        while (true) {
            if (host.x >= monster.x) {
                System.out.println("몬스터가 죽었어요");
                // 1. 호스트 스레드 중지
                host.isActive = false;
                // 2. 몬스터 스레드 중지
                monster.isActive = false;
                // 3. 메인 스레드 중지
                break;
            } else {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}