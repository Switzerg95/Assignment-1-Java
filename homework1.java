import java.util.*;

//Java CS 401
//Professor Sosnowski's Class
// Galen Switzer
// Assignment 1 2-23-23


public class RealHomework1 {
	
	// check to see if greeted, and based on that, display member greeting, and then determine which price list is displayed based on member flag.
	public static void showPriceList (boolean member,int [] memberPrices, int []regularPrices, String [] itemsForsale,boolean greeted) {
		
		if (!greeted && member == true) {
			System.out.println("Welcome Member!!! \nEnjoy our items at a discounted price!\nAn additional 10% discount is applied to orders of 10 Sickles or more.");
		}
		// member prices.
		if (member) {
			System.out.println("Here is the price list for members.");
			// iterate thru array of member price + items
			for (int i = 0 ;  i < 5  ; i++) 
			{
				System.out.println(itemsForsale [i] + " " + memberPrices[i] + " knuts.");	
			}
				}
		// loop for non member non discounted.
		else{
			System.out.println("Here is our regular price list:");
			for (int i = 0; i < 5; i++) 
			{	
			System.out.println(itemsForsale[i] + " " + regularPrices[i] + " knuts.");	
			}
	}
	}
	public static void showOptions () {
		String [] Options = {"1)Update Acid Pops Order", "2)Update Pumpkin Pasties Order","3)Update Every Flavour Beans Order","4)Show Price List","5)Show Current Subtotal", "6)Check Out"};
		System.out.println("Please choose an option:");
		for (int i = 0; i < 6; i++) {
			System.out.println(Options[i]);
		}
	}

public static void main(String[] args){
	boolean main = true;
	while (main){
	// creates scanner object to take in input stream.
    Scanner inputStream = new Scanner(System.in);
	//allocating memory to an array
	//int memberPrices [] = new int [3];
	String Password = "test";
	// items are ordered -- loook at the string array to figure it out each item index / price
	
	int [] selectedItem = {0,0,0,0,0};
    int [] memberPrices = {11,50,100,50,58};
	int [] regularPrices = {12,58,116,50,70};
	String [] itemsForsale = {"Acid Pop",
							"Acid Pops (bag of 5)",
							"Pumpkin Pasties",
							"Every Flavour Beans (Small Bag)",
							"Every Flavour beans (Large Bag)"};
	
    int triesleft = 2;	
    int change = 0;
    int kChange = 0;
    int sChange = 0;
    int gChange = 0;
    boolean browsing = false;
	boolean customer = false;
	boolean member = false;
	boolean greeted =false;
	boolean checkOut = false;
	int totalPops = 0;
	int remainder = 0;
	int subTotal = 0;
	int knuts = 1;
	int sickle = 29;
	int galleon = 493 ;
	int memberSubTotal = 0;




	System.out.println("Welcome to the HoneyPot!");
	System.out.println("[Official Licensed HoneyDukes Franchise]");
	// loop that handles customer.
	// check to see if customer, and if yes, then continue, otherwise exit.
	while (!customer)
	{
		System.out.println("Is there a customer waiting? \nEnter yes or no");
		String userInput = inputStream.nextLine().toLowerCase();
		if (userInput.equals("no")|| userInput.equals("n")){
			inputStream.close();
			System.exit(1);
		}
		else if (userInput.equals("yes")|| userInput.equals("y")){
			customer = true;
		}
	}
	// loop checks for password, 2 tries.
    while (triesleft > 0){
		System.out.println("What is the password?");
		String userInput = inputStream.nextLine().toLowerCase();
		if (userInput.equals("")){
			System.out.println("Silly! You need to actually tell me a password!");
		}
		if(userInput.equals(Password)){
			member = true;
			break;
		}
			else if (!userInput.equals(Password) && !userInput.equals(""))
			{
				triesleft --;
				System.out.println("Sorry, that's not right. Tries left:" + triesleft);
					if (triesleft == 0){
						System.out.println("You're out of tries! Better luck next time.");
					}
				}
	}  
    browsing = true;
    showPriceList(member, memberPrices, regularPrices, itemsForsale,greeted);
    greeted = true;
	
	int itemsToBuy = 0;
	while (browsing) 
	{
		showOptions();
		int userSelectOption = inputStream.nextInt();
		switch(userSelectOption) 
		{
		case 1:
			totalPops = selectedItem[0] + selectedItem[1]*5;
			// handle prompt based on if user has any acid pops already selected to purchase.
			if (selectedItem[0] >= 1 || selectedItem[1] >= 1) {
				System.out.println("Here is your current order:");
				System.out.println("Acid Pops Selected (single):"+ selectedItem[0] + "\nAcid Pops (bag of 5):" + selectedItem[1]);
				System.out.println("How many would you like to add or remove? Enter in singular amounts of Acid Pops.");
			}
			else {
				System.out.println("How many would you like? Enter in singular amounts of Acid Pops.");
			}
			int userInput = inputStream.nextInt();
			if (userInput > 0){
				totalPops = totalPops + userInput ;
			}
			else
			{
				totalPops = totalPops + userInput;
			}
			// handles the conversion of bags to single.
			if (totalPops >= 5){
				selectedItem[0] = totalPops % 5;
				selectedItem[1] = totalPops / 5 ;	
			}
			else 		{
				selectedItem[1] = 0;
				selectedItem[0] = totalPops;
			}
			// prevents negative amounts if user goes crazy.
			if (selectedItem[0] < 0){
				selectedItem[0] = 0;
			}
			if (selectedItem[1] < 0){
				selectedItem[1] = 0;
			}
			break;
		case 2:
			if(selectedItem[2] >=1) {
				System.out.println("How many would you like to add or remove?");
				System.out.println("Here is your current order:");
				System.out.println("Pumpkin Pasties:"+ selectedItem[2]);
			}
			else
			{
				System.out.println("How many would you like?");
			}
			userInput = inputStream.nextInt();
			
			selectedItem[2] = userInput + selectedItem[2];
			
			
			
			if (selectedItem[2] < 0) {
				selectedItem[2] = 0;
			}

			break;
		case 3:
			if (selectedItem[3] >=1 || selectedItem [4] >=1){
				System.out.println("Here is your current order:");
				System.out.println("Every Flavour Beans Small Bag:" + selectedItem[3] + "\nEvery Flavour Beans Large Bag:" + selectedItem[4]);
				System.out.println ("How many small bags do you want to add or remove to your order?");
				userInput = inputStream.nextInt();
				selectedItem[3] = userInput + selectedItem[3];
				System.out.println("How many large bags do you want to add or remove to your order?");
				userInput = inputStream.nextInt();
				selectedItem[4] = userInput + selectedItem[4];
			}
			else 
			{
				System.out.println("How many small bags do you want?");
				userInput = inputStream.nextInt();
				selectedItem[3] = userInput + selectedItem[3];
				System.out.println("How many large bags do you want?");
				userInput = inputStream.nextInt();
				selectedItem[4] = userInput + selectedItem[4];
			}

			if (selectedItem[3] < 0 ){
				selectedItem[3] = 0;
				
			}

			if (selectedItem[4] < 0) {
				selectedItem[4] = 0; 

			}
			break;
		case 4:
			showPriceList(member, memberPrices, regularPrices, itemsForsale,greeted);
			break;
		case 5:// subtotal section I calculate all of the items that are stored in the arrays. If you are a member,
				//	then you get whatever is in your inventory displayed back in stdout.
			subTotal = 0;
		    itemsToBuy = 0;
			itemsToBuy = selectedItem [0] + selectedItem[1] + selectedItem[2] + selectedItem[3] + selectedItem[4];
	if (member && itemsToBuy >=1) 	
			{
				System.out.println("Here is your subtotal:");
				for (int i = 0 ; i < 5 ; i++) 
					{
					if (selectedItem[i] == 0){
						continue;
					}
					System.out.println(selectedItem[i] + " " + itemsForsale[i] + " " + memberPrices[i]+ " each unit");
					}
			}
				else if(!member && itemsToBuy >=1) {
					System.out.println("Here is your subtotal:");
					for (int i = 0; i < 5 ; i++)
					{
					if (selectedItem[i] == 0)
					{
						continue;
					}
					System.out.println(selectedItem[i] + " " + itemsForsale[i] + " " + regularPrices[i]+ " each unit");
					}
			}
				else {
					System.out.println("No items selected to purchase. Cannot display subtotal at this time.");
					break;
				}
			if (member) {
				for (int i = 0; i < 5 ; i++ ) {
					subTotal = selectedItem[i] * memberPrices[i] + subTotal;  
				}
				}
				else {
					for (int i = 0; i < 5 ; i++ ) {
						subTotal = selectedItem[i] * regularPrices[i] + subTotal;				
					}				
				}
			 System.out.println("--------------------------------------------------");
			 System.out.println(subTotal + " knuts");
			 //apply 10% disc
			 if (member && subTotal >= 290){
				double discount = 0;
				discount = subTotal *.10;
				System.out.println("--------------------------------------------------");
				System.out.println(subTotal - discount + " knuts" + " after the 10% discount applied!");
			 }
			break;
		case 69:
			System.out.println("Real mature...");
			break;
		case 420:
			System.out.println("420 Blaze it!!");
			break;
		default:
		System.out.println("Thats not an available option.");
		break;
		case 6:
		subTotal = 0;
		itemsToBuy = 0;
		itemsToBuy = selectedItem [0] + selectedItem[1] + selectedItem[2] + selectedItem[3] + selectedItem[4];
		if (member && itemsToBuy >=1) 	
		{
			System.out.println("Here is your subtotal:");
			System.out.println("-----------------------------");
			for (int i = 0 ; i < 5 ; i++) 
				{
				if (selectedItem[i] == 0){
					continue;
				}
				System.out.println(selectedItem[i] + " " + itemsForsale[i] + " " + memberPrices[i]+ " each unit");
				}
		}
			else if(!member && itemsToBuy >=1) {
				System.out.println("Here is your subtotal:");
				System.out.println("-----------------------------");
				for (int i = 0; i < 5 ; i++)
				{
				if (selectedItem[i] == 0)
				{
					continue;
				}
				System.out.println(selectedItem[i] + " " + itemsForsale[i] + " " + regularPrices[i]+ " each unit");
				}
		}
			else {
				System.out.println("No items selected to purchase. Cannot checkout at this time.");
				System.out.println("Goodbye.");
				System.exit(1);
				
				break;
			}
		if (member) {
			for (int i = 0; i < 5 ; i++ ) {
				subTotal = selectedItem[i] * memberPrices[i] + subTotal;  
			}
			}
			else {
				for (int i = 0; i < 5 ; i++ ) {
					subTotal = selectedItem[i] * regularPrices[i] + subTotal;				
				}				
			}
		 System.out.println("--------------------------------------------------");
		 System.out.println(subTotal + " knuts, is your grand total.");
		 //apply 10% disc
		 if (member && subTotal >= 290){
			int discount = 0;
			discount = subTotal / 10;
			memberSubTotal = subTotal - discount;
			System.out.println("--------------------------------------------------");
			System.out.println(memberSubTotal + " knuts" + " total, after the 10% discount applied!");
			
		 }

		
		browsing = false;
	}
	}
	
	// checkout loop
	
	System.out.println("Note 1: We prefer exact change, but will make change if necessary!");
	System.out.println("Note 2: No more than 50 galleons are kept in the cart (funds are transported to Gringotts on a daily basis)");
	System.out.println("Note 3: Recall our currency options:");
	System.out.println("1 Sickle = 29 Knuts, 17 Sickles = 1 Galleon = 493 Knuts");
	System.out.println("Please enter a payment amount in the following format:");
	System.out.println("<amount><space><currency>");
	System.out.println("Where <amount> = an integer");
	System.out.println("Where <space> = a blank space");
	System.out.println("Where <currency> = {Knuts, Sickles, Galleons}");
	System.out.println("You may enter as many times as you like.  Each entry will be added to your total until sufficient funds have been obtained");

	checkOut = true;
	
	if (member) {
		subTotal = memberSubTotal;
	}
	
	while (checkOut){	
		// take in input for payment & currency
		int payment = inputStream.nextInt();
		String currencyType = inputStream.nextLine().strip().toLowerCase();
		
		// prevent negative payments.
		if (payment <= 0) {
			payment = 0;
			System.out.println("Please enter a valid payment");
			continue;
		}
		// handles currency type value conversion to KNUTS.
		if (currencyType.equals("galleon") || currencyType.equals("galleons")){
			payment = payment * 493; 
		}
		else if (currencyType.equals("sickle") || currencyType.equals("sickles"))
		{
			payment = payment * 29;
		}

		
		// displays user payment and subtotal.
	
		System.out.println("Your Payment is: " + payment  + " Knuts in value");
		System.out.println("Subtotal: " + subTotal + " knuts");
		
		
		subTotal = subTotal - payment;
		change = subTotal * -1;
		
		

		if (subTotal > 0){
			System.out.println("Remaining Payment: " + subTotal + " knuts");
		}
		
		
		// if payment 1 - 2
		
		if (change > 0 && change <29) {
			System.out.println("Here is your change "  + change + " knuts");
		}
		if (change > 29 && change < 493) {
			
			sChange = change / 29;
			kChange = change % 29;
			System.out.println("Here is your change:" + "" + sChange + " sickles " + kChange + " knuts");
		}
		
		if (change >=493) {
			gChange = change / 493;
			remainder = change % 493;
			if ( remainder < 29){
				kChange = remainder;
			}
			else if (remainder > 29 && remainder < 493) {
			sChange = remainder / 29;
			if (sChange >= 17) {
				sChange = 0;
			}
			kChange = remainder % 29;
			}
		System.out.println("Here is your change: " +"Galleons: " + gChange +" Sickles: " + sChange + " knuts: " + kChange);
		}
		


		// break back to main loop
		if(subTotal <= 0 ){
			System.out.println("Thanks for visiting!! Come again soon!");
			break;
		}
		}
	}
}
}
