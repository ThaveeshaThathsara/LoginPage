package raven.main;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.util.UIScale;
import raven.forms.Home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends JFrame {

    private Home home;

    public Main() {
        init();
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(UIScale.scale(new Dimension(1365, 768)));
        setLocationRelativeTo(null);
        home = new Home();
        setContentPane(home);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                home.initOverlay(Main.this);
                home.play(0);
            }

            @Override
            public void windowClosing(WindowEvent e) {
                home.stop();
            }
        });
    }


    public static void main(String[] args) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("raven.themes");
        FlatMacDarkLaf.setup();

        UIManager.put("Slider.thumbWidth", 10); // Adjust the thumb width as needed
        UIManager.put("Slider.thumbHeight", 20); // Adjust the thumb height as needed
        UIManager.put("Slider.thumbColor", Color.red); // Set the thumb color to red
        UIManager.put("Slider.trackWidth", 8); // Adjust the track width as needed
        UIManager.put("Slider.trackColor", Color.red); // Set the track color to red

        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        EventQueue.invokeLater(() -> new Main().setVisible(true));
    }
}
