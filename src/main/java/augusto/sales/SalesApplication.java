package augusto.sales;


import augusto.sales.ItemsDatabaseManagement.repository.ItemsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class SalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesApplication.class);
	}

	@Bean
	public CommandLineRunner sales(ItemsRepository itemsRepository) {
		return (args) -> {
			TaxesCalculation tax = new TaxesCalculation(itemsRepository);
			tax.taxCalc();
		};
	}
}