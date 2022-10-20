import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GeradorDeFigurinhas {
    public void Cria() throws IOException {
        BufferedImage imagemOriginal = ImageIO.read(new File("entrada/teste1.jpg"));
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int NovaAltura = altura + 100;
        BufferedImage novaImagem = new BufferedImage(largura, NovaAltura, BufferedImage.TRANSLUCENT);
        Graphics2D graph = (Graphics2D) novaImagem.getGraphics();
        graph.drawImage(imagemOriginal, 0, 0, null);
        //---
        graph.drawString("BRABO", 100, NovaAltura - 60 );
        Font fonts = new Font(Font.SANS_SERIF, Font.BOLD, 60);
        graph.setColor(Color.ORANGE);
        graph.setFont(fonts);
        //---

        ImageIO.write(novaImagem, "png", new File("saida/final1.jpg"));
    }

    //para rodar basta executar esta função main e observr a pasta saída.
    public static void main(String[] args) throws IOException {
        var geradora =  new GeradorDeFigurinhas();
        geradora.Cria();
    }
}
