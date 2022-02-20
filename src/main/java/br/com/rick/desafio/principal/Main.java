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
