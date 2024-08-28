import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//listar contas do cliente e acessar pelo indice + 1 que sera listado junto com a conta

public class Banco {
    Scanner scanner = new Scanner(System.in);

    private List<Cliente> clientes;
    private int clienteAtual;

    public Banco(){
        clientes = new ArrayList<>();
    }

    private void adicionarCliente(String nome, String senha){
        clientes.add(new Cliente(nome, senha));
    }

    private boolean login(){
        System.out.println("Insira seu nome abaixo:\nNome: ");
        String nome = scanner.nextLine();
        System.out.println("Insira sua senha abaixo:\nSenha: ");
        String senha = scanner.nextLine();
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNome().equals(nome) && clientes.get(i).getSenha().equals(senha)){
                System.out.println("Bem vindo, " + clientes.get(i).getNome() + "!\n");
                this.clienteAtual = i;
                return true;
            }
        }
        return false;
    }

    private void criarContaCorrente(){
        this.clientes.get(clienteAtual).contas.add(new ContaCorrente());
        System.out.println("Conta corrente criada com sucesso!\n");
    }
    
    private void criarContaPoupanca(){
        this.clientes.get(clienteAtual).contas.add(new ContaPoupanca());
        System.out.println("Conta poupanca criada com sucesso!\n");
    }

    private void mostrarContas(){
        System.out.println("Contas do cliente " + clientes.get(clienteAtual).getNome() + ":\n");
        for (Cliente cliente: clientes){
            cliente.listarContas();
        }
    }

    private void escolherConta(){
        mostrarContas();
        System.out.println("Escolha a conta que deseja acessar: ");
        Conta contaEscolhida = clientes.get(clienteAtual).contas.get(scanner.nextInt() - 1);
        menuConta(contaEscolhida);
    }

    private void menuConta(Conta conta){
        int escolha = 0;
        
        do{
            System.out.println("=== Menu Conta ===\n\nEscolha uma opção abaixo:\n1 - Depositar\n2 - Sacar\n3-Transferencia\n0 - Voltar");
            System.out.println("Escolha: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Insira o valor a ser depositado: "); 
                    conta.deposito(scanner.nextDouble());
                    break;

                case 2:
                    System.out.println("Insira o valor a ser depositado: ");
                    conta.saque(scanner.nextDouble());
                    break;

                case 3:
                    fazerTransferencia(conta);
                    break;
            
                case 0:
                    System.out.println("Voltando para o menu principal...!\n");
                    break;
            }
        }while(escolha != 0);
    }

    private void fazerTransferencia(Conta origem){
        System.out.println("=== Fazer Transferencia ===\n");
        mostrarContas();
        System.out.println("Escolha a conta de destino: ");
        int escolhaContaDestino = scanner.nextInt() - 1;
        Conta destino = this.clientes.get(clienteAtual).contas.get(escolhaContaDestino); 
        System.out.println("Valor da transferencia: ");
        double valor = scanner.nextDouble();
        if(origem != destino){
            origem.transferencia(destino, valor);
        } else {
            System.out.println("Não é possível transferir para a mesma conta!\n");
        }
    }

    public void boasVindas(){
        System.out.println("Bem vindo ao Banco Banquinho!\nPor favor, realize seu login para continuar...\n");
        boolean logged = login();
        do{
            if(logged){
                menuPrincipal();
            }
            else{
                System.out.println("Login invalido, tente novamente!\n");
                logged = login();
            }
        } while(!logged);
    }

    private void menuPrincipal(){
        int escolha = 0;
        
        do{
            System.out.println("=== Menu ===\n");
            System.out.println("1 - Criar conta corrente");
            System.out.println("2 - Criar conta poupanca");
            System.out.println("3 - Listar contas");
            System.out.println("4 - Acessar conta");
            System.out.println("0 - Sair");
            
            System.out.println("Escolha: ");
            escolha = scanner.nextInt();

            switch(escolha){
                case 1:
                    criarContaCorrente();
                    break;
                case 2:
                    criarContaPoupanca();
                    break;
                case 3:
                    mostrarContas();
                    break;
                case 4:
                    escolherConta();
                    break;
                case 5: 
                    System.out.println("\nSaindo...!\n");
                    break;
            }

        }while(escolha != 0);

    }

    public static void main(String[] args) {
        Banco banco = new Banco();

        banco.adicionarCliente("Arthur", "123");
        banco.adicionarCliente("Lucca", "456");
        banco.adicionarCliente("Thiago", "789");

        banco.boasVindas();
    }
}
