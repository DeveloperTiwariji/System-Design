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


