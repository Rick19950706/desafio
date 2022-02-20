![topo2](https://user-images.githubusercontent.com/98782996/154866070-dfcbe39b-009b-499a-9fe4-23d1b641b92b.png)

#### Segue abaixo instruções para execução dos questionariois, no pacote <strong style="color:gray">br.com.rick.desafio.principal</strong> tem uma class Main com o metodo static main, nesse metodo tem os exemplo de execução da questão



>Questão 01 Escadas:
>

```
new QuestaoEscada().build(6);

Saida:
     *
    **
   ***
  ****
 *****
******
```

>Questão 02 Senha:
>

```
new QuestaoSenha().validar("Ya3");

Saida:
Senha   : Ya3
Sugestão: Ya3#qb
Sua senha é fraca veja a sugestão para uma senha forte.
```

>Questão 03 Anagrama:
>

```
new QuestaoAnagrama().find("ifailuhkqq");

Saida:
Anagramas : [i, i, q, q, ifa, fai]
Quantidade: 3
```

>Metodo da Class br.com.rick.desafio.principal.Main:

```
package br.com.rick.desafio.principal;

import br.com.rick.desafio.principal.questoes.QuestaoAnagrama;
import br.com.rick.desafio.principal.questoes.QuestaoEscada;
import br.com.rick.desafio.principal.questoes.QuestaoSenha;

public class Main {
    public static void main(String[] args) {
        new QuestaoSenha().validar("Ya3");
        new QuestaoEscada().build(6);
        new QuestaoAnagrama().find("ifailuhkqq");
    }
}

Saidas:
-------Resultado da verificação
Senha   : Ya3
Sugestão: Ya3&kx
Sua senha é fraca veja a sugestão para uma senha forte.
-------------------------------

-----------Construção da escada
     *
    **
   ***
  ****
 *****
******
-------------------------------

----Procurando por de Anagramas
Anagramas : [i, i, q, q, ifa, fai]
Quantidade: 3
-------------------------------

```


> nome: Ricardo Henrique Pereira da Silva 
> 
> Email: ricardohenriquesilva95@gmail.com

![rodape2](https://user-images.githubusercontent.com/98782996/154866099-a8ebc262-dc03-42e2-961c-ff95c4ae6fa1.png)

