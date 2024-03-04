class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int ans=0,l=0,r=tokens.length-1,score=0;
        for(int i=0;i<tokens.length;i++){
            if(power>=tokens[l]){
                score++;
                power-=tokens[l];
                l++;
            }else if(score>0){
                power+=tokens[r];
                r--;
                score--;
            }
            else{
                break;
            }
            ans=Math.max(ans,score);
        }
        return ans;
    }
}

