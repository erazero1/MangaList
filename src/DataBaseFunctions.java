import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseFunctions {
    Statement statement;
    public Connection connectionToDB(String DBName, String user, String password){
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DBName, user, password);
            if (connection != null){
                System.out.println("Connection Established");
            }else{
                System.out.println("Connection Failed");
            }
        }catch (Exception e){
            System.out.println("Exception is: " + e);
        }
        return connection;
    }

    public void createTable(Connection connection, String tableName){
        try {
            String query = "create table " + tableName + "( mangaID SERIAL, title varchar(255), author varchar(255), yearOfRelease INT, titleStatus varchar(255), amountOfChapters varchar(255), rating varchar(255), PRIMARY KEY(mangaID));";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created");
        }catch (Exception e){
            System.out.println("Exception: " + e);
        }
    }

    public void insertRow(Connection connection, String tableName, Manga manga){
        try {
            String query = String.format("insert into %s(title, author, yearOfRelease, titleStatus, amountOfChapters, rating) values ('%s', '%s', '%s', '%s', '%s', '%s')", tableName, manga.getTitle(), manga.getAuthor(), manga.getYearOfRelease(), manga.getTitleStatus(), manga.getAmountOfChapters(), manga.getRating());
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void readData(Connection connection, String tableName){
        ResultSet resultSet = null;
        try {
            String query = String.format("select * from %s order by mangaid asc", tableName);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            System.out.println("-----------------------------------------------------------------------------------------------");
            while (resultSet.next()){
                System.out.print(resultSet.getString("mangaID") + " | ");
                System.out.print(resultSet.getString("title") + " | ");
                System.out.print(resultSet.getString("author") + " | ");
                System.out.print(resultSet.getString("yearOfRelease") + " | ");
                System.out.print(resultSet.getString("titleStatus") + " | ");
                System.out.print(resultSet.getString("amountOfChapters") + " | ");
                System.out.println(resultSet.getString("rating") + " | ");
                System.out.println("-----------------------------------------------------------------------------------------------");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void updateData(Connection connection, String tableName, String columnName,String oldName, String newName){
        try {
            String query = String.format("update %s set %s='%s' where %s='%s'", tableName, columnName, newName, columnName, oldName);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data updated");
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void searchData(Connection connection, String tableName, String columnName, String targetValue){
        ResultSet resultSet = null;
        try {
            String query = String.format("select * from %s where %s = '%s' order by mangaid asc", tableName, columnName, targetValue);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            System.out.println("-----------------------------------------------------------------------------------------------");
            while (resultSet.next()){
                System.out.print(resultSet.getString("mangaID") + " | ");
                System.out.print(resultSet.getString("title") + " | ");
                System.out.print(resultSet.getString("author") + " | ");
                System.out.print(resultSet.getString("yearOfRelease") + " | ");
                System.out.print(resultSet.getString("titleStatus") + " | ");
                System.out.print(resultSet.getString("amountOfChapters") + " | ");
                System.out.println(resultSet.getString("rating") + " | ");
                System.out.println("-----------------------------------------------------------------------------------------------");
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void deleteByTitle(Connection connection, String tableName, String titleName){
        try {
            String query = String.format("delete from %s where title = '%s'", tableName, titleName);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Title deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
