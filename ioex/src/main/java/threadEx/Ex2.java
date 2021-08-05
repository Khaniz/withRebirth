package threadEx;

public class Ex2 implements Runnable {
  
  public void doA() {
    for(int i = 0; i <100; i++) {
      System.out.println(Thread.currentThread().getName()+":" +this);
    }
  }
  
  @Override
  public void run() {
    doA();
    
  }
  
  public static void main(String[] args) {
    
    Ex2 obj = new Ex2();
    
    Thread t0 = new Thread(obj);
    Thread t1 = new Thread(obj);
    Thread t2 = new Thread(obj);
    Thread t3 = new Thread(obj);
    
    t0.start();
    t1.start();
    t2.start();
    t3.start();
  }

}
