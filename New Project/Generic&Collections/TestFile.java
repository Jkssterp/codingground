public class TestFile{
    
    public static void main(String... args) {
    Integer i1 = 1000;
    Integer i2 = 1000;
    
    if(i1 == i2)  System.out.println("Same objects");
    if(i1 != i2)  System.out.println("different objects");
    if(i1.equals(i2)) System.out.println("meaningfully equal");
    int i3= 10;
    int i4 =10;
    if(i1 == i2)  System.out.println("Same objects i3 and i4");
    if(i1 != i2)  System.out.println("different objects i3 and i4");
    if(i1.equals(i2)) System.out.println("meaningfully equal i3 and i4");
    
    }
    
}