import java.io.FileNotFoundException;
import java.util.*;

class Menu {

    void menu() throws FileNotFoundException {

        Scanner scan = new Scanner(System.in);

        //Instantierer logind klassen for at senere at kører metoden for at afgøre hvorvidt det er en leder eller ansat til at beslutte menuens valgmuligheder
        Logind bruger = new Logind();
        bruger.Logind();
        BornHaandtering bH = new BornHaandtering();

        boolean go = true;

        bH.indlesBorn();
        bH.visBarn();

        while (go) {

            try {

                int svar = 0;
                System.out.println("1: Telefon liste \n2: Indskrevet børn\n3: Hjælp\n4: Sluk program");
                svar = scan.nextInt();

                switch (svar) {

                    case 1:
                        if (bruger.getStatus().equals("Leder")) {
                            //!MANGLER rediger og vis telefon liste
                            System.out.println("1");
                        } else if (bruger.getStatus().equals("Ansat")) {
                            //!MANGLER vis telefon liste
                        }
                        break;
                    case 2:
                        if (bruger.getStatus().equals("Leder")) {
                            //!MANGLER rediger børn

                            System.out.println("1: Opret barn\n2: Vis børn\n3: Fjern børn\n4: Tilbage");
                            if(scan.nextInt() == 1) {
                                bH.indlesBorn();

                            }
                            else if (scan.nextInt() == 2){
                                bH.visBarn();

                            }
                            else if(scan.nextInt() == 3){
                                bH.fjernBarn();

                            }
                            else if(scan.nextInt() == 4){
                                // tilbage til menu
                            }
                        } else if (bruger.getStatus().equals("Ansat")) {
                            System.out.println("1: vis børn \n2: Tilbage");
                            if(scan.nextInt() == 1) {
                                bH.visBarn();
                            }
                            if(scan.nextInt() == 1) {
                                // tilbage til menu
                            }
                        }
                        break;
                    case 3:
                        if (bruger.getStatus().equals("Leder")) {
                            System.out.println("Som leder kan du redigere telefon listen og redigere i informationen om de indskrevne børn, samt tilføje flere børn eller slette børn.");
                            System.out.println("Du har også mulighed for at bare at se enten telefon listen eller de indskrevne børn.");
                            VisitKort();

                        } else if (bruger.getStatus().equals("Ansat")) {
                            System.out.println("Som ansat kan du se telefon listen og se indskrevne børn.");
                            VisitKort();
                        }
                        break;
                    case 4:
                        System.out.println("Farvel");
                        go = false;
                        break;
                    default:
                        System.out.println("Venligst indtast nummer indenfor funktionslisten");
                }
            } catch (InputMismatchException e){
                System.out.println("Venligst indtast kun numre tilsvarende til den funktion du prøver at tilgå");
                scan.nextLine();
            }
        }
    }

    //Intellij brokkede sig over at der var duplikeret kode..
    private void VisitKort(){
        System.out.println("Skulle der være spørgsmål eller fejl kan du kontakte 'Gruppe Pizza' på");
        System.out.println("\t\t-------------------------------");
        System.out.println("\t\t|        55 55 55 55          |");
        System.out.println("\t\t|        falsk@email.dk       |");
        System.out.println("\t\t-------------------------------\n\n");
    }
}
