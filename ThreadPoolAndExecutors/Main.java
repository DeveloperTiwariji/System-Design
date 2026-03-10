package ThreadPoolAndExecutors;
import java.util.*;
import java.util.concurrent.*;


// class RideMatchingService {
//     public void requestRide(String riderId){
//         Thread matchThread = new Thread(()->{
//             System.out.println("Matching rider "+ riderId+ " to a driver...");

//             try {
//                 Thread.sleep(2000);
//             }catch (InterruptedException e){
//                 Thread.currentThread();
//             }
//             System.out.println("Ride matched for rider "+riderId);
//         });

//         matchThread.start();
//     }
// }


class EmailService {
    private static final ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void sendEmail(String recipient){

        executor.execute(() -> {
            System.out.println("Sending email to "+ recipient +" on "+ Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }

            System.out.println("Email sent to "+recipient);
        });
    }

    public static void main(String[] args){
        for (int i=1;i<=25;i++){
            sendEmail("user"+ i +"@gmail.com"); 
        }

        executor.shutdown();
    }
}

class FutureExample {

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);


        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(1000);
            return 42;
        });


        System.out.println("Doing other work...");

        Integer result = future.get();
        System.out.println("Result: "+result);

        executor.shutdown(); 
    }
}


// public class Main {
//     public static void main(String args[]){
//         RideMatchingService rs1 = new RideMatchingService();
//         RideMatchingService rs2 = new RideMatchingService();
//         rs1.requestRide("raj1");
//         System.out.println("task1 running");
//         rs2.requestRide("raj2");
//         System.out.println("task2 running");
//     }
// }
