import java.util.HashMap;
import java.util.Map;


class ArvoreMorse {
    private No raiz = new No("");
    private Map<String, String> mapaMorseParaLetra = new HashMap<>();

    public ArvoreMorse() {
        inicializarMapaMorse();
        construirArvoreMorse(); 
    }

    private void inicializarMapaMorse() {
        mapaMorseParaLetra.put(".-", "A");
        mapaMorseParaLetra.put("-...", "B");
        mapaMorseParaLetra.put("-.-.", "C");
        mapaMorseParaLetra.put("-..", "D");
        mapaMorseParaLetra.put(".", "E");
        mapaMorseParaLetra.put("..-.", "F");
        mapaMorseParaLetra.put("--.", "G");
        mapaMorseParaLetra.put("....", "H");
        mapaMorseParaLetra.put("..", "I");
        mapaMorseParaLetra.put(".---", "J");
        mapaMorseParaLetra.put("-.-", "K");
        mapaMorseParaLetra.put(".-..", "L");
        mapaMorseParaLetra.put("--", "M");
        mapaMorseParaLetra.put("-.", "N");
        mapaMorseParaLetra.put("---", "O");
        mapaMorseParaLetra.put(".--.", "P");
        mapaMorseParaLetra.put("--.-", "Q");
        mapaMorseParaLetra.put(".-.", "R");
        mapaMorseParaLetra.put("...", "S");
        mapaMorseParaLetra.put("-", "T");
        mapaMorseParaLetra.put("..-", "U");
        mapaMorseParaLetra.put("...-", "V");
        mapaMorseParaLetra.put(".--", "W");
        mapaMorseParaLetra.put("-..-", "X");
        mapaMorseParaLetra.put("-.--", "Y");
        mapaMorseParaLetra.put("--..", "Z");
    }

    public void construirArvoreMorse() {
        for (Map.Entry<String, String> entrada : mapaMorseParaLetra.entrySet()) {
            inserirCodigoMorse(entrada.getKey(), entrada.getValue());
        }
    }

    private void inserirCodigoMorse(String codigoMorse, String letra) {
        No noAtual = raiz;
        char[] caracteresMorse = codigoMorse.toCharArray();

        for (char caractere : caracteresMorse) {
            if (caractere == '.') {
                if (noAtual.esquerda == null) {
                    noAtual.esquerda = new No("");
                }
                noAtual = noAtual.esquerda;
            } else if (caractere == '-') {
                if (noAtual.direita == null) {
                    noAtual.direita = new No("");
                }
                noAtual = noAtual.direita;
            }
        }
        noAtual.valor = letra;
    }

    public String decodificar(String codigoMorse) {
        String[] codigosMorse = codigoMorse.split(" ");
        StringBuilder mensagemDecodificada = new StringBuilder();

        for (String codigo : codigosMorse) {
            No noAtual = raiz;
            char[] caracteresMorse = codigo.toCharArray();

            for (char caractere : caracteresMorse) {

                if (caractere == '.') {
                    noAtual = noAtual.esquerda;
                } else if (caractere == '-') {
                    noAtual = noAtual.direita;
                }

                if (noAtual == null) {
                    break;
                }
            }

            mensagemDecodificada.append((noAtual != null && !noAtual.valor.isEmpty()) ? noAtual.valor : "?");
        }

        return mensagemDecodificada.toString();
    }

    public No getRaiz() {
        return raiz;
    }

}
