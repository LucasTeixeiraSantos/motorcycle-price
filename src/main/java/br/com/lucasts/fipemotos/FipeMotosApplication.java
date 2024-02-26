package br.com.lucasts.fipemotos;

import br.com.lucasts.fipemotos.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipeMotosApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FipeMotosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Main main = new Main();
        main.showMenu();
    }
}
