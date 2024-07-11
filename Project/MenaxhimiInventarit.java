
package Project;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenaxhimiInventarit {
    private Map<String, Integer> stoku;
    private Map<String, Double> cmimet;

    public MenaxhimiInventarit() {
        stoku = new HashMap<>();
        cmimet = new HashMap<>();
    }

    // Metoda per shtimin e nje produkti ne inventar
    public void shtoProdukt(String emriProduktit, int sasia, double cmimi) {
        stoku.put(emriProduktit, sasia);
        cmimet.put(emriProduktit, cmimi);
        System.out.println("Produkti u shtua me sukses.");
    }

    // Metoda per te fshire nje produkt nga inventari
    public void fshiProdukt(String emriProduktit) {
        if (stoku.containsKey(emriProduktit)) {
            stoku.remove(emriProduktit);
            cmimet.remove(emriProduktit);
            System.out.println("Produkti u fshi me sukses nga inventari.");
        } else {
            System.out.println("Produkti nuk u gjet ne inventar.");
        }
    }

    // Metoda per shfaqjen e inventarit
    public void shfaqInventarin() {
        System.out.println("\nInventari:");
        for (String emriProduktit : stoku.keySet()) {
            int sasia = stoku.get(emriProduktit);
            double cmimi = cmimet.get(emriProduktit);
            System.out.println(emriProduktit + " - Sasia: " + sasia + ", Çmimi: $" + cmimi);
        }
    }

    public static void main(String[] args) {
        MenaxhimiInventarit inventari = new MenaxhimiInventarit();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nMenuja e Menaxhimit te Inventarit:");
            System.out.println("1. Shto Produkt");
            System.out.println("2. Fshi Produkt");
            System.out.println("3. Shfaq Inventarin");
            System.out.println("4. Dil");
            System.out.print("Zgjidhni veprimin tuaj: ");
            int zgjedhja = scanner.nextInt();
            scanner.nextLine(); 

            switch (zgjedhja) {
                case 1:
                    System.out.print("Fut emrin e produktit: ");
                    String emriProduktit = scanner.nextLine();
                    System.out.print("Fut sasine: ");
                    int sasia = scanner.nextInt();
                    System.out.print("Fut çmimin: ");
                    double cmimi = scanner.nextDouble();
                    inventari.shtoProdukt(emriProduktit, sasia, cmimi);
                    break;
                
                case 2:
                    while (true) {
                        System.out.print("Fut emrin e produktit qe deshironi te fshini (ose 'kthehu' per tu kthyer në menune fillestare): ");
                        String emriProduktitFshirje = scanner.nextLine().toLowerCase();
                        if (emriProduktitFshirje.equalsIgnoreCase("kthehu")) {
                            break;
                        }
                        inventari.fshiProdukt(emriProduktitFshirje);
                    }
                    break;
                
                case 3:
                    if (inventari.stoku.isEmpty()) {
                        System.out.println("\nInventari eshte bosh.");
                    } else {
                        inventari.shfaqInventarin();
                    }
                    break;
                
                case 4:
                    running = false;
                    break;
                
                default:
                    System.out.println("Zgjedhje e pavlefshme. Ju lutem provoni perseri.");
                    break;
            }
        }

        System.out.println("Duke dalur nga Menaxhimi i Inventarit. Mirupafshim!");
        scanner.close();
    }
}
