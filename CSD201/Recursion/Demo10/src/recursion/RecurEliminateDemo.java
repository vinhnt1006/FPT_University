package recursion;

import java.util.Stack;

public class RecurEliminateDemo {

    public static String rec_convert(int n, int base) {
        if (n == 0) {
            return "0";
        }
        return rec_convert(n / base, base) + Character.forDigit(n % base, base);
    }

    public static String convert2(int n, int base) {
        String result = "";
        do {
            result = Character.forDigit(n % base, base) + result;
            n /= base;
        } while (n > 0);
        return result;
    }

    public static String convert3(int n, int base) {
        Stack<Character> stk = new Stack();
        do {
            stk.push(Character.forDigit(n % base, base));
            n /= base;
        } while (n > 0);
        String result = "";
        while (!stk.empty()) {
            result += stk.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("10-base: " + rec_convert(122, 10));
        System.out.println("2-base: " + rec_convert(122, 2));
        System.out.println("8-base: " + rec_convert(122, 8));
        System.out.println("16-base: " + rec_convert(122, 16));
        String s1 = rec_convert(122, 16);
        String s2 = convert2(122, 16);
        String s3 = convert3(122, 16);
        System.out.println(s1 + ", " + s2 + ", " + s3);
    }
}
