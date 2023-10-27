package main

import "fmt"

type No struct {
	Chave    int
	Esq, Dir *No
}

type Arvore struct {
	Raiz *No
}

func main() {
	arv := Arvore{}
	
	n1 := &No{Chave: 3}
	n2 := &No{Chave: 1}
	n3 := &No{Chave: 2}
	n4 := &No{Chave: 7}
	n5 := &No{Chave: 5}
	n6 := &No{Chave: 4}
	n7 := &No{Chave: 6}

	arv.Raiz = n1
	n1.Esq = n2
	n1.Dir = n4
	n2.Dir = n3
	n4.Esq = n5
	n5.Esq = n6
	n5.Dir = n7

	imprimeArvore(arv)
	fmt.Println("----------------")
	insere(arv, 0)
	imprimeArvore(arv)
	fmt.Println("----------------")
	insere(arv, 10)
	imprimeArvore(arv)
	fmt.Println("----------------")
	insere(arv, 7)
	imprimeArvore(arv)
	fmt.Println("----------------")
}

func buscaArvore(n *No, valor int) (*No, int) {
	if n == nil { return nil, 0 }
	if n.Chave == valor { return n, 1 }

	if valor < n.Chave {
		if n.Esq == nil { return nil, 2 }
		return buscaArvore(n.Esq, valor)
	} else {
		if n.Dir == nil { return nil, 3 }
		return buscaArvore(n.Dir, valor)
	}
}

func insere(a Arvore, valor int) {
	if a.Raiz == nil {
		a.Raiz = &No{Chave: valor}
		return
	}

	no := a.Raiz

	for {
		_, i := buscaArvore(no, valor)

		if i == 1 {
			fmt.Println("*** Erro! Valor já existente. ***")
			return
		}

		novoNo := &No{Chave: valor, Esq: nil, Dir: nil}

		if i == 2 { 
			if no.Esq == nil {
				no.Esq = novoNo
				return
			}
			no = no.Esq
		} else {
			if no.Dir == nil {
				no.Dir = novoNo
				return
			}
			no = no.Dir
		}
	}
}

func imprimeArvore(a Arvore) {
	if a.Raiz != nil { imprimeSimetrico(a.Raiz) }
}

func imprimeSimetrico(n *No) {
	if n.Esq != nil { imprimeSimetrico(n.Esq) }
	fmt.Println(n.Chave)
	if n.Dir != nil { imprimeSimetrico(n.Dir) }
}
