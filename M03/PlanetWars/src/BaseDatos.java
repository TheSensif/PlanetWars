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
	}
	
	public CallableStatement getShipValues(int idShip) {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int id = -1;
        Connection cn = null;
        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            
            // Conecta con la base de )datos orcl con el usuario system y la contraseï¿½a password
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

            
            // Conecta con la base de datos orcl con el usuario system y la contraseï¿½a password
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

            
            // Conecta con la base de datos orcl con el usuario system y la contraseï¿½a password
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

            
            // Conecta con la base de datos orcl con el usuario system y la contraseï¿½a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + ":1521:xe", BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call getPlanetMetal (?,?)}");

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
	public String getPlanetName(int planetID) throws ClassNotFoundException, SQLException
	{
        int id = -1;
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + ":1521:xe", BD_PROJECT_NAME, BD_PROJECT_PASSWORD);;

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            
            // Conecta con la base de datos orcl con el usuario system y la contraseï¿½a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + ":1521:xe", BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call getPlanetName (?,?)}");

            do {
                // Parametro 1 del procedimiento almacenado
                cst.setInt(1, planetID);
                
                // Se obtienen la salida del procedimineto almacenado
                cst.registerOutParameter(2, java.sql.Types.VARCHAR);
                
                // Ejecuta el procedimiento almacenado
                cst.execute();
            	return cst.getString(2);
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
		return "º";
	}
	public void setPlanetMetal(int planetID, int metalAdd)
	{
		int id = -1;
        Connection cn = null;

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            
            // Conecta con la base de datos orcl con el usuario system y la contraseï¿½a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + ":1521:xe", BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call setplanetmetal (?)}");

            do {
                cst.setInt(1, metalAdd);
                cst.execute();
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
	}
	public void setPlanetDeuterium(int planetID, int metalAdd)
	{
		int id = -1;
        Connection cn = null;

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            
            // Conecta con la base de datos orcl con el usuario system y la contraseï¿½a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + ":1521:xe", BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call setplanetdeuterium (?)}");

            do {
                cst.setInt(1, metalAdd);
                cst.execute();
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
	}
	
	public void setPlanetAtkTech(int planetID, int techCant) throws ClassNotFoundException, SQLException
	{
        int id = -1;
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + ":1521:xe", BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            
            // Conecta con la base de datos orcl con el usuario system y la contraseï¿½a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + ":1521:xe", BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call setPlanetTechAtk (?,?)}");

            do {
                // Parametro 1 del procedimiento almacenado
                cst.setInt(1, planetID);
                cst.setInt(2, techCant);
                cst.execute();
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
	}
	public int getPlanetAtkTech(int planetID) throws ClassNotFoundException, SQLException
	{
        int id = -1;
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + ":1521:xe", BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            
            // Conecta con la base de datos orcl con el usuario system y la contraseï¿½a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + ":1521:xe", BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call getPlanetTechAtk (?,?)}");

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
	public void setPlanetDefTech(int planetID, int techCant) throws ClassNotFoundException, SQLException
	{
        int id = -1;
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + ":1521:xe", BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            
            // Conecta con la base de datos orcl con el usuario system y la contraseï¿½a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + ":1521:xe", BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call setPlanetTechDef (?,?)}");

            do {
                // Parametro 1 del procedimiento almacenado
                cst.setInt(1, planetID);
                cst.setInt(2, techCant);
                cst.execute();
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
	}
	public int getPlanetDefTech(int planetID) throws ClassNotFoundException, SQLException
	{
        int id = -1;
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + ":1521:xe", BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            
            // Conecta con la base de datos orcl con el usuario system y la contraseï¿½a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + ":1521:xe", BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call getPlanetTechAtk (?,?)}");

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
	
	public void addShip(int planetID, int warshipID, int shipCant, int shipLevel) throws ClassNotFoundException, SQLException
	{ // pID in number, warshipID in number, shipCant in number, shipLvL in number
        int id = -1;
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + ":1521:xe", BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            
            // Conecta con la base de datos orcl con el usuario system y la contraseï¿½a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + ":1521:xe", BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call addShip (?,?,?,?)}");

            do {
                // Parametro 1 del procedimiento almacenado
                cst.setInt(1, planetID);
                cst.setInt(2, warshipID);
                cst.setInt(3, shipCant);
                cst.setInt(4, shipLevel);
                // Ejecuta el procedimiento almacenado
                cst.execute();
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
	}
	public void addDefense(int planetID, int defenseID, int defenseCant, int defenseLevel) throws ClassNotFoundException, SQLException
	{ // pID in number, warshipID in number, shipCant in number, shipLvL in number
        int id = -1;
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + ":1521:xe", BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            
            // Conecta con la base de datos orcl con el usuario system y la contraseï¿½a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + ":1521:xe", BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call addDefense (?,?,?,?)}");

            do {
                // Parametro 1 del procedimiento almacenado
                cst.setInt(1, planetID);
                cst.setInt(2, defenseID);
                cst.setInt(3, defenseCant);
                cst.setInt(4, defenseLevel);
                // Ejecuta el procedimiento almacenado
                cst.execute();
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
	}
	
	
}
