package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculo.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculo.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("The Matrix", 1999);
        meuFilme.setDuracaoEmMinutos(135);
        meuFilme.setIncluidoNoPlano(true);

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(9);
        meuFilme.avalia(8);
        meuFilme.avalia(9);

        //System.out.println(meuFilme.somaDasAvaliacoes);
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println("Média de avaliações do filme: " + meuFilme.pegaMedia());
        System.out.println("Duracao do filme: " + meuFilme.getDuracaoEmMinutos());

        Serie lost = new Serie("Lost", 2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duracao para Maratonar Lost: " + lost.getDuracaoEmMinutos());

        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.setDuracaoEmMinutos(200);
        outroFilme.setIncluidoNoPlano(true);


        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        var filmeDoPaulo = new Filme("Dogville", 2003);
        filmeDoPaulo.setDuracaoEmMinutos(220);
        filmeDoPaulo.avalia(10);

        ArrayList<Titulo> listadeFilmes = new ArrayList<>();
        listadeFilmes.add(filmeDoPaulo);
        listadeFilmes.add(meuFilme);
        listadeFilmes.add(outroFilme);
        listadeFilmes.add(lost);

        System.out.println("Tamanho da lista " + listadeFilmes.size());
        System.out.println("Primeiro filme: "+ listadeFilmes.get(0).getNome());
        System.out.println(listadeFilmes);
        System.out.println("TO STRING do filme: "+ listadeFilmes.get(0).toString());



    }
}
