package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> prods = new ArrayList<>();
		
		
		System.out.print("Enter number of Products: ");
		int n = sc.nextInt();
		for(int i = 1; i< n+1; i ++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported?(c/u/i) ");
			sc.nextLine();
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			
			if (ch == 'i') {
				System.out.print("Customs fee: ");
				Double cf = sc.nextDouble();
				prods.add(new ImportedProduct(name, price, cf));
			}
			
			else if (ch == 'u') {
				System.out.print("Manufacure date(DD/MM/YYYY) ");
				Date date = sdf.parse(sc.next());
				prods.add(new UsedProduct(name, price, date));
			}
			
			else {
				prods.add(new Product(name, price));
			}
			
		}
		
		System.out.println();
		System.out.println("PRICE TAGS");
		
		for(Product pd : prods) {
			System.out.println(pd.priceTag());
		}
		
		sc.close();		
	}

}
