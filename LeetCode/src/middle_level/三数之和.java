package middle_level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 64621 -- lzcai
 * @time 2018年6月6日 下午2:56:54
 * 首先如果使用暴力法解决此题，时间复杂度为O(n^3)，必将超时。
 * 
 * 思路解析：
 * 因为本题求解的是，在数组中找到3个数，使得a+b+c=0，那么除了a=b=c=0的情况下，三个数中必定存在正负数。
 * 因此，在求解本题时，可以考虑首先对给定的数组进行排序，
 * 然后，从头开始，领 nums[i] = a, 在数组中查找a+b=-a,并且b=nums[i+1], c=nums[nums.length-1]
 * 因为数组是递增（递减）排序，因此当b+c>-a时，c往左移动，当b+c<-a时，b向右移动。
 * 但是在上述过程中，要时刻判断会不会存在重读的元素。
 * 
 * 注意：
 * 当a=nums[i]时，b只需要从i+1开始遍历即可，因为0-i的元素前面的循环中已经遍历。
 * 
 * 参考网址：https://www.cnblogs.com/grandyang/p/4481576.html
 */
public class 三数之和 {
	
	public static void main(String[] args){
		
		int[] nums = {-1, 0, 1, 2, -1, -4} ;
		
		System.out.println(threeSum(nums));
	}
	
	public static List<List<Integer>> threeSum(int[] nums){
		
		List<List<Integer>> list = new LinkedList<List<Integer>>() ;
		
		if(nums==null || nums.length < 3) return list ;  //输入数据不符合要求吗，直接返回空集合
		
		Arrays.sort(nums);
		
		for(int i=0 ; i<nums.length-2 ; i++){
			
			int a = nums[i] ;
			
			if(a>0) break ;  //如果a大于0，那么b和c也大于0，则a+b+c>0，因为数组递增排序
			if(i>0 && nums[i] == nums[i-1]) continue ;  //如果后一个元素等于前一个元素跳过
			
			int j = i+1 ;
			int k = nums.length-1 ;
			
			while(j<k){
				
				int b = nums[j] ;
				int c = nums[k] ;
				
				if(a+b+c == 0){
					
					List<Integer> threeNum = new ArrayList<Integer>() ;
					
					threeNum.add(a);
					threeNum.add(b) ;
					threeNum.add(c) ;
					
					/*
					 * 因为已对原数组进行排序，因此必定不会存在重复的数列，删除此句之前运行时间为986ms，删除后时间为63ms
					 * 由此可见集合运算的时间复杂度较高
					 * 
					Collections.sort(threeNum);
					
					if(!list.contains(threeNum))
						
						list.add(threeNum) ;
					*/
					
					list.add(threeNum) ;
					
					while(j<k && nums[j] == nums[j+1]) j++ ;
					while(j<k && nums[k] == nums[k-1]) k-- ;
					
					j++ ;
					k-- ;
					
				}else if(b+c < -a){
					
					j++ ;
					
				}else{
					
					k-- ;
				}
				
			}
			
			
		}
		
		return list ;
		
	}

}
