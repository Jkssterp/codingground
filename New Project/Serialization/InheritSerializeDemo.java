class Animal{
    int i = 10;
    Animal(){
        System.out.println("Animal Constructor Called");
    }
}

class Dog extends Animal implements Serializable{
    int j = 20;
    Dog(){
        System.out.println("Dog Constructor Called");
    }
}


class InheritSerializeDemo {
    public static void main(String[] args){
        Dog d = new Dog();
        d.i=888;
        d.j=999;
        System.out.println("Before Serialization");
        FileOutputStream fos = new FileOutputStream("abc.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(d);
        // Deserialization Calls the witeObject in Account
        FileInputStream fis = new FileInputStream("abc.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Dog d1= (Dog)ois.readObject();
        System.out.println(d1.i+"This is the After De-Serialization"+d1.j);
        
        
    }
}