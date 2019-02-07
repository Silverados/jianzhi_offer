package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/2/1 19:40
 */
public class Q43_countDigitOne {
    public static void main(String[] args){
        System.out.println(countDigitOne(21345));
    }
    /**
     * LeetCode 233
     * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
     * @param n
     * @return
     */
    public static int countDigitOne(int n) {
        int num = n;
        int i = 1;
        int s = 0;
        while(num!=0){
            if(num%10==0){
                s+= num/10*i;
            }else if(num%10==1){
                s+= num/10*i + n%i+1;
            }else {
                s+= Math.ceil(num/10.0)*i;
            }
            num/=10;
            i*=10;
        }
        return s;
    }
}
