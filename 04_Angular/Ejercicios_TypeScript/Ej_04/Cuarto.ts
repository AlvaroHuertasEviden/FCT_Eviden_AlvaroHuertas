// Crea una interfaz llamada Persona que tenga propiedades nombre y edad. Luego, crea una función que acepte un parámetro de tipo
// Persona e imprima su nombre y edad.

interface Persona {
    nombre: string;
    edad: number;
}

function imprimirPersona(persona: Persona): void {
    console.log(`Nombre: ${persona.nombre}, Edad: ${persona.edad}`);
}

let persona: Persona = {
    nombre: "Álvaro",
    edad: 21
};

imprimirPersona(persona);