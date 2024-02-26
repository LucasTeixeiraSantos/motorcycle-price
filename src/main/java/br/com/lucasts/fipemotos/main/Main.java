package br.com.lucasts.fipemotos.main;

import br.com.lucasts.fipemotos.model.ApiDatas;
import br.com.lucasts.fipemotos.model.ApiModels;
import br.com.lucasts.fipemotos.service.ApiConsumer;
import br.com.lucasts.fipemotos.service.DataConverter;

import java.util.Comparator;
import java.util.Scanner;

public class Main {

    Scanner scanner = new Scanner(System.in);
    private ApiConsumer consumer = new ApiConsumer();
    private DataConverter converter = new DataConverter();
    private final String URL_STANDARD = "https://parallelum.com.br/fipe/api/v1/motos/marcas";

    public void showMenu() {
        var menu = """
                Hello!
                
                List of Motorcycles brands:
                
                """;
        System.out.println(menu);
        String url;

        var json = consumer.getData(URL_STANDARD);
        var brands = converter.getList(json, ApiDatas.class);

        brands.stream()
                .sorted(Comparator.comparing(ApiDatas::name))
                .forEach(System.out::println);

        System.out.println("\nInput the brand name: ");
        var brandCode = scanner.nextLine();

        url = URL_STANDARD + "/" + brandCode + "/modelos";
        json = consumer.getData(url);
        var modelList = converter.getData(json, ApiModels.class);

        System.out.println("\nModels of this brand: ");
        modelList.apiModels().stream()
                .sorted(Comparator.comparing(ApiDatas::name))
                .forEach(System.out::println);
    }
}
