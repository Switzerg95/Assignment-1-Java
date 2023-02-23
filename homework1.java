import java.util.*;

public class homework1 {
	
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
	
	public static int updateOrder(int userSelectOption, int selectedItem[]) {
		int indexChosen = 0;
		indexChosen = userSelectOption;
		return selectedItem[indexChosen];
		
		
	}

public static void main(String[] args){
	// creates scanner object to take in input stream.
    Scanner inputStream = new Scanner(System.in);
	//allocating memory to an array
	//int memberPrices [] = new int [3];
    int [] memberPrices = {11,50,100,50,58};
	int [] regularPrices = {12,58,116,50,70};
	String [] itemsForsale = {"Acid Pop","Acid Pops (bag of 5)","Pumpkin Pasties","Every Flavour Beans (Small Bag)","Every Flavour beans (Large Bag)"};
	String Password = "test";
    int triesleft = 2;	
    int [] selectedItem = new int [5];
    // acid pop
    selectedItem [0] = 0;
    // pumpkin pastie
	selectedItem [1] = 0;
	// small every flavor bean bag
	selectedItem [2]= 0;
	// every flavour bean large
	selectedItem [3]= 0;
	// flag section
    boolean browsing = false;
	boolean customer = false;
	boolean member = false;
	boolean greeted =false;
	
	int subTotal = 0;
	
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
		if(userInput.equals(Password)){
			member = true;
			break;
		}
			else{
				triesleft --;
				System.out.println("Sorry, thats not right.\nTries left:" + triesleft);
				}
	}  
    
    browsing = true;
    showPriceList(member, memberPrices, regularPrices, itemsForsale,greeted);
    greeted = true;
	while (browsing) 
	{
		showOptions();
		
		int userSelectOption = inputStream.nextInt();
		switch(userSelectOption) 
		{
		case 1:
			System.out.println("Here is your current order:");
			System.out.println("Acid Pops Selected:"+ selectedItem[0]);
			if (selectedItem[0] >= 1) {
				System.out.println("How many would you like to add or remove?");
			}
			else {
				System.out.println("How many would you like?");
			}
			
			int userInput = inputStream.nextInt();
			
			if (userInput >=0){
				selectedItem[0] = userInput + selectedItem[0];
				
			}
				if (selectedItem[0] < 0){
					selectedItem[0] = 0;
				}

			if (selectedItem[0] !=0) {
				selectedItem[1] = selectedItem[0] % 5;
				selectedItem[0] = selectedItem[0] / 5 ;
			}
			break;
			
		case 2:
			System.out.println("Here is your current order:");
			System.out.println("Pumpkin Pasties:"+ selectedItem[2]);
			if(selectedItem[2] >=1) {
				System.out.println("How many would you like to add or remove?");
			}
			else
			{
				System.out.println("How many would you like?");
			}

			userInput = inputStream.nextInt();
			if (userInput >=0){
				selectedItem[2] = userInput + selectedItem[2];
				if (userInput <0){
					selectedItem[2] = 0;
				}
			}
			break;
		case 3:
			System.out.println("Here is your current order:");
			System.out.println("Every Flavour Beans Small Bag:" + selectedItem[3] + "\nEvery Flavour Beans Large Bag:" + selectedItem[4]);

			if (selectedItem[3] >=1 || selectedItem [4] >=1){
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
			break;
		case 4:
			showPriceList(member, memberPrices, regularPrices, itemsForsale,greeted);
			break;
		case 5:// subtotal section
			subTotal = 0;
			if (member && selectedItem[0] >= 1 || selectedItem[1] >= 1 || selectedItem [2] >=1 || selectedItem [3] >=1 || selectedItem[4] >=1) 
			{
				System.out.println("Here is your subtotal:");
				for (int i = 0 ; i < 5 ; i++) 
					{
					System.out.println(selectedItem[i] + " " + itemsForsale[i] + " " + memberPrices[i]+ " each unit");
					}
			}
			
				else if(!member && selectedItem[0] >= 1 || selectedItem[1] >= 1 || selectedItem [2] >=1 || selectedItem [3] >=1 || selectedItem[4] >=1) {
					System.out.println("Here is your subtotal:");
					for (int i = 0; i < 5 ; i++){
	
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
			 System.out.println(subTotal + " knuts");
			 if (subTotal >= 290){
				double discount = 0;
				System.out.println("with 10% discount applied");
				discount = subTotal *.10;
				System.out.println(subTotal- discount + "knuts");
			 }
			break;
		// exit loop
		case 6:
			browsing = false;
	}
	}
	// checkout loop
	System.out.println("Please enter a payment amount in the following format:");
	System.out.println("<amount><space><currency>");
	System.out.println("Where <amount> = an integer");
	System.out.println("Where <space> = a blank space");
	System.out.println("Where <currency> = {Knuts, Sickles, Galleons}");
	System.out.println("You may enter as many times as you like.  Each entry will beadded to your total until sufficient funds have been obtained");



	inputStream.close();
	}
}
