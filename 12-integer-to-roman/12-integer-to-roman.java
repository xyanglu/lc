class Solution {
    public String intToRoman(int num) {
        String rc = "";
        while ( num > 0 ) {
            if ( num >= 1000 ) {
                rc += 'M';
                num-=1000;
            }
            else if ( num >= 900 ) {
                rc += "CM";
                num-=900;
            }
            else if ( num >= 500 ) {
                rc += 'D';
                num-=500;
            }
            else if ( num >= 400 ) {
                rc += "CD";
                num-=400;
            }
            else if ( num >= 100 ) {
                rc += 'C';
                num-=100;
            }
            else if ( num >= 90 ) {
                rc += "XC";
                num-=90;
            }
            else if ( num >= 50 ) {
                rc += 'L';
                num-=50;
            }
            else if ( num >= 40 ) {
                rc +="XL";
                num-=40;
            }
            else if ( num >= 10 ) {
                rc += 'X';
                num-=10;
            }
            else if ( num >= 9 ) {
                rc += "IX";
                num-=9;
            }
            else if ( num >= 5 ) {
                rc += 'V';
                num-=5;
            }
            else if ( num >= 4 ) {
                rc += "IV";
                num-=4;
            }
            else if ( num >= 1 ) {
                rc += 'I';
                num-=1;
            }
        }
        return rc;
    }
}