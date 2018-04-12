import java.util.ArrayList;

public class Cart implements DiscountRule{

    private ArrayList<Item> cart;
    private int total;

    public Cart() {
        this.cart = new ArrayList<>();
        this.total = 0;
    }

    public int getSize(){
        return cart.size();
    }

    public int getTotal() {
        return total;
    }


    public void addItem(Item item){
        this.total += item.getPrice();
        cart.add(item);
    }

    public String getItemNames(){
        StringBuilder allItemNames = new StringBuilder("[");
        int size = getSize();
        if (getSize() > 0) {
            for (int i = 0; i < size - 1; i++) {
                allItemNames.append(capitaliseFirstCharacter(cart.get(i).getName())).append(", ");
            }
            allItemNames.append(capitaliseFirstCharacter(cart.get(size - 1).getName())).append("]");
            return allItemNames.toString();
        }
        return allItemNames.append("cart is empty]").toString();
    }

    private String capitaliseFirstCharacter(String str){
        String capitol   = Character.toString(str.charAt(0)).toUpperCase();
        return capitol + str.substring(1);
    }

    @Override
    public int addBuyOneGetOneFreeOnApplesDiscount() {
        int numberOfApples = 0;
        int price = 0;
        for (Item item : this.cart) {
            if (item.getName().equals("apple")){
                numberOfApples++;
                price = item.getPrice();
            }
        }
        return price * (numberOfApples / 2);
    }

    @Override
    public int add3forThePriceOf2OnOrangesDiscount() {
        int numberOfOranges = 0;
        int price = 0;
        for (Item item : this.cart) {
            if (item.getName().equals("orange")){
                numberOfOranges++;
                price = item.getPrice();
            }
        }
        return price * (numberOfOranges / 3);
    }

}
