import java.sql.*;

public class Main {
    // JDBC драйвер и URL базы данных
    static final  String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/EMP?useSSL=false";

    //параметры базы данных
    static  final String USER = "root";
    static final String PASS = "rjirf_ljcz";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try{

            //регистрируем jdbc драйвер
            Class.forName("com.mysql.jdbc.Driver");

            // Открываем соединенеие
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Выполняем запрос
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, first, last, age FROM Employees";
            ResultSet rs = stmt.executeQuery(sql);

            //извлекаем данные из результирующего множества
            while (rs.next()){
                //возврат по названию столбцов
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                // вывод значений
                System.out.print("ID:" + id);
                System.out.print(", Age:" + age );
                System.out.print(", First:" + first);
                System.out.println(", Last:" + last);
            }

            //очистка
            rs.close();
            stmt.close();
            conn.close();

        }
        catch (SQLException se){
            se.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {

            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}