package main

import (
	"fmt"
	"strconv"
)

/*
A permutation is an ordered arrangement of objects. For example, 3124 is one
possible permutation of the digits 1, 2, 3 and 4. If all of the permutations
are listed numerically or alphabetically, we call it lexicographic order. The
lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5,
6, 7, 8 and 9?
*/

func main() {
	max := 1000000
	choices := []int{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}

	permutation := ""

	for i := len(choices) - 1; i > 0; i-- {
		iFactorial := factorial(i)

		if iFactorial * len(choices) < max {
			break
		}

		for j := 1; j <= len(choices); j++ {
			if j*iFactorial >= max {

				permutation = permutation + strconv.Itoa(choices[j-1])
				choices = append(choices[:j-1], choices[j:]...)
				max = max - ((j - 1) * iFactorial)

				break
			}
		}
	}

	for _, choice := range choices {
		permutation = permutation + strconv.Itoa(choice)
	}

	fmt.Println("Result: ", permutation)
}

func factorial(num int) int {
	result := 1

	for i := 1; i <= num; i++ {
		result = result * i
	}

	return result
}
