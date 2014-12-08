class Account implements Serializable{
    String username = "prolifics";
    transient String pwd = "training2014";
    
    private void writeObject(ObjectOutputStream os) throws Exception{
        os.defaultWriteObject();
        String epwd = (String)is.readObject();
        pwd = epwd.subString(3);
    }
    
}

class CustSerializeDemo{
    public static void main(String[] args){
        Account a1= new Account();
        System.out.println(a1.username+"This is the B4 Serialization"+a1.pwd);
        FileOutputStream fos = new FileOutputStream("abc.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(a1);
        // Deserialization Calls the witeObject in Account
        FileInputStream fis = new FileInputStream("abc.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Account a2= (Account)ois.readObject();
        System.out.println(a2.username+"This is the After De-Serialization"+a2.pwd);
        
    }
}