import javax.swing.JOptionPane;
public class Finalizar {
    public static String FechamentoEstatisticas(int Bancos[][], int ValorNota[],int Quantidade[]){
        int i,Banco;
        String Dados = "";
        String Saldo = "";
        String NomeBanco = "";
        
        for(i=0; i<4; i++){
            Banco = i;
            switch(Banco){
                case 0:
                    NomeBanco = "Banco do Brasil";
                    break;
                case 1:
                    NomeBanco = "Santander";
                    break;
                case 2:
                    NomeBanco = "Itaú";
                    break;
                case 3:
                    NomeBanco = "Caixa";
                    break;    
            }
            Dados += ("\n\n"+NomeBanco);
            Dados += ("\nMaior Saque: "+Bancos[0][Banco]);
            Dados += ("\nMenor Saque: "+Bancos[1][Banco]);
            Dados += ("\nQuantidade de Saques: "+Bancos[2][Banco]);
            Dados += ("\nSoma dos Saques: "+Bancos[3][Banco]);
            Dados += ("\nMédia dos Saques: "+Bancos[4][Banco]);
            Dados += ("\n______________________");
        }
        JOptionPane.showMessageDialog(null, Dados);
        Saldo = ("- Caixa 24h - \nRestante:");
        for(i=0; i<6; i++){
            Saldo += ("\nNotas de R$"+ValorNota[i]+": "+Quantidade[i]);
        }
        Saldo += ("\nSaldo do Caixa: "+Bancos[5][0]);
        JOptionPane.showMessageDialog(null, Saldo);
        return Dados;
    }
}