import java.awt.Graphics;
import javax.swing.JPanel;

class PainelArvore extends JPanel {
    private ArvoreMorse arvoreMorse;

    public PainelArvore(ArvoreMorse arvoreMorse) {
        this.arvoreMorse = arvoreMorse;
    }

    public void setArvore(ArvoreMorse arvore) {
        this.arvoreMorse = arvore;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        No raiz = this.arvoreMorse.getRaiz();
        if (raiz != null) {
            this.desenharArvore(g, raiz, this.getWidth() / 2, 30, this.getWidth() / 4);
        }
    }

    private void desenharArvore(Graphics g, No no, int x, int y, int espacamento) {
        if (no != null) {
            g.drawString(no.valor.isEmpty() ? "-" : no.valor, x, y);
            if (no.esquerda != null) {
                g.drawLine(x, y, x - espacamento, y + 50);
                this.desenharArvore(g, no.esquerda, x - espacamento, y + 50, espacamento / 2);
            }

            if (no.direita != null) {
                g.drawLine(x, y, x + espacamento, y + 50);
                this.desenharArvore(g, no.direita, x + espacamento, y + 50, espacamento / 2);
            }
        }
    }
}
