public class ContaCorrente extends Conta{
    protected double credito = 1000.0;
    protected double debito = 0.0;

    protected void comprarNoCredito(double valor){
        if(credito >= valor){
            credito -= valor;
            debito += valor;
            System.out.println("Compra realizada! Credito disponivel: " + this.credito);
        }
        else{
            System.out.println("Não há crédito suficiente!\n");
        }
    }

    public double getDebito() {
        return debito;
    }

    public double getCredito() {
        return credito;
    }
}
