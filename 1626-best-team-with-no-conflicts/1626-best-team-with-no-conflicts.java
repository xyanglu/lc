class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] rc = new int[scores.length][2];
        for (int i=0;i<scores.length;i++)
            rc[i] = new int[]{scores[i],ages[i]};
        
        Arrays.sort(rc,(a,b)->a[0] == b[0] ? a[1] - b[1] : a[0] - b[0] );
        Arrays.sort(scores);
        
        int max = 0;
        for (int i=0;i<rc.length;i++)
        {
            int mScore = rc[i][0];
            int mAge =  rc[i][1];
            for (int j=0;j<i;j++) {
                int score = rc[j][0];
                int age = rc[j][1];
                if ( mAge >= age )
                    scores[i] = Math.max(scores[i],mScore+scores[j]);
            }
            max = Math.max(max,scores[i]);
        }
            
            
        return max;
    }
}