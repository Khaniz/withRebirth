package threadEx;

public class Horse extends Thread{

    private String name;
    private int position;

    public Horse(String name) {
        this.name = name;
        this.position = 0;
    }

    @Override
    public void run() {
        this.gallop();
    }

    public void gallop() {
        for(int i = 0; i < 100; i++){

            int range = (int)(Math.random() * 10) +1;

            this.position += range;

            //객체 하나를 여러 쓰레드가 지날때! 문제가 생김. 리소스 쉐어시 ㅠ
            //요 때는 한 현재 쓰레드만 시스템.아웃을 쓸게!
            synchronized (System.out){
                int count = this.position/10;
                for(int j = 0; j< count; j++){
                    System.out.print("..");
                }

                System.out.println(this.name + ": " + this.position);
            }


            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }//end for


    }

    public static void main(String[] args) {

        Horse h1 = new Horse("기훈말");
        Horse h2 = new Horse("현상말");
        Horse h3 = new Horse("한슬말");
        Horse h4 = new Horse("승환말");

        h1.start();
        h2.start();
        h3.start();
        h4.start();

    }

}
