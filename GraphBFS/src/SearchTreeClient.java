// This program uses the SearchTree class to construct a binary
// search tree of integers and printing out each element in level order.

import java.util.*;

public class SearchTreeClient {
    public static void main(String[] args) {
        SearchTree<Integer> test1 = new SearchTree<Integer>();
        System.out.println("Adding 1, 8, 9, 2 should equal:\n1\n8\n2 9");
        System.out.println("\nTest Showed:");
        test1.add(1);
        test1.add(8);
        test1.add(9);
        test1.add(2);
        test1.printByLevel();
        Scanner console = new Scanner(System.in);
        SearchTree<Integer> numbers = new SearchTree<Integer>();
        System.out.print("Next int (0 to quit)? ");
        int number = console.nextInt();
        while (number != 0) {
            numbers.add(number);
            System.out.print("Next int (0 to quit)? ");
            number = console.nextInt();
        }
        System.out.println();
        System.out.println("Level order traversal: ");
        numbers.printByLevel();
    }
}
