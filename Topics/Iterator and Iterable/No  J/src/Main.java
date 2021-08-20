import java.util.*;

public class Main {

    public static void processIterator(String[] array) {
        ListIterator<String> iterator =  Arrays.asList(array).listIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        while (iterator.hasPrevious()) {
            String previous = iterator.previous();
            if (previous.startsWith("J")) {
                System.out.println(previous.replaceFirst("J",""));
            }
        }

    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        processIterator(scanner.nextLine().split(" "));
    }
}
