import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BornHaandtering {

    static List<Born> børneliste = new LinkedList<>();
    private Scanner input = new Scanner(System.in);

    public void indlæsBørn() throws FileNotFoundException {
        Scanner input = new Scanner(new File("C:\\Users\\madsr\\IdeaProjects\\untitled1\\src\\Børneliste"));
        while (input.hasNext()) {
            String fornavn = input.next();
            String efternavn = input.next();
            int alder = input.nextInt();
            int ind_Dato = input.nextInt();
            String stue = input.next();
            String parent_Navn = input.next();

            børneliste.add(new Born(fornavn, efternavn, alder, ind_Dato, stue, parent_Navn));
        }
    }


    public void gemBarn() throws FileNotFoundException {
        PrintStream output = new PrintStream(new FileOutputStream("C:\\Users\\madsr\\IdeaProjects\\untitled1\\src\\Børneliste", true));
        for (Born b : børneliste) {
            output.println(b.getFornavn()+" "+b.getEfternavn()+" "+b.getAlder()+" "+b.getInd_Dato()+" "+b.getStue()+" "+b.getParent_Navn());
        }
        System.out.println();
    }

    public void fjernBarn()throws FileNotFoundException {
        System.out.println("Hvilket barn vil du gerne fjerne fra listen?:");
        System.out.print("Input fornavn: ");
        String fornavn = input.nextLine().toUpperCase();
        System.out.print("Input efternavn: ");
        String efternavn = input.nextLine().toUpperCase();

        for (Born b : børneliste){

            if (b.getFornavn().equals(fornavn) & b.getEfternavn().equals(efternavn)) {
                System.out.println();
                børneliste.remove(b);
                System.out.println("Du slettede: "+b.getFornavn()+" "+b.getEfternavn());
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
































}