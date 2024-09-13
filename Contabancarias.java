package contabancarias;

// Classe abstrata ContaBancaria
abstract class ContaBancaria {
    protected double saldo;

    // Construtor para inicializar o saldo
    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    // Métodos abstratos para saque e depósito
    public abstract void sacar(double valor);
    public abstract void depositar(double valor);

    // Método para exibir o saldo atual
    public void exibirSaldo() {
        System.out.println("Saldo atual: " + saldo);
    }
}

// Classe ContaCorrente que estende ContaBancaria
class ContaCorrente extends ContaBancaria {
    private double limite;

    // Construtor que recebe saldo inicial e limite
    public ContaCorrente(double saldoInicial, double limite) {
        super(saldoInicial);
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
        if (saldo + limite >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso da Conta Corrente.");
        } else {
            System.out.println("Saldo insuficiente na Conta Corrente.");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado na Conta Corrente.");
    }
}

// Classe ContaPoupanca que estende ContaBancaria
class ContaPoupanca extends ContaBancaria {

    // Construtor que recebe saldo inicial
    public ContaPoupanca(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso da Conta Poupança.");
        } else {
            System.out.println("Saldo insuficiente na Conta Poupança.");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado na Conta Poupança.");
    }
}

// Classe principal Contabancarias
public class Contabancarias {

    public static void main(String[] args) {
        // Criação das contas bancárias
        ContaBancaria contaCorrente = new ContaCorrente(1000.0, 500.0); // Saldo inicial R$1000, Limite R$500
        ContaBancaria contaPoupanca = new ContaPoupanca(1500.0); // Saldo inicial R$1500

        // Operações na Conta Corrente
        System.out.println("Operações na Conta Corrente:");
        contaCorrente.depositar(200); // Deposita R$200
        contaCorrente.sacar(1100); // Saca R$1100
        contaCorrente.exibirSaldo(); // Exibe o saldo atual
        System.out.println();

        // Operações na Conta Poupança
        System.out.println("Operações na Conta Poupança:");
        contaPoupanca.depositar(300); // Deposita R$300
        contaPoupanca.sacar(500); // Saca R$500
        contaPoupanca.exibirSaldo(); // Exibe o saldo atual
    }
}
