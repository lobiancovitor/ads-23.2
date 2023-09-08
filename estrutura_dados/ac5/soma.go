package main

import "fmt"

func main() {
	exemplo := []int{1, 2, 3, 4, 5}

	fmt.Println(soma(exemplo, 3))
	fmt.Println(soma(exemplo, 12))

}

func soma(v []int, alvo int) (int, int) {
	for i := 0; i < len(v); i++ {
		comp := alvo - v[i]
		if comp <= v[len(v)-1] && comp >= v[0] && comp != v[i]{
			return v[i], comp
		}
	}
	return -1, -1
}