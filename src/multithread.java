public class multithread {
    public static Object lock= new Object();
    public static void main(String[] args) {
        Thread a= new Thread(new Runnable() {
            public int []arr1={1,3,5,7,9};
            @Override
            public void run() {
                for(int i=0;i<5;i++){
                    synchronized (lock){
                        try{
                            lock.notify();
                            lock.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        System.out.println(arr1[i]);
                    }
                }
            }
        });
        Thread b= new Thread(new Runnable() {
            public int []arr2={2,4,6,8,10};
            @Override
            public void run() {
                for(int i=0;i<5;i++){
                    synchronized (lock){
                        try{
                            lock.notify();
                            lock.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        System.out.println(arr2[i]);
                    }
                }
            }
        });
        a.start();
        b.start();
    }

}
