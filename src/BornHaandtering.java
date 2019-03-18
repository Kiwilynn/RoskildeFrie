import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BornHaandtering {

    static List<Born> borneliste = new LinkedList<>();
    private Scanner input = new Scanner(System.in);

    public void indlesBorn() throws FileNotFoundException {

        File file = new File("Børneliste");
        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String fornavn = input.next();
            String efternavn = input.next();
            int alder = input.nextInt();
            String stue = input.next();
            String parent_Navn = input.next();
            String dato = input.next();

            borneliste.add(new Born(fornavn, efternavn, alder, stue, parent_Navn, dato));
        }
    }


    public void gemBarn() throws FileNotFoundException {
        PrintStream output = new PrintStream(new FileOutputStream("Børneliste", true));
        for (Born b : borneliste) {
            output.println(b.getFornavn() + " " + b.getEfternavn() + " " + b.getAlder() + " " + b.getDato() + " " + b.getStue() + " " + b.getParent_Navn());
        }
        System.out.println();
    }

    public void fjernBarn() throws FileNotFoundException {
        System.out.println("Hvilket barn vil du gerne fjerne fra listen?:");
        System.out.print("Input fornavn: ");
        String fornavn = input.nextLine().toUpperCase();
        System.out.print("Input efternavn: ");
        String efternavn = input.nextLine().toUpperCase();

        for (Born b : borneliste) {

            if (b.getFornavn().equalsIgnoreCase(fornavn) & b.getEfternavn().equalsIgnoreCase(efternavn)) {
                System.out.println();
                borneliste.remove(b);
                System.out.println("Du slettede: " + b.getFornavn() + " " + b.getEfternavn());
                System.out.println();
                gemBarn();
                break;
            } else {
                System.out.println();
                System.out.println("Dette barn findes ikke ");
                System.out.println();
                break;
            }
        }
    }

    public void visBarn() {
            int count = 0;
            //System.out.printf("%-10S %-10S %10S %10S\n","First:","Last:","Age:","Team:");

            for (Born b : borneliste) {
                System.out.printf("%-10S %-10S %3d %10S %10S %15S\n", b.getFornavn(), b.getEfternavn(), b.getAlder(), b.getStue(), b.getParent_Navn(), b.getDato());
                count++;
            }
            System.out.println();
            if(count == 1){
                System.out.println("Der er " + count + " barn i alt:");
            }else {
                System.out.println("Der er " + count + " børn i alt:");
            }
            System.out.println();
        }
}
