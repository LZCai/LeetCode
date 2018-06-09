package primary;


/**
 * @author 64621 -- lzcai
 * @time 2018年6月9日 下午3:44:17
 * 
 * 执行时间：6ms
 * 
 * 思路分析：
 * 根据题意可知，要求购买者利益最大
 * 
 * 因此，分两种情况讨论，比较相邻两天的价格，若已经购买，并且当天价格大于后一天的价格，则以当天的价格进行卖出，
 * 
 * 若当天价格小于后一天的价格，则不卖。
 * 
 * 若没有购买，并且当天价格大于后一天的价格，则继续观望，若当天价格小于后一天的价格，则以当天价格买入。
 * 
 */
public class 买股票的最佳时机 {
	
	public static void main(String[] args){
		
		int[] prices = {1, 2, 3, 4, 5} ;
		
		System.out.println(maxProfit(prices));
		
	}
	
	public static int maxProfit(int[] prices) {
        
		int count = 0 ;
		
		//价格数组为空，或者长度小于两天
		if(prices == null || prices.length <2)
			
			return 0 ;
		
		int n = prices.length ;
		
		int buy = -1 ;
		
		for(int i=0 ; i<n ; i++){
			
			if(buy==-1 && i==n-1)
				break ;
			if(i==n-1){
				
				count += prices[i] -buy ;
				break ;
			}
			
			if(prices[i]<prices[i+1]){
				
				if(buy == -1){
					
					buy = prices[i] ;
					
				}else{
					
					continue ;
				}
				
			}else{
				
				if(buy == -1){
					
					continue ;
					
				}else{
					
					count += prices[i] - buy ;
					buy = -1 ;
				}
			}
				
		}
		
		return count ;
		
    }

}
