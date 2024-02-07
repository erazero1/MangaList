import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataBaseFunctions db = new DataBaseFunctions();
        Connection connection = db.connectionToDB("postgres", "postgres", "1234");
//        db.createTable(connection, "Manga");
//        Manga manga = new Manga("One Piece", "Eiichiro Oda", "1997", "Ongoing", "1112", "9.79");
//        Manga manga = new Manga("Dragon Ball Kanzenban", "Toriyama Akira", "1984", "Ended", "519", "9.49");
//        Manga manga = new Manga("Hunter x Hunter", "Togashi Yoshihiro", "1998", "Paused", "409", "9.80");
//        Manga manga = new Manga("Naruto", "Masashi Kishimoto", "1999", "Ended", "702", "9.51");
//        Manga manga = new Manga("Fullmetal Alchemist", "Arakawa Hiromu", "2001", "Ended", "111", "9.82");
//        Manga manga = mangaCreate();
//        db.insertRow(connection, "Manga", manga);
//        db.readData(connection, "manga");

        int choice = 0;
        String columnName, targetValue, oldName, newName, titleName;

        while(choice != 6){
            System.out.println("\t~1. Add manga\n" +
                "\t~2.Delete manga\n" +
                "\t~3.Update data\n" +
                "\t~4.Read all data\n" +
                "\t~5.Search\n" +
                "\t~6.Stop\n");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Manga manga = mangaCreate();
                    db.insertRow(connection, "Manga", manga);
                    break;
                case 2:
                    System.out.println("Enter the name of the title: ");
                    titleName = scanner.next();
                    db.deleteByTitle(connection, "manga", titleName);
                    break;
                case 3:
                    System.out.println("The name of the column: ");
                    columnName = scanner.next();
                    System.out.println("Enter the old name: ");
                    oldName = scanner.next();
                    System.out.println("Enter the new name: ");
                    newName = scanner.next();
                    db.updateData(connection, "Manga", columnName, oldName, newName);
                    break;
                case 4:
                    db.readData(connection, "Manga");
                    break;
                case 5:
                    System.out.println("Column name: ");
                    columnName = scanner.next();
                    System.out.println("Target value: ");
                    targetValue = scanner.next();
                    db.searchData(connection, "Manga", columnName, targetValue);
                    break;
            }
        }


    }

    public static Manga mangaCreate() {
        Scanner scanner = new Scanner(System.in);
        String title, author, yearOfRelease, titleStatus, amountOfChapters, rating;

        System.out.println("Title: ");
        title = scanner.nextLine();
        System.out.println("Author:");
        author = scanner.nextLine();
        System.out.println("Year of release: ");
        yearOfRelease = scanner.nextLine();
        System.out.println("Title status(Ongoing, Paused, Ended): ");
        titleStatus = scanner.nextLine();
        System.out.println("Amount of chapters: ");
        amountOfChapters = scanner.nextLine();
        System.out.println("Rating: ");
        rating = scanner.nextLine();
        return new Manga(title, author, yearOfRelease, titleStatus, amountOfChapters, rating);
    }
}
