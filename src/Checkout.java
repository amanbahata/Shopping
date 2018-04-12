import java.util.Scanner;

public class Checkout {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome");
        Cart cart = new Cart();

        int applePriceInPence = 60;
        int orangePriceInPence = 25;
        String name;


        do {
            System.out.println("Add item, enter <done> to finish: ");
            name = in.next().trim().toLowerCase();

            switch (name) {
                case "apple":
                    Item apple = new Item("apple", applePriceInPence);
                    cart.addItem(apple);
                    break;
                case "orange":
                    Item orange = new Item("orange", orangePriceInPence);
                    cart.addItem(orange);
                    break;
                case "done":
                    System.out.println("Getting cart total");
                    break;
                default:
                    System.out.println("We don't sell this item");
                    break;
            }

        } while (!name.equals("done"));


        int total = cart.getTotal();
        total -= cart.addBuyOneGetOneFreeOnApplesDiscount();
        total -= cart.add3forThePriceOf2OnOrangesDiscount();
        
        System.out.println(cart.getItemNames() + " => £" + (total/100.0));
    }
}
