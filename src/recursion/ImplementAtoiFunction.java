package recursion;

public class ImplementAtoiFunction {
    public static void main(String[] args) {
        String s = "-546+er";
        System.out.println(createAtoi(s));
        System.out.println(method2(s));
    }

    public static int createAtoi1(String str) {
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

    public static int createAtoi(String str) {
        long ans = 0;
        int sign = 1, i = 0;
        while (i < str.length() && str.charAt(i) == ' ')
            i++;

        if (i < str.length()) {
            if (str.charAt(i) == '-' || str.charAt(i) == '+')
                sign = 1 - 2 * (str.charAt(i++) == '-' ? 1 : 0);

            while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                ans = ans * 10 + str.charAt(i) - '0';
                if (ans > Integer.MAX_VALUE && sign == 1) {
                    return Integer.MAX_VALUE;
                } else if (-1 * ans < Integer.MIN_VALUE && sign == -1) {
                    return Integer.MIN_VALUE;
                }
                i++;
            }
        }
        return (int) ans * sign;
    }

    public static int method2(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ')
            i++;
        if (i < str.length()) {
            int sign = 1;
            if (str.charAt(i) == '+' || str.charAt(i) == '-')
                sign = 1 - 2 * (str.charAt(i++) == '+' ? 0 : 1);
            str = str.substring(i);
            int j = 0;
            while (j < str.length()) {
                if (!(str.charAt(j) >= '0' && str.charAt(j) <= '9'))
                    break;
                j++;
            }
            return (int) recurAtoi(str, j, sign) * sign;
        }
        return 0;
    }

    static long recurAtoi(String str, int n, int sign) {
        if (n == 0)
            return n;
        long ans = recurAtoi(str, n - 1, sign);
        if (ans == Integer.MIN_VALUE || ans == Integer.MAX_VALUE)
            return ans;
        ans = ans * 10 + str.charAt(n - 1) - '0';
        if (ans > Integer.MAX_VALUE && sign == 1)
            return Integer.MAX_VALUE;
        else if (-1 * ans < Integer.MIN_VALUE && sign == -1)
            return Integer.MIN_VALUE;
        return ans;
    }
}
