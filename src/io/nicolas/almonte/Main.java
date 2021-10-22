package io.nicolas.almonte;

public class Main {

    public static void main (String[] args) {

        long [] testRange1;
        testRange1 = new long[2];
        testRange1[0] = 11;
        testRange1[1] = 50;

        long [] testRange2;
        testRange2 = new long[2];
        testRange2[0] = 22;
        testRange2[1] = 175;

        long [] testRange3;
        testRange3 = new long[2];
        testRange3[0] = 4;
        testRange3[1] = 837;

        int test1 = howManyDivisorsInRange(testRange1, 3);
        int test2 = howManyDivisorsInRange(testRange2, 3);
        int test3 = howManyDivisorsInRange(testRange3, 3);

        // Output: 2
        System.out.format("There are %d numbers having exactly 3 divisors between %d and %d \n", test1, testRange1[0], testRange1[1]);
        // Output: 4
        System.out.format("There are %d numbers having exactly 3 divisors between %d and %d \n", test2, testRange2[0], testRange2[1]);
        // Output: 9
        System.out.format("There are %d numbers having exactly 3 divisors between %d and %d \n", test3, testRange3[0], testRange3[1]);

    }

    /**
     * Counts the amount of numbers within a range [a, b] having exactly the specified amount of divisors.
     *
     * @param range array of size 2 containing the lower and upper limits of the range to evaluate.
     * @param numberOfDivisorsToFind criteria representing how many divisors to find.
     * @return amount of numbers having the specified amount of divisors.
     */
    static int howManyDivisorsInRange(long[] range, int numberOfDivisorsToFind)
    {
        if (range.length > 2) {
            throw new IllegalArgumentException("The range can only have a lower and an upper limit.");
        }

        if (range[0] > range[1]) {
            throw new IllegalArgumentException("The lower limit of the range cannot be greater than the upper limit");
        }

        if (howManyDigits(range[0]) > 9 || (howManyDigits(range[1]) > 9 )) {
            throw new IllegalArgumentException("The values in the range cannot be over 9 digits long");
        }

        int divisorCount = 0;
        for (long i = range[0]; i <= range[1]; i++) {
            if (howManyDivisors(i) == numberOfDivisorsToFind)
                divisorCount += 1;
        }
        return divisorCount;
    }

    /**
     * Counts the amount of divisors for any given integer.
     *
     * @param number the integer to be evaluated.
     * @return the amount of divisors found.
     */
    static long howManyDivisors(long number)
    {
        int divisorCount = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                divisorCount += 1;
            }
        }
        return divisorCount;
    }

    /**
     * Counts the amount of digits for any given integer.
     *
     * @param number integer to be evaluated.
     * @return amount of digits that the given number has.
     */
    static long howManyDigits(long number) {
        long digitCount = 0;

        while (number != 0) {
            number /= 10;
            ++ digitCount;
        }

        return digitCount;
    }


}