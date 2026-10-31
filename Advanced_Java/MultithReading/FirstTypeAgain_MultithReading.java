package MultithReading;

public class FirstTypeAgain_MultithReading extends Thread{
    public void run() {
    	for(int i = 0; i<=10;i++) {
    		System.out.println(i);
    	}
    }
	
	public static void main(String[] args) { // main поток
	     FirstTypeAgain_MultithReading thread1 = new FirstTypeAgain_MultithReading();
	     thread1.start(); // thread1 поток 
	     
	     
	     // main поток
	     for(int i = 10; i>=0;i--) {
	    	 System.out.println(i);
	     }
         
	}

}
