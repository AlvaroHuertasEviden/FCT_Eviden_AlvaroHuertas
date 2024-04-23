// Define una clase llamada Rectangulo con propiedades base y altura.
// Agrega un método para calcular el área del rectángulo.

class Rectangulo {
    base: number;
    altura: number;

    constructor(base: number, altura: number) {
        this.base = base;
        this.altura = altura;
    }

    calcularArea(): number {
        return this.base * this.altura;
    }
}

let rectangulo: Rectangulo = new Rectangulo(2, 3);
console.log(`Área del rectángulo: ${rectangulo.calcularArea()}u²`);	