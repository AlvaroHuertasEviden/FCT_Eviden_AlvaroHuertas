"use strict";
// Crea un decorador llamado log que imprima un mensaje antes y después de llamar a una función.
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
function log(target, nombreMetodo, descriptor) {
    let originalMethod = descriptor.value;
    descriptor.value = function (...args) {
        console.log(`Llamando a ${nombreMetodo}`);
        let result = originalMethod.apply(this, args);
        console.log(`Fin de la llamada a ${nombreMetodo}`);
        return result;
    };
    return descriptor;
}
class Persona {
    constructor(nombre, edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    saludar() {
        console.log(`Hola soy ${this.nombre} y tengo ${this.edad} años`);
    }
}
__decorate([
    log
], Persona.prototype, "saludar", null);
let persona = new Persona("Álvaro", 21);
persona.saludar();
