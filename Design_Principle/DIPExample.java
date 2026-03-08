//<======================Dependency Inversion Principle=======================>
//<=======================High-level modules should not depend on low-level modules. Both should depend on abstractions===================>

interface Database {
    void save(String data);
}

class MySQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving data to MySQL database: " + data);
    }
}

class MongoDBDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving data to MongoDB database: " + data);
    }
}

class ClientService {
    private Database database;

    public ClientService(Database database) {
        this.database = database;
    }

    public void saveData(String data) {
        database.save(data);
    }
}

public class DIPExample {
    public static void main(String[] args) {
        Database mySQLDatabase = new MySQLDatabase();
        ClientService clientService1 = new ClientService(mySQLDatabase);
        clientService1.saveData("MySQL Data");

        Database mongoDBDatabase = new MongoDBDatabase();
        ClientService clientService2 = new ClientService(mongoDBDatabase);
        clientService2.saveData("MongoDB Data");
    }
}



// problme =====================


// class Bulb{
//     void turnOn(){
//         System.out.println("Bulb is On ");
//     }
// }


// class  Switch{
//     Bulb bulb = new Bulb();
    
//     void operate(){
//         bulb.turnOn();
//     }
// }

// with DIP=======================

interface Device{
    void turnOn();
    void turnOff();
}



class Bulb implements Device{
    
    public void turnOn(){
        System.out.println("Bulb is ON");
    }

    public void turnOff(){
        System.out.println("Bulb is OFF");
    }
}



class Fan implements Device{

    public void turnOn(){
        System.out.println("Fan is ON");
    }

    public void turnOff(){
        System.out.println("Fan is OFF");
    }
}


class Switch{
    Device device;

    Switch(Device device){
        this.device = device;
    }


    void operate(){
        device.turnOn();
        device.turnOff();
    }
}


// inside main method===
/*
Bulb bulb = new Bulb();
Switch s = new Switch(bulb);
s.operat();

Fan f = new Fan();
Switch s = new Switch(f);
s.operate();

 */

