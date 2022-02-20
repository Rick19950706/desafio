package br.com.rick.desafio.principal.questoes;

public class QuestaoEscada {

    /**
     * Metodo que criar e retorna um degrau em questão conforme posição na escada exemplo: degra 1,2,3 ...
     * @param posicao posição do degrau
     * @param max quantidade de degraus que a escada possue
     * @return retonar um degrau com base na posição na escada
     */
    private String getDegrau(int posicao, int max) {
        String degrua = "";
        for (int i = 0; i < (max - posicao); i++) {
            degrua += " ";
        }

        if (posicao == 1) {
            degrua += "*";
        } else {
            for (int j = (posicao - 1); j >= 0; j--) {
                degrua += "*";
            }
        }
        return degrua;
    }

    /**
     * Metodo que criar os desgraus da escada
     * @param nd numero do degrua que sera criado
     * @param max quandodade de degraus que a escada possue
     * @return
     */
    private String criarDegarus(int nd, int max) {
        if (max == 0) max = 1;
        return getDegrau(nd, max);
    }

    /**
     * Metodo de entrada para construção da escada dinamica e saida para console
     * @param tamannho informe a quantidade de degruas que a escada possue
     * @return
     */
    public String build(int tamannho) {
        String escada[] = new String[tamannho];
        for (int d = 1; d < (tamannho + 1); d++) {
            escada[d - 1] = criarDegarus(d, tamannho);
        }
        System.out.println("-----------Construção da escada");
        for (String s : escada) {
            System.out.println(s);
        }
        System.out.println("-------------------------------");
        System.out.println();

        return "";
    }
}
