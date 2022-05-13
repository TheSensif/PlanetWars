import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class VentanaBuildDefense extends JFrame implements ActionListener , MouseListener {

    private JMenuBar menu;
    private JMenu ViewPlanetStats,Build,UpgradeTecnology,ViewBattleReports,Exit;
    private JMenuItem BuildDefense,BuildShips;
    private JPanel defensa,arriba,abajo,missileLauncher,ionCannon,plasmaCannon;

    private JPanel inicioMS,medioMS, finalMS;
    private JLabel imagenMS,nombreMS,precioMS,cantMS;

    private JPanel inicioIC,medioIC, finalIC;
    private JLabel imagenIC,nombreIC,precioIC,cantIC;

    private JPanel inicioPC,medioPC, finalPC;
    private JLabel imagenPC,nombrePC,precioPC,cantPC;

    private JTextField tCantMS,tCantIC,tCantPC;
    private JButton bCompraMS,bCompraIC,bCompraPC;

    public VentanaBuildDefense() {

        defensa = new JPanel();
        arriba = new JPanel();
        abajo = new JPanel();
        missileLauncher = new JPanel();
        ionCannon = new JPanel();
        plasmaCannon = new JPanel();

        // Interfaz

        this.add(defensa);
        defensa.setLayout(new BoxLayout(defensa, BoxLayout.Y_AXIS));

        defensa.add(arriba);
        arriba.setLayout(new BoxLayout(arriba, BoxLayout.X_AXIS));

        defensa.add(abajo);
        abajo.setLayout(new BoxLayout(abajo, BoxLayout.Y_AXIS));

        // Construir Missile Launcher

        arriba.add(missileLauncher);
        missileLauncher.setBackground(Color.LIGHT_GRAY);
        missileLauncher.setLayout(new BoxLayout(missileLauncher, BoxLayout.Y_AXIS));
        imagenMS = new JLabel("imagen");
        nombreMS = new JLabel("LightHunter");
        precioMS = new JLabel("Precio");
        cantMS = new JLabel("Cantidad:");
        tCantMS = new JTextField(10);
        bCompraMS = new JButton("Comprar");

        inicioMS = new JPanel();
        medioMS = new JPanel();
        finalMS = new JPanel();

        inicioMS.add(imagenMS);
        medioMS.add(nombreMS);
        medioMS.add(precioMS);
        finalMS.add(cantMS);
        finalMS.add(tCantMS);
        finalMS.add(bCompraMS);

        missileLauncher.add(inicioMS);
        missileLauncher.add(medioMS);
        missileLauncher.add(finalMS);

        // Construir Ion Cannon

        arriba.add(ionCannon);
        ionCannon.setBackground(Color.LIGHT_GRAY);
        ionCannon.setLayout(new BoxLayout(ionCannon, BoxLayout.Y_AXIS));
        imagenIC = new JLabel("imagen");
        nombreIC = new JLabel("LightHunter");
        precioIC = new JLabel("Precio");
        cantIC = new JLabel("Cantidad:");
        tCantIC = new JTextField(10);
        bCompraIC = new JButton("Comprar");

        inicioIC = new JPanel();
        medioIC = new JPanel();
        finalIC = new JPanel();

        inicioIC.add(imagenIC);
        medioIC.add(nombreIC);
        medioIC.add(precioIC);
        finalIC.add(cantIC);
        finalIC.add(tCantIC);
        finalIC.add(bCompraIC);

        ionCannon.add(inicioIC);
        ionCannon.add(medioIC);
        ionCannon.add(finalIC);

        // Construir PlasmaCannon

        abajo.add(plasmaCannon);
        plasmaCannon.setBackground(Color.LIGHT_GRAY);
        plasmaCannon.setLayout(new BoxLayout(plasmaCannon, BoxLayout.Y_AXIS));
        imagenPC = new JLabel("imagen");
        nombrePC = new JLabel("LightHunter");
        precioPC = new JLabel("Precio");
        cantPC = new JLabel("Cantidad:");
        tCantPC = new JTextField(10);
        bCompraPC = new JButton("Comprar");

        inicioPC = new JPanel();
        medioPC = new JPanel();
        finalPC = new JPanel();

        inicioPC.add(imagenPC);
        medioPC.add(nombrePC);
        medioPC.add(precioPC);
        finalPC.add(cantPC);
        finalPC.add(tCantPC);
        finalPC.add(bCompraPC);

        plasmaCannon.add(inicioPC);
        plasmaCannon.add(medioPC);
        plasmaCannon.add(finalPC);

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
            JOptionPane.showMessageDialog(null,"Ya estas en este menu","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(ViewPlanetStats)) {
            Main vps = null;
            try {
				vps = new Main();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            vps.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource().equals(UpgradeTecnology)) {
            VentanaUpgradeTechnology vup = new VentanaUpgradeTechnology();
            vup.setVisible(true);
            this.setVisible(false);
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
