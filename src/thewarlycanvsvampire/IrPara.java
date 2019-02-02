package thewarlycanvsvampire;

import javax.swing.JOptionPane;

public class IrPara {

    public IrPara norte;
    public IrPara sul;
    public IrPara leste;
    public IrPara oeste;
    public String decricao;

    public IrPara(String decricao) {
        this.decricao = decricao;
    }

    public IrPara() {

    }

    public void index() {
        JOptionPane.showMessageDialog(null, "Sejam bem Vindos as The War Lycan vs Vampire");
        JOptionPane.showMessageDialog(null, "Objetivo do jogo é matar todos os vampiros \n"
                + " e principalmente o conde Drácula e tomar a poção\npara voltar a ser humano novamente");
    }

}
