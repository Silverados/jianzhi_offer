package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/1/23 00:21
 */
public class Q5_ReplaceWhiteSpace {
    public static void main(String[] args){
        System.out.println(replace("We are happy."));
    }

    /**
     * 将字符串中所有的空格替换成 %20.这题考点主要针对C、C++类语言。
     * @param str
     * @return
     */
    private static String replace(String str) {
        return str.replaceAll(" ", "%20");
    }
}
