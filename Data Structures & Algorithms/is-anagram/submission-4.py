class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # ordered the strings
        FirstStringOrdered = "".join(sorted(s))
        SecondStringOrdered = "".join(sorted(t))

        if FirstStringOrdered == SecondStringOrdered and len(SecondStringOrdered) == len(FirstStringOrdered):
            return True
        
        return False