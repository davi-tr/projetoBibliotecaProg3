package br.edu.femass.model;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoEmprestimo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Emprestimos {


    protected LocalDateTime data;
    protected LocalDateTime devolucao;
    protected String mensagemDev;
    protected LocalDateTime prev;
    public String mensagem;
    @JsonIgnore
    public String nome;
    @JsonIgnore
    public String nomeExemplar;

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

    public Emprestimos(String exemplar, List<Leitor> alunos)  {
        listaLeito.addAll(alunos);
        try{
            for(Leitor l : alunos){
                this.prev=LocalDateTime.now().plusDays(l.getPrazoMaximoDevolucao());
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        listaExemplar.addAll(Collections.singleton(exemplar));
        this.data=LocalDateTime.now();
        this.mensagemDev="Ainda não devolvido";
    }

    public String getNome() {
        return nome;
    }

    public String getNomeExemplar() {
        return nomeExemplar;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Emprestimos(List<Leitor> alunos, String data)  {
        listaLeito.addAll(alunos);
        this.data=LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        this.devolucao = LocalDateTime.parse(data,formatter);
        this.mensagemDev="Devolvido";

    }
    public String getMensagemDev() {
        return mensagemDev;
    }

    public List<Leitor> getListaLeito() {
        return listaLeito;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        try {
            for (Leitor l : listaLeito){
                nome = l.getNome();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            for (Object ex : listaExemplar){
                nomeExemplar = String.valueOf(ex);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return nome+" "+nomeExemplar;
    }

    //    public static void main(String[] args) {
//        String str = "2016-03-04 11:30";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        Emprestimos emprestimos =  new Emprestimos(LocalDateTime.parse(str,formatter));
//    }
}


