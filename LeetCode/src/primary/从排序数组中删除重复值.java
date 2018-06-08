package primary;

import java.util.Arrays;

/**
 * @author 64621 -- lzcai
 * @time 2018年6月7日 下午2:54:35
 * 
 * 执行时间：13ms
 * 思路分析：
 * 
 * 题目要求在原地进行操作，不能创建额外的数组空间，并且时间复杂度为O(1)
 * 
 * 因为给定的数组为排序数组，所以不需要再次进行排序，那么就逐项比较相邻的两个元素是否相同，
 * 	若出现相同的，后者设置为int最大值，在最后排序时放到最后，不用考虑；后面的元素继续和前面的元素进行比较。
 * 	若不同，则更新prev，继续比较。
 * 最后对原数组进行排序。并返回nums.length - count(重复值的个数)
 
 */
public class 从排序数组中删除重复值 {
	
	public static void main(String[] args){
		
		int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 4} ;

		System.out.println(removeDuplicates(nums));
		
		System.out.println(nums[4]);
		
	}
	
	public static int removeDuplicates(int[] nums) {
		
		if(nums == null || nums.length == 0)
			
			return 0 ;
        
        int count = 0 ;
        
        int prev = nums[0] ;
        
        for(int i=1 ; i<nums.length ; i++){
            
            if(nums[i] == prev){
                
                nums[i] = Integer.MAX_VALUE ;
                
                count ++ ;
                
            }else{
            	
            	prev = nums[i] ;
            }
        }
        
        Arrays.sort(nums);
        
        return nums.length - count ;
        
    }

}
