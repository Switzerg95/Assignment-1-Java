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
		System.out.println("1) Update Acid Pops Order");
		System.out.println("2) Update Pumpkin Pasties Order");
		System.out.println("3) Upate Every Flavour Beans Order");
		System.out.println("4) Show Price List");
		System.out.println("5) Show Current Selected Items to Purchase:");
		System.out.println("6) Pay");
	}
	public static void displaySelectedItems(int acidPops, int pumpkinPasties, int everyBeans) {
		//if (discountPercentage == 0) {
		
		
		//}
	}

	public static void DiscountedShoppingExperience() {

		
		System.out.println("Here is our discounted price list:");
		System.out.println("Acid pop (single):" + acidPopSingle + " knuts");
		System.out.println("Acid pop (bag of 5):" + acidPopNickleBag + " knuts");
		System.out.println("Pumpkin Pasties: " + pumpkinPasties + " knuts");
		System.out.println("Every flavor beans (small bag):" + everyFlavorBeansSmallBag + " knuts");
		System.out.println("Every flavor beans (large bag):" + everyFlavorBeansLargeBag + " knuts");
		
		
		optionMenu();

		
		
	}
	
	public static void RegularShoppingExperience() {
		System.out.println("Unfortunately, you ran out of attempts. You will now see the regular price list.");
		int acidPopSingle = 11;
		int acidPopNickleBag = 50;
		int pumpkinPasties = 100;
		int everyFlavorBeansSmallBag = 50;
		int everyFlavorBeansLargeBag = 70;
		
		
		
		
		System.out.println("Acid pop (single):" + acidPopSingle + " knuts");
		System.out.println("Acid pop (bag of 5):" + acidPopNickleBag + " knuts");
		System.out.println("Pumpkin Pasties: " + pumpkinPasties + " knuts");
		System.out.println("Every flavor beans (small bag):" + everyFlavorBeansSmallBag + " knuts");
		System.out.println("Every flavor beans (large bag):" + everyFlavorBeansLargeBag + " knuts");
		
		
		optionMenu();

		
		
	}
	
	
	public static void main(String[] args) {
		int triesLeft = 2;

		// 	int itemsForSaleArray[]; declaring an array
		 // allocating memory to array
		
	
		Scanner inScan = new Scanner(System.in);
		System.out.println("Welcome to our shop!");
		boolean isTrue = true;
		while (isTrue) {
			int selectedItemsArray[] = new int [3]; 
			String password = "blulu";
			int acidPopsSelected = 0;
			int pumpkinPastiesSelected = 0;
			int everyBeansSelected = 0 ;
			boolean isShopping = false;
			int acidPopsSelectedByUser = 0;
			System.out.println("Is there a customer waiting?");
			System.out.println("Enter yes or no.");
			String userInput = inScan.nextLine().toLowerCase();
			while (userInput.equals("yes") || userInput.equals("y")) {
				while (triesLeft > 0 ) {
				System.out.println("What is the password?");
				String enteredPassword = inScan.nextLine().toLowerCase();
				if (enteredPassword.equals("blulu")) {
					System.out.println("Great, thats right! Welcome valued club member!");
					DiscountedShoppingExperience();
					System.exit(0);
					}
				else  {
					
					triesLeft --;
					if (triesLeft == 0) {
						isShopping = true;
						RegularShoppingExperience();
						int userSelectOption = inScan.nextInt();
						
						while (isShopping) {
							switch (userSelectOption) {
							case 1: userSelectOption = 1;
							System.out.println("How many would you like?");
							acidPopsSelectedByUser = inScan.nextInt();
							acidPopsSelected = acidPopsSelectedByUser + acidPopsSelected;
							System.out.println(acidPopsSelected);
							case 2: userSelectOption = 2;
							break;
							case 3: userSelectOption = 3;
							break;
							case 4: userSelectOption = 4;
							break;
							case 5: userSelectOption = 5;
							break;
							case 6: userSelectOption = 6;
							break;
							
							}
						}
						
						
					}
					System.out.println("Try again, tries left:"+ triesLeft);
				}

				}
			}	
			if (userInput.equals("no")|| userInput.equals("n")){
				System.out.println("exiting program.");
				break;
			}
		}
	}
}
