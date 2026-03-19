class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        l = 0
        n = len(nums) 
        hash = {}
        for i in range(n):
            if nums[i] not in hash:
                hash[nums[i]] = i
        ans = []
        print(hash)
        for j in range(n):
            if target-nums[j] in hash and j != hash[target-nums[j]]:
                ans = [j, hash[target-nums[j]]]
                print(ans)
                return ans;
        return ans
