import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDatos implements Variables{
	
	public static void main(String[] args) {
		BaseDatos bd = new BaseDatos();
		bd.getPlanetName(1);
	}
	
	public CallableStatement getShipValues(int idShip) {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int id = -1;
        Connection cn = null;
        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            
            // Conecta con la base de )datos orcl con el usuario system y la contrase�a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + ":1521:xe", "planet", "planet");

            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call getshipvalues (?,?,?,?,?,?,?,?,?,?)}");

            do {
                System.out.println("\nIntroduce el ID de la nave:");
                try {
                    id = Integer.parseInt(entrada.readLine());
                } catch (IOException ex) {
                    System.out.println("Error...");
                }
                
                // Parametro 1 del procedimiento almacenado
                cst.setInt(1, id);
                
                // Se obtienen la salida del procedimineto almacenado
                cst.registerOutParameter(2, java.sql.Types.VARCHAR);
                cst.registerOutParameter(3, java.sql.Types.INTEGER);
                cst.registerOutParameter(4, java.sql.Types.INTEGER);
                cst.registerOutParameter(5, java.sql.Types.INTEGER);
                cst.registerOutParameter(6, java.sql.Types.INTEGER);
                cst.registerOutParameter(7, java.sql.Types.INTEGER);
                cst.registerOutParameter(8, java.sql.Types.INTEGER);
                cst.registerOutParameter(9, java.sql.Types.INTEGER);
                cst.registerOutParameter(10, java.sql.Types.INTEGER);
                
                // Ejecuta el procedimiento almacenado
                cst.execute();
            	return cst;
            } while (id > 0);

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
		return null;
		
	}
	public int checkUserPlanet (String nameUser) {
        int id = -1;
        Connection cn = null;

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            
            // Conecta con la base de datos orcl con el usuario system y la contrase�a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + ":1521:xe", BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call checkUserPlanet (?,?)}");

            do {
                // Parametro 1 del procedimiento almacenado
                cst.setString(1, nameUser);
                
                // Se obtienen la salida del procedimineto almacenado
                cst.registerOutParameter(2, java.sql.Types.INTEGER);
                
                // Ejecuta el procedimiento almacenado
                cst.execute();
            	return cst.getInt(2);
            } while (id > 0);

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
		return 0;
	}
	public int getPlanetDeuterium (int planetID) {
        int id = -1;
        Connection cn = null;

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            
            // Conecta con la base de datos orcl con el usuario system y la contrase�a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + ":1521:xe", BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call getDeuterium (?,?)}");

            do {
                // Parametro 1 del procedimiento almacenado
                cst.setInt(1, planetID);
                
                // Se obtienen la salida del procedimineto almacenado
                cst.registerOutParameter(2, java.sql.Types.INTEGER);
                
                // Ejecuta el procedimiento almacenado
                cst.execute();
            	return cst.getInt(2);
            } while (id > 0);

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
		return 0;
	}
	public int getPlanetMetal (int planetID) {
        int id = -1;
        Connection cn = null;

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            
            // Conecta con la base de datos orcl con el usuario system y la contrase�a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + ":1521:xe", BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call getMetal (?,?)}");

            do {
                // Parametro 1 del procedimiento almacenado
                cst.setInt(1, planetID);
                
                // Se obtienen la salida del procedimineto almacenado
                cst.registerOutParameter(2, java.sql.Types.INTEGER);
                
                // Ejecuta el procedimiento almacenado
                cst.execute();
            	return cst.getInt(2);
            } while (id > 0);

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
		return 0;
	}
	public String getPlanetName(int planetID)
	{
		Connection cn = null;
		String querySql="SELECT NAMEPLANET FROM planet WHERE id_planet = " + planetID;
        try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			// Conecta con la base de datos orcl con el usuario system y la contrase�a password
	        cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + ":1521:xe", BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
	        //Statement pstmnt=cn.prepareStatement(querySql);
	        Statement stmt = cn.createStatement();
	        ResultSet rsPstmnt=stmt.executeQuery(querySql);
	        /*
	         *             //save the select statement in a string
            String selectStat="SELECT * FROM product";
            String selectProduct="SELECT pid, pname from product where price>20";
            //stmt.executeUpdate(selectStat);

            //create a result set
            ResultSet rows = stmt.executeQuery(selectStat);
            ResultSet rows1= stmt.executeQuery(selectProduct);

            //stmt.executeQuery(selectStat);
	         * 
	         * 
	         * 
	         */
	        
	        
	        rsPstmnt.first();
	        	System.out.println(rsPstmnt.getString(1));
	        
        } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return querySql;
	}
} // checkUserPlanet (nameUser in varchar, planetID out number)
