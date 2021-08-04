package threadEx;

public class Ex1 {


    //bad code
    public static void main(String[] args) throws Exception{

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()+" B"+i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();;

        for(int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName()+" A" +i );
            Thread.sleep(200);
        }


    }
}
