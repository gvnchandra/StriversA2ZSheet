package recursion;

public class ImplementAtoiFunction {
    public static void main(String[] args) {
        String s = "23";
        int res = 0;
        /*for (int i = 0; i < s.length(); i++) {
            res = res*10+s.charAt(i)-'0';
        }
        System.out.println(res);*/
        System.out.println(createAtoi(s));
        System.out.println(recurAtoi(s, s.length()));
    }

    public static int createAtoi(String str) {
        int i = 0, base = 0, sign = 1;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i < str.length()) {
            if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                sign = 1 - 2 * (str.charAt(i++) == '-' ? 1 : 0);
            }
            while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) > '7')) {
                    if (sign == 1)
                        return Integer.MAX_VALUE;
                    else
                        return Integer.MIN_VALUE;
                }
                base = base * 10 + str.charAt(i) - '0';
                i++;
            }
        }
        return base * sign;
    }

    static int recurAtoi(String str, int n) {
        if (str.equals("") || !str.matches("^\\d*$"))
            return 0;
        if (n == 1)
            return str.charAt(0) - '0';
        return 10 * recurAtoi(str, n - 1) + str.charAt(n - 1) - '0';
    }

}
