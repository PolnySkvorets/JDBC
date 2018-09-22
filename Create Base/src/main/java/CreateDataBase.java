import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDataBase {
    // jdbc драйвер и ссылка на базу данных
    static final String JDBC_DRIVER = " com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/?useSSL=false";

    //доступ к базе данных
    public static final String USER = "root";
    public static final String  PASS = "rjirf_ljcz";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try{
            //регистрируем jdbc драйвер
            Class.forName("com.mysql.cj.jdbc.Driver");

            //открываем соединение
            System.out.println(" Соединение с базой данных ...");
            conn = DriverManager.getConnection(DB_URL, USER , PASS);

            //выполняем запрос
            System.out.println("Создание базы данных...");
            stmt = conn.createStatement();

            String sql = "CREATE DATABASE newbigbase";
            stmt.executeUpdate(sql);
            System.out.println("База данных успешно создана");

        } catch (SQLException e) {
            System.out.println("исключение");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if(conn != null)
                    conn.close();

            }
            catch (SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("База закрыта");
    }
}
