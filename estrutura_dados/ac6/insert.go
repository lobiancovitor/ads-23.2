package main

import "fmt"

const M = 5

func main() {
	var lista [M]int
	var n = 0

	insereOrd(&lista, &n, 4)
	fmt.Println(lista)

	insereOrd(&lista, &n, 12)
	fmt.Println(lista)

	insereOrd(&lista, &n, 2)
	fmt.Println(lista)

	insereOrd(&lista, &n, 6)
	fmt.Println(lista)

	insereOrd(&lista, &n, 17)
	fmt.Println(lista)

	insereOrd(&lista, &n, 1)
	fmt.Println(lista)
}

func insereOrd(v *[M]int, n *int, novoValor int) {
	if *n == M {
		fmt.Println("Overflow")
		return
	}
	i := *n - 1
	// fmt.Println("i -->", i)
    for i >= 0 && v[i] > novoValor {
		// fmt.Println(v[i+1], "<--", v[i])
        v[i+1] = v[i]
        i--
    }
	// fmt.Println(v[i+1], "<----", novoValor)
    v[i+1] = novoValor
    *n++
}