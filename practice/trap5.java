public class trap5 {
    // shadowed fields
    int value = 10; // Instance variable
    public void printValue() {
        int value = 20; // Local variable shadows instance variable
        System.out.println(value); // Outputs: 20
    }
    public static void main(String[] args) {
        trap5 obj = new trap5();
        obj.printValue();   
    }
}
