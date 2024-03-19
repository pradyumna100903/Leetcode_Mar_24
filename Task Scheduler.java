class Solution {
    public int leastInterval(char[] tasks, int n) {
       // Create an array to store the frequency of each task (A-Z)
        int[] frequency = new int[26];
        
        // Count the frequency of each task
        for (char task : tasks) {
            frequency[task - 'A']++;
        }
        
        // Sort the frequencies in ascending order
        Arrays.sort(frequency);
        
        // Find the maximum frequency (subtract 1 to account for the last task)
        int maxFreq = frequency[25] - 1;
        
        // Calculate the total idle slots needed
        int idleSlots = maxFreq * n;
        
        // Iterate through the frequencies from the second highest to the lowest
        for (int i = 24; i >= 0 && frequency[i] > 0; i--) {
            // Subtract the minimum of maxFreq and current frequency from idle slots
            idleSlots -= Math.min(maxFreq, frequency[i]);
        }
        
        // If idle slots are still remaining, add them to the total length
        // Otherwise, return the original length of tasks array
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length; 
    }
}
