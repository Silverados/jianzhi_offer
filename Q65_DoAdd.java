package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/2/5 22:57
 */
public class Q65_DoAdd {
    /**
     * 不用加减乘除实现 两个整数之和
     * @param args
     */
    public static void main(String[] args){
        System.out.println(doAdd(5, 8));
    }

    public static int doAdd(int a, int b) {
        int sum = 0;
        int carry = 0;
        do {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        } while (b != 0);
        return a;
    }
}
