import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int[] box1 = new int[3];
        for (int i = 0; i < box1.length; i ++) {
            box1[i] = scanner.nextInt();
        }
        Arrays.sort(box1);
        int[] box2 = new int[3];
        for (int i = 0; i < box2.length; i ++) {
            box2[i] = scanner.nextInt();
        }
        Arrays.sort(box2);
        int counter1 = 0;
        int counter2 = 0;
        for (int i = 0; i < 3; i++) {
            if (box1[i] < box2[i]) {
                counter2++;
            } else if (box1[i] > box2[i]) {
                counter1++;
            }

        }

        if (counter1 == 3) {
            System.out.println("Box 1 > Box 2");
        } else if (counter2 == 3) {
            System.out.println("Box 1 < Box 2");
        } else {
            System.out.println("Incompatible");
        }
    }
}