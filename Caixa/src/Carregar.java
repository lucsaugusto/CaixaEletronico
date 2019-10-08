import javax.swing.JOptionPane;
public class Carregar {
    public static int[] CarregarNotas(){
        int Nota, Count;
        int Notas[]=new int[6];
        int ValorNota[] = {2, 5, 10, 20, 50, 100};
        
        JOptionPane.showMessageDialog(null,"Bem-vindo ao abastecimento de notas do caixa 24h.\nPor favor, digitar a quantidade de notas para cada tipo.");
        for(Count = 0; Count <= 5; Count++){
            Nota = Integer.parseInt(JOptionPane.showInputDialog("Notas de "+ValorNota[Count]+" reais."));
            Notas[Count] = (Nota * ValorNota[Count]);
        }
        return Notas;
    }
}
