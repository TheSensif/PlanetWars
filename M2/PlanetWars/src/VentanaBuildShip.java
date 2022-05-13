import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class VentanaBuildShip extends JFrame implements ActionListener , MouseListener {

    private JMenuBar menu;
    private JMenu ViewPlanetStats,Build,UpgradeTecnology,ViewBattleReports,Exit;
    private JMenuItem BuildDefense,BuildShips;
    private JPanel army,derecha,izquierda,lightHunter,heavyHunter,battleShip,armoredShip;

    private JPanel inicioLH,medioLH, finalLH;
    private JLabel imagenLH,nombreLH,precioLH,cantLH;

    private JPanel inicioHH,medioHH, finalHH;
    private JLabel imagenHH,nombreHH,precioHH,cantHH;

    private JPanel inicioBS,medioBS, finalBS;
    private JLabel imagenBS,nombreBS,precioBS,cantBS;

    private JPanel inicioAR,medioAR, finalAR;
    private JLabel imagenAR,nombreAR,precioAR,cantAR;

    private JTextField tCantLH,tCantHH,tCantBS,tCantAR;
    private JButton bCompraLH,bCompraHH,bCompraBS,bCompraAR;

    public VentanaBuildShip() {

        army = new JPanel();
        izquierda = new JPanel();
        derecha = new JPanel();
        add(army);
        army.add(izquierda);
        izquierda.setLayout(new BoxLayout(izquierda, BoxLayout.Y_AXIS));
        army.add(derecha);
        derecha.setLayout(new BoxLayout(derecha, BoxLayout.Y_AXIS));
        lightHunter = new JPanel();
        heavyHunter = new JPanel();
        battleShip = new JPanel();
        armoredShip = new JPanel();

        army.setLayout(new BoxLayout(army, BoxLayout.X_AXIS));

        // Compra Light Hunter

        izquierda.add(lightHunter);
        lightHunter.setBackground(Color.LIGHT_GRAY);
        lightHunter.setLayout(new BoxLayout(lightHunter, BoxLayout.Y_AXIS));
        imagenLH = new JLabel("imagen");
        nombreLH = new JLabel("LightHunter");
        precioLH = new JLabel("Precio");
        cantLH = new JLabel("Cantidad:");
        tCantLH = new JTextField(10);
        bCompraLH = new JButton("Comprar");

        inicioLH = new JPanel();
        medioLH = new JPanel();
        finalLH = new JPanel();

        inicioLH.add(imagenLH);
        medioLH.add(nombreLH);
        medioLH.add(precioLH);
        finalLH.add(cantLH);
        finalLH.add(tCantLH);
        finalLH.add(bCompraLH);

        lightHunter.add(inicioLH);
        lightHunter.add(medioLH);
        lightHunter.add(finalLH);

        // Compra Heavy Hunter


        izquierda.add(heavyHunter);
        heavyHunter.setLayout(new BoxLayout(heavyHunter, BoxLayout.Y_AXIS));
        imagenHH = new JLabel("imagen");
        nombreHH = new JLabel("LightHunter");
        precioHH = new JLabel("Precio");
        cantHH = new JLabel("Cantidad:");
        tCantHH = new JTextField(10);
        bCompraHH = new JButton("Comprar");

        inicioHH = new JPanel();
        medioHH = new JPanel();
        finalHH = new JPanel();

        inicioHH.add(imagenHH);
        medioHH.add(nombreHH);
        medioHH.add(precioHH);
        finalHH.add(cantHH);
        finalHH.add(tCantHH);
        finalHH.add(bCompraHH);

        heavyHunter.add(inicioHH);
        heavyHunter.add(medioHH);
        heavyHunter.add(finalHH);

        // Comprar Battle Ship

        derecha.add(battleShip);
        battleShip.setBackground(Color.LIGHT_GRAY);
        battleShip.setLayout(new BoxLayout(battleShip, BoxLayout.Y_AXIS));
        imagenBS = new JLabel("imagen");
        nombreBS = new JLabel("LightHunter");
        precioBS = new JLabel("Precio");
        cantBS = new JLabel("Cantidad:");
        tCantBS = new JTextField(10);
        bCompraBS = new JButton("Comprar");

        inicioBS = new JPanel();
        medioBS = new JPanel();
        finalBS = new JPanel();

        inicioBS.add(imagenBS);
        medioBS.add(nombreBS);
        medioBS.add(precioBS);
        finalBS.add(cantBS);
        finalBS.add(tCantBS);
        finalBS.add(bCompraBS);

        battleShip.add(inicioBS);
        battleShip.add(medioBS);
        battleShip.add(finalBS);

        // Comprar armoredShip

        derecha.add(armoredShip);
        armoredShip.setBackground(Color.LIGHT_GRAY);
        armoredShip.setLayout(new BoxLayout(armoredShip, BoxLayout.Y_AXIS));
        imagenAR = new JLabel("imagen");
        nombreAR = new JLabel("LightHunter");
        precioAR = new JLabel("Precio");
        cantAR = new JLabel("Cantidad:");
        tCantAR = new JTextField(10);
        bCompraAR = new JButton("Comprar");

        inicioAR = new JPanel();
        medioAR = new JPanel();
        finalAR = new JPanel();

        inicioAR.add(imagenAR);
        medioAR.add(nombreAR);
        medioAR.add(precioAR);
        finalAR.add(cantAR);
        finalAR.add(tCantAR);
        finalAR.add(bCompraAR);

        armoredShip.add(inicioAR);
        armoredShip.add(medioAR);
        armoredShip.add(finalAR);


        //Menu

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
            JOptionPane.showMessageDialog(null,"Ya estas en este menu","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource().equals(BuildDefense)) {
            VentanaBuildDefense vbd = new VentanaBuildDefense();
            vbd.setVisible(true);
            this.setVisible(false);
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
