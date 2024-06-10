import java.util.*;

public class Headsets{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        HeadsetItem[] hs = new HeadsetItem[n];
        for(int i=0; i<n; i++){
            String name = scanner.nextLine();
            String brand = scanner.nextLine();
            int price = scanner.nextInt();
            boolean available = scanner.nextBoolean();
            scanner.nextLine();
            hs[i] = new HeadsetItem(name, brand, price, available);
        }
        // for(int i=0; i<n; i++){
        //     System.out.println("Name: " + hs[i].getHeadsetName());
        //     System.out.println("brand: " + hs[i].getBrand());
        //     System.out.println("price: " + hs[i].getPrice());
        //     System.out.println("available status: " + hs[i].getAvailable());
        // }
        System.out.println("Enter the brand to get the total price: ");
        String br = scanner.nextLine();
        System.out.println("total price: " + findTotalPriceForGivenBrand(br, hs));
        System.out.println("Second minimum price: " + findAvailableHeadsetWithSecondLowestPrice(hs));



    }
    static int findTotalPriceForGivenBrand(String brand, HeadsetItem[] hs){
        int sm = 0;
        for(HeadsetItem x : hs){
            if(x.getBrand().equalsIgnoreCase(brand)){
                sm += x.getPrice();
            }
        }
        return sm;
    }
    static HeadsetItem findAvailableHeadsetWithSecondLowestPrice(HeadsetItem[] hs){
        List<HeadsetItem> ls = new ArrayList<>();
        for(HeadsetItem x: hs){
            if(x.getAvailable() == true){
                ls.add(x);
            }
        }
        if(ls.size()<2){return null;}
        ls.sort(Comparator.comparingInt(HeadsetItem::getPrice));
        return ls.get(1);

    }
}
class HeadsetItem{
    private String headsetName;
    private String brand;
    private int price;
    private boolean available;
    public HeadsetItem(String headsetName, String brand, int price, boolean available){
        this.headsetName = headsetName;
        this.brand = brand;
        this.price = price;
        this.available = available;
    }
    // getters
    public String getHeadsetName(){return this.headsetName;}
    public String getBrand(){return this.brand;}
    public int getPrice(){return this.price;}
    public boolean getAvailable(){return this.available;}
}