import java.util.*;

public class Menu {

    public void menu() {

        Scanner scan = new Scanner(System.in);
        Logind bruger = new Logind();
        boolean go = true;

        bruger.Logind();


        while (go) {


            try {




                int svar = 0;
                System.out.println("1: Telefon liste \n2: Indskrevet børn\n3: Hjælp\n4: Sluk program");
                svar = scan.nextInt();

                switch (svar) {

                    case 1:
                        if (bruger.getStatus().equals("Leder")) {
                            // rediger og vis telefon liste
                            System.out.println("1");
                        } else if (bruger.getStatus().equals("Ansat")) {
                            //vis telefon liste
                        }
                        break;
                    case 2:
                        if (bruger.getStatus().equals("Leder")) {
                            // rediger børn
                            // vis børn
                            // slet børn
                            System.out.println("2");
                        } else if (bruger.getStatus().equals("Ansat")) {
                            // vis børn
                        }
                        break;
                    case 3:
                        if (bruger.getStatus().equals("Leder")) {
                            System.out.println("Som leder kan du redigere telefon listen og redigere i informationen om de indskrevne børn, samt tilføje flere børn eller slette børn.");
                            System.out.println("Du har også mulighed for at bare at se enten telefon listen eller de indskrevne børn.");
                            System.out.println("Skulle der være spørgsmål eller fejl kan du kontakte 'Gruppe Pizza' på");
                            System.out.println("\t\t-------------------------------");
                            System.out.println("\t\t|        55 55 55 55          |");
                            System.out.println("\t\t|        falsk@email.dk       |");
                            System.out.println("\t\t-------------------------------\n\n");
                        } else if (bruger.getStatus().equals("Ansat")) {
                            //vis telefon liste
                        }
                        break;
                    case 4:
                        System.out.println("Farvel");
                        go = false;
                    default:
                        System.out.println("Venligst indtast nummer indenfor funktionslisten");
                }
            } catch (InputMismatchException e){
                System.out.println("Venligst indtast kun numre tilsvarende til den funktion du prøver at tilgå");
                scan.nextLine();
            }
        }
    }
}
