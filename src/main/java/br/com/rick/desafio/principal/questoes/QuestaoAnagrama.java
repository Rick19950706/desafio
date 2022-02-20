package br.com.rick.desafio.principal.questoes;

import java.util.ArrayList;
import java.util.List;

public class QuestaoAnagrama {

    /**
     * Metodo que soma os caracteres de uma string retornado um número inteiro
     *
     * @param s
     * @return int
     */
    private int somarPalavra(String s) {
        int soma = 0;
        for (char c : s.toCharArray()) {
            soma = soma + c;
        }
        return soma;
    }

    /**
     * Metodo que procura as palavras que são Anagramas e coloca dentro de uma lista, receber com entrada uma listar de palavras
     *
     * @param lista lista de palavras separadas
     * @return List<String> retona uma lista de anagramas
     */
    private List<String> encontrarAnagramas(List<String> lista) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            int s1 = somarPalavra(lista.get(i));
            int s2 = 0;
            for (int j = 0; j < lista.size(); j++) {
                if (j != i) {
                    s2 = somarPalavra(lista.get(j));
                    if (s1 == s2) {
                        result.add(lista.get(i));
                    }
                }
            }
        }
        return result;
    }

    /**
     * Metodo que agrupa as palavras conforme o passo muda, o passo determinas quantos caracteres tera a lista para se processada logo em sequência
     *
     * @param step qual passo esta a seleção
     * @param s    entrada da string que será processada
     * @return retonas a lista de string separdas conforme o passo
     */
    private List<String> criarPalavras(int step, String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int p = i + step;
            if (p <= s.length()) {
                String sub = s.substring(i, p);
                if (sub.length() > 0) result.add(sub);
            }
        }
        return result;
    }

    /**
     * Metodo de entrada que excuta o ciclo completo, entra com uma String diferente de null e vasia e retorna quantodade de pares
     *
     * @param s entrada da string que sera analizada
     * @return int retona quantidade de pares encontras
     */
    public int find(String s) {
        if (s != null && !s.isEmpty()) {
            List<List<String>> palavras = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                palavras.add(criarPalavras((i + 1), s));
            }

            List<String> anagramas = new ArrayList<>();
            for (List<String> l : palavras) {
                anagramas.addAll(encontrarAnagramas(l));
            }

            System.out.println("----Procurando por de Anagramas");
            System.out.println("Anagramas : " + anagramas.toString());
            if (anagramas.size() > 1) {
                System.out.println("Quantidade: " + anagramas.size() / 2);
                System.out.println("-------------------------------");
                return anagramas.size() / 2;
            } else {
                System.out.println("Quantidade: " + anagramas.size());
                System.out.println("-------------------------------");
                return anagramas.size();
            }
        }
        return 0;
    }
}

