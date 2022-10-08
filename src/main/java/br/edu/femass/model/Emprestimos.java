package br.edu.femass.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Emprestimos {
    @JsonFormat(pattern = "yyyy-MM-dd")
    protected LocalDateTime data;
    @JsonFormat(pattern = "yyyy-MM-dd")
    protected LocalDateTime devolucao;
    @JsonFormat(pattern = "yyyy-MM-dd")
    protected LocalDateTime prev;

    public Emprestimos(){
    }

    List<Leitor> listaLeito = new ArrayList();

    public static void calculartempo(String dataInicio, String dataFim){
        SimpleDateFormat sdf
                = new SimpleDateFormat(
                "dd-MM-yyyy");

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

                System.out.println("Atrasado em " + tempodeAtraso + " Dias");
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

    }


    public Emprestimos(List<Leitor> leitores){
        this.data=LocalDateTime.now();
        this.devolucao=LocalDateTime.now();
        listaLeito.addAll(leitores);
        for (Leitor l : leitores){
            if (l.getClass()== Aluno.class){
                System.out.println("Teste");
            }
        }
        //this.prev=LocalDateTime.now().plusDays(prazoMaximoDevolucao);
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


