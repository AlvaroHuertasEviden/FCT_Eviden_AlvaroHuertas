// Crea una función genérica llamada repetir que tome un valor y un número y devuelva un arreglo
// con el valor repetido el número de veces especificado.

function repetir(valor: any, cantidad: number): any[] {
    let arreglo: any = [];
    for (let i = 0; i < cantidad; i++) {
        arreglo.push(valor);
    }
    return arreglo;
}

console.log(repetir("Álvaro", 3));
console.log(repetir(1, 4));