class Solution:
    def appendCharacters(self, s: str, t: str) -> int:
        i = 0
        length = len(t)
        for c in s:
            if i < len(t) and c == t[i]:
                i += 1
        return length - i