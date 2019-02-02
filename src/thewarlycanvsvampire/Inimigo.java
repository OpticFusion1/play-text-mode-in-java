package thewarlycanvsvampire;

import javax.swing.JOptionPane;

public class Inimigo {

    private String nome;
    private int dano;
    private int vida;

    public Inimigo() {

    }

    public void vamp01() {
        nome = "Dente de Sabre";
        vida = 40;
        dano = 20;
    }

    public void vamp02() {
        nome = "Junguernourt";
        vida = 60;
        dano = 20;
    }

    public void dracula() {
        nome = "Conde Drácula";
        vida = 180;
        dano = 40;
    }

    public void info() {
        JOptionPane.showMessageDialog(null, "O vampiro " + this.nome + " tem um força de "
                + this.vida + " FPS e ele pode tirar ou \n"
                + "perder um dano de " + this.dano + " FPS de força a cada ataque");
    }
}
