public class GenerateIncreasingNumberSequence {

    public static void generateCombinations(int[] digits, int start, int n, String current) {
        if (current.length() == n) { // Base case: reached required length
            System.out.println(current);
            return;
        }

        for (int i = start; i < digits.length; i++) {
            generateCombinations(digits, i, n, current + digits[i]);
        }
    }

    public static void main(String[] args) {
        int[] digits = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // The available digits
        int n = 9;
        System.out.println("Increasing permutations of length " + n + ":");
        generateCombinations(digits, 0, n, "");
    }
}
