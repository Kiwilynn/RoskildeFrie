import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class BornHaandtering {
    LinkedList<Born> borneliste = new LinkedList<>();
    LinkedList<Born> telefonliste = new LinkedList<>();
    private Scanner input = new Scanner(System.in);
    private int count = 0;
    private boolean stop = true;
    File file = new File("Børneliste");
    File file1 = new File("Telefonliste");

    public void indlesBorn() throws FileNotFoundException {

        Scanner scan = new Scanner(file);
        Scanner scan1 = new Scanner(file1);
        try {
            while (scan.hasNext()) {
                String fornavn = scan.next();
                String efternavn = scan.next();
                int alder = scan.nextInt();
                String stue = scan.next();
                String parent_Navn = scan.next();
                String dato = scan.next();

                borneliste.add(new Born(fornavn, efternavn, alder, stue, parent_Navn, dato));
            }

            while (scan1.hasNext()) {
                String telefon = scan1.next();
                String parent_Navn = scan1.next();

                telefonliste.add(new Born(parent_Navn, telefon));
            }
        } catch (InputMismatchException IME) {
            System.out.println("Der gik noget galt under indlæsningen");
        }
    }

    public void gemBarn() throws FileNotFoundException {
        PrintStream output = new PrintStream(new FileOutputStream("Børneliste", true));
        output.println(borneliste.get(borneliste.size() - 1).getFornavn() + " " + borneliste.get(borneliste.size() - 1).getEfternavn() + " " + borneliste.get(borneliste.size() - 1).getAlder() + " " + borneliste.get(borneliste.size() - 1).getStue() + " " + borneliste.get(borneliste.size() - 1).getParent_Navn() + " " + borneliste.get(borneliste.size() - 1).getDato());

        System.out.println();
    }

    public void gemTelefonliste() throws IOException {
        new FileOutputStream("Telefonliste").close();
        PrintStream output1 = new PrintStream(new FileOutputStream("Telefonliste", true));
        for (Born t : telefonliste) {
            output1.println(t.getTelefon() + " " + t.getParent_Navn());
        }
        System.out.println();
    }

    public void sletBarn() throws java.io.IOException {

        String tempRemove = null;
        String tempRemove2 = null;
        int tempRemove3 = 0;


        if (borneliste.size() == 0) {
            System.out.println("Der er ingen børn registeret\n");
        } else {
            System.out.println("Hvad er barnest fornavn?");
            System.out.print("Input: ");
            tempRemove = input.nextLine();
            System.out.println("Hvad er barnest efternavn?");
            System.out.print("Input: ");
            tempRemove2 = input.nextLine();
        }
        for (int i = 0; i < borneliste.size(); i++) {
            if (tempRemove.equalsIgnoreCase(borneliste.get(i).getFornavn()) && tempRemove2.equalsIgnoreCase(borneliste.get(i).getEfternavn())) {
                count++;
                System.out.println("Du fandt: " + borneliste.get(i).getFornavn() + " " + borneliste.get(i).getEfternavn());
                System.out.println("Vil du slette dette barn? \n[1]: Ja\n[2]: Nej\n");
                tempRemove3 = input.nextInt();
                input.nextLine();

                if (tempRemove3 == 1) {
                    System.out.println("Du slettede: " + borneliste.get(i).getFornavn() + " " + borneliste.get(i).getEfternavn());
                    System.out.println();
                    borneliste.remove(i);
                    filoverskrivning();
                    break;
                }
            }
        }
        if (count == 0) {
            System.out.println("Der er ingen børn som hedder det");
            System.out.println();
            count = 0;
        }
    }

    public void filoverskrivning() throws java.io.IOException {

        new FileOutputStream("Børneliste").close();
        PrintStream output = new PrintStream(new FileOutputStream(file, true));

        for (Born b : borneliste) {
            output.println(b.getFornavn() + " " + b.getEfternavn() + " " + b.getAlder() + " " + b.getStue() + " " + b.getParent_Navn() + " " + b.getDato());
        }
    }

    public void opretBarn() throws IOException {
        int alder = 0;
        String telefon = null;

        try {
            System.out.println("");
            System.out.print("Fornavn: ");
            String fornavn = input.nextLine().toUpperCase();
            System.out.print("Efternavn: ");
            String efternavn = input.nextLine().toUpperCase();

            stop = true;
            while (stop) {
                System.out.print("Alder: ");
                alder = input.nextInt();
                input.nextLine();

                if (alder > 6) {
                    System.out.println("Barnet er for gammelt");
                } else if (alder < 2) {
                    System.out.println("Barnet er for ungt");
                } else {
                    stop = false;
                }
            }
            System.out.print("Stue: ");
            String stue = input.nextLine().toUpperCase();
            System.out.print("Forældre: ");
            String parent = input.nextLine().toUpperCase();

            stop = true;
            while (stop) {
                System.out.print("Telefon nr.: ");
                telefon = input.nextLine();
                if (telefon.length() != 8) {
                    System.out.println("Telefon nr. skal 8 tal lang");
                } else {
                    stop = false;
                }
            }
            String dato = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
            borneliste.add(new Born(fornavn, efternavn, alder, stue, parent, dato));
            telefonliste.add(new Born(parent, telefon));
            gemBarn();
            gemTelefonliste();

            System.out.println("Barn er oprettet");
            System.out.println();


        } catch (InputMismatchException ime) {
            System.out.println("Der gik noget galt");
            input.nextLine();
        }
        System.out.println();
    }

    public void visBarn() {
        sorterAlder();
        int count = 0;

        System.out.printf("%-15S %-15S %-15S %-15S %-15S %-15S\n", "Fornavn:", "Efternavn:", "Alder:", "Stue:", "Forældre:", "Indskriv. Dato:");
        for (Born b : borneliste) {
            System.out.printf("%-15S %-15S %-15d %-15S %-15S %-15S\n", b.getFornavn(), b.getEfternavn(), b.getAlder(), b.getStue(), b.getParent_Navn(), b.getDato());

            count++;
        }
        System.out.println();
        if (count == 1) {
            System.out.println("Der er " + count + " barn i alt:");
        } else {
            System.out.println("Der er " + count + " børn i alt:");
        }
        System.out.println();
    }

    public void visTelefonliste() {
        sorterNavn();
        System.out.printf("%-15S %-15S\n", "Forældre:", "Telfon nr:");
        for (Born t : telefonliste) {
            System.out.printf("%-15S %-15S\n", t.getParent_Navn(), t.getTelefon());
        }
        System.out.println();
    }

    void redigerBarn() {

        System.out.println("Hvad ønsker du at ændre?");
        String svarString = null;
        System.out.println("[1]: Alder\n[2]: Navn\n[3]: Stue\n[4]: Dato for indskrivelse");
        System.out.print("Input: ");
        String svarString2;
        String svarString3;
        svarString = input.nextLine();

        System.out.println("Hvad hedder barnet til Fornavn?");
        svarString2 = input.nextLine();
        System.out.println("Hvad hedder barnet til Efternavn?");
        svarString3 = input.nextLine();


        switch (svarString.toUpperCase()) {

            case "1":
                for (Born b : borneliste) {
                    if (b.getFornavn().equalsIgnoreCase(svarString2) && b.getEfternavn().equalsIgnoreCase(svarString3)) {
                        System.out.println("Barnets alder er lige nu: " + b.getAlder());
                        System.out.println("Hvad ønsker du at ændre barnets alder til?");
                        b.setAlder(input.nextInt());
                        System.out.println("Barnets alder er nu sat til: " + b.getAlder());
                    }
                }
                break;

            case "2":
                System.out.println("[1]: Vil du ændre fornavn?");
                System.out.println("[2]: Vil du ændre Efternavn?");
                System.out.println("[3]: Vil du ændre både fornavn og efternavn?");
                svarString = null;
                svarString = input.nextLine();
                if (svarString.equalsIgnoreCase("1")) {
                    for (Born b : borneliste) {
                        if (b.getFornavn().equalsIgnoreCase(svarString2) && b.getEfternavn().equalsIgnoreCase(svarString3)) {
                            System.out.println("Barnet hedder lige nu: " + b.getFornavn() + " " + b.getEfternavn());
                            System.out.println("Hvad skal barnet hedde til fornavn?");
                            b.setFornavn(input.nextLine());
                            System.out.println("Barnet hedder nu: " + b.getFornavn() + " " + b.getEfternavn());
                        }
                    }
                } else if (svarString.equalsIgnoreCase("2")) {

                    for (Born b : borneliste) {

                        if (b.getFornavn().equalsIgnoreCase(svarString2) && b.getEfternavn().equalsIgnoreCase(svarString3)) {

                            System.out.println("Barnet hedder lige nu: " + b.getFornavn() + " " + b.getEfternavn());
                            System.out.println("Hvad skal barnet hedde til efternavn?");
                            b.setEfternavn(input.nextLine());
                            System.out.println("Barnet hedder nu: " + b.getFornavn() + " " + b.getEfternavn());
                        }
                    }

                } else if (svarString.equalsIgnoreCase("3")) {

                    for (Born b : borneliste) {

                        if (b.getFornavn().equalsIgnoreCase(svarString2) && b.getEfternavn().equalsIgnoreCase(svarString3)) {

                            System.out.println("Barnet hedder lige nu: " + b.getFornavn() + " " + b.getEfternavn());
                            System.out.println("Hvad skal barnet hedde til fornavn?");
                            b.setFornavn(input.nextLine());
                            System.out.println("Hvad skal barnet hedde til efternavn?");
                            b.setEfternavn(input.nextLine());
                            System.out.println("Barnet hedder nu: " + b.getFornavn() + " " + b.getEfternavn());
                        }
                    }

                } else {
                }
                break;

            case "3":

                for (Born b : borneliste) {

                    if (b.getFornavn().equalsIgnoreCase(svarString2) && b.getEfternavn().equalsIgnoreCase(svarString3)) {


                        System.out.println("Barnets stue er lige nu: " + b.getStue());
                        System.out.println("Hvad ønsker du at ændre barnets stue til?");
                        b.setStue(input.nextLine());
                        System.out.println("Barnets stue er nu sat til: " + b.getStue());
                    }
                }
                break;

            case "4":

                for (Born b : borneliste) {

                    if (b.getFornavn().equalsIgnoreCase(svarString2) && b.getEfternavn().equalsIgnoreCase(svarString3)) {


                        System.out.println("Barnets indskrivningsdato er lige nu: " + b.getDato());
                        System.out.println("Hvad ønsker du at ændre barnets indskrivingsdato til?");
                        b.setDato(input.nextLine());
                        System.out.println("Barnets indskrivningsdato er nu sat til: " + b.getDato());
                    }
                }
                break;


        }
    }
    void sletAlt() {

        int svar = 0;
        System.out.println("[1]: Vil du slette telefonliste\n[2]: Børneliste\n[3]: Begge?\n[4]: Tilbage");
        svar = input.nextInt();

        switch (svar) {

            case 1:
                telefonliste.clear();
                System.out.println("Telefonlisten er nu slettet");
                break;

            case 2:
                borneliste.clear();
                System.out.println("Børnelisten er nu slettet");
                break;

            case 3:
                telefonliste.clear();
                borneliste.clear();
                System.out.println("Telefonlisten og børnelisten er nu slettet");
                break;
            default:
        }

    }
    void redigerTelefon() {

        System.out.println("Hvad hedder forældren?");
        String svarString2 = input.nextLine();

        for (Born t : telefonliste) {

            if (t.getParent_Navn().equalsIgnoreCase(svarString2)) {

                System.out.println("Forældres telefon nummer er: " + t.getTelefon());
                System.out.println("Hvad ønsker du at ændre forældres telefon nummer til?");
                t.setTelefon(input.nextLine());
                System.out.println("Forældres telefon nummer er nu sat til: " + t.getTelefon());
            }
        }
    }

    public void sorterAlder() {
        borneliste.sort(Comparator.comparing(Born::getAlder));
    }
    public void sorterNavn() { telefonliste.sort(Comparator.comparing(Born::getParent_Navn));}

}
