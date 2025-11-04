public class trap4 {
    // type inference is compiled-time only
    public static void main(String[] args) {
        var a = 1;
        a = 1.5; // Compilation error: incompatible types: possible lossy conversion from double to int
        System.out.println(a); // Outputs: Hello, World!
    }
}
