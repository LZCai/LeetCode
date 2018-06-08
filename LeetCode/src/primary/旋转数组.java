package primary;

import java.util.Arrays;

/**
 * @author 64621 -- lzcai
 * @time 2018年6月7日 下午3:27:00
 * 
 * 执行时间：1ms
 * 
 * 前前后后大概33-4个小时，第二天突然发现最大公约数的规律，然后把题目搞了出来😂
 * 
 * 思路解析：
 * 
 * 模拟发现，数组元素交换次数 = 数组长度len 和 移动次数k的最大公约数
 * 
 * 因此，在进行交换时本题，思路拓展数组中两个元素交换的方法，进行多元素交换。
 * 
 */
public class 旋转数组 {
	
	public static void main(String[] args){
		
		int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,
				28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54} ;
		
		rotate(nums, 45) ;
		
		System.out.println(Arrays.toString(nums)) ;
		
		System.out.println(gcd(54, 45));
		
		
	}
	
	 public static void rotate(int[] nums, int k) {
		 
		 if(nums == null || nums.length == 0)
			 
			 return ;
		 
		 int len = nums.length ;
		 
		 if(k%len == 0)
			 
			 return ;
		 
		 int loop = gcd(len, k%len) ;
		 
		 for(int i=0 ; i<loop ; i++){
			 
				 int old_index = len-1-i ;
				 
				 int new_index = (old_index+k)%len ;
				 
				 int prev = nums[old_index] ;
				 int temp = nums[new_index] ;
				 
				 while(new_index != len-1-i){
					 
					 nums[new_index] = prev ;
					 
					 old_index = new_index ;
					 
					 prev = temp ;
					 
					 new_index = (old_index+k)%len ;
					 
					 temp = nums[new_index] ;
					 
				 }
				 
				 nums[len-1-i] = prev ;
		 }
		 
	 }
	 
	 public static int gcd(int a, int b){
		 
		 if(a%b != 0){
			 
			 return gcd(b, a%b) ;
			 
		 }else{
			 
			 return b ;
		 }
	 }

}
