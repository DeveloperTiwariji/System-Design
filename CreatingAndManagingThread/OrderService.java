package CreatingAndManagingThread;
import java.util.*;
import java.util.concurrent.*;

// public class OrderService {
//     public static void main(String args[]){
//         System.out.println("Placing Order...");
//         sendSMS();
//         System.out.println("Task 1 done");
//         sendEmail();
//         System.out.println("Task 2 done");
//         String eta = calculateETA();
//         System.out.println("Order placed. ETA: "+ eta);
//         System.out.println("Taks 3 done");
//     }

//         private static void sendSMS(){
//             try{
//                 Thread.sleep(2000);
//                 System.out.println("SMS sent!");

//             }catch(InterruptedException e){
//                 e.printStackTrace();
//             }
//         }

//         private static void sendEmail(){

//             try{
//                 Thread.sleep(3000);
//                 System.out.println("Email sent!");


//             }catch(InterruptedException e){
//                 e.printStackTrace();
//             }
//         }


//         private static String calculateETA(){
//             try{
//                 Thread.sleep(5000);

//             }catch(InterruptedException e){
//                 e.printStackTrace();
//             }

//             return "25 minutes";
//         } 
// }

class SMSThread extends Thread{
    public void run(){
        try{
           Thread.sleep(2000);
           System.out.println("SMS sent using Thread!");
        }catch(InterruptedException e){
            e.printStackTrace(); 
        }
    }
}

class EmailThread extends Thread{
    public void run(){
        try{
           Thread.sleep(2000);
           System.out.println("Email sent using Thread!");
        }catch(InterruptedException e){
            e.printStackTrace(); 
        }
    }
}

class SMSThreadRunnable implements Runnable{
    public void run(){
        try{
            Thread.sleep(2000);
            System.out.println("SMS sent using Thread");
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

// same for email===


// collable============
class ETACalculator implements Callable<String> {
    private final String location;
    public ETACalculator(String location){
        this.location = location;
    }
    public String call() throws Exception {
        System.out.println("["+Thread.currentThread().getName()+"] Calculation ETA to: "+ location);
        Thread.sleep(3000);
        return "ETA to "+location+" 20 minutes";
    }
}

public class OrderService{
    public static void main(String args[]) throws Exception{
        Thread smsThread  =new Thread(new SMSThreadRunnable());
        FutureTask etaThreadRunnable = new FutureTask<>(new ETACalculator("BLR"));
        Thread etThread = new Thread(etaThreadRunnable);
        // SMSThread smsThread = new SMSThread();
        EmailThread emailThread = new EmailThread();
        System.out.println("Task started");
        smsThread.start();
        System.out.println("Task 1 ongoning");
        emailThread.start();
        System.out.println("Task 2 ongoing");
        etThread.start();
        try{
            smsThread.join();
            emailThread.join();
            String eta = (String) etaThreadRunnable.get();
            System.out.println("Eta is: "+eta);
            System.out.println("Task done");
        }catch(InterruptedException e){

        }
    }
}
