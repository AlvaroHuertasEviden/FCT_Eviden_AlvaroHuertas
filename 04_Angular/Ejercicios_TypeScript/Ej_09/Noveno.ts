// Crea un decorador llamado log que imprima un mensaje antes y después de llamar a una función.

function log(target: any, nombreMetodo: string, descriptor: PropertyDescriptor) {

        let originalMethod = descriptor.value;

        descriptor.value = function(...args: any[]) {
            console.log(`Llamando a ${nombreMetodo}`);
            let result = originalMethod.apply(this, args);
            console.log(`Fin de la llamada a ${nombreMetodo}`);
            return result;
        }

        return descriptor;
    }



class Persona {
    nombre: string;
    edad: number;

    constructor(nombre: string, edad: number) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @log
    saludar(): void {
        console.log(`Hola soy ${this.nombre} y tengo ${this.edad} años`);
    }
}

let persona: Persona = new Persona("Álvaro", 21);
persona.saludar();

