Approch 
Brute force-
For 69. Sqrt(x), brute force means:

Try every possible answer until you find the largest number whose square is ≤ x.

Example:

x = 8

1 * 1 = 1
2 * 2 = 4
3 * 3 = 9  ← too big

Answer = 2

Code:

class Solution {
    public int mySqrt(int x) {

        for (int i = 0; i <= x; i++) {

            if ((long)i * i > x) {
                return i - 1;
            }

        }

        return x;
    }
}

How to think

Ask:
What are all possible answers?

For sqrt:
0, 1, 2, 3, 4, ...

Then:
Can I check whether an answer is correct?

Yes:
i * i <= x

Then:
Try all answers one by one.

That's brute force.

For x = 16
0² = 0
1² = 1
2² = 4
3² = 9
4² = 16
5² = 25 ← too much

return 4

Time Complexity:
O(√x)

because the loop effectively stops around the square root.
After finding the brute force, then ask:
Can I avoid checking every number?
That question leads to Binary Search, which is the optimal solution for this problem. But always find the brute force first. That's how interviewers expect you to think.


Optimal-
The key observation:
x = 81² = 12² = 43² = 9
The answer lies between:
0 and x
And the squares are sorted:
1, 4, 9, 16, 25, ...
Whenever you see sorted values and you're searching for a target condition:
mid² == xmid² < xmid² > x
think Binary Search.

Dry Run
x = 8left = 0right = 8mid = 44² = 16 > 8
Too large.
right = 3

left = 0right = 3mid = 11² = 1 < 8
Possible answer.
ans = 1left = 2

left = 2right = 3mid = 22² = 4 < 8
Better answer.
ans = 2left = 3

left = 3right = 3mid = 33² = 9 > 8
Too large.
right = 2
Loop ends.
return 2

Code

class Solution {
    public int mySqrt(int x) {

        int left = 0;
        int right = x;
        int ans = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            }

            if (square < x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}

Why long?
    
If:
x = 2147395599
    
then
mid * mid
can overflow an int.
    
So:
long square = (long) mid * mid;
prevents overflow.
Pattern learned
When you need:
largest value satisfying a condition
    
such as:
mid² <= x
Binary Search is often the optimal approach.
    
Time Complexity:
O(log x)
Space Complexity:
O(1)
