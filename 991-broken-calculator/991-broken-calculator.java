class Solution {
    public int brokenCalc(int X, int Y) {
        int steps = 0;
        while ( Y > X) {
            if ( Y % 2 == 1)
                Y++;
            else 
                Y = Y/2;
            steps++;
        }
        return steps + X - Y;
    }
}