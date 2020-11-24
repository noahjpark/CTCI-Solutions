/* Noah Park

You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1) return nums;
        if(k == 0) return new int[0];
        List<Integer> res = new ArrayList<>();
        
        int wstart = 0, wend = 0, max = Integer.MIN_VALUE;
        // initialize max in sliding window
        while(wend < k) 
            max = Math.max(max, nums[wend++]);
        wend = k - 1; // put wend on the max window size so far
        
        // loop through
        while(wend < nums.length){           
            // add the max each new window
            if(wend - wstart + 1 == k) res.add(max);
    
            // update the window end
            // update max in case we found a larger one
            wend++;
            if(wend < nums.length && nums[wend] > max) max = nums[wend];
            
            // break if we fall off the end
            if(wend >= nums.length) break;
            
            // shrink the window if too large
            if(wend - wstart + 1 > k) {
                if(nums[wstart] == max){
                    wstart++;
                    max = Integer.MIN_VALUE; // find new max if we drop our old one
                    for(int i = wstart; i <= wend; i++)
                        max = Math.max(max, nums[i]);
                }
                else wstart++;
            }
        }
        
        int[] ret = new int[res.size()];
        for(int i = 0; i < res.size(); i++)
            ret[i] = res.get(i);
        
        return ret;
    }
}
