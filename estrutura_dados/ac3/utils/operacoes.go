package utils

import (
	"fmt"
	c "ac3/contato"
)


func EditaEmail(x int, novoEmail string, a *[5]c.Contato) {
	a[x].AlteraEmail(novoEmail)
}

func AdicionaContato(cont c.Contato, a *[5]c.Contato) {
	for ind, contato := range a {
		if (contato == c.Contato{}) {
			a[ind] = cont
			break
		}
	}
}

func ExcluiContato(contatos *[5]c.Contato) {
	for i := len(contatos)-1; i >= 0; i-- {
		if (contatos[i] != c.Contato{}) {
			contatos[i] = c.Contato{}
			break
		}
	}
}

func ExibeContatos(a [5]c.Contato) {
	for ind, contato := range a {
		fmt.Println(ind, contato)
	}
}