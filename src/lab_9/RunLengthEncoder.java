package lab_9;

public class RunLengthEncoder {
    public static void main(String[] args) {
        String input = args[0];
        char curr = input.charAt(0);
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == curr) {
                count++;
            } else {
                System.out.print(Character.toString(curr) + count);
                curr = input.charAt(i);
                count = 1;
            }
        }
        System.out.print(Character.toString(curr) + count);
    }
}
