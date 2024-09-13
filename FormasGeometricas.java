public class FormasGeometricas {

    // Classe abstrata FormaGeometrica
    abstract static class FormaGeometrica {
        // Método abstrato para calcular a área
        public abstract double calcularArea();
    }

    // Classe Círculo que estende FormaGeometrica
    static class Circulo extends FormaGeometrica {
        private double raio;

        public Circulo(double raio) {
            this.raio = raio;
        }

        @Override
        public double calcularArea() {
            return Math.PI * Math.pow(raio, 2);
        }
    }

    // Classe Retângulo que estende FormaGeometrica
    static class Retangulo extends FormaGeometrica {
        private double largura;
        private double altura;

        public Retangulo(double largura, double altura) {
            this.largura = largura;
            this.altura = altura;
        }

        @Override
        public double calcularArea() {
            return largura * altura;
        }
    }

    // Classe Triângulo que estende FormaGeometrica
    static class Triangulo extends FormaGeometrica {
        private double base;
        private double altura;

        public Triangulo(double base, double altura) {
            this.base = base;
            this.altura = altura;
        }

        @Override
        public double calcularArea() {
            return (base * altura) / 2;
        }
    }

    // Programa principal
    public static void main(String[] args) {
        // Criação das formas geométricas
        FormaGeometrica circulo = new Circulo(5);
        FormaGeometrica retangulo = new Retangulo(4, 6);
        FormaGeometrica triangulo = new Triangulo(3, 8);

        // Impressão das áreas usando polimorfismo
        System.out.println("Área do Círculo: " + circulo.calcularArea());
        System.out.println("Área do Retângulo: " + retangulo.calcularArea());
        System.out.println("Área do Triângulo: " + triangulo.calcularArea());
    }
}
