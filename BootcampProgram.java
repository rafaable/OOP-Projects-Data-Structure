import java.util.Scanner;

// ABSTRACT CLASS
abstract class Bootcamp {

    protected String name;
    protected String path;
    protected String specialization;
    protected String paymentMethod;

    private double basePrice;
    protected double finalPrice;

    public Bootcamp(String name, String path, double basePrice) {
        this.name = name;
        this.path = path;
        this.basePrice = basePrice;
    }

    // ABSTRACTION
    abstract void calculatePrice(int choice);

    // ENCAPSULATION
    public double getBasePrice() {
        return basePrice;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void displaySummary() {
        System.out.println("\n===== BOOTCAMP ORDER SUMMARY =====");
        System.out.println("Name           : " + name);
        System.out.println("Path           : " + path);
        System.out.println("Specialization : " + specialization);
        System.out.println("Final Price    : Rp" + finalPrice);
        System.out.println("Payment Method : " + paymentMethod);
    }
}

// WEB DEV CLASS
class WebDev extends Bootcamp {

    public WebDev(String name) {
        super(name, "Web Development", 1500000);
    }

    @Override
    void calculatePrice(int choice) {

        if (choice == 1) {
            specialization = "Frontend";
            finalPrice = getBasePrice();
        }

        else if (choice == 2) {
            specialization = "Backend";
            finalPrice = getBasePrice();
        }

        else if (choice == 3) {
            specialization = "Frontend + Backend";
            finalPrice = (getBasePrice() * 2) * 0.85;
        }
    }
}

// DATA SCIENCE CLASS
class DataScience extends Bootcamp {

    public DataScience(String name) {
        super(name, "Data Science", 1000000);
    }

    @Override
    void calculatePrice(int choice) {

        if (choice == 1) {
            specialization = "MySQL";
            finalPrice = getBasePrice();
        }

        else if (choice == 2) {
            specialization = "Machine Learning";
            finalPrice = getBasePrice();
        }

        else if (choice == 3) {
            specialization = "MySQL + Machine Learning";
            finalPrice = (getBasePrice() * 2) * 0.85;
        }
    }
}

// CYBER SECURITY CLASS
class CyberSecurity extends Bootcamp {

    public CyberSecurity(String name) {
        super(name, "Cyber Security", 2000000);
    }

    @Override
    void calculatePrice(int choice) {

        if (choice == 1) {
            specialization = "Network Security";
            finalPrice = getBasePrice();
        }

        else if (choice == 2) {
            specialization = "Cloud Security";
            finalPrice = getBasePrice();
        }

        else if (choice == 3) {
            specialization = "Network + Cloud";
            finalPrice = (getBasePrice() * 2) * 0.85;
        }
    }
}

// MAIN CLASS
public class BootcampProgram {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.println("\nChoose Bootcamp Path");
        System.out.println("1. Web Development");
        System.out.println("   Frontend  : Rp1.500.000");
        System.out.println("   Backend   : Rp1.500.000");
        System.out.println("   Both (15% discount)");

        System.out.println("\n2. Data Science");
        System.out.println("   MySQL           : Rp1.000.000");
        System.out.println("   Machine Learning: Rp1.000.000");
        System.out.println("   Both (15% discount)");

        System.out.println("\n3. Cyber Security");
        System.out.println("   Network : Rp2.000.000");
        System.out.println("   Cloud   : Rp2.000.000");
        System.out.println("   Both (15% discount)");

        System.out.print("\nChoose path: ");
        int pathChoice = input.nextInt();

        Bootcamp bootcamp = null;

        // POLYMORPHISM
        if (pathChoice == 1) {
            bootcamp = new WebDev(name);

            System.out.println("\nChoose specialization");
            System.out.println("1. Frontend");
            System.out.println("2. Backend");
            System.out.println("3. Both");

        }

        else if (pathChoice == 2) {
            bootcamp = new DataScience(name);

            System.out.println("\nChoose specialization");
            System.out.println("1. MySQL");
            System.out.println("2. Machine Learning");
            System.out.println("3. Both");

        }

        else if (pathChoice == 3) {
            bootcamp = new CyberSecurity(name);

            System.out.println("\nChoose specialization");
            System.out.println("1. Network");
            System.out.println("2. Cloud");
            System.out.println("3. Both");

        }

        System.out.print("Choose: ");
        int specChoice = input.nextInt();

        bootcamp.calculatePrice(specChoice);

        input.nextLine();

        System.out.println("\nChoose payment method");
        System.out.println("1. Transfer");
        System.out.println("2. E-Wallet");
        System.out.println("3. Cash");

        System.out.print("Choose: ");
        int payChoice = input.nextInt();

        if (payChoice == 1) bootcamp.setPaymentMethod("Transfer");
        else if (payChoice == 2) bootcamp.setPaymentMethod("E-Wallet");
        else bootcamp.setPaymentMethod("Cash");

        bootcamp.displaySummary();
        input.close();
    }

}
