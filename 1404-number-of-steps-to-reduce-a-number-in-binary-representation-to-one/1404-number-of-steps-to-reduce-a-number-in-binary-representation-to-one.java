public class Solution {
    public int numSteps(String s) {
        int steps = 0;
        while (!s.equals("1")) {
            if (s.charAt(s.length() - 1) == '1') {
                s = addOne(s);
            } else {
                s = s.substring(0, s.length() - 1);
            }
            steps++;
        }
        return steps;
    }

    private String addOne(String s) {
        StringBuilder sb = new StringBuilder();
        int carry = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int sum = (s.charAt(i) - '0') + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
