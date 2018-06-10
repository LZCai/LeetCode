package primary;

import java.util.Arrays;

/**
 * @author 64621 -- lzcai
 * @time 2018年6月10日 下午2:40:04
 * 
 * 题目：给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 思路分析：从数组的最后一个数组开始遍历，并+1，若>=10,则进一位，当前值-10
 * 若不需要进位则循环结束，break
 * 
 * 注意：当最高为需要进位时，需要对数组进行复制和扩容。
 * 
 * 考察点：数组的复制和扩容
 * Array.copyOf()
 * System.arraycopy()
 */
public class 加一 {
	
	public static void main(String[] args){
		
		int[] nums = {9, 9} ;
		
		System.out.println(Arrays.toString(plusOne(nums)));
		
	}
	
	public static int[] plusOne(int[] digits) {
        
        for(int i=digits.length-1 ; i>=0 ; i--){
            
            int num = digits[i] ;
            
            num = num+1 ;
            
            if(num >= 10){
                
                num -= 10 ;
                
                digits[i] = num ;
                
            }else{
                
                digits[i] = num ;
                
                break ;
            }
            
            if(i == 0){
                
                int[] result = new int[digits.length+1] ;
                
                System.arraycopy(digits, 0, result, 1, digits.length) ;
                
                result[0] = 1 ;
                
                return result ;
                
            }
            
        }
        
        return digits ;
        
    } 

}
