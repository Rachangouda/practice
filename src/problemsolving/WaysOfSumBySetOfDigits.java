package problemsolving;

public class WaysOfSumBySetOfDigits {

    // JAVA program to count ways to write
// number as sum of even integers


        // Initialize mod variable as constant
        static int MOD = 1000000007;

        /* Iterative Function to calculate
        (x^y)%p in O(log y) */
        static int power(int x, int y, int p)
        {
            // Initialize result
            int res = 1;

            // Update x if it is more
            // than or equal to p
            x = x % p;

            while (y > 0)
            {
                // If y is odd, multiply x
                // with result
                if (y % 2 == 1)
                    res = (1 * res * x) % p;

                // y must be even now
                y = y >> 1; // y = y/2
                x = (1 * x * x) % p;
            }
            return res;
        }

        // Return number of ways to write
        // 'n' as sum of even integers
        static int countEvenWays(int n)
        {
            return power(2, n/2 - 1, MOD);
        }

        // Driver code
        public static void main(String args[])
        {
            int n = 6;
            System.out.println(countEvenWays(n));
            n = 20;
            System.out.println(countEvenWays(n));
        }

    /* This code is contributed by Nikita Tiwari. */

}
