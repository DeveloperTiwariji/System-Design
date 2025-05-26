//<====================1. Eager Initialization (Thread-Safe)====================>

public class SingletonEager {
    private static final SingletonEager INSTANCE = new SingletonEager();

    private SingletonEager() {
        // Private constructor to prevent instantiation
    }

    public static SingletonEager getInstance() {
        return INSTANCE;
    }
}

//<=================================2. Lazy Initialization (Thread-Safe)==========================>
public class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy() {
        // Private constructor to prevent instantiation
    }

    public static synchronized SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}

//<=============================3. Double-Checked Locking (Thread-Safe)============================>
public class SingletonDoubleChecked {
    private static volatile SingletonDoubleChecked instance;

    private SingletonDoubleChecked() {
        // Private constructor to prevent instantiation
    }

    public static SingletonDoubleChecked getInstance() {
        if (instance == null) {
            synchronized (SingletonDoubleChecked.class) {
                if (instance == null) {
                    instance = new SingletonDoubleChecked();
                }
            }
        }
        return instance;
    }
}

//<=============================4. Bill Pugh Singleton Design Pattern (Thread-Safe)============================>
public class SingletonBillPugh {
    private SingletonBillPugh() {
        // Private constructor to prevent instantiation
    }

    private static class SingletonHelper {
        private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
    }

    public static SingletonBillPugh getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

//<=============================5. Enum Singleton Design Pattern (Thread-Safe)============================>
public enum SingletonEnum {
    INSTANCE;

    // You can add methods here if needed
    public void someMethod() {
        System.out.println("This is a method in the Singleton Enum.");
    }
}

//<=============================6. ThreadLocal Singleton Design Pattern (Thread-Safe)============================>
public class SingletonThreadLocal {
    private static final ThreadLocal<SingletonThreadLocal> threadLocalInstance = ThreadLocal.withInitial(SingletonThreadLocal::new);

    private SingletonThreadLocal() {
        // Private constructor to prevent instantiation
    }

    public static SingletonThreadLocal getInstance() {
        return threadLocalInstance.get();
    }
}

//<=============================7. Static Block Initialization (Thread-Safe)============================>
public class SingletonStaticBlock {
    private static final SingletonStaticBlock INSTANCE;

    static {
        try {
            INSTANCE = new SingletonStaticBlock();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred while creating singleton instance", e);
        }
    }

    private SingletonStaticBlock() {
        // Private constructor to prevent instantiation
    }

    public static SingletonStaticBlock getInstance() {
        return INSTANCE;
    }
}

//<=============================8. Synchronized Method Singleton Design Pattern (Thread-Safe)============================>
public class SingletonSynchronizedMethod {
    private static SingletonSynchronizedMethod instance;

    private SingletonSynchronizedMethod() {
        // Private constructor to prevent instantiation
    }

    public static synchronized SingletonSynchronizedMethod getInstance() {
        if (instance == null) {
            instance = new SingletonSynchronizedMethod();
        }
        return instance;
    }
}

//<=============================9. Lazy Holder Singleton Design Pattern (Thread-Safe)============================>
public class SingletonLazyHolder {
    private SingletonLazyHolder() {
        // Private constructor to prevent instantiation
    }

    private static class Holder {
        private static final SingletonLazyHolder INSTANCE = new SingletonLazyHolder();
    }

    public static SingletonLazyHolder getInstance() {
        return Holder.INSTANCE;
    }
}

