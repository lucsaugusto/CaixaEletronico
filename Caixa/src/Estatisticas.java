import javax.swing.JOptionPane;
public class Estatisticas {
    public static String GerarEstatisticas(int Bancos[][]){
        int Banco;
        String Dados = "";
        Banco = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do banco para gerar as estatísticas.\n- BANCOS -\n1 - Banco do Brasil\n2 - Santander\n3 - Itaú\n4 - Caixa"));
        Banco = Banco - 1;
        Dados += ("Maior Saque: "+Bancos[0][Banco]);
        Dados += ("\nMenor Saque: "+Bancos[1][Banco]);
        Dados += ("\nQuantidade de Saques: "+Bancos[2][Banco]);
        Dados += ("\nSoma dos Saques: "+Bancos[3][Banco]);
        Dados += ("\nMédia dos Saques: "+Bancos[4][Banco]);
        Dados += ("\nSaldo do Caixa: "+Bancos[5][Banco]);
        JOptionPane.showMessageDialog(null, Dados);
        return Dados;
    }
}
