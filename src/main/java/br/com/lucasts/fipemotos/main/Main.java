package br.com.lucasts.fipemotos.main;

import br.com.lucasts.fipemotos.service.ApiConsumer;

import java.util.Scanner;

public class Main {

    Scanner scanner = new Scanner(System.in);
    private ApiConsumer consumer = new ApiConsumer();

    private final String URL_STANDARD = "https://parallelum.com.br/fipe/api/v1/motos/marcas";

    public void showMenu() {
        var menu = """
                Hello!
                
                Type the name of the motorcycle brand.
                
                """;
        System.out.println(menu);
//        var option = scanner.nextLine();
        String url;

        var json = consumer.getData(URL_STANDARD);
        System.out.println(json);

    }
}
