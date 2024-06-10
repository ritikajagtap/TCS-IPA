import java.util.*;

public class Medicine{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        MedicineItem[] meds = new MedicineItem[n];
        for(int i=0; i<n; i++){
            String name = scanner.nextLine();
            String batch = scanner.nextLine();
            String disease = scanner.nextLine();
            int price = scanner.nextInt();
            scanner.nextLine();
            meds[i] = new MedicineItem(name, batch, disease, price);
        }
        // for(int i=0; i<n; i++){
        //     System.out.println("Name: " + meds[i].getMedicineName());
        //     System.out.println("batch: " + meds[i].getBatch());
        //     System.out.println("Disease: " + meds[i].getDisease());
        //     System.out.println("Price: " + meds[i].getPrice());
        // }
        String disease = scanner.nextLine();
        Integer[] arr = getPriceByDisease(meds, disease);
        for(int ar : arr){
            System.out.println("Prices: " + ar);
        }
    }
    public static Integer[] getPriceByDisease(MedicineItem meds[], String disease){
        List<Integer> lis = new ArrayList<>();
        for(MedicineItem med : meds){
            if(med.getDisease().equalsIgnoreCase(disease)){
                lis.add(med.getPrice());
            }
        }
        Integer[] arr = lis.toArray(new Integer[0]);
        Arrays.sort(arr);
        return arr;
    }
}

class MedicineItem{
    private String medicineName;
    private String batch;
    private String disease;
    private int price;
    public MedicineItem(String medicineName, String batch, String disease, int price){
        this.medicineName = medicineName;
        this.batch = batch;
        this.disease = disease;
        this.price = price;
    }

    // getters
    public String getMedicineName(){return this.medicineName;}
    public String getBatch(){return this.batch;}
    public String getDisease(){return this.disease;}
    public int getPrice(){return this.price;}
}