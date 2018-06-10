package primary;

/**
 * @author 64621 -- lzcai
 * @time 2018年6月10日 下午1:52:11
 * 
 * 题目：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 
 * 思路分析：
 * 
 * 本题主要考察二进制的^（异或）运算，并且相同两个数的运算结果为0；即：4^4 = 0 
 * 因此，可以使用异或运算来求解只出现一次的数字。
 */
public class 只出现一次的数字 {
	
	public static void main(String[] args){
	
		int[] nums = {1,2,3,4,4,3,2} ;
		
		System.out.println(singleNumber(nums));
		
	}
	
	public static int singleNumber(int[] nums) {
        
        int result = nums[0];

        for(int i=1 ; i<nums.length ; i++){
            
            result ^= nums[i] ;
            
        }
        
        return result ;
        
    }

}
