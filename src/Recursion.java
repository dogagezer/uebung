public class Recursion {

    public static void main(String[] args) {
        String input = "Hello, World!";
        String reversed = ReverseString.reverseString(input);
        System.out.println("Reversed string: " + reversed);

        int numDiscs = 5;
        char sourceRod = 'A';
        char auxiliaryRod = 'B';
        char destinationRod = 'C';

      //  TowerOfHanoi.solveTowerOfHanoi(numDiscs, sourceRod, auxiliaryRod, destinationRod);
    }
    public class ReverseString {

        public static String reverseString(String str) {
            if (str.isEmpty()) {
                return str;
            } else {
                return reverseString(str.substring(1)) + str.charAt(0);
            }
        }
    }

    public class TowerOfHanoi {

        public static void solveTowerOfHanoi(int n, char source, char auxiliary, char destination) {
            if (n == 1) {
                System.out.println("Move disc 1 from " + source + " to " + destination);
            } else {
                solveTowerOfHanoi(n - 1, source, destination, auxiliary);
                System.out.println("Move disc " + n + " from " + source + " to " + destination);
                solveTowerOfHanoi(n - 1, auxiliary, source, destination);
            }
        }
    }

}
