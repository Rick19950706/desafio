package br.com.rick.test;

import br.com.rick.desafio.principal.questoes.QuestaoAnagrama;
import br.com.rick.desafio.principal.questoes.QuestaoEscada;
import br.com.rick.desafio.principal.questoes.QuestaoSenha;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExercicioTest {

    @Test
    public void testAnagrama() {
        int qtda = new QuestaoAnagrama().find("ifailuhkqq");
        assertEquals(qtda, 3);
    }

    @Test
    public void testSenha() {
        String sugestao = new QuestaoSenha().validar("Ya3");
        assertEquals(sugestao.length(), 6);
    }

    @Test
    public void testEscada() {
        String[] escada = new QuestaoEscada().build(6);
        assertEquals(escada.length, 6);
        assertEquals(escada[0].trim(), "*");
        assertEquals(escada[1].trim(), "**");
        assertEquals(escada[2].trim(), "***");
        assertEquals(escada[3].trim(), "****");
        assertEquals(escada[4].trim(), "*****");
        assertEquals(escada[5].trim(), "******");
    }
}
