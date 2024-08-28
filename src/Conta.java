import java.util.concurrent.ThreadLocalRandom;

public abstract class Conta {
    protected String agencia;
    protected String conta;
    protected double saldo;


    public Conta(){
        this.agencia = String.valueOf(ThreadLocalRandom.current().nextInt(100, 999));
        this.conta = String.valueOf(ThreadLocalRandom.current().nextInt(1000, 9999));
        this.saldo = 0.0;
    }

    protected String getAgencia() {
        return agencia;
    }
    
    protected String getConta() {
        return conta;
    }

    protected void saque(double saque) {
        if (this.saldo >= saque) {
            this.saldo -= saque;
            System.out.println("\nO valor do saque foi de: " + saque + ". Valor atual: " + this.saldo + "\n");
        }
        else{
            System.out.println("\nSaldo insuficiente para saque\n");
        }
    }

    protected void deposito(double valor){
        this.saldo += valor;
        System.out.println("Deposito de " + valor + " realizado! Valor atual: " + this.saldo + "\n");
    }

    public double getSaldo() {
        return saldo;
    }

    public void transferencia(Conta contaDestino, double valor){
        this.saldo -= valor;
        contaDestino.deposito(valor);
        System.out.println("Transferencia realizada!\n");
    }

}
