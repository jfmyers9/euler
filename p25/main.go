package main

import (
	"fmt"
	"math/big"
)

func main() {
	var last, current, n *big.Int

	last = big.NewInt(1)
	current = big.NewInt(1)
	n = big.NewInt(0)

	i := 0

	for {
		i++
		if i <= 2 {
			continue
		}

		n = n.Add(last, current)

		last.Add(big.NewInt(0), current)
		current.Add(big.NewInt(0), n)

		width := len(n.String())

		if width >= 1000 {
			fmt.Println("Result: ", i)
			break
		}
	}
}
