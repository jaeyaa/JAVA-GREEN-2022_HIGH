package ex23;

public class ThreadEx01 {

    // main 스레드 시작
    public static void main(String[] args) {
        System.out.println(1);
        try {
            Thread.sleep(2000); // 밀리세컨즈 1/1000초
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }
}
