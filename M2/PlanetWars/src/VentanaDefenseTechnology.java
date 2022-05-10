import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VentanaDefenseTechnology extends JFrame implements ActionListener , MouseListener {

    private JMenuBar menu;
    private JMenu ViewPlanetStats,Build,UpgradeTecnology,ViewBattleReports,Exit;
    private JMenuItem BuildDefense,BuildShips,AttackTechnology,DefenseTechnology;

    public VentanaDefenseTechnology() {
        menu = new JMenuBar();

        ViewPlanetStats = new JMenu("<html><p style='text-align:center;width:150px;'>View Planet Stats</p></html>");
        Build = new JMenu("<html><p style='text-align:center;width:150px;'>Build");
        UpgradeTecnology = new JMenu("<html><p style='text-align:center;width:150px;'>Upgrade Technology");
        ViewBattleReports = new JMenu("<html><p style='text-align:center;width:150px;'>View Battle Reports");
        Exit = new JMenu("<html><p style='text-align:center;width:150px;'>Exit");

        BuildDefense = new JMenuItem("<html><p style='text-align:center;width:140px;'>Defense");
        BuildShips = new JMenuItem("<html><p style='text-align:center;width:140px;'>Ships");

        AttackTechnology = new JMenuItem("<html><p style='text-align:center;width:140px;'>Attack Technology");
        DefenseTechnology = new JMenuItem("<html><p style='text-align:center;width:140px;'>Defense Technology");


        Build.add(BuildShips);
        Build.add(BuildDefense);
        UpgradeTecnology.add(AttackTechnology);
        UpgradeTecnology.add(DefenseTechnology);

        menu.add(ViewPlanetStats);
        menu.add(Build);
        menu.add(UpgradeTecnology);
        menu.add(ViewBattleReports);
        menu.add(Exit);

        ViewPlanetStats.addMouseListener(this);
        ViewBattleReports.addMouseListener(this);
        Exit.addMouseListener(this);


        BuildShips.addActionListener(this);
        BuildDefense.addActionListener(this);
        AttackTechnology.addActionListener(this);
        DefenseTechnology.addActionListener(this);

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
        if (e.getSource().equals(AttackTechnology)) {
            VentanaDefenseTechnology vat = new VentanaDefenseTechnology();
            vat.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource().equals(DefenseTechnology)) {
            JOptionPane.showMessageDialog(null,"Ya estas en este menu","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(ViewPlanetStats)) {
            Main vps = new Main();
            vps.setVisible(true);
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
