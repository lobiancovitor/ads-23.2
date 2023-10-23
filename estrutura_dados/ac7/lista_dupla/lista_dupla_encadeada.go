package main

import "fmt"

type No struct {
	chave int
	prox  *No
	ant	  *No
}

type Lista struct {
	cab *No
}

func (l *Lista) busca(chave int) *No {
	no := l.cab

    for no != nil {
        if no.chave == chave { return no }
        no = no.prox
        if no == l.cab { break }
    }
    return nil
}

func (l *Lista) exibe() {
	no := l.cab

	for no != nil {
		fmt.Println(no.chave)
		no = no.prox
		if no == l.cab { break }
	}
}

func (l *Lista) insere(ch int) {
	novoNo := &No{chave: ch, prox: l.cab, ant: nil}
	no := l.cab

	if no == nil {
		novoNo.ant = novoNo
	} else {
		no.ant = novoNo
	}
	l.cab = novoNo
}

func (l *Lista) remove(ch int) {
	no := l.busca(ch)

	if no == nil { return }

	if no == l.cab { l.cab = no.prox }

	if no.ant != nil { no.ant.prox = no.prox}

	if no.prox != nil { no.prox.ant = no.ant }

}

func main() {
	var l Lista

	l.insere(2)
	l.insere(1)
	l.insere(9)
	l.insere(3)
	l.exibe()
	fmt.Println()

	l.remove(0)
	l.remove(2)
	l.remove(9)
	l.exibe()
}