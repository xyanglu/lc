class Solution(object):
    def countSeniors(self, details):
        count = 0
        for detail in details:
            age_str = detail[-4:-2]  # Assuming age is in the last 4 characters, e.g., 'XX' or 'XXYY' format
            if age_str.isdigit() and int(age_str) > 60:
                count += 1
        return count
