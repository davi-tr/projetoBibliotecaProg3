package br.edu.femass.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Emprestimos {
    private LocalDateTime data;


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

                System.out.println("Atrasado em " + tempodeAtraso +" Dias");
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args)
    {
        String dataInicio
                = "01-09-2022";

        String dataFim
                = "30-10-2022";
        
        calculartempo(dataInicio,
                dataFim);
    }
}

