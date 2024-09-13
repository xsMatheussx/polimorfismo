package gerenciamento.de.animais;

import java.util.ArrayList;
import java.util.List;

// Classe abstrata Animal
abstract class Animal {
    // Métodos abstratos
    public abstract void emitirSom();
    public abstract void mover();
}

// Classe Cachorro que estende Animal
class Cachorro extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("O cachorro late: Au au!");
    }

    @Override
    public void mover() {
        System.out.println("O cachorro corre.");
    }
}

// Classe Gato que estende Animal
class Gato extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("O gato mia: Miau!");
    }

    @Override
    public void mover() {
        System.out.println("O gato anda pelos telhados.");
    }
}

// Classe Pássaro que estende Animal
class Passaro extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("O pássaro canta: Piu piu!");
    }

    @Override
    public void mover() {
        System.out.println("O pássaro voa.");
    }
}

// Classe principal GerenciamentoDeAnimais
public class GerenciamentoDeAnimais {

    public static void main(String[] args) {
        // Criação de uma lista de animais
        List<Animal> animais = new ArrayList<>();
        animais.add(new Cachorro());
        animais.add(new Gato());
        animais.add(new Passaro());

        // Usando polimorfismo para chamar os métodos emitirSom() e mover()
        for (Animal animal : animais) {
            animal.emitirSom();
            animal.mover();
            System.out.println(); // Separador entre as ações dos animais
        }
    }
}
