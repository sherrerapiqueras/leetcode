// see at https://leetcode.com/problems/add-two-numbers/solutions/5943028/strings-and-chars-approach-in-kotlin
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
