package main

import (
	"fmt"
)

/*
A perfect number is a number for which the sum of its proper divisors is
exactly equal to the number. For example, the sum of the proper divisors of 28
would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n
and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
number that can be written as the sum of two abundant numbers is 24. By
mathematical analysis, it can be shown that all integers greater than 28123 can
be written as the sum of two abundant numbers. However, this upper limit cannot
be reduced any further by analysis even though it is known that the greatest
number that cannot be expressed as the sum of two abundant numbers is less than
this limit.

Find the sum of all the positive integers which cannot be written as the sum of
two abundant numbers.
*/

func main() {
	canBeMadeUpOfTwoAbundantNums := map[int]bool{}

	abundant := []int{}
	for i := 1; i < 28123; i++ {
		if isAbundant(i) {
			abundant = append(abundant, i)
			for _, j := range abundant {
				canBeMadeUpOfTwoAbundantNums[i+j] = true
			}
		}
	}

	var sum int
	for i := 1; i < 28123; i++ {
		_, ok := canBeMadeUpOfTwoAbundantNums[i]
		if ok {
			continue
		}

		sum += i
	}

	fmt.Printf("Result: %d\n", sum)
}

func isAbundant(num int) bool {
	var sum int
	divisors := properDivisors(num)

	for _, i := range divisors {
		sum += i
	}

	return sum > num
}

func properDivisors(num int) []int {
	result := []int{}

	for i := 1; i <= num/2; i++ {
		if num%i == 0 {
			result = append(result, i)
		}
	}

	return result
}
