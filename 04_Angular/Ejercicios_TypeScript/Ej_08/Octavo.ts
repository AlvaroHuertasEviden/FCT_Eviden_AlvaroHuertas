// Escribe una función que tome un argumetno y devuelva un número si el argumento es un número,
// y una cadena si el argumento es una cadena.

function devolverNumeroOCadena(valor: string | number): string {
    if (typeof valor === "number") {
        return "valor es un número";
    }
    else {
        return "valor es una cadena";
    }
}

console.log(devolverNumeroOCadena(21));
console.log(devolverNumeroOCadena("Hola mundo"));