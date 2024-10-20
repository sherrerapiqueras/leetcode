# Intuition
Firstly, I thought it could be easily solve with 2 for loops at maximum. After some trials escaping the wrong cases (like nums[i] > target), I saw it wasn't necessary at all, and it could even generate some problems in the scenario with negative numbers.

# Approach
A very simple iterative approach using for loops with indices. Having i as first loop index and j as second loop index, we try to add up two numbers following this sequence (imagine we have 3 numbers in nums array): nums[0] + nums[1], nums[0] + nums[2], nums[1] + nums[2].

# Complexity
- Time complexity: $$O(n^2)$$

- Space complexity: $$O(1)$$

# Code
```kotlin []
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in nums.indices) {
            for (j in i + 1..<nums.size) {
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        return intArrayOf()
    }
}
```