class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] freq = new int[1001];
        int[] ans = new int[1001];
        int j=0;
        for(int a:nums1){
            freq[a]=-1;            
        }
        for(int a:nums2){
            if(freq[a]==-1){
                ans[j++]=a;
                freq[a]=1;
            }    
        }
        int[] res = new int[j];
        for(int i=0; i<res.length; i++){
            res[i]=ans[i];
        }
        return res;
    }
}

