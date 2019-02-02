package thewarlycanvsvampire;

import javax.swing.JOptionPane;

public class Chave {

    public String desChave;

    public Chave(String desc) {
        this.desChave = desc;
    }

    public void infoChave01() {
        JOptionPane.showMessageDialog(null, "Parabéns agora você tem a chave para abrir a sala NostraDamus");
    }

    public void infoChave02() {
        JOptionPane.showMessageDialog(null, "Parabéns agora você tem a chave para abrir a porta até a ponte da Torre");
    }

}
