abstract class Car {
  protected String brand;                                                 // define atribut
  protected String type;
  protected String color;
  private int speed;
  protected TollPayment tollPayment;
  protected Navigation navigation;
  protected Maintenance maintenance;

  public Car() {                                                          // constructor default - constructor parameterized
  }

  public Car(String brand, String type, String color, int speed,
             TollPayment tollPayment,
             Navigation navigation,
             Maintenance maintenance) {
    this.brand = brand;
    this.type = type;
    this.color = color;
    this.speed = speed;
    this.tollPayment = tollPayment;
    this.navigation = navigation;
    this.maintenance = maintenance;
  }

  public abstract void startEngine();                                      // method abstract, method setter getter, 

  public void setSpeed(int speed) {     // setter ada parameter
    this.speed = speed;
  }

  public int getSpeed() {               // getter ada return type
    return speed;
  }

  public void payToll(int amount) {
    if (tollPayment != null) {          // kalau obj tollPayment nggak kosong, 
      tollPayment.payToll(amount);
    } else {
      System.out.println("Metode pembayaran tol belum tersedia.");
    }
  }

  // ===== NAVIGATION =====
  public void navigateTo(String destination) {
    if (navigation != null) {
      navigation.navigate(destination);
    } else {
      System.out.println("Sistem navigasi tidak tersedia.");
    }
  }

  // ===== MAINTENANCE =====
  public void checkMaintenance() {
    if (maintenance != null) {
      maintenance.check();
    } else {
      System.out.println("Sistem maintenance tidak tersedia.");
    }
  }

  public void showCarInfo() {
    System.out.println("Brand : " + brand);
    System.out.println("Type  : " + type);
    System.out.println("Color : " + color);
    System.out.println("Speed : " + speed + " km/h");
  }
}

// ================= PAYMENT =================
interface TollPayment {
  void payToll(int amount);
}

class CashPayment implements TollPayment {
  @Override
  public void payToll(int amount) {
    System.out.println("Pembayaran tol tunai sebesar Rp" + amount + " berhasil.");
  }
}

// ================= NAVIGATION =================
interface Navigation {
  void navigate(String destination);
}

class GPSNavigation implements Navigation {
  @Override
  public void navigate(String destination) {
    System.out.println("Navigasi menuju " + destination + " dimulai.");
  }
}

// ================= MAINTENANCE =================
interface Maintenance {
  void check();
}

class BasicMaintenance implements Maintenance {
  @Override
  public void check() {
    System.out.println("Maintenance: Semua sistem dalam kondisi baik.");
  }
}

// ================= ELECTRIC CAR =================
class ElectricCar extends Car {
  public ElectricCar(String brand, String type, String color, int speed,
                     TollPayment tollPayment,
                     Navigation navigation,
                     Maintenance maintenance) {
    super(brand, type, color, speed, tollPayment, navigation, maintenance);
  }

  @Override
  public void startEngine() {
    System.out.println("Mobil listrik dinyalakan tanpa suara.");
  }
}

// ================= MAIN =================
public class AppFinal {
  public static void main(String[] args) {
    TollPayment payment = new CashPayment();
    Navigation nav = new GPSNavigation();
    Maintenance maintenance = new BasicMaintenance();

    ElectricCar car = new ElectricCar(
        "Tesla",
        "Model 3",
        "Merah",
        120,
        payment,
        nav,
        maintenance
    );

    System.out.println("=== DATA MOBIL ===");
    car.showCarInfo();

    System.out.println("\n=== MENYALAKAN MOBIL ===");
    car.startEngine();

    System.out.println("\n=== NAVIGASI ===");
    car.navigateTo("Surabaya");

    System.out.println("\n=== PEMBAYARAN TOL ===");
    car.payToll(15000);

    System.out.println("\n=== MAINTENANCE ===");
    car.checkMaintenance();

    System.out.println("\n=== UBAH KECEPATAN ===");
    car.setSpeed(140);
    System.out.println("Kecepatan sekarang: " + car.getSpeed() + " km/h");
  }
}
