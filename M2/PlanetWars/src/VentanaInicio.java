import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VentanaInicio extends JFrame implements MouseListener {
    private JMenuBar menu;
    private JMenu ViewPlanetStats,Build,UpgradeTecnology,ViewBattleReports,Exit;

    public VentanaInicio() {

        menu = new JMenuBar();

        ViewPlanetStats = new JMenu("<html><p style='text-align:center;width:150px;'>View Planet Stats</p></html>");

        Build = new JMenu("<html><p style='text-align:center;width:150px;'>Build");


        UpgradeTecnology = new JMenu("<html><p style='text-align:center;width:150px;'>Upgrade Technology");

        ViewBattleReports = new JMenu("<html><p style='text-align:center;width:150px;'>View Battle Reports");

        Exit = new JMenu("<html><p style='text-align:center;width:150px;'>Exit");

        menu.add(ViewPlanetStats);
        ViewPlanetStats.addMouseListener(this);
        menu.add(Build);
        Build.addMouseListener(this);
        menu.add(UpgradeTecnology);
        UpgradeTecnology.addMouseListener(this);
        menu.add(ViewBattleReports);
        ViewBattleReports.addMouseListener(this);
        menu.add(Exit);
        Exit.addMouseListener(this);

        add(menu, BorderLayout.NORTH);
        menu.add(Box.createRigidArea(new Dimension(20,50)));
        //menu.setMargin(new Insets(0,50,0,50));

        this.setTitle("Planet Wars");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setSize(1024,768);
        this.setResizable(false);
        this.setVisible(true);

        Toolkit pantalla = Toolkit.getDefaultToolkit();

        Dimension grandaria = pantalla.getScreenSize();
        int ancho = grandaria.width;
        int alto = grandaria.height;

        this.setLocation((ancho/2) - (this.getWidth() / 2), (alto / 2) - (this.getHeight() / 2));

        Image imagen = pantalla.getImage("./src/imagenes/Planet Wars.png");

        this.setIconImage(imagen);

        this.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(ViewPlanetStats)) {
            JOptionPane.showMessageDialog(null,"Ya estas en este menu","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource().equals(Build)) {
            VentanaBuild vb = new VentanaBuild();
            this.setVisible(false);
            vb.setVisible(true);
        }
        if (e.getSource().equals(UpgradeTecnology)) {

        }
        if (e.getSource().equals(ViewBattleReports)) {

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
