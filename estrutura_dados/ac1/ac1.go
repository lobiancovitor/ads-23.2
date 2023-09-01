package main

import "fmt"

func main() {

	// e_bissexto()

	// semana()

	// e_primo()
	

	var fibo_num int
	fmt.Println("Informe um número:")
	fmt.Scanln(&fibo_num)

	fmt.Println(fibo(fibo_num))
	
	
}

func e_bissexto() {
	var ano int
	fmt.Println("Informe um ano:")
	fmt.Scanln(&ano)

	if ano % 4 != 0 || ano % 100 == 0 && ano % 400 != 0 {
			fmt.Println("Não é bissexto", ano)
		} else {
			fmt.Println("É bissexto", ano)
		}
	} 


func semana() {
	var dia int
	fmt.Println("Informe um dia da semana:")
	fmt.Scanln(&dia)

	switch dia {
	case 1:
		fmt.Println("Domingo")
	case 2:
		fmt.Println("Segunda")
	case 3:
		fmt.Println("Terça")
	case 4:
		fmt.Println("Quarta")
	case 5:
		fmt.Println("Quinta")
	case 6:
		fmt.Println("Sexta")
	default:
		fmt.Println("Valor inválido")
	}
	
}

func e_primo() (bool) {
	var primo int
	var count int
	fmt.Println("Informe um número para saber se é primo:")
	fmt.Scanln(&primo)

	for i := 2; i <= primo/2; i++ {
		if primo % i == 0 {
			fmt.Println(i)
			count += 1
		}
	}

	if count > 0 {
		return false
	} else {
		return true
	}
}


func fibo(num int) (int) {
	if num <= 0 {
		return 0
	} else if num == 1 {
		return 1
	} else {
		return fibo(num - 1) + fibo(num - 2)
	}

	




}