package sistemadepagamento;

// Classe abstrata Pagamento
abstract class Pagamento {
    protected double valor;

    // Construtor para inicializar o valor do pagamento
    public Pagamento(double valor) {
        this.valor = valor;
    }

    // Método abstrato para calcular o valor final do pagamento
    public abstract double calcularValor();
}

// Classe PagamentoCartaoCredito que estende Pagamento
class PagamentoCartaoCredito extends Pagamento {
    private double taxaJuros; // Taxa de juros aplicada a pagamentos com cartão de crédito

    // Construtor que recebe o valor do pagamento e a taxa de juros
    public PagamentoCartaoCredito(double valor, double taxaJuros) {
        super(valor);
        this.taxaJuros = taxaJuros;
    }

    @Override
    public double calcularValor() {
        // Calcula o valor final com a taxa de juros
        return valor + (valor * taxaJuros / 100);
    }
}

// Classe PagamentoBoleto que estende Pagamento
class PagamentoBoleto extends Pagamento {
    private double desconto; // Desconto aplicado a pagamentos por boleto

    // Construtor que recebe o valor do pagamento e o desconto
    public PagamentoBoleto(double valor, double desconto) {
        super(valor);
        this.desconto = desconto;
    }

    @Override
    public double calcularValor() {
        // Calcula o valor final com o desconto aplicado
        return valor - (valor * desconto / 100);
    }
}

// Classe principal Sistemadepagamento
public class Sistemadepagamento {

    public static void main(String[] args) {
        // Criação de métodos de pagamento
        Pagamento pagamentoCartao = new PagamentoCartaoCredito(1000.0, 10.0); // Valor de R$1000, juros de 10%
        Pagamento pagamentoBoleto = new PagamentoBoleto(1000.0, 5.0); // Valor de R$1000, desconto de 5%

        // Exibição dos valores calculados com polimorfismo
        System.out.println("Valor do pagamento com Cartão de Crédito: R$ " + pagamentoCartao.calcularValor());
        System.out.println("Valor do pagamento com Boleto: R$ " + pagamentoBoleto.calcularValor());
    }
}
