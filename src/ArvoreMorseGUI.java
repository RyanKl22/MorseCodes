import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ArvoreMorseGUI extends JFrame {
    private ArvoreMorse arvoreMorse;
    private JTextField campoEntrada;
    private JTextArea areaSaida;
    private PainelArvore painelArvore;

    public ArvoreMorseGUI() {
        this.setTitle("Decodificador de Código Morse");
        this.setSize(900, 700);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo((Component)null);
        this.arvoreMorse = new ArvoreMorse();
        this.arvoreMorse.construirArvoreMorse();
        this.configurarInterface();
    }

    private void configurarInterface() {
        this.setLayout(new BorderLayout());
        JPanel painelSuperior = new JPanel(new FlowLayout());
        this.campoEntrada = new JTextField(20);
        JButton botaoDecodificar = new JButton("Decodificar");
        botaoDecodificar.addActionListener(new OuvinteBotaoDecodificar());
        painelSuperior.add(new JLabel("Digite o Código Morse:"));
        painelSuperior.add(this.campoEntrada);
        painelSuperior.add(botaoDecodificar);
        this.areaSaida = new JTextArea(5, 40);
        this.areaSaida.setEditable(false);
        this.painelArvore = new PainelArvore(this.arvoreMorse);
        this.painelArvore.setPreferredSize(new Dimension(800, 400));
        this.add(painelSuperior, "North");
        this.add(new JScrollPane(this.areaSaida), "Center");
        this.add(new JScrollPane(this.painelArvore), "South");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            (new ArvoreMorseGUI()).setVisible(true);
        });
    }

    private class OuvinteBotaoDecodificar implements ActionListener {
        private OuvinteBotaoDecodificar() {
        }

        public void actionPerformed(ActionEvent e) {
            String entradaMorse = ArvoreMorseGUI.this.campoEntrada.getText().trim();
            String mensagemDecodificada = ArvoreMorseGUI.this.arvoreMorse.decodificar(entradaMorse);
            ArvoreMorseGUI.this.areaSaida.setText("Mensagem Decodificada: " + mensagemDecodificada);
            ArvoreMorseGUI.this.painelArvore.repaint();
        }
    }
}
