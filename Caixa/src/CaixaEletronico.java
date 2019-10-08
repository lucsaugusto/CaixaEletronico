import javax.swing.JOptionPane;
public class CaixaEletronico {
    public static void main(String[] args) {
        int Notas[] = new int[6];
        int ValorNota[] = {2, 5, 10, 20, 50, 100};
        int Quantidade[] = new  int[6];
        int Bancos[][] = new int[6][5];
        int SaldoCaixa = 0, opc = 0, Fechar = 0, i, j;
        String Mostra = "";
        String Resposta = "";
        
        JOptionPane.showMessageDialog(null,"Bem-vindo ao caixa 24h.");
        do {
        opc = Integer.parseInt(JOptionPane.showInputDialog("Por favor, selecione a operação que deseja realizar.\n1 - Carregar notas\n2 - Realizar saque \n3 - Saldo do caixa \n4 - Gerar estatísticas \n9 - Finalizar"));
            switch (opc){
                case 1: 
                        if(Fechar == 0){
                            Fechar++;
                        }
                        else{
                            Resposta =  JOptionPane.showInputDialog("O caixa já foi abastecido hoje, para realizar um novo abastecimento, é necessário o encerramento do ciclo atual\nDeseja continuar?(S/N)");
                            if(Resposta.equalsIgnoreCase("S")){
                                opc = 9;
                                JOptionPane.showMessageDialog(null,"Operação finalizada.");
                                Finalizar.FechamentoEstatisticas(Bancos, ValorNota, Quantidade);
                            break;
                            }
                            else{
                                break;
                            }
                        }
                        Notas = Carregar.CarregarNotas();
                        SaldoCaixa = Saldo.CalcSaldo(Notas);
                        for(i=0; i<6; i++){
                            for(j=0; j<4; j++){
                                if(i == 5){
                                    Bancos[i][j] = SaldoCaixa;
                                }
                                else{
                                   Bancos[i][j] = 0; 
                                }
                                Quantidade[i] = Notas[i]/ValorNota[i];
                            }
                        }
                        break;
                    
                case 2:
                        Bancos = Sacar.SacarNotas(SaldoCaixa, Quantidade, Bancos);
                        for(i=0; i<6; i++){
                            Quantidade[i] = Bancos[i][4];
                        }
                        SaldoCaixa = Bancos[5][0];
                        break;
                    
                case 3: 
                        for(i=0; i<6; i++){
                            Mostra += ("Notas de R$"+ValorNota[i]+": "+Quantidade[i]+"\n"); 
                        }
                        JOptionPane.showMessageDialog(null,Mostra+"\nSaldo no caixa: R$"+SaldoCaixa);
                        Mostra = "";
                        break;
                    
                case 4: Estatisticas.GerarEstatisticas(Bancos);
                        break;
                        
                case 9: JOptionPane.showMessageDialog(null,"Operação finalizada.");
                        Finalizar.FechamentoEstatisticas(Bancos, ValorNota, Quantidade);
                        break;
                        
                default: JOptionPane.showMessageDialog(null,"Opção inválida");
            }
        }
        while(opc != 9);
    }
}
