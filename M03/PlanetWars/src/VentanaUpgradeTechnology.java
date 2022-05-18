import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;

public class VentanaUpgradeTechnology extends JFrame implements ActionListener , MouseListener, Variables {

    private JMenuBar menu;
    private JMenu ViewPlanetStats,Build,UpgradeTecnology,ViewBattleReports,Exit;
    private JMenuItem BuildDefense,BuildShips;
    private JPanel upgrade,atak,defe;

    private JPanel inicioAT,medioAT, finalAT;
    private JLabel imagenAT,nombreAT,precioAT,cantAT;

    private JPanel inicioDE,medioDE, finalDE;
    private JLabel imagenDE,nombreDE,precioDE,cantDE;

    private JTextField tCantAT,tCantDE;
    private JButton bCompraAT,bCompraDE;

    public VentanaUpgradeTechnology() {

        upgrade = new JPanel();
        atak = new JPanel();
        defe = new JPanel();

        this.add(upgrade);
        upgrade.setLayout(new BoxLayout(upgrade, BoxLayout.X_AXIS));

        upgrade.add(atak);
        atak.setLayout(new BoxLayout(atak, BoxLayout.Y_AXIS));

        upgrade.add(defe);
        defe.setLayout(new BoxLayout(defe, BoxLayout.Y_AXIS));

        // Upgrade Atak

        imagenAT = new JLabel("");
        nombreAT = new JLabel("Atack Technology");
        precioAT = new JLabel("Precio: " + UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST);
        cantAT = new JLabel("Cantidad:");
        tCantAT = new JTextField(10);
        bCompraAT = new JButton("Comprar");
        bCompraAT.addActionListener(this);

        inicioAT = new JPanel();
        medioAT = new JPanel();
        finalAT = new JPanel();

        inicioAT.add(imagenAT);
        medioAT.add(nombreAT);
        medioAT.add(precioAT);
        finalAT.add(cantAT);
        finalAT.add(tCantAT);
        finalAT.add(bCompraAT);

        atak.add(inicioAT);
        atak.add(medioAT);
        atak.add(finalAT);

        // Upgrade Defens

        imagenDE = new JLabel("");
        nombreDE = new JLabel("Defense Technology");
        precioDE = new JLabel("Precio: " + UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST);
        cantDE = new JLabel("Cantidad:");
        tCantDE = new JTextField(10);
        bCompraDE = new JButton("Comprar");
        bCompraDE.addActionListener(this);

        inicioDE = new JPanel();
        medioDE = new JPanel();
        finalDE = new JPanel();

        inicioDE.add(imagenDE);
        medioDE.add(nombreDE);
        medioDE.add(precioDE);
        finalDE.add(cantDE);
        finalDE.add(tCantDE);
        finalDE.add(bCompraDE);

        defe.add(inicioDE);
        defe.add(medioDE);
        defe.add(finalDE);

        // Menu

        menu = new JMenuBar();

        ViewPlanetStats = new JMenu("<html><p style='text-align:center;width:150px;'>View Planet Stats</p></html>");
        Build = new JMenu("<html><p style='text-align:center;width:150px;'>Build");
        UpgradeTecnology = new JMenu("<html><p style='text-align:center;width:150px;'>Upgrade Technology");
        ViewBattleReports = new JMenu("<html><p style='text-align:center;width:150px;'>View Battle Reports");
        Exit = new JMenu("<html><p style='text-align:center;width:150px;'>Exit");

        BuildDefense = new JMenuItem("<html><p style='text-align:center;width:140px;'>Defense");
        BuildShips = new JMenuItem("<html><p style='text-align:center;width:140px;'>Ships");


        Build.add(BuildShips);
        Build.add(BuildDefense);

        menu.add(ViewPlanetStats);
        menu.add(Build);
        menu.add(UpgradeTecnology);
        menu.add(ViewBattleReports);
        menu.add(Exit);

        ViewPlanetStats.addMouseListener(this);
        ViewBattleReports.addMouseListener(this);
        Exit.addMouseListener(this);
        UpgradeTecnology.addMouseListener(this);

        BuildShips.addActionListener(this);
        BuildDefense.addActionListener(this);

        add(menu, BorderLayout.NORTH);
        menu.add(Box.createRigidArea(new Dimension(20,50)));
        //menu.setMargin(new Insets(0,50,0,50));

        this.setTitle("Planet Wars");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setSize(1024,768);
        this.setResizable(false);

        Toolkit pantalla = Toolkit.getDefaultToolkit();

        Dimension grandaria = pantalla.getScreenSize();
        int ancho = grandaria.width;
        int alto = grandaria.height;

        this.setLocation((ancho/2) - (this.getWidth() / 2), (alto / 2) - (this.getHeight() / 2));

        Image imagen = pantalla.getImage("./src/Planet Wars.png");

        this.setIconImage(imagen);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(BuildShips)) {
            VentanaBuildShip vbs = new VentanaBuildShip();
            vbs.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource().equals(BuildDefense)) {
            VentanaBuildDefense vbd = new VentanaBuildDefense();
            vbd.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource().equals(bCompraAT)) {
            try {
                Planet p = new Planet();
                int numeroAT = Integer.parseInt(tCantAT.getText());
                p.upgradeTechnologyAttack(numeroAT);
            } catch (ResourceException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource().equals(bCompraDE)) {
            try {
                Planet p = new Planet();
                int numeroDE = Integer.parseInt(tCantDE.getText());
                p.upgradeTechnologyDefense(numeroDE);
            } catch (ResourceException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e){
        if (e.getSource().equals(ViewPlanetStats)) {
            Main vps = new Main();
            vps.setVisible(true);
            this.setVisible(false);
        }
       
        if (e.getSource().equals(UpgradeTecnology)) {
            JOptionPane.showMessageDialog(null,"Ya estas en este menu","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource().equals(ViewBattleReports)) {
            VentanaViewBattleReports vvbr = new VentanaViewBattleReports();
            vvbr.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource().equals(Exit)) {
            System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
