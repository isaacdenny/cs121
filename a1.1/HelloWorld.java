/**
Prints hello world
@author Isaac Denny
@keyterm class header
*/

public class HelloWorld {
    public static void main(String[] args) {
        // @keyterm class body
        System.out.println("Hello World!");
        if (args.length > 0) {
            System.out.println(args[0]);
        }
    }
}
