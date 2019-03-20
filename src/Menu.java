import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

class Menu {

    void menu() throws FileNotFoundException, IOException {

        Scanner input = new Scanner(System.in);

        //Instantierer logind klassen for at senere at kører metoden for at afgøre hvorvidt det er en leder eller ansat til at beslutte menuens valgmuligheder
        Logind bruger = new Logind();
        bruger.Logind();
        BornHaandtering bH = new BornHaandtering();

        boolean go = true;
        bH.indlesBorn();

        while (go) {

            try {

                int svar = 0;
                System.out.println();
                System.out.println("[1]: Telefon liste \n[2]: Indskrevet børn\n[3]: Hjælp\n[4]: Slet lister\n[5]: Sluk program");

                System.out.print("\nInput: ");
                svar = input.nextInt();

                switch (svar) {

                    case 1:
                        if (bruger.getStatus().equals("Leder")) {
                            bH.visTelefonliste();
                            //!MANGLER rediger telefon liste
                            System.out.println("1");
                        } else if (bruger.getStatus().equals("Ansat")) {
                            bH.visTelefonliste();
                        } break;

                    case 2:
                        svar = 0;

                        if (bruger.getStatus().equals("Leder")) {
                            //!MANGLER rediger børn

                            System.out.println("[1]: Opret barn\n[2]: Vis børn\n[3]: Rediger barn\n[4]: Slet barn\n[5]: Tilbage");
                            svar = input.nextInt();
                            if(svar == 1) {
                                bH.opretBarn();

                            }
                            else if (svar == 2){
                                bH.visBarn();

                            }
                            else if (svar == 3){
                                bH.redigerBarn();
                                bH.filoverskrivning();

                            }
                            else if(svar == 4){
                                bH.sletBarn();

                            }
                            else if(svar == 5){
                                System.out.println("\n\n\n\n\n");
                            }
                        } else if (bruger.getStatus().equals("Ansat")) {
                            System.out.println("[1]: Se børn \n[2]: Tilbage");
                            svar = input.nextInt();
                            if (svar == 1) {
                                bH.visBarn();
                            } else if (svar == 2) {
                                System.out.println("\n\n\n\n\n");
                            }
                        } break;

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
                        bH.sletAlt();
                        bH.filoverskrivning();
                        System.out.println("Du har nu slettet listerne");
                        break;
                    case 5:
                        System.out.println("Farvel");
                        go = false;
                        break;
                    default:
                        System.out.println("Venligst indtast nummer indenfor funktionslisten");
                }
            } catch (InputMismatchException e){
                System.out.println("Venligst indtast kun numre tilsvarende til den funktion du prøver at tilgå");
                input.nextLine();
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
