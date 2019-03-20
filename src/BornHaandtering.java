import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.*;


public class BornHaandtering {

    static List<Born> borneliste = new LinkedList<>();
    static List<Born> telefonliste = new LinkedList<>();
    private Scanner input = new Scanner(System.in);
    private int count = 0;

    File file = new File("Børneliste");
    File file1 = new File("Telefonliste");

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

        while(input.hasNext()){
            String telefon = input.next();
            String parent_Navn = input.next();

            telefonliste.add(new Born(parent_Navn, telefon));
        }
    }

    public void gemBarn() throws FileNotFoundException {
        PrintStream output = new PrintStream(new FileOutputStream("Børneliste", true));
        for (Born b : borneliste) {
            output.println(b.getFornavn()+" "+b.getEfternavn()+" "+b.getAlder()+" "+b.getStue()+" "+b.getParent_Navn()+" "+b.getDato());
        }

        PrintStream output1 = new PrintStream(new FileOutputStream("Telefonliste", true));
        for (Born b : borneliste) {
            output1.println(b.getTelefon()+" "+b.getParent_Navn());
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
            System.out.print("Input: ");
            tempRemove = input.nextLine();
            System.out.println("Hvad er barnest efternavn?");
            System.out.print("Input: ");
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

            System.out.print("Telefon nr.: ");
            String telefon = input.next();

            System.out.println();

            borneliste.add(new Born(fornavn, efternavn, alder, stue, parent, dato));
            System.out.println("Barn er oprettet");
            gemBarn();

            telefonliste.add(new Born(parent, telefon));

        } catch (InputMismatchException ime) {
            System.out.println("Der gik noget galt");
        }
        System.out.println();
    }

    public void visBarn() {
            int count = 0;
            //System.out.printf("%-10S %-10S %10S %10S\n","First:","Last:","Age:","Team:");

            for (Born b : borneliste) {
                System.out.printf("%-10S %-10S %10d %10S %10S %10S\n", b.getFornavn(), b.getEfternavn(), b.getAlder(), b.getStue(), b.getParent_Navn(), b.getDato());

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

    public void visTelefonliste(){

        for (Born t : telefonliste){
            System.out.printf("%-10S %10S\n", t.getParent_Navn(), t.getTelefon());
        }
        System.out.println();
    }


    void redigerBarn(){

        System.out.println("Hvad ønsker du at ændre?");
        String svarString = null;
        System.out.println("Alder, navn, stue eller dato for indskrivelse?");
        System.out.print("Input: ");
        String svarString2;
        String svarString3;
        svarString = input.nextLine();

        System.out.println("Hvad hedder barnet til fornavn?");
        svarString2 = input.nextLine();
        System.out.println("Hvad hedder barnet til Efternavn?");
        svarString3 = input.nextLine();


            switch(svarString.toUpperCase()) {

                case "ALDER":

                    for(Born b : borneliste){

                        if (b.getFornavn().equalsIgnoreCase(svarString2) && b.getEfternavn().equalsIgnoreCase(svarString3)){


                            System.out.println("Barnets alder er lige nu: " + b.getAlder());
                            System.out.println("Hvad ønsker du at ændre barnets alder til?");
                            b.setAlder(input.nextInt());
                            System.out.println("Barnets alder er nu sat til: " + b.getAlder());
                        }
                    } break;

                case "NAVN":

                    System.out.println("1: Vil du ændre fornavn?");
                    System.out.println("2: Vil du ændre Efternavn?");
                    System.out.println("3: Vil du ændre både fornavn og efternavn?");
                    svarString = null;
                    svarString = input.nextLine();
                    if (svarString.equalsIgnoreCase("1")) {

                        for (Born b : borneliste) {

                            if (b.getFornavn().equalsIgnoreCase(svarString2) && b.getEfternavn().equalsIgnoreCase(svarString3)) {

                                System.out.println("Barnet hedder lige nu: " + b.getFornavn() +" " + b.getEfternavn());
                                System.out.println("Hvad skal barnet hedde til fornavn?");
                                b.setFornavn(input.nextLine());
                                System.out.println("Barnet hedder nu: " + b.getFornavn() + " " + b.getEfternavn());
                            }
                        }

                    } else if (svarString.equalsIgnoreCase("2")) {

                        for (Born b : borneliste) {

                            if (b.getFornavn().equalsIgnoreCase(svarString2) && b.getEfternavn().equalsIgnoreCase(svarString3)) {

                                System.out.println("Barnet hedder lige nu: " + b.getFornavn() +" " + b.getEfternavn());
                                System.out.println("Hvad skal barnet hedde til efternavn?");
                                b.setEfternavn(input.nextLine());
                                System.out.println("Barnet hedder nu: " + b.getFornavn() + " " + b.getEfternavn());
                            }
                        }

                    } else if (svarString.equalsIgnoreCase("3")) {

                        for (Born b : borneliste) {

                            if (b.getFornavn().equalsIgnoreCase(svarString2) && b.getEfternavn().equalsIgnoreCase(svarString3)) {

                                System.out.println("Barnet hedder lige nu: " + b.getFornavn() +" " + b.getEfternavn());
                                System.out.println("Hvad skal barnet hedde til fornavn?");
                                b.setFornavn(input.nextLine());
                                System.out.println("Hvad skal barnet hedde til efternavn?");
                                b.setEfternavn(input.nextLine());
                                System.out.println("Barnet hedder nu: " + b.getFornavn() + " " + b.getEfternavn());
                            }
                        }

                    } else{}
                    break;

                case "STUE":

                    for(Born b : borneliste){

                        if (b.getFornavn().equalsIgnoreCase(svarString2) && b.getEfternavn().equalsIgnoreCase(svarString3)){


                            System.out.println("Barnets stue er lige nu: " + b.getStue());
                            System.out.println("Hvad ønsker du at ændre barnets stue til?");
                            b.setStue(input.nextLine());
                            System.out.println("Barnets stue er nu sat til: " + b.getStue());
                        }
                    } break;

                        case "DATO":

                            for(Born b : borneliste){

                                if (b.getFornavn().equalsIgnoreCase(svarString2) && b.getEfternavn().equalsIgnoreCase(svarString3)){


                                    System.out.println("Barnets indskrivningsdato er lige nu: " + b.getDato());
                                    System.out.println("Hvad ønsker du at ændre barnets indskrivingsdato til?");
                                    b.setDato(input.nextLine());
                                    System.out.println("Barnets indskrivningsdato er nu sat til: " + b.getDato());
                                }
                            } break;
        }
    }
}
