// Escribe una función que intente dividir dos números y maneje cualquier error que pueda surgir.

function dividir(a: number, b: number): number | string {
    try {
        if (b === 0) {
            throw new Error("No se puede dividir entre 0!!!");
        }
        return a / b;
    } catch (error) {
        return error.message;
    }
}

console.log(dividir(10, 2));
console.log(dividir(10, 0));

console.log(dividir(-10, 2));
console.log(dividir(10.23, -2));