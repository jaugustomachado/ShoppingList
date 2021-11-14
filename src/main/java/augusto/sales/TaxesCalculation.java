package augusto.sales;

import augusto.sales.ItemsDatabaseManagement.repository.ItemsRepository;

import java.util.ArrayList;
import java.util.Scanner;


public class TaxesCalculation {

    private final ItemsRepository itemsRepository;

    public TaxesCalculation(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public void taxCalc(){

        double basicSaleTax = 0.10;
        double importDuty = 0.05;
        double salesTaxes=0.00;
        double total=0.00;
        double updatedPrice;

        ArrayList<String> purchase = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();
        ArrayList<Integer> quantity = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("\nPlease inform the purchase items according to the model: \n"+
                "\n1 book at 12.49\n \nTo close the list press enter. \n");

        try {

            while (true) {

                String item = sc.nextLine();

                if (item.equals("")) {

                    break;

                } else {

                    quantity.add(Integer.valueOf(item.split(" ")[0]));
                    prices.add(Double.valueOf(item.split(" at ")[1]));

                    String product = item.split(" at ")[0];
                    product = product.substring(product.indexOf(" ") + 1);
                    purchase.add(product);
                }
            }
        } catch (Exception e) {
            System.out.println("\nlast purchase item entered incorrectly, " +
                    "please inform the item according to the requested model\n");
        }

        for(int i=0 ; i<purchase.size() ; i++){

            try{
                if(itemsRepository.findByPurchase(purchase.get(i)).getClassification().equals("food")
                        || itemsRepository.findByPurchase(purchase.get(i)).getClassification().equals("book")
                        || itemsRepository.findByPurchase(purchase.get(i)).getClassification().equals("medical products")){

                    if (purchase.get(i).toLowerCase().contains("imported")) {

                        salesTaxes = salesTaxes + (Math.ceil(20.0 *
                                prices.get(i) * (importDuty)) / 20.0) * quantity.get(i);

                        updatedPrice = ((Math.ceil(20.0 *
                                prices.get(i) * (importDuty)) / 20.0) + prices.get(i)) * quantity.get(i);

                        prices.set(i, updatedPrice);

                    } else {

                        updatedPrice = prices.get(i) * quantity.get(i);
                        prices.set(i, updatedPrice);
                    }

                } else {

                    if(purchase.get(i).toLowerCase().contains("imported")){

                        salesTaxes=salesTaxes+ (Math.ceil(20.0 *
                                prices.get(i)*(basicSaleTax+importDuty)) / 20.0)*quantity.get(i);

                        updatedPrice = ((Math.ceil(20.0 *
                                prices.get(i)*(basicSaleTax+importDuty)) / 20.0)+ prices.get(i))*quantity.get(i);

                        prices.set(i, updatedPrice);

                    } else {

                        salesTaxes=salesTaxes+ (Math.ceil(20.0 *
                                prices.get(i)*(basicSaleTax)) / 20.0)*quantity.get(i);

                        updatedPrice = ((Math.ceil(20.0 *
                                prices.get(i)*(basicSaleTax)) / 20.0)+ prices.get(i))*quantity.get(i);

                        prices.set(i, updatedPrice);
                    }
                }
            }catch (NullPointerException e){

                if(purchase.get(i).toLowerCase().contains("imported")){

                    salesTaxes=salesTaxes+ (Math.ceil(20.0 *
                            prices.get(i)*(basicSaleTax+importDuty)) / 20.0)*quantity.get(i);

                    updatedPrice = ((Math.ceil(20.0 *
                            prices.get(i)*(basicSaleTax+importDuty)) / 20.0)+ prices.get(i))*quantity.get(i);

                    prices.set(i, updatedPrice);

                } else {

                    salesTaxes=salesTaxes+ (Math.ceil(20.0 *
                            prices.get(i)*(basicSaleTax)) / 20.0)*quantity.get(i);

                    updatedPrice = ((Math.ceil(20.0 *
                            prices.get(i)*(basicSaleTax)) / 20.0)+ prices.get(i))*quantity.get(i);

                    prices.set(i, updatedPrice);
                }
            }
        }

        for(int i=0 ; i<purchase.size() ; i++){

            total=total+prices.get(i);

            System.out.printf(quantity.get(i)+" "+purchase.get(i)+": "+"%.2f",prices.get(i));
            System.out.println();
        }

        System.out.printf("Sales Taxes: %.2f \n",salesTaxes);
        System.out.printf("Total: %.2f \n\n",total);

        sc.close();
    }
}
