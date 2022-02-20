package br.com.rick.desafio.principal.util;

public class Util {
    /**
     * Vericar se a senha possue um caracter numérico
     *
     * @param senha entrar com a senha para verificação
     * @return retorna verdadeiro caso encomtre um carcter numérico e false se não encontrar
     */
    public static boolean verificarSeTemNumero(String senha) {
        for (char c : senha.toCharArray()) {
            if (c >= 48 && c <= 57) return true;
        }
        return false;
    }

    public static boolean isMinuscula(char c) {
        return (c >= 97 && c <= 122);
    }

    public static boolean isMaisculas(char c) {
        return (c >= 65 && c <= 90);
    }

    public static boolean isNumero(char c) {
        return (c >= 48 && c <= 57);
    }

    public static boolean isEspecial(char c) {
        String especiais = "!@#$%^&*()-+";
        for (char cs : especiais.toCharArray()) {
            if (cs == c) return true;
        }
        return false;
    }

    public static String charsToString(char[] cs) {
        String r = "";
        for (char c : cs) {
            r += c;
        }
        return r;
    }

}
