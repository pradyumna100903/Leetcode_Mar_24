class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
         // Find the minimum and maximum elements in the array
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Create an array to store the frequencies of elements
        int[] frequencies = new int[max - min + 1];

        int left = 0; // Left pointer for the sliding window
        
        int maxWindow = 0; // Variable to store the maximum length of the good subarray

        // Iterate through the array using the right pointer
        for (int right = 0; right < nums.length; right++) {
            frequencies[nums[right] - min]++; // Increment the frequency of the current element

            // Shrink the window until all frequencies are less than or equal to k
            while (frequencies[nums[right] - min] > k) {
                frequencies[nums[left] - min]--; // Decrement the frequency of the element at the left pointer

                left++; // Move the left pointer to the right
            }

            // Update the maximum window size
            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return maxWindow; // Return the maximum length of the good subarray
    }
}
