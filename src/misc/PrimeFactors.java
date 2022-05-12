package misc;

/*
 * https://www.geeksforgeeks.org/print-all-prime-factors-of-a-given-number/
 *
 */
public class PrimeFactors {

    public void printPrimeFactors(int n) {

        int i = 2;

        while (n > 1) {
            if (n % i == 0) {
                System.out.print(i + " ");
                n = n / i;
            } else {
                i++;
            }
        }

    }

}
