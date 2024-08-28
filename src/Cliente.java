import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String senha;
    protected List<Conta> contas;

    public Cliente(String nome, String senha){
        this.contas = new ArrayList<>();
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void listarContas(){
        for (int i = 0; i < contas.size(); i++) {
            Conta conta = contas.get(i);
            System.out.println("Conta " + (i+1) + ": " + conta.getAgencia() + "/" + conta.getConta() + ". Saldo: " + conta.getSaldo()); 
        }
    }

}
