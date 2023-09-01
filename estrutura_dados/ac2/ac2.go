package main

import "fmt"

func main() {
	var x int
	var contatos [5]Contato

	var contato1 = Contato{
		Nome: "Vitor",
		Email: "lobi@gmail.com",
	}

	contatos[1] = contato1

	for {
		fmt.Println("1 - Adicionar")
		fmt.Println("2 - Remover")
		fmt.Println("3 - Sair")
		fmt.Println("4 - Ver Contatos")
		fmt.Scanln(&x)

		switch x {
		case 1: 
			contatos = adicionaContato(criaContato(), contatos)
			fmt.Println(contatos)
		case 2: 
			contatos = excluiContato(contatos)
			fmt.Println(contatos)
		case 3:
			return
		case 4:
			fmt.Println(contatos)
		}
	}
	
}

type Contato struct {
	Nome	string
	Email	string
}

func criaContato() Contato {
	var nome, email string
	fmt.Println("Nome: ")
	fmt.Scanln(&nome)
	fmt.Println("Email: ")
	fmt.Scanln(&email)

	var c = Contato {
		Nome: nome,
		Email: email,
	}

	return c
}

func adicionaContato(c Contato, contatos [5]Contato) [5]Contato {
	for indice, contato := range contatos {
		if (contato == Contato{}) {
			contatos[indice] = c
			break
		}
	}
	return contatos
}

func excluiContato(contatos [5]Contato) [5]Contato {
	for i := len(contatos)-1; i >= 0; i-- {
		if (contatos[i] != Contato{}) {
			contatos[i] = Contato{}
			break
		}
	}
	return contatos
}


