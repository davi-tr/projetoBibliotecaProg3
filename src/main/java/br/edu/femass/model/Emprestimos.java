package br.edu.femass.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Emprestimos {
    protected LocalDateTime data;
    protected String devolucao;
    protected LocalDateTime prev;

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

    public Emprestimos(){

    }


    public Emprestimos(LocalDateTime data){
        SimpleDateFormat volta
                = new SimpleDateFormat(
                "dd-MM-yyyy");
        this.data=data;
        this.devolucao=data.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.prev=LocalDateTime.now().plusDays(15);
    }

    public String getPrev() {
        return prev.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public String getDevolucao() {
        return devolucao;
    }

    public String getData() {
        return data.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    @Override
    public String toString() {
        return "Emprestimos{" +
                "data=" + data +
                '}';
    }

    public static void main(String[] args)
    {
        String dataInicio
                = "01-08-2022";

        Emprestimos emprestimos = new Emprestimos(LocalDateTime.now());
        String dataFim = emprestimos.getData();
        System.out.println(emprestimos.getData());
        System.out.println(emprestimos.getPrev());
        System.out.println(emprestimos.getDevolucao());
        calculartempo(dataInicio,
                dataFim);
    }
}


