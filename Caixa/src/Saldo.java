public class Saldo {
    public static int CalcSaldo(int Valores[]){
        int Saldo = 0, Count;
        for(Count = 0; Count<=5; Count++){
            Saldo = Saldo + Valores[Count];
        }
        return Saldo;
    }
}
