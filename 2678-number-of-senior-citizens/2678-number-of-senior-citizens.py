import re
class Solution:
    def countSeniors(self, details: List[str]) -> int:
        return len([s for s in details if int(s[-4:]) >= 6100])
