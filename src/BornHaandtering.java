import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BornHaandtering {

    static LinkedList<Born> borneliste = new LinkedList<>();
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

    public void gemBarn()
throws FileNotFoundException {
        PrintStream output = new PrintStream(new FileOutputStream("Børneliste", true));
        for (Born b : borneliste) {
            output.println(b.getFornavn() + " " + b.getEfternavn() + " " + b.getAlder() + " " + b.getDato() + " " + b.getStue() + " " + b.getParent_Navn());
        }
        System.out.println();
    }

    public void sletBarn() throws FileNotFoundException {
        System.out.println("Hvilket barn vil du gerne fjerne fra listen?:");
        System.out.print("Input fornavn: ");
        String fornavn = input.nextLine();
        System.out.print("Input efternavn: ");
        String efternavn = input.nextLine();

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

    public void opretBarn() throws FileNotFoundException{
        try {
            System.out.println("");
            System.out.print("Fornavn: ");
            String fornavn = input.next().toUpperCase();
            System.out.print("Efternavn: ");
            String efternavn = input.next().toUpperCase();
            System.out.print("Alder: ");
            int alder = input.nextInt();
            System.out.print("Stue: ");
            String stue = input.next().toUpperCase();;
            System.out.print("Forældre: ");
            String parent = input.next().toUpperCase();;

            String dato = "10-10-2019";

            System.out.println();

            borneliste.add(new Born(fornavn, efternavn, alder, stue, parent, dato));
            System.out.println("Barn er oprettet");
            gemBarn();

        } catch (InputMismatchException ime) {
            System.out.println("Der gik noget galt");
        }
        System.out.println();
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

        void redigerBarn(){

        String svarString = null;
        svarString = input.nextLine();

            switch(svarString) {

                case "Alder":
                    svarString = null;
                    System.out.println("Hvad hedder barnet til fornavn?");
                    svarString = input.nextLine();
                    System.out.println("Hvad hedder barnet til Efternavn?");
                    svarString = input.nextLine();
            }
        for(int i = 0; i < borneliste.size(); i++){


        }
        }
}
