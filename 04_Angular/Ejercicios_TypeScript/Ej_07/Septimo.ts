// Declara una variable que pueda ser de tipo "hombre" o "mujer". Luego, imprime un mensaje basado
// en el valor de esa variable.

enum Genero {
    hombre = "hombre",
    mujer = "mujer"
}

let genero: Genero = Genero.hombre;

console.log(`El género es ${genero}.`);