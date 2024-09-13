package sistemadefuncionarios;

// Classe abstrata Funcionario
abstract class Funcionario {
    protected String nome;
    protected double salarioBase;

    // Construtor para inicializar o nome e o salário base
    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    // Método abstrato para calcular o salário
    public abstract double calcularSalario();

    // Método para exibir informações do funcionário
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Salário: R$ " + calcularSalario());
    }
}

// Classe Gerente que estende Funcionario
class Gerente extends Funcionario {
    private double bonus;

    // Construtor que recebe nome, salário base e bônus
    public Gerente(String nome, double salarioBase, double bonus) {
        super(nome, salarioBase);
        this.bonus = bonus;
    }

    @Override
    public double calcularSalario() {
        // Salário do gerente é o salário base mais o bônus
        return salarioBase + bonus;
    }
}

// Classe Programador que estende Funcionario
class Programador extends Funcionario {
    private double horasExtras;

    // Construtor que recebe nome, salário base e horas extras
    public Programador(String nome, double salarioBase, double horasExtras) {
        super(nome, salarioBase);
        this.horasExtras = horasExtras;
    }

    @Override
    public double calcularSalario() {
        // Salário do programador é o salário base mais o valor das horas extras (considerando uma taxa por hora extra)
        double taxaHoraExtra = 20.0; // Taxa por hora extra
        return salarioBase + (horasExtras * taxaHoraExtra);
    }
}

// Classe principal Sistemadefuncionarios
public class Sistemadefuncionarios {

    public static void main(String[] args) {
        // Criação de instâncias de funcionários
        Funcionario gerente = new Gerente("Juan", 5000.0, 1500.0);
        Funcionario programador = new Programador("João", 4000.0, 10); // 10 horas extras

        // Exibição das informações e salários usando polimorfismo
        System.out.println("Informações do Gerente:");
        gerente.exibirInformacoes();
        
        System.out.println();
        
        System.out.println("Informações do Programador:");
        programador.exibirInformacoes();
    }
}
