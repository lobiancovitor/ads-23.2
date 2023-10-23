# Lista Circular

O que define uma lista circular é o fato de que 
**o último nó da lista aponta de volta para o primeiro nó**.

## Pseudocódigo

### Exibição
```bash
Programa exibe(ptlista)
    pont := ptlista
    Enquanto pont != NULL, faça:
        Escrever pont*.info
        pont := pont*.prox
        Se pont = lista.cab, então: 
            Break
```

### Inserção
```bash
Programa insere(ptlista, novaChave)
    novoNo := CriaNovoNo com novaChave
    pont := ptlista

    Se pont = NULL, então:
        ptlista := novoNo
    Senão:
        novoNo.prox := ptlista
        pont := ptlista
        Enquanto pont.prox != ptlista, faça:
            pont := pont.prox
        Fim Enquanto
        pont.prox := novoNo
```

### Exclusão
```bash
Programa remove(ptlista, chave)
    pont := ptlista

    Se pont = NULL, então:
        Retorne

    Se pont.prox = pont, então:
        ptlista := NULL
    Senão:
        novoNo := ptlista
        Enquanto novoNo.prox != ptlista, faça:
            novoNo := novoNo.prox

        novoNo.prox := pont.prox
        ptlista := ptlista.prox
```