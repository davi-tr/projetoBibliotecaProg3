package br.edu.femass.model;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoEmprestimo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Emprestimos {


    protected LocalDate data;
    protected LocalDate devolucao;
    protected String mensagemDev;
    protected LocalDate prev;
    public String mensagem;
    @JsonIgnore
    public String nome;
    @JsonIgnore
    public String nomeExemplar;


    public Long codigo;

    public Emprestimos(){

    }
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    List<Leitor> listaLeito = new ArrayList();
    List<Exemplar> listaExemplar = new ArrayList<>();
    List<Emprestimos> listaEmprestimo = new ArrayList<>();


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

    public List<Exemplar> getListaExemplar() {
        return listaExemplar;
    }

    public Emprestimos(List<Exemplar> exemplar, List<Leitor> alunos)  {
        listaLeito.addAll(alunos);
        try{
            for(Leitor l : alunos){
                this.prev=LocalDate.now().plusDays(l.getPrazoMaximoDevolucao());
                setCodigo(l.getCodigo());
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        listaExemplar.addAll(exemplar);
        this.data=LocalDate.now();
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

    public Emprestimos(List<Emprestimos> emprestimos,String data)  {
        listaEmprestimo.addAll(emprestimos);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.devolucao = LocalDate.parse(data, formatter);
        try{
            for(Emprestimos em : listaEmprestimo){
                setCodigo(em.getCodigo());
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

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

    public LocalDate getPrev() {
        return prev;
    }

    public LocalDate getDevolucao() {
        return devolucao;
    }

    public LocalDate getData() {
        return data;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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
            for (Exemplar ex : listaExemplar){
                nomeExemplar = ex.getNome();
            }
            } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return nomeExemplar + " Emprestado à  " + "|"+nome+"|" + "|" + codigo;
    }

    public void setDevolucao(LocalDate devolucao) {
        this.devolucao = devolucao;
        this.mensagemDev="Devolvido";
    }

//    public static void main(String[] args) {
//        Emprestimos emprestimos = new Emprestimos();
//        emprestimos.setDevolução(LocalDateTime.of(2022,12,31,12,30));
//        System.out.println(emprestimos.getDevolucao());
//    }

    //    public static void main(String[] args) {
//        String str = "2016-03-04 11:30";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        Emprestimos emprestimos =  new Emprestimos(LocalDateTime.parse(str,formatter));
//    }
}


