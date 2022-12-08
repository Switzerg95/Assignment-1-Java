package homework;

import java.util.*;

public class Stuff {
	
	public static void displayMenu() {
		System.out.println("We prefer exact change (but will make change if necessary)!");
		System.out.println("No more than 50 galleons are kept in the cart (funds are transported to Gringotts on a daily basis)");
		System.out.println("Recall our currency options: 29 Knuts == 1 Sickle 17 Sickles == 1 Galleon == 493 Knuts");
	}
	
	public static void optionMenu() {
		System.out.println("Please choose an option:");
		System.out.println("w");
	}
	public static void displaySelectedItems(int acidPops, int pumpkinPasties, int everyBeans) {
		//if (discountPercentage == 0) {
		
		
		//}
	}

	public static void displayDiscountedMenu() {
		boolean isTrue = true;
		while(isTrue) {

		System.out.println("Great, thats right! Welcome valued club member!");

		String pumpkinPasties = "Pumpkin Pasties: ";
		String acidPops = "Acid Pops: ";
		String everyBeansSmall = "Every Flavour Beans (small bag): ";
		String everyBeansLarge = "Every Flavour Beans (large bag): ";
		
		
		String itemsForSaleArray[] = new String [4];
				
		itemsForSaleArray[0] = acidPops;
		itemsForSaleArray[1] = pumpkinPasties;
		itemsForSaleArray[2] = everyBeansSmall;
		itemsForSaleArray[3] = everyBeansLarge;
		
		int itemPriceArray[] = new int [4];
		
		itemPriceArray[0] = 11;
		itemPriceArray[1] = 100;
		itemPriceArray[2] = 50;
		itemPriceArray[3] = 70;
		
		
		System.out.println("Here is our price List:");
		System.out.println(acidPops + itemPriceArray[0] );
		System.out.println(pumpkinPasties + itemPriceArray[1]);
		System.out.println(everyBeansSmall + itemPriceArray[2] );
		System.out.println(everyBeansLarge + itemPriceArray[3]);
		
		optionMenu();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		
		int discountPercentage = 0;
		int triesLeft = 2;
		int selectedItemCost = 0;
		int discountedItemcost = 0;
		
		
		// 	int itemsForSaleArray[]; declaring an array
		; // allocating memory to array

		int selectedItemsArray[] = new int [3]; 
		
		int acidPopsSelected = 0;
		int pumpkinPastiesSelected = 0;
		int everyBeansSelected = 0 ;
		
		
//System.out.print("Acid Pops, Pumpkin Pasties, EveryBeans" + java.util.Arrays.toString(itemsForSaleArray)+"\n");
		Scanner inScan = new Scanner(System.in);
		System.out.println("Welcome to our shop!");
		boolean isTrue = true;
		boolean rightPassword = false;
		while (isTrue) {
			System.out.println("Is there a customer waiting?");
			System.out.println("Enter yes or no.");
			String userInput = inScan.nextLine().toLowerCase();
			if (userInput.equals("yes") || userInput.equals("y")) {
				System.out.println("What is the password?");
				String enteredPassword = inScan.nextLine().toLowerCase();
				if (enteredPassword.equals("blulu")) {
					discountPercentage = 10;
					displayDiscountedMenu();
					}
				
				while (triesLeft != 0) {
					triesLeft --;
					System.out.println("Try again, tries left:"+ triesLeft);
					enteredPassword = inScan.nextLine().toLowerCase();
					
					if(triesLeft <= 0) {
						displayMenu();
						System.out.println(discountPercentage);
					}
					
						

					}
					
					
					
				}
				
				
			if (userInput.equals("no")|| userInput.equals("n")){
				System.out.println("exiting program.");
				break;
			}
			}
			
			
		}
		
		
	 //converts whatever input to lowercase		
		
//		while (userInput.equals("yes")||userInput.equals("y")) {
//			System.out.println("What is the password?"); // ask for pw
//			userInput = inScan.nextLine(); //ask for a input from user
//			if (userInput.equals(discount_password)){
//				discountPercentage = 1;
//				//displayPrices();
//			}
//
//			else {
//				triesLeft --;
//				System.out.println("Try again, tries left:"+ triesLeft);
//				userInput = inScan.nextLine();
//				if(triesLeft == 0) {
//					System.out.println("No more tries left, here is the menu at full price.");
//				}
//			}
//		} 

		
		
	}
