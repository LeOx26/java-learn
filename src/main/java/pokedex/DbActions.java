package pokedex;

import java.sql.*;

public class DbActions {

    static String status = "Conexion no exitosa";

    public static String carga(String q){
        Connection c;
        Statement stmt;
        String status = "Carga Fallida";
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/pokedex",
                    "postgres",
                    "postgres"
            );
            c.setAutoCommit(false);
            stmt = c.createStatement();
            stmt.executeUpdate(q);
            stmt.close();
            c.commit();
            c.close();
            status = "Carga exitosa";

        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            status = e.getClass().getName()+": "+e.getMessage();
        }
        return status;



    }


}
