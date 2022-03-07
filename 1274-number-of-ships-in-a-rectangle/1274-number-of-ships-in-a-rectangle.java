/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    public int countShips(Sea sea, int[] t, int[] b) {
        if ( !sea.hasShips(t,b) ) return 0;
        if ( t[0] == b[0] && t[1] == b[1] ) return 1;
        int x = b[0] + (t[0] - b[0])/2;
        int y = b[1] + (t[1] - b[1])/2;
        
        int res = 0;
        
        //bottom left
        int[] blb = b;
        int[] blt = new int[]{x,y};
            
            res+= countShips(sea,blt,blb);
        
        //bottom right
        int[] brb = new int[]{x+1,b[1]};
        int[] brt = new int[]{t[0],y};
        
            res+= countShips(sea,brt,brb);
        
        
        //top left
        int[] tlb = new int[]{b[0],y+1};
        int[] tlt = new int[]{x,t[1]};
        
            res+= countShips(sea,tlt,tlb);
            
        //top right
        int[] trb = new int[]{x+1,y+1};
        int[] trt = t;
        
            res+= countShips(sea,trt,trb);
        
        return res;
    }
}