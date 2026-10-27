class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        newNums = set()
        for i in nums:
            if i in newNums:
                return True
            else:
                newNums.add(i)
        return False