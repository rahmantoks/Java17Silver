public class trap3 {
    // var needs to be initialized before use
    public static void main(String[] args) {
        var z; // Compilation error: variable z might not have been initialized
        System.out.println(z);  
    }
}
