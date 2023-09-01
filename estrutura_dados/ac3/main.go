package main

import (
	"bufio"
	"fmt"
	"os"
	"ac3/contato"
	"ac3/utils"
)

func main() {
	var contatos [5]contato.Contato
	var nome, email, opcao, novoEmail string
	var x int

	leitor := bufio.NewReader(os.Stdin)

	fmt.Println("Lista de contatos!")
	for {
		fmt.Println("Digite (1) para adicionar, (2) para remover, (3) para exibir contatos, (4) para editar o email de um contato ou qualquer outra coisa para sair: ")
		fmt.Scanln(&opcao)

		switch opcao {
		case "1":
			fmt.Print("Informe o seu nome: ")
			nome, _ = leitor.ReadString('\n')

			fmt.Print("Informe o seu email: ")
			fmt.Scanln(&email)

			utils.AdicionaContato(contato.Contato{Nome: nome, Email: email}, &contatos)
		case "2":
			utils.ExcluiContato(&contatos)
		case "3":
			utils.ExibeContatos(contatos)
		case "4": 
			fmt.Print("Informe o índice do contato: ")
			fmt.Scanln(&x)

			if (contatos[x] == contato.Contato{}) {
				fmt.Println("Contato não existente.")
				break
			}

			fmt.Print("Informe o novo email: ")
			fmt.Scanln(&novoEmail)

			utils.EditaEmail(x, novoEmail, &contatos)
		default:
			return
		}

		fmt.Println(contatos)
	}

}