import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Script {
    ArrayList<String> content;
    ArrayList<String> workingHours;
    File file;
    String filename;
    String date;
    String firstname;
    String lastname;
    String scolarYear;
    String university;
    String parcours;
    Scanner scanner;

    public Script( String firstname, String lastname, String parcours, String scholarYear, String university) {
        this.content = new ArrayList<String>();
        this.workingHours = new ArrayList<String>();
        this.date = ("" + LocalDate.now().getDayOfMonth() + "_" + LocalDate.now().getMonthValue() + "_" + LocalDate.now().getYear());
        this.filename = "rapport_" + date + ".txt";
        this.file = new File(filename);
        this.firstname = firstname;
        this.lastname = lastname;
        this.scolarYear = scholarYear;
        this.parcours = parcours;
        this.university = university;
        this.scanner = new Scanner(System.in);
    }

    public void addContent(String newContent) {
        this.content.add(newContent);
    }


    public void writeRapport() {
        try {
            FileWriter fileWriter = new FileWriter(filename);
            //Intro
            fileWriter.write("  ____                              _   \n" +
                    " |  _ \\ __ _ _ __  _ __   ___  _ __| |_ \n" +
                    " | |_) / _` | '_ \\| '_ \\ / _ \\| '__| __|\n" +
                    " |  _ < (_| | |_) | |_) | (_) | |  | |_ \n" +
                    " |_| \\_\\__,_| .__/| .__/ \\___/|_|   \\__|\n" +
                    "            |_|   |_|                   ");

            fileWriter.write("\n\n\n------------------\n");
            fileWriter.write(date);
            fileWriter.write("\n------------------\n");
            fileWriter.write("Horaires de travail: \n");
            if (!this.workingHours.isEmpty()) {
                for (String workinghour: workingHours
                     ) {
                    fileWriter.write("\n- " + workinghour);
                }
            }
            fileWriter.write("\n\n------------------\n");
            fileWriter.write("Ce qui a été fait aujourd'hui: \n");
            if (!this.content.isEmpty()) {
                for (String content : this.content
                ) {
                    fileWriter.write("\n- " + content);
                }
            }
            fileWriter.write("\n\n------------------\n");
            fileWriter.write(firstname + " " + lastname + "\n" + parcours + " " + scolarYear + "\n" + university);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillWorkingHours() {
        System.out.println("You worked from when to when?");
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.isEmpty()) {
                break;
            }
            else {
                workingHours.add(nextLine);
                System.out.println("\nOkay, it's been added to your working hours, what next? Press <Return> whenever you want to stop adding fields!\n");
            }
        }
        System.out.println("Heures de travail remplie, bye");
        System.out.println("\n----------------------------------");
    }

    public void fillContent() {
        System.out.println("                                                                                              \n" +
                "                                                                                              \n" +
                "  ______ ______ ______ ______ ______ ______ ______ ______ ______ ______ ______ ______ ______  \n" +
                " |______|______|______|______|______|______|______|______|______|______|______|______|______| \n" +
                " | |  __ \\                            | |    / ____|                         | |           | |\n" +
                " | | |__) |__ _ _ __  _ __   ___  _ __| |_  | |  __  ___ _ __   ___ _ __ __ _| |_ ___  _ __| |\n" +
                " | |  _  // _` | '_ \\| '_ \\ / _ \\| '__| __| | | |_ |/ _ \\ '_ \\ / _ \\ '__/ _` | __/ _ \\| '__| |\n" +
                " | | | \\ \\ (_| | |_) | |_) | (_) | |  | |_  | |__| |  __/ | | |  __/ | | (_| | || (_) | |  | |\n" +
                " | |_|  \\_\\__,_| .__/| .__/ \\___/|_|   \\__|  \\_____|\\___|_| |_|\\___|_|  \\__,_|\\__\\___/|_|  | |\n" +
                " | |           | |   | |                                                                   | |\n" +
                " |_|____ ______|_|___|_|_____ ______ ______ ______ ______ ______ ______ ______ ______ _____|_|\n" +
                " |______|______|______|______|______|______|______|______|______|______|______|______|______| ");
        fillWorkingHours();
        System.out.println("\nSoooo what have you done today? Press <Return> whenever you want to stop adding fields!\n");
        while (scanner.hasNextLine()) {
            String nextline = scanner.nextLine();
            if(nextline.isEmpty()){
                break;
            }
            else {
                content.add(nextline);
                System.out.println("\nOkay, it's been added to your report, what next ? Press <Return> whenever you want to stop adding fields !\n");
            }
        }
        System.out.println("Contenu remplie, bye");
        System.out.println("----------------------------------");
        scanner.close();
    }

    public static void main(String[] args) {
        Script script = new Script("X", "Y","L3 Informatique", "Année 2021/2022", "Université de Poitiers");
        script.fillContent();
        script.writeRapport();
        System.out.println("Rapport generé, bye");
    }
}
