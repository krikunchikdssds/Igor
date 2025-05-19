import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Motivation extends JFrame {
    public Motivation() {
        setTitle("Igor");
        setSize(720, 370);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        Color bg = new Color(0, 0, 0);
        Color btnColor = new Color(30, 30, 30);
        Color hover = new Color(43, 41, 41);
        Color text = new Color(200, 196, 196);
        getContentPane().setBackground(bg);
        JLabel title = new JLabel("Hallo! Ich bin Igor");
        title.setForeground(text);
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(bg);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        JButton storyBtn = createRoundedButton("Meine Geschichte", btnColor, hover, text);
        JButton javaBtn = createRoundedButton("Warum Java?", btnColor, hover, text);
        JButton goalBtn = createRoundedButton("Mein Ziel", btnColor, hover, text);
        JButton motivationBtn = createRoundedButton("Meine Motivation", btnColor, hover, text);
        storyBtn.addActionListener(e -> showPopup("Meine Geschichte", """
                Mein Name ist Igor, ich bin 14 Jahre alt. Ich bin aufgrund des Krieges aus der Ukraine in die Schweiz gekommen.
                Anfangs war es schwer: die Sprache nicht zu beherrschen, keine Freunde und eine neue Umgebung.
                Aus Langeweile begann ich nach einem Hobby zu suchen, und so fand ich die Programmierung.
                """));
        javaBtn.addActionListener(e -> showPopup("Warum Java?", """
                Es begann alles mit einem Spiel – ich wollte ein Plugin verändern, dass mir nicht gefallen hat.
                Also schrieb ich mein eigenes. Ich fand es spannend, Dinge zu ändern und zu schaffen.
                So lernte ich Java kennen und verstand, dass Programmierung ein mächtiges Werkzeug ist.
                """));
        goalBtn.addActionListener(e -> showPopup("Mein Ziel", """
                Ich möchte Informatiker werden und nicht nur Code schreiben,
                sondern echte Probleme lösen. Ich möchte nützliche, schöne und intelligente Software entwickeln.
                Ich bin bereit zu lernen, zu wachsen und das zu tun, was mich wirklich interessiert.
                """));
        motivationBtn.addActionListener(e -> showPopup("Meine Motivation", """
                Programmierung hat mir ein Ziel und Vertrauen gegeben.
                Es hat meine Einsamkeit in Ideen verwandelt und die Langeweile in Projekte.
                Es ist nicht nur ein Hobby für mich. Es ist mein Weg.
                """));
        buttonPanel.add(storyBtn);
        buttonPanel.add(javaBtn);
        buttonPanel.add(goalBtn);
        buttonPanel.add(motivationBtn);

        add(title, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }
    private JButton createRoundedButton(String text, Color base, Color hover, Color textColor) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(2, 2, getWidth(), getHeight(), 20, 20);
                super.paintComponent(g);
            }
        };
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        button.setBorderPainted(false);
        button.setForeground(textColor);
        button.setBackground(base);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(200, 45));
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hover);
            }
            public void mouseExited(MouseEvent e) {
                button.setBackground(base);
            }
        });
        return button;
    }
    private void showPopup(String title, String content) {
        JTextArea area = new JTextArea(content);
        area.setWrapStyleWord(true);
        area.setLineWrap(true);
        area.setEditable(false);
        area.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        area.setBackground(new Color(240, 240, 240));
        area.setForeground(new Color(0, 0, 0));
        area.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(400, 200));
        scroll.setBorder(null);
        JOptionPane.showMessageDialog(this, scroll, title, JOptionPane.INFORMATION_MESSAGE);
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception ignored) {
        }
        SwingUtilities.invokeLater(Motivation::new);
    }
}