import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class  ShowDoJavao {
    private static final int PONTUACAO_CORRETA = 200;
    private static final int MAX_PONTUACAO = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pergunta> perguntas = criarPerguntas();
        int pontuacao = 0;

        System.out.println("==============================");
        System.out.println("  🎮 Show do Javão 🎮");
        System.out.println("Vença para ganhar 1 milhão de Riais iranianos");
        System.out.println("==============================");

        for (int i = 0; i < perguntas.size(); i++) {
            Pergunta pergunta = perguntas.get(i);
            System.out.println("Pergunta " + (i + 1) + ": " + pergunta.getTexto());
            System.out.println("A) " + pergunta.getAlternativas().get(0));
            System.out.println("B) " + pergunta.getAlternativas().get(1));
            System.out.println("C) " + pergunta.getAlternativas().get(2));
            System.out.println("D) " + pergunta.getAlternativas().get(3));
            System.out.print("> Sua resposta: ");
            String resposta = scanner.nextLine().toUpperCase();

            if (pergunta.isCorreta(resposta)) {
                pontuacao += PONTUACAO_CORRETA;
                System.out.println("✅ Correto! +" + PONTUACAO_CORRETA + " pontos!");
            } else {
                System.out.println("❌ Errado! A resposta correta era: " + pergunta.getRespostaCorreta());
                break;
            }
        }

        System.out.println("Fim de jogo!");
        System.out.println("Você fez " + pontuacao + " pontos.");
        if (pontuacao >= MAX_PONTUACAO) {
            System.out.println("Você foi bem!");
        } else {
            System.out.println("Tente novamente!");
        }
        scanner.close();
    }

    private static List<Pergunta> criarPerguntas() {
        List<Pergunta> perguntas = new ArrayList<>();
        perguntas.add(new Pergunta("Qual é a linguagem usada para este jogo?", 
            List.of("Python", "Java", "C++", "PHP"), "B"));
        perguntas.add(new Pergunta("Qual palavra-chave usamos para criar uma classe em Java?", 
            List.of("define", "function", "class", "public"), "C"));
            perguntas.add(new Pergunta("Como se fala "Lixo" em espanhol?", 
            List.of("Basura", "Mugre", "Tiradero", "Porquería"), "A"));
            perguntas.add(new Pergunta("O que essa palavra significa em espanhol "Esgotou"  ", 
            List.of("Se acabo", "Acabado", "Consumido", "Agotado"), "D"));
            perguntas.add(new Pergunta("Como se fala em espanhol "Espero que seja você" ? ", 
            List.of("Aspiro que seas tu", "Aspiro que seas tu", "Ojala que seas tu", "Espero que seas tu"), "C"));

        // Adicione mais perguntas conforme necessário
        return perguntas;
    }
}

class Pergunta {
    private String texto;
    private List<String> alternativas;
    private String respostaCorreta;

    public Pergunta(String texto, List<String> alternativas, String respostaCorreta) {
        this.texto = texto;
        this.alternativas = alternativas;
        this.respostaCorreta = respostaCorreta;
    }

    public String getTexto() {
        return texto;
    }

    public List<String> getAlternativas() {
        return alternativas;
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }

    public boolean isCorreta(String resposta) {
        return resposta.equals(respostaCorreta);
    }
}
