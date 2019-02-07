package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/2/5 22:26
 */
public class Q63_maxProfit {
    /**
     * LeetCode 121
     *
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     *
     * 注意你不能在买入股票前卖出股票。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices == null ||prices.length == 0) {
            return 0;
        }
        return maxProfit(prices,prices.length - 1);
    }

    public int maxProfit(int[] prices/*,int start*/,int end){
        if(end < 1) {
            return 0;
        }
        int last = maxProfit(prices,end - 1);
        int res =  prices[end] - prices[end - 1] + last;
        if(res < 0) {
            return 0;
        }
        return res;
    }
}
