import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

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
            
            // Conecta con la base de )datos orcl con el usuario system y la contrase�a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, "planet", "planet");

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
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
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
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call getPlanetDeuterium (?,?)}");

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
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
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
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);;

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            
            // Conecta con la base de datos orcl con el usuario system y la contrase�a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
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
		return "�";
	}
	public void setPlanetMetal(int planetID, int metalAdd)
	{
		int id = -1;
        Connection cn = null;

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            
            // Conecta con la base de datos orcl con el usuario system y la contrase�a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
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

            
            // Conecta con la base de datos orcl con el usuario system y la contrase�a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
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
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            
            // Conecta con la base de datos orcl con el usuario system y la contrase�a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
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
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            
            // Conecta con la base de datos orcl con el usuario system y la contrase�a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
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
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            
            // Conecta con la base de datos orcl con el usuario system y la contrase�a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
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
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            
            // Conecta con la base de datos orcl con el usuario system y la contrase�a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call getPlanetTechDef (?,?)}");

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
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            
            // Conecta con la base de datos orcl con el usuario system y la contrase�a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
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
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            
            // Conecta con la base de datos orcl con el usuario system y la contrase�a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
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
	
	public int getShip(int idShip) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getship(?,?)}");

            // Parametro 1 del procedimiento almacenado
            cst.setInt(1, idShip);

            // Se obtienen la salida del procedimineto almacenado
            cst.registerOutParameter(2, Types.INTEGER);

            // Ejecuta el procedimiento almacenado
            cst.execute();
            return cst.getInt(2);

    }
	public int getDef(int idDef) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getdef(?,?)}");

        // Parametro 1 del procedimiento almacenado
        cst.setInt(1, idDef);

        // Se obtienen la salida del procedimineto almacenado
        cst.registerOutParameter(2, Types.INTEGER);

        // Ejecuta el procedimiento almacenado
        cst.execute();
        return cst.getInt(2);

    }
	
	public void addBattleLog(int battleID, int userID, int userlighthunter_start, int userheavyhunter_start, int userbattleship_start, int userarmoredship_start, int usermissilelauncher_start,
			int userioncannon_start, int userplasmacannon_start, int enemielighthunter_start, int enemieheavyhunter_start, int enemiebattleship_start, int enemiearmoredship_start,
			int userlighthunter_end, int userheavyhunter_end, int userbattleship_end, int userarmoredship_end, int usermissilelauncher_end,
			int userioncannon_end, int userplasmacannon_end, int enemielighthunter_end, int enemieheavyhunter_end, int enemiebattleship_end, int enemiearmoredship_end) throws ClassNotFoundException, SQLException
	{ // pID in number, warshipID in number, shipCant in number, shipLvL in number
        int id = -1;
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            
            // Conecta con la base de datos orcl con el usuario system y la contrase�a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call addBattleLog (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            do {
                // Parametro 1 del procedimiento almacenado
                cst.setInt(1, battleID);
                cst.setInt(2, userID);
                
                cst.setInt(3, userlighthunter_start);
                cst.setInt(4, userheavyhunter_start);
                cst.setInt(5, userbattleship_start);
                cst.setInt(6, userarmoredship_start);
                cst.setInt(7, usermissilelauncher_start);
                cst.setInt(8, userioncannon_start);
                cst.setInt(9, userplasmacannon_start);
                
                cst.setInt(10, enemielighthunter_start);
                cst.setInt(11, enemieheavyhunter_start);
                cst.setInt(12, enemiebattleship_start);
                cst.setInt(13, enemiearmoredship_start);
                
                cst.setInt(14, userlighthunter_end);
                cst.setInt(15, userheavyhunter_end);
                cst.setInt(16, userbattleship_end);
                cst.setInt(17, userarmoredship_end);
                cst.setInt(18, usermissilelauncher_end);
                cst.setInt(19, userioncannon_end);
                cst.setInt(20, userplasmacannon_end);
                
                cst.setInt(21, enemielighthunter_end);
                cst.setInt(22, enemieheavyhunter_end);
                cst.setInt(23, enemiebattleship_end);
                cst.setInt(24, enemiearmoredship_end);
                
                
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
	public void addLog(int battleID, int planetID, int turn, String log) throws ClassNotFoundException, SQLException
	{ // pID in number, warshipID in number, shipCant in number, shipLvL in number
        int id = -1;
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            
            // Conecta con la base de datos orcl con el usuario system y la contrase�a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call addLog (?,?,?,?)}");

            do {
                // Parametro 1 del procedimiento almacenado
                cst.setInt(1, battleID);
                cst.setInt(2, planetID);
                cst.setInt(3, turn);
                cst.setString(4, log);
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

	public int getLastBattle(int planetID) throws ClassNotFoundException, SQLException
	{ // pID in number, warshipID in number, shipCant in number, shipLvL in number
        int id = -1;
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());


            // Conecta con la base de datos orcl con el usuario system y la contrase�a password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call getLastIDBattle (?,?)}");

            do {
                // Parametro 1 del procedimiento almacenado
                cst.setInt(1, planetID);
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

    public int getIdBattle(int idRowBat) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getIdBattle(?,?)}");

        cst.setInt(1,idRowBat);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);

    }

    public int getbLogStartLH(int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getbLogStartLH(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public int getbLogStartHH(int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getbLogStartHH(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public int getbLogStartBS(int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getbLogStartBS(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public int getbLogStartAS(int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getbLogStartAS(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public int getbLogStartML(int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getbLogStartML(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public int getbLogStartIC(int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getbLogStartIC(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public int getbLogStartPC(int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getbLogStartPC(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public int getbEnemiLogStartLH(int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getbEnemiLogStartLH(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public int getbEnemiLogStartHH(int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getbEnemiLogStartHH(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public int getbEnemiLogStartBS(int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getbEnemiLogStartBS(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public int getbEnemiLogStartAS(int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getbEnemiLogStartAS(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    //End

    public int getbLogEndLH(int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getbLogEndLH(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public int getbLogEndHH(int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getbLogEndHH(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public int getbLogEndBS(int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getbLogEndBS(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public int getbLogEndAS(int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getbLogEndAS(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public int getbLogEndML(int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getbLogEndML(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public int getbLogEndIC(int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getbLogEndIC(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public int getbLogEndPC(int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getbLogEndPC(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public int getbEnemiLogEndLH(int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getbEnemiLogEndLH(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public int getbEnemiLogEndHH(int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getbEnemiLogEndHH(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public int getbEnemiLogEndBS(int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getbEnemiLogEndBS(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public int getbEnemiLogEndAS(int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getbEnemiLogEndAS(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public void addWastGen(int idBatle, int metal, int deuterium) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call addWastGen(?,?,?)}");

        cst.setInt(1,idBatle);
        cst.setInt(2,metal);
        cst.setInt(3,deuterium);

        cst.execute();

    }

    public int getWastMetal (int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getWastMetal(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }
    public int getWastDeuterium (int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getWastDeuterium(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public void addCostArmy(int idBatle, int uMetal, int uDeuterium, int eMetal, int eDeuterium) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call addCostArmy(?,?,?,?,?)}");

        cst.setInt(1,idBatle);
        cst.setInt(2,uMetal);
        cst.setInt(3,uDeuterium);
        cst.setInt(4,eMetal);
        cst.setInt(5,eDeuterium);

        cst.execute();

    }

    public int getCostArmyMetal (int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getCostArmyMetal(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public int getCostArmyDeuterium (int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getCostArmyDeuterium(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public int getCostEnemyArmyMetal (int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getCostEnemyArmyMetal(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

    public int getCostEnemyArmyDeuterium (int idBatle) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@" + BD_PROJECT_IP + BD_PROJECT_PORT_AND_SID, BD_PROJECT_NAME, BD_PROJECT_PASSWORD);

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        CallableStatement cst = cn.prepareCall("{call getCostEnemyArmyDeuterium(?,?)}");

        cst.setInt(1,idBatle);

        cst.registerOutParameter(2,Types.INTEGER);

        cst.execute();
        return cst.getInt(2);
    }

}
