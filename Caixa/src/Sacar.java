import javax.swing.JOptionPane;
public class Sacar {
    public static int[][] SacarNotas(int Saldo, int Notas[],int Bancos[][]){
        int ValorNota[] = {2, 5, 10, 20, 50, 100};
        int Saque, Banco, Count, Quantidade, Aux = 0, i, j;
        
        JOptionPane.showMessageDialog(null,"Bem-vindo ao saque.");
        Banco = Integer.parseInt(JOptionPane.showInputDialog("- BANCOS -\n1 - Banco do Brasil\n2 - Santander\n3 - Itaú\n4 - Caixa\n\nDigite o código do seu Banco: "));
        Banco = Banco - 1;
        Saque = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do saque: "));
        
        while(Saque>Saldo){
            JOptionPane.showMessageDialog(null,"Excedeu o limite do caixa!\n");
            Saque = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor novamente, mas agora abaixo de R$: "+Saldo));
        }
        
        if(Bancos[0][Banco] == 0){
            Bancos[0][Banco] = Saque;
            Bancos[1][Banco] = Saque;
        }

        Bancos[5][Banco] = Saldo;
        Aux = Saque;
        
        for(Count = 5; Count >= 0; Count--){
            
            if(Saque >= ValorNota[Count]){
                Quantidade = Integer.parseInt(JOptionPane.showInputDialog("\nQuantas notas de R$"+ValorNota[Count]+"?\n"));
            }
            
            else{
                Quantidade = 0;
            }

            while(Quantidade > Notas[Count] || (Quantidade*ValorNota[Count])>Saldo || (Quantidade*ValorNota[Count])>Saque){
                Quantidade = Integer.parseInt(JOptionPane.showInputDialog("Ops, exagerou na quantidade. Digite novamente: \n"));
            }
            if(Saque >= 0 && Saque >= ValorNota[Count]){
                Notas[Count] = Notas[Count] - Quantidade;
                Saque = Saque - (Quantidade*ValorNota[Count]);
                Saldo = Saldo - (Quantidade*ValorNota[Count]);
            }
            
            if(Count == 0){
                
                Aux = Aux - Saque;
                if(Saque > 0){
                    JOptionPane.showMessageDialog(null, "\nSaque finalizado, o valor restante de R$"+ Saque +", continuará em sua conta.");
                    JOptionPane.showMessageDialog(null,"\nValor final do saque foi: R$"+ Aux +".\n");
                    if((Bancos[0][Banco]-Saque)<=Aux){
                        Bancos[0][Banco] = Aux;
                    }
                    Saque = Aux - Saque;
                }
                else{
                    JOptionPane.showMessageDialog(null,"\nSaque finalizado.");
                    JOptionPane.showMessageDialog(null,"\nValor final do saque foi: R$"+ Aux +".\n");
                }
            }
            else if (Count != 0 && Saque == 0){
                JOptionPane.showMessageDialog(null,"\nSaque finalizado.");
                JOptionPane.showMessageDialog(null,"\nValor final do saque foi: R$"+ Aux +".\n");
            }
            
            if(Saque == 0){
                Count = -1;
            }
        }
        
        if(Aux > Bancos[0][Banco]){
            Bancos[0][Banco] = Aux;
        }
        else if(Aux < Bancos[1][Banco]){
            Bancos[1][Banco] = Aux;
        }
        
        Bancos[2][Banco]=Bancos[2][Banco] + 1;
        Bancos[3][Banco]=Bancos[3][Banco] + Aux;
        Bancos[4][Banco]=Bancos[3][Banco] / Bancos[2][Banco];
        
        for(j=0; j<4; j++){
            Bancos[5][j]=Bancos[5][j] - Aux;
        }
        
        for(i=0; i<6; i++){
            Bancos[i][4]=Notas[i];
        }
        
        return Bancos;
    }
}
