import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.*;


public class BornHaandtering {

    static List<Born> borneliste = new LinkedList<>();
    private Scanner input = new Scanner(System.in);
    private int count = 0;

    File file = new File("Børneliste");

    public void indlesBorn() throws FileNotFoundException {

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
            output.println(b.getFornavn()+" "+b.getEfternavn()+" "+b.getAlder()+" "+b.getStue()+" "+b.getParent_Navn()+" "+b.getDato());
        }
        System.out.println();
    }

    public void sletBarn() throws java.io.IOException{

        String tempRemove = null;
        String tempRemove2 = null;
        int tempRemove3 = 0;


        if (borneliste.size() == 0) {
            System.out.println("Der er ingen børn registeret\n");
        } else
        {
            System.out.println("Hvad er barnest fornavn?");
            tempRemove = input.nextLine();
            System.out.println("Hvad er barnest efternavn?");
            tempRemove2 = input.nextLine();
        }
        for (int i = 0; i < borneliste.size(); i++) {


            if (tempRemove.equalsIgnoreCase(borneliste.get(i).getFornavn()) && tempRemove2.equalsIgnoreCase(borneliste.get(i).getEfternavn())){


                count++;
                System.out.println("Du fandt: "+borneliste.get(i).getFornavn()+" "+borneliste.get(i).getEfternavn());
                System.out.println("Vil du slette dette barn? \n1: Yes\n2: No\n");
                tempRemove3 = input.nextInt();
                input.nextLine();

                if (tempRemove3 == 1) {

                    System.out.println("Du slettede: "+borneliste.get(i).getFornavn()+" "+borneliste.get(i).getEfternavn());
                    System.out.println();
                    borneliste.remove(i);
                    filoverskrivning();
                    break;
                }
            }
        } if (count == 0){
            System.out.println("Der er ingen børn som hedder det");
            System.out.println();
            count = 0;
        }
    }

    public void filoverskrivning() throws java.io.IOException{

        new FileOutputStream("Børneliste").close();
        PrintStream output = new PrintStream(new FileOutputStream(file, true));

        for (Born b : borneliste) {
            output.println(b.getFornavn()+" "+b.getEfternavn()+" "+b.getAlder()+" "+b.getStue()+" "+b.getParent_Navn()+" "+b.getDato());
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
            String stue = input.next().toUpperCase();
            System.out.print("Forældre: ");
            String parent = input.next().toUpperCase();

            String dato = new SimpleDateFormat("dd.MM.yyyy").format(new Date());

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
                System.out.printf("%-15S %-15S %15d %15S %15S %15S\n", b.getFornavn(), b.getEfternavn(), b.getAlder(), b.getStue(), b.getParent_Navn(), b.getDato());

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


        System.out.println("Hvad ønsker du at ændre?");
        String svarString = null;
        svarString = input.nextLine();

            switch(svarString.toUpperCase()) {

                case "ALDER":

                    svarString = null;
                    System.out.println("Hvad hedder barnet til fornavn?");
                    svarString = input.nextLine();
                    System.out.println("Hvad hedder barnet til Efternavn?");
                    svarString = input.nextLine();

                case "FORNAVN":

                    svarString = null;
                    System.out.println("Hvad hedder barnet til fornavn?");
                    svarString = input.nextLine();
                    System.out.println("Hvad hedder barnet til Efternavn?");
                    svarString = input.nextLine();

                    case "EFTERNAVN":

                    svarString = null;
                    System.out.println("Hvad hedder barnet til fornavn?");
                    svarString = input.nextLine();
                    System.out.println("Hvad hedder barnet til Efternavn?");
                    svarString = input.nextLine();

                    case "STUE":

                        svarString = null;
                        System.out.println("Hvad hedder barnet til fornavn?");
                        svarString = input.nextLine();
                        System.out.println("Hvad hedder barnet til Efternavn?");
                        svarString = input.nextLine();

                        case "DATO":

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
