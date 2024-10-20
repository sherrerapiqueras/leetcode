# Intuition
The problem seemed to be easily solved using strings and chars, so the complex part would be to arrange the solution using the ListNode object.

# Approach
Firstly, unwrap all the values from the ListNode class to primitive values, integers and strings.
Then, reverse the strings to get the actual numbers and make the sum. We need to be prepared against some test cases with really big numbers, so we parse to BigInteger to be able to make it.
Finally, wrap the results in the charArray with a temp variable and an indexed for starting from the second element until the end. There you have the result.

# Complexity
- Time complexity: $$O(N + M)$$

- Space complexity: $$O(max(N, M))$$

# Code
```kotlin []
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var a = l1
        var b = l2
        var l1String = ""
        var l2String = ""
        while (a != null) {
            l1String += a.`val`
            a = a.next
        }
        while (b != null) {
            l2String += b.`val`
            b = b.next
        }
        val op1 = l1String.reversed().toBigInteger()
        val op2 = l2String.reversed().toBigInteger()
        val sum = op1 + op2
        val sumStringArray = sum.toString().reversed().toCharArray()

        val result = ListNode(sumStringArray[0].digitToInt())
        var current = result
        for (i in 1..<sumStringArray.size) {
            current.next = ListNode(sumStringArray[i].digitToInt())
            current = current.next!!
        }
        return result
    }
}
```