package main

import "fmt"

type No struct {
	chave int
	prox  *No
}

type Lista struct {
	cab *No
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
	novoNo := &No{chave: ch}
	no := l.cab

	if no == nil {
		novoNo.prox = novoNo
	} else {
		novoNo.prox = l.cab
		for no.prox != l.cab {
			no = no.prox
		}
		no.prox = novoNo
	}
	l.cab = novoNo
}

func (l *Lista) remove() {
	no := l.cab

	if no == nil { return }

	if no.prox == no { 
		l.cab = nil 
	} else {
		novoNo := l.cab
		for novoNo.prox != l.cab {
			novoNo = novoNo.prox
		}
		novoNo.prox = no.prox
		l.cab = l.cab.prox
		
	}
}

func main() {
	var l Lista

	l.insere(3)
	l.insere(2)
	l.insere(1)
	l.exibe()

	fmt.Println()
	
	l.remove()
	l.exibe()
}
