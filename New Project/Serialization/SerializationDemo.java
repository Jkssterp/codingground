class Account implements Serializable{
    String username = "prolifics";
    transient String password = "training2014";
}

class SerializationDemo{
    public static void main(String[] args){
        Account a1= new Account();
        System.out.println(a1.username+"This is the B4 Serialization"+a1.password);
        FileOutputStream fos = new FileOutputStream("abc.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(a1);
        // Deserialization
        FileInputStream fis = new FileInputStream("abc.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Account a2= (Account).readObject();
        System.out.println(a2.username+"This is the After De-Serialization"+a2.password);
        
    }
}