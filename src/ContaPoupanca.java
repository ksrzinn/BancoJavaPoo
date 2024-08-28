public class ContaPoupanca extends Conta{
    private double taxaRendimentoMes = (136.40/100)/12;

    private void aplicarRendimentoMes(){
        this.saldo += this.saldo * taxaRendimentoMes;
    }

    public ContaPoupanca(){
        super();
        this.aplicarRendimentoMes(); //Sempre aplica o rendimento do mes como bonus na criacao da conta, apenas para utilizar o metodo, ja que nao foi feito nenhum deposito ainda
    }
}


