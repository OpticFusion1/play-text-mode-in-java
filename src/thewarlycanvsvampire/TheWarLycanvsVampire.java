package thewarlycanvsvampire;

import javax.swing.JOptionPane;

public class TheWarLycanvsVampire {

    public static void main(String[] args) {
        IrPara portaoAcesso = new IrPara("Você está no portão de acesso");
        IrPara salaA = new IrPara("Você está na sala Feudal A");
        IrPara salaB = new IrPara("Você está na Sala Feudal B");
        IrPara salaC = new IrPara("Você está na Sala Feudal C");
        IrPara nostradamus = new IrPara("Você está na sala Nostradamus");
        IrPara corredorFeudal = new IrPara("Você está no corredor feudal");
        IrPara acessoCentral = new IrPara("Você está no Acesso Central");
        IrPara santIluminati = new IrPara("Você está no Santuário Iluminati");
        IrPara corredorBiblioteca = new IrPara("Você está no Corredor da Biblioteca");
        IrPara biblioteca = new IrPara("Você está na Biblioteca");
        IrPara salaChaves1 = new IrPara("Você está na sala de Chaves 1");
        IrPara salaE = new IrPara("Você está na Sala Feudal E");
        IrPara patenteA = new IrPara("Você está na patente A");
        IrPara patenteB = new IrPara("Você está na patente B");
        IrPara ponteTorre = new IrPara("Você está na Ponte da Torre");
        IrPara torre = new IrPara("Você está na Torre");
        IrPara salaSecreta = new IrPara("Você está na Sala Secreta");
        IrPara index = new IrPara();

        Inimigo vamp01 = new Inimigo();
        Inimigo vamp02 = new Inimigo();
        Inimigo dracula = new Inimigo();

        vamp01.vamp01();
        vamp02.vamp02();
        dracula.dracula();

        Chave chave01 = new Chave("Chave para primeira porta");
        Chave chave02 = new Chave("Chave para segunda porta");

        int vida = 100;
        int vidaVamp01 = 40;
        int vidaVamp02 = 60;
        int vidaDracula = 180;
        int chaveAcessoPega = 1;
        int chaveNostraDamus = 1;
        int tomarPocao = 1;
        int pegarArma = 1;

        portaoAcesso.norte = salaA;

        salaA.leste = salaB;
        salaA.sul = portaoAcesso;
        salaA.norte = corredorFeudal;

        salaB.oeste = salaA;
        salaB.leste = salaC;

        salaC.oeste = salaB;
        salaC.norte = salaChaves1;

        salaChaves1.sul = salaC;

        corredorFeudal.sul = salaA;
        corredorFeudal.norte = acessoCentral;

        acessoCentral.sul = corredorFeudal;
        acessoCentral.norte = santIluminati;
        acessoCentral.leste = ponteTorre;
        acessoCentral.oeste = corredorBiblioteca;

        santIluminati.sul = acessoCentral;

        corredorBiblioteca.leste = acessoCentral;
        corredorBiblioteca.oeste = biblioteca;

        biblioteca.leste = corredorBiblioteca;
        biblioteca.norte = nostradamus;
        biblioteca.oeste = salaE;

        salaE.leste = biblioteca;
        salaE.sul = patenteB;
        salaE.oeste = patenteA;

        patenteB.norte = salaE;

        patenteA.leste = salaE;

        nostradamus.sul = biblioteca;

        ponteTorre.oeste = acessoCentral;
        ponteTorre.leste = torre;

        torre.oeste = ponteTorre;
        torre.leste = salaSecreta;

        index.index();

        IrPara posAtual = portaoAcesso;
        String opcao, lugarDisponivel = "";

        while (true) {
            JOptionPane.showMessageDialog(null, posAtual.decricao);

            lugarDisponivel = "";

            if (posAtual.norte != null) {
                lugarDisponivel += "\nExiste um lugar ao (N)orte";
            }
            if (posAtual.sul != null) {
                lugarDisponivel += "\nExiste um lugar ao (S)ul";
            }
            if (posAtual.oeste != null) {
                lugarDisponivel += "\nExiste um lugar ao (O)este";
            }
            if (posAtual.leste != null) {
                lugarDisponivel += "\nExiste um lugar ao (L)este";
            }

            opcao = JOptionPane.showInputDialog("Digite uma opção: "
                    + lugarDisponivel + "\n (Q)uit");

            opcao = opcao.toLowerCase();

            if (opcao.equals("q")) {
                break;
            } else if (opcao.equals("n")) {
                if (posAtual.norte != null) {
                    posAtual = posAtual.norte;

                } else {
                    JOptionPane.showMessageDialog(null, "Não existe lugar ao norte!");
                }
            } else if (opcao.equals("s")) {
                if (posAtual.sul != null) {
                    posAtual = posAtual.sul;
                } else {
                    JOptionPane.showMessageDialog(null, "Não existe lugar ao sul!");
                }
            } else if (opcao.equals("l")) {
                if (posAtual.leste != null) {
                    posAtual = posAtual.leste;
                } else {
                    JOptionPane.showMessageDialog(null, "Não existe lugar ao Leste!");
                }
            } else if (opcao.equals("o")) {
                if (posAtual.oeste != null) {
                    posAtual = posAtual.oeste;
                } else {
                    JOptionPane.showMessageDialog(null, "Não existe lugar ao Oeste!");
                }
            }

            if (posAtual == salaB) {
                if (vidaVamp01 <= 0) {
                    JOptionPane.showMessageDialog(null, "Você já matou o Dente de Sabre");

                } else if (vidaVamp01 > 0) {
                    String lutar = null;
                    String dano2 = null;
                    JOptionPane.showMessageDialog(null, "Você entrará na sala B onde tem um vampiro para lutar!!!!");
                    vamp01.info();
                    do {
                        JOptionPane.showMessageDialog(null, "Sua vida antes da batalha é: " + vida + "%");
                        lutar = JOptionPane.showInputDialog(null, "Gostaria de Atacar ele? \n(S)im  \n(N)ão");
                        switch (lutar) {
                            case "s":
                            case "S":
                                JOptionPane.showMessageDialog(null, "Com esse ataque você conseguirar tirar 50% da vida do Vampiro");
                                vidaVamp01 = vidaVamp01 - 20;
                                JOptionPane.showMessageDialog(null, "Vida de Dente de Sabre esta em " + vidaVamp01 + " FPS de força");

                                do {
                                    do {
                                        if (vida <= 0) {
                                            JOptionPane.showMessageDialog(null, "Você morreu");
                                            return;
                                        }

                                        dano2 = JOptionPane.showInputDialog(null, "Você gostaria de acabar de vez com Dente de Sabre?"
                                                + " \n(S)im \n(N)ão");
                                        if (dano2.equals("S") || dano2.equals("s")) {
                                            vidaVamp01 = vidaVamp01 - 20;
                                            JOptionPane.showMessageDialog(null, "Vida de Dente de Sabre esta em " + vidaVamp01 + " FPS de força");

                                            JOptionPane.showMessageDialog(null, " ****Dente de Sabre está Morto****");
                                            JOptionPane.showMessageDialog(null, "Sua vida após a batalha é: " + vida + "%");

                                        } else if (dano2.equals("N") || dano2.equals("n")) {
                                            vida = vida - 20;
                                            JOptionPane.showMessageDialog(null, "Você recebeu um ataque sua vida é de " + vida + "%");

                                        } else {
                                            JOptionPane.showMessageDialog(null, "Opção Errada !!!! \nEscolha novamente");
                                        }
                                    } while (!(dano2.equals("S")) && !(dano2.equals("s")) && !(dano2.equals("n"))
                                            && !(dano2.equals("N")));
                                } while (vidaVamp01 > 0);
                                break;
                            case "n":
                            case "N":
                                JOptionPane.showMessageDialog(null, "Você optou por não ir para batalha então ficará na sala atual");
                                posAtual = salaA;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção inválida!!! \nDigite novamente");
                        }
                    } while (!(lutar.equals("S")) && !(lutar.equals("s")) && !(lutar.equals("n")) && !(lutar.equals("N")));
                }
            }

            if (posAtual == salaChaves1) {
                if (chaveAcessoPega <= 0) {
                    posAtual = salaChaves1;
                } else if (chaveAcessoPega > 0) {
                    String chaveAcesso;
                    JOptionPane.showMessageDialog(null, "Nesta sala tem um chave!!!!");
                    do {
                        chaveAcesso = JOptionPane.showInputDialog("Para pegar a chave digite \n(S)im \n(N)ão");
                        if (chaveAcesso.equals("S") || chaveAcesso.equals("s")) {
                            chave01.infoChave01();
                            chaveAcessoPega = 0;
                        } else if (chaveAcesso.equals("N") || chaveAcesso.equals("n")) {
                            JOptionPane.showMessageDialog(null, "Você optou por não pegar a chave");
                        } else {
                            JOptionPane.showMessageDialog(null, "Opção Inválida!!!! \nEscolha novamente");
                        }
                    } while (!(chaveAcesso.equals("S")) && !(chaveAcesso.equals("s"))
                            && !(chaveAcesso.equals("n")) && !(chaveAcesso.equals("N")));
                }
            }
            if (posAtual == biblioteca) {
                if (vidaVamp02 <= 0) {
                    JOptionPane.showMessageDialog(null, "Você já matou o Junguernourt");
                } else if (vidaVamp02 > 0) {
                    String lutar = null;
                    String dano2 = null;
                    JOptionPane.showMessageDialog(null, "Você entrará na Biblioteca onde tem um vampiro para lutar!!!!");
                    vamp02.info();
                    do {
                        JOptionPane.showMessageDialog(null, "Sua vida antes da batalha é: " + vida + "%");
                        lutar = JOptionPane.showInputDialog(null, "Gostaria de Atacar Junguernourt? \n(S)im  \n(N)ão");
                        JOptionPane.showMessageDialog(null, "Oh não ele foi mais rápido e lhe atacou");
                        vida -= 10;
                        JOptionPane.showMessageDialog(null, "Você sofreu um pequeno dano sua vida é de: " + vida + "%");
                        switch (lutar) {
                            case "s":
                            case "S":
                                JOptionPane.showMessageDialog(null, "Com esse ataque você conseguirar tirar 20 FPS da vida do Vampiro");
                                vidaVamp02 -= 20;
                                JOptionPane.showMessageDialog(null, "Vida de Junguernourt esta em " + vidaVamp02 + " FPS de força");

                                do {
                                    do {
                                        if (vida <= 0) {
                                            JOptionPane.showMessageDialog(null, "Você morreu");
                                            return;
                                        }

                                        dano2 = JOptionPane.showInputDialog(null, "Você gostaria de atacar novamente Junguernourt?"
                                                + " \n(S)im \n(N)ão");
                                        if (dano2.equals("S") || dano2.equals("s")) {
                                            vidaVamp02 -= 20;
                                            JOptionPane.showMessageDialog(null, "Vida de Junguernourt esta em " + vidaVamp02 + " FPS de força");

                                            if (vidaVamp02 <= 0) {
                                                JOptionPane.showMessageDialog(null, " ****Junguernourt está Morto****");
                                                JOptionPane.showMessageDialog(null, "Sua vida após a batalha é: " + vida + "%");
                                            }
                                        } else if (dano2.equals("N") || dano2.equals("n")) {
                                            vida = vida - 20;
                                            JOptionPane.showMessageDialog(null, "Você recebeu um ataque sua vida é de " + vida + "%");

                                        } else {
                                            JOptionPane.showMessageDialog(null, "Opção Errada !!!! \nEscolha novamente");
                                        }
                                    } while (!(dano2.equals("S")) && !(dano2.equals("s")) && !(dano2.equals("n"))
                                            && !(dano2.equals("N")));
                                } while (vidaVamp02 > 0);
                                break;
                            case "n":
                            case "N":
                                JOptionPane.showMessageDialog(null, "Você optou por não ir para batalha então ficará na sala atual");
                                posAtual = corredorBiblioteca;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção inválida!!! \nDigite novamente");
                        }
                    } while (!(lutar.equals("S")) && !(lutar.equals("s")) && !(lutar.equals("n")) && !(lutar.equals("N")));
                }
            }

            if (posAtual == nostradamus) {
                if (chaveNostraDamus <= 0) {
                    posAtual = nostradamus;
                }
                if (chaveNostraDamus <= 0) {
                    posAtual = nostradamus;
                } else if (chaveAcessoPega <= 0) {
                    String chaveAcesso1;
                    JOptionPane.showMessageDialog(null, "Nesta sala tem um chave!!!!");
                    do {
                        chaveAcesso1 = JOptionPane.showInputDialog("Para pegar a chave digite \n(S)im \n(N)ão");
                        if (chaveAcesso1.equals("S") || chaveAcesso1.equals("s")) {
                            chave02.infoChave02();
                            chaveNostraDamus = 0;
                        } else if (chaveAcesso1.equals("N") || chaveAcesso1.equals("n")) {
                            JOptionPane.showMessageDialog(null, "Você optou por não pegar a chave");

                        } else {
                            JOptionPane.showMessageDialog(null, "Opção Inválida!!!! \nEscolha novamente");
                        }
                    } while (!(chaveAcesso1.equals("S")) && !(chaveAcesso1.equals("s"))
                            && !(chaveAcesso1.equals("n")) && !(chaveAcesso1.equals("N")));
                } else {
                    JOptionPane.showMessageDialog(null, "**** Atenção você não tem acesso a esta sala****\n "
                            + "\nPara acesar essa sala primeiro você tem ter a chave de acesso"
                            + "\n que está localizada na sala de chaves após a sala feudal C!!!");
                    posAtual = biblioteca;
                }
            }

            if (posAtual == patenteA) {
                JOptionPane.showMessageDialog(null, "Você entrou em uma sala com vulcânica você irá Morrer!!!");
                JOptionPane.showMessageDialog(null, "********GAME OVER******");
                return;

            }

            if (posAtual == patenteB) {
                if (pegarArma > 0) {
                    String armaEstacaMadeira;
                    JOptionPane.showMessageDialog(null, "Nesta sala tem uma Estaca de Madeira!!!!");
                    do {
                        armaEstacaMadeira = JOptionPane.showInputDialog("Para pegar a Estaca de Madeira digite \n(S)im \n(N)ão");
                        if (armaEstacaMadeira.equals("S") || armaEstacaMadeira.equals("s")) {
                            JOptionPane.showMessageDialog(null, "Parabéns agora você tem uma estaca para matar o Drácula");
                            pegarArma = 0;
                        } else if (armaEstacaMadeira.equals("N") || armaEstacaMadeira.equals("n")) {
                            JOptionPane.showMessageDialog(null, "Você optou por não pegar a Estaca de Madeira \nVai se arrepender!!!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Opção Inválida!!!! \nEscolha novamente");
                        }
                    } while (!(armaEstacaMadeira.equals("S")) && !(armaEstacaMadeira.equals("s"))
                            && !(armaEstacaMadeira.equals("n")) && !(armaEstacaMadeira.equals("N")));
                } else {
                    posAtual = patenteB;
                }
            }

            if (posAtual == ponteTorre) {

                if (chaveNostraDamus <= 0) {

                    if (pegarArma <= 0) {
                        if (tomarPocao <= 0) {

                        } else {
                            JOptionPane.showMessageDialog(null, "Você não tomou a poção para se tornar um Lycan"
                                    + "\nAssim você irá morreu fácil!!!");

                            String beberPocao;
                            do {
                                beberPocao = JOptionPane.showInputDialog(null, "Gostaria de voltar e "
                                        + "tomar a poção \n(S)im \n (N)ão");
                                switch (beberPocao) {
                                    case "s":
                                    case "S":
                                        posAtual = acessoCentral;
                                        break;
                                    case "N":
                                    case "n":
                                        posAtual = ponteTorre;
                                        break;
                                    default:
                                }
                            } while (!(beberPocao.equals("S")) && !(beberPocao.equals("s")) && !(beberPocao.equals("n"))
                                    && !(beberPocao.equals("N")));
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Você não tem a estaca de madeira para lutar com Drácula!!!"
                                + "\nPegue a Estaca e entrará para o acesso até a torre");
                        posAtual = acessoCentral;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Você não a chave para acessar a ponte da torre"
                            + "\nPara acessar a ponte pegue a chave que esta na sala NostraDamus");
                    posAtual = acessoCentral;
                }
            }

            if (posAtual == santIluminati) {

                if (tomarPocao <= 0) {

                } else {

                    String pocaoLaycan;
                    JOptionPane.showMessageDialog(null, "Nesta sala tem uma Poção para você se tornar um LYCAN!!!!");
                    do {
                        pocaoLaycan = JOptionPane.showInputDialog("Para beber a poção para se transformar em Lycan escolha "
                                + "\n(S)im \n(N)ão");
                        if (pocaoLaycan.equals("S") || pocaoLaycan.equals("s")) {
                            JOptionPane.showMessageDialog(null, "Parabéns agora você se transformou em um grande Lobisomen\n"
                                    + " Lycan com sua vida multiplicada pronto para matar o Drácula");
                            vida = vida * 2;
                            JOptionPane.showMessageDialog(null, "Sua vida atual antes da batalha é: " + vida + " %");
                            tomarPocao = 0;
                        } else if (pocaoLaycan.equals("N") || pocaoLaycan.equals("n")) {
                            JOptionPane.showMessageDialog(null, "Você optou por não tomar a poção para se tornar um Lycan"
                                    + "\nVai se arrepender!!!");
                            posAtual = acessoCentral;
                        } else {
                            JOptionPane.showMessageDialog(null, "Opção Inválida!!!! \nEscolha novamente");
                        }
                    } while (!(pocaoLaycan.equals("S")) && !(pocaoLaycan.equals("s"))
                            && !(pocaoLaycan.equals("n")) && !(pocaoLaycan.equals("N")));
                }

            }
            if (posAtual == torre) {
                if (vidaDracula <= 0) {
                    JOptionPane.showMessageDialog(null, "Você já matou o Conde Drácula");
                } else if (vidaDracula > 0) {
                    String lutar = null;
                    String dano2 = null;
                    JOptionPane.showMessageDialog(null, "Você irá para a ultima batalha"
                            + "\nonde se você matar o Conde Drácular \n"
                            + " e poderá terminar de vez com essa maldição!!!!");
                    dracula.info();
                    do {
                        JOptionPane.showMessageDialog(null, "Sua vida antes da batalha é: " + vida + "%");
                        lutar = JOptionPane.showInputDialog(null, "Gostaria de Atacar Conde Drácula? \n(S)im  \n(N)ão");
                        switch (lutar) {
                            case "s":
                            case "S":
                                JOptionPane.showMessageDialog(null, "Com esse ataque você conseguirar tirar 20 FPS da vida do Vampiro");
                                vidaDracula -= 20;
                                JOptionPane.showMessageDialog(null, "Vida de Drácula esta em " + vidaDracula + " FPS de força");
                                vida -= 120;
                                JOptionPane.showMessageDialog(null, "Mas Drácula se tele- transportou e lhe deu um ataque");
                                JOptionPane.showMessageDialog(null, "Sua vida atual é: " + vida + "%");

                                do {
                                    do {
                                        if (vida <= 0) {
                                            JOptionPane.showMessageDialog(null, "Você morreu!!!!!!!!");
                                            return;
                                        }

                                        dano2 = JOptionPane.showInputDialog(null, "Você gostaria de atacar novamente Drácula mas com estaca?"
                                                + " \n(S)im \n(N)ão");
                                        if (dano2.equals("S") || dano2.equals("s")) {

                                            vidaDracula -= 40;
                                            JOptionPane.showMessageDialog(null, "Vida de Drácula esta em " + vidaDracula + " FPS de força");

                                            if (vidaDracula == 0) {
                                                JOptionPane.showMessageDialog(null, " ****O PODEROSO CONDE DRÁCULA ESTÁ MORTO****");
                                                JOptionPane.showMessageDialog(null, "Sua vida após a batalha é de: " + vida + " % ");
                                            }
                                        } else if (dano2.equals("N") || dano2.equals("n")) {
                                            vida -= 100;
                                            JOptionPane.showMessageDialog(null, "Você recebeu um ataque sua vida é de " + vida + "%");

                                        } else {
                                            JOptionPane.showMessageDialog(null, "Opção Errada !!!! \nEscolha novamente");
                                        }
                                    } while (!(dano2.equals("S")) && !(dano2.equals("s")) && !(dano2.equals("n"))
                                            && !(dano2.equals("N")));
                                } while (vidaDracula > 0);
                                break;
                            case "n":
                            case "N":
                                JOptionPane.showMessageDialog(null, "Você optou por não ir para batalha então ficará na sala atual");
                                posAtual = ponteTorre;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção inválida!!! \nDigite novamente");
                        }
                    } while (!(lutar.equals("S")) && !(lutar.equals("s")) && !(lutar.equals("n")) && !(lutar.equals("N")));
                }
            }
            if (posAtual == salaSecreta) {
                String homem = JOptionPane.showInputDialog("Parabéns você derrotou o Conde Drácula gostaria de Tomar a poção"
                        + " para voltar a ser humano? \n(S)im \n(N)ão");
                if (homem.equals("S") || homem.equals("s")) {
                    JOptionPane.showMessageDialog(null, "PARABÉNS VOCÊ TERMINOU THE WAR LYCAN VS VAMPARE E SE "
                            + "\nTORNOU HUMANO NOVAMENTE ASSIM HONRANDO A MORTE DE SEU PAI E AJUDANDO TODA A "
                            + "\nCOMUNIDADE......"
                            + "\n @   @  "
                            + "\n   V    "
                            + "\n ~~~~~~ ");
                } else if ((homem.equals("N") || homem.equals("n"))) {
                    JOptionPane.showMessageDialog(null, "PARABÉNS VOCÊ TERMINOU THE WAR LYCAN VS VAMPARE "
                            + " \nMAS OPTOU EM FICAR ETERNAMENTE COMO UM LYCAN..."
                            + "\n QUE DEUS PROTEJA ESSA COMUNIDADE");

                }
            }

        }

    }
}
