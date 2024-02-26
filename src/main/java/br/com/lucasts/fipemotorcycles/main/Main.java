package br.com.lucasts.fipemotorcycles.main;

import br.com.lucasts.fipemotorcycles.model.ApiDatas;
import br.com.lucasts.fipemotorcycles.model.ApiModels;
import br.com.lucasts.fipemotorcycles.model.ApiVehicle;
import br.com.lucasts.fipemotorcycles.service.ApiConsumer;
import br.com.lucasts.fipemotorcycles.service.DataConverter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    Scanner scanner = new Scanner(System.in);
    private ApiConsumer consumer = new ApiConsumer();
    private DataConverter converter = new DataConverter();
    private final String URL_STANDARD = "https://parallelum.com.br/fipe/api/v1/motos/marcas";

    public void showMenu() {
        var menu = """
                List of Motorcycles brands:
                
                """;
        System.out.println(menu);
        String url;

        var json = consumer.getData(URL_STANDARD);
        var brands = converter.getList(json, ApiDatas.class);

        brands.stream()
                .sorted(Comparator.comparing(ApiDatas::name))
                .forEach(System.out::println);

        System.out.println("\nInput the brand code: ");
        var inputBrandCode = scanner.nextLine();

        url = URL_STANDARD + "/" + inputBrandCode + "/modelos";
        json = consumer.getData(url);
        var modelList = converter.getData(json, ApiModels.class);

        System.out.println("\nModels of this brand: ");
        modelList.apiModels().stream()
                .sorted(Comparator.comparing(ApiDatas::name))
                .forEach(System.out::println);

        System.out.println("Search the model of the vehicle: ");
        var inputVehicleName = scanner.nextLine();
        List<ApiDatas> filteredModels = modelList.apiModels().stream()
                .filter(m -> m.name().toLowerCase().contains(inputVehicleName.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("\nFiltered models: ");
        filteredModels.forEach(System.out::println);

        System.out.println("\nType the code of the model: ");
        var inputModelCode = scanner.nextLine();

        url = url + "/" + inputModelCode + "/anos";
        json = consumer.getData(url);

        List<ApiDatas> years = converter.getList(json, ApiDatas.class);
        List<ApiVehicle> vehicles = new ArrayList<>();

        for (ApiDatas year : years) {
            var urlYear = url + "/" + year.code();
            json = consumer.getData(urlYear);
            ApiVehicle vehicle = converter.getData(json, ApiVehicle.class);
            vehicles.add(vehicle);
        }

        System.out.println("\nAll filtered vehicles: ");
        vehicles.forEach(System.out::println);
    }
}
