package br.edu.femass.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Emprestimos {


    protected LocalDateTime data;
    protected LocalDateTime devolucao;
    protected String mensagemDev;
    protected LocalDateTime prev;
    public String mensagem;

    public Emprestimos(){

    }
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    List<Leitor> listaLeito = new ArrayList();
    List<Object> listaExemplar = new ArrayList<>();


    public void calculartempo(String dataInicio, String dataFim){
        SimpleDateFormat sdf
                = new SimpleDateFormat(
                "dd/MM/yyyy");

        try {

            Date d1 = sdf.parse(dataInicio);
            Date d2 = sdf.parse(dataFim);

            long difference_In_Time
                    = d2.getTime() - d1.getTime();

            long difference_In_Days
                    = TimeUnit
                    .MILLISECONDS
                    .toDays(difference_In_Time)
                    % 365;

            System.out.print(
                    "A diferença"
                            + " Entre as duas datas é de ");

            // Exibe o resultado
            System.out.println(
                            + difference_In_Days
                            + " Dias");
            //Verifica o tempo maximo
            if (difference_In_Days > 15){
                long tempodeAtraso
                        = difference_In_Days - 15;
                mensagem = "Atrasado em " + tempodeAtraso + " Dias";
            } else mensagem = "Não está atrasado";
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public List<Object> getListaExemplar() {
        return listaExemplar;
    }

    public Emprestimos(Object exemplar, List<Leitor> alunos)  {
        listaLeito.addAll(alunos);
        listaExemplar.addAll(Collections.singleton(exemplar));
        this.data=LocalDateTime.now();
        this.mensagemDev="Ainda não devolvido";
        this.prev=LocalDateTime.now().plusDays(15);
    }
    public String getMensagem() {
        return mensagem;
    }

    public Emprestimos(List<Leitor> alunos, LocalDateTime data)  {
        listaLeito.addAll(alunos);
        this.data=LocalDateTime.now();
        this.mensagemDev="Devolvido";
        this.devolucao = data;
        this.prev=LocalDateTime.now().plusDays(15);
    }
    public String getMensagemDev() {
        return mensagemDev;
    }

    public List<Leitor> getListaLeito() {
        return listaLeito;
    }


    public LocalDateTime getPrev() {
        return prev;
    }

    public LocalDateTime getDevolucao() {
        return devolucao;
    }

    public LocalDateTime getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Emprestimos{" +
                "data=" + data +
                '}';
    }

}


