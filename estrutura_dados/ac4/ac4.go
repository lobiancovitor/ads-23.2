package main

import "fmt"

func main() {
	hanoi(4, "A", "B", "C")
	fmt.Println(count, "movimentos.")
}

var count int = 0

func hanoi(n int, origem string, destino string, trabalho string) {
	if n > 0 {
		hanoi(n-1, origem, trabalho, destino)
		fmt.Println(n, ":", origem, "-->", destino)
		hanoi(n-1, trabalho, destino, origem)
		count++
	}
}