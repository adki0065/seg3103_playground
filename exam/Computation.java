/*
Q3: [10 points]
The code in Q2 in unnecessarily complex. Simplify the code in at least 2 spots to
make it simpler, but maintain the same behaviour (in other words, refactor the code).
public class Computation {
public int compute(int a, int b)
{
// refactor the code to make it simpler
//
// HINT: Look closely at when a <= b
// and when a > 6
}
}
What changes, if any, would you make the to the test cases from above. Justify your
answer.
*/



public class Computation {
    public int compute(int a, int b) {
        int x = 0;
        if (b > a) {
            x = a;
            if (a > 6) {
                x = b;
            }
            if (x == 3 || x < 0) {
                x = x * b;
            }
            x -= 1;
        } else {
            x = x + 1;
        }
        return x;
    }

}
