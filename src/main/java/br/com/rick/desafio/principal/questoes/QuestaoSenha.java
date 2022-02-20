package br.com.rick.desafio.principal.questoes;

import br.com.rick.desafio.principal.util.Util;

import java.util.Random;

public class QuestaoSenha {
    private final String especiais = "!@#$%^&*()-+";
    private final int minimo = 6;
    private final Random rd = new Random();

    boolean especial = false;
    boolean maiuscula = false;
    boolean minuscula = false;
    boolean numero = false;


    /**
     * Vericar se a senha possue um caracter numérico
     *
     * @param senha entrar com a senha para verificação
     * @return retorna verdadeiro caso encomtre um carcter numérico e false se não encontrar
     */
    protected boolean verificarSeTemNumero(String senha) {
        for (char c : senha.toCharArray()) {
            if (c >= 48 && c <= 57) return true;
        }
        return false;
    }

    /**
     * Metodo que verifica se tem um caracter especial na senha
     *
     * @param senha entrar com a senha para ser analizada
     * @return retorna verdadeiro caso encomtre um carcter especial e false se não tiver
     */
    protected boolean verificarCaracterEspecias(String senha) {
        for (char c : senha.toCharArray()) {
            for (char cs : especiais.toCharArray()) {
                if (cs == c) return true;
            }
        }
        return false;
    }

    /**
     * Metodo que verifica se tem um caracter minusculos na senha
     *
     * @param senha entrar com a senha para verificação
     * @return retorna verdadeiro caso encomtre um caracter minúsculo e false se não encontrar
     */
    protected boolean verificarSeTemMinuscula(String senha) {
        for (char c : senha.toCharArray()) {
            if (c >= 97 && c <= 122) return true;
        }
        return false;
    }

    /**
     * Metodo que verifica se tem um caracter maiscusculos na senha
     *
     * @param senha entrar com a senha para verificação
     * @return retorna verdadeiro caso encomtre um caracter minúsculo e false se não encontrar
     */
    protected boolean verificarSeTemMaiuscula(String senha) {
        for (char c : senha.toCharArray()) {
            if (c >= 65 && c <= 90) return true;
        }
        return false;
    }

    /**
     * Metodo que retorna um caracter Minúsculo randomico
     *
     * @return retonar caracter asccII
     */
    private char getRadomCaracterMinusculo() {
        return (char) (rd.nextInt((122 - 97) + 1) + 97);
    }

    /**
     * Metodo que retorna um caracter Maisculo randomico
     *
     * @return retorna um caracter asccII
     */
    private char getRadomCaracterMaiusculo() {
        return (char) (rd.nextInt((90 - 65) + 1) + 65);
    }

    /**
     * Metodo de entrada para processamento da senha
     *
     * @param senha entrar com a senha para verificação
     */
    public String validar(String senha) {
        String sugestao = "";
        boolean isForte = false;

        if (senha.length() >= minimo) {
            char[] indexModificados = new char[senha.length()];
            char cs[] = senha.toCharArray();
            especial = verificarCaracterEspecias(senha);
            maiuscula = verificarSeTemMaiuscula(senha);
            minuscula = verificarSeTemMinuscula(senha);
            numero = verificarSeTemNumero(senha);
            if (!maiuscula) {
                for (int i = 0; i < cs.length; i++) {
                    if (Util.isMinuscula(cs[i])) {
                        cs[i] -= 32;
                        indexModificados[i] = 1;
                        sugestao = Util.charsToString(cs);
                        break;
                    } else {
                        sugestao += senha + getRadomCaracterMaiusculo();
                        break;
                    }
                }
            }

            if (!minuscula) {
                for (int i = 0; i < cs.length; i++) {
                    if (Util.isMaisculas(cs[i]) && ((int) indexModificados[i] != 1)) {
                        cs[i] += 32;
                        indexModificados[i] = 1;
                        sugestao = Util.charsToString(cs);
                        break;
                    } else {
                        if (sugestao.isEmpty())
                            sugestao = senha + getRadomCaracterMinusculo();
                        else
                            sugestao += getRadomCaracterMinusculo();
                        break;
                    }
                }
            }

            if (!especial) {
                char[] chars = especiais.toCharArray();
                if (sugestao.isEmpty())
                    sugestao = Util.charsToString(cs) + chars[rd.nextInt(especiais.length())];
                else
                    sugestao = Util.charsToString(cs) + chars[rd.nextInt(especiais.length())];
            }

            if (!numero) {
                if (sugestao.isEmpty())
                    sugestao = senha + rd.nextInt(9);
                else
                    sugestao += "" + rd.nextInt(9);

            }
            isForte = (minuscula && minuscula && especial && numero);
        } else {
            especial = verificarCaracterEspecias(senha);
            maiuscula = verificarSeTemMaiuscula(senha);
            minuscula = verificarSeTemMinuscula(senha);
            numero = verificarSeTemNumero(senha);
            sugestao = senha;
            int falta = minimo - senha.length();
            for (int i = 0; i < falta; i++) {
                if (!especial) {
                    especial = true;
                    sugestao += especiais.toCharArray()[rd.nextInt(especiais.length())];
                    continue;
                }
                if (!maiuscula) {
                    sugestao += getRadomCaracterMaiusculo();
                    maiuscula = true;
                    continue;
                }
                if (!minuscula) {
                    sugestao += getRadomCaracterMinusculo();
                    minuscula = true;
                    continue;
                }
                if (!numero) {
                    sugestao += "" + rd.nextInt(9);
                    numero = true;
                    continue;
                }
            }
            if (sugestao.length() < 6) {
                falta = minimo - sugestao.length();
                for (int j = 0; j < falta; j++) {
                    sugestao += getRadomCaracterMinusculo();
                }
            }
        }

        System.out.println("-------Resultado da verificação");
        System.out.println("Senha   : " + senha);
        if (!isForte) {
            System.out.println("Sugestão: " + sugestao);
            System.out.println("Sua senha é fraca veja a sugestão para uma senha forte.");
        } else {
            System.out.println("Sua Senha é Forte.");
        }
        System.out.println("-------------------------------");
        System.out.println();

        return sugestao;
    }
}
