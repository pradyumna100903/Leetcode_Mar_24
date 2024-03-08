class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq=new int[101];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        int max=0;
        for(int i=0;i<freq.length;i++){
             max=Math.max(max, freq[i]);
        }
        int c=0;
        for(int i=0;i<101;i++){
           if(freq[i]==max)
            c++;
        }
        return c*max;
    }
}

