## Lista Duplamente Encadeada

O que define uma lista duplamente encadeada é o fato de que 
**cada nó possui dois ponteiros: um para o próximo nó e um para o nó anterior**.

## Pseudocódigo

### Busca
```bash
Programa busca(ptlista, chave)
    pont := ptlista
    Enquanto pont != NULL, faça:
        Se pont.chave = chave, então:
            Retorna pont
        pont := pont.prox
        Se pont = ptlista, então:
            Pare
    Retorna Null
```

### Exibição
```bash
Programa exibe(ptlista)
    pont := ptlista
    Enquanto pont != NULL, faça:
        Escrever pont*.info
        pont := pont*.prox
```

### Inserção
```bash
Programa insere(ptlista, novaChave)
    novoNo := CriaNovoNo com novaChave
    pont := ptlista

    Se pont = NULL, então:
        novoNo.ant := novoNo
    Senão:
        pont.ant := novoNo
    pont := novoNo
```

### Exclusão
```bash
Programa remove(ptlista, chave)
    pont := ptlista.buca com chave

    Se pont = NULL, então:
        Retorne

    Se pont = ptlista.cabeca, então:
        ptlista.cabeca := pont.prox

    Se pont.ant != NULL, então:
        pont.ant.prox := pont.prox

    Se pont.prox != NULL, então:
        pont.prox.ant := pont.ant
```

