package primary;

import java.util.Arrays;

/**
 * @author 64621 -- lzcai
 * @time 2018年6月11日 下午5:55:57
 * 
 */
public class 两个数组的交集 {
	
	public static void main(String[] args){
		
		int[] nums1 = {-2147483648,1,2,3} ;
		int[] nums2 = {1,-2147483648,-2147483648} ;
		
		System.out.println(Arrays.toString(intersect(nums1, nums2)));
	}
	
	public static int[] intersect(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1) ;
        Arrays.sort(nums2) ;
        
        int len1 = nums1.length ;
        int len2 = nums2.length ;
        
        int[] result = new int[len1<len2?len1:len2] ;
        int index = 0 ;
        
        if(len1 < len2){
        	
        	boolean[] used = new boolean[len2] ;
            
            for(int i=0 ; i<len1 ; i++){
                
                for(int j=0 ; j<len2 ; j++){
                    
                    if(nums1[i] == nums2[j] && !used[j]){
                        
                        result[index] = nums1[i] ;
                        
                        used[j] = true ;
                        
                        index ++ ;
                            
                        break ;
                    }else if(nums1[i] < nums2[j]){
                        
                        break ;
                    }
                }
            }
        }else{
        	
        	boolean[] used = new boolean[len1] ;
            
            for(int i=0 ; i<len2 ; i++){
            	
                for(int j=0 ; j<len1 ; j++){
                	
                    if(nums2[i] == nums1[j] && !used[j]){
                        
                        result[index] = nums2[i] ;
                        
                        used[j] = true ;
                        index ++ ;
                        
                        break ;
                        
                    }else if(nums2[i] < nums1[j]){
                        
                        break ;
                    }
                }
            }
        }
        
        result = Arrays.copyOf(result, index) ;
        
        return result ;
    }

}
