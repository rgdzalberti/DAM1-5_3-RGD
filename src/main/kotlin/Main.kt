
class Agenda(contacto: String = "", numero: String = ""){

    val listaContactos = mutableListOf<String>()
    val listaNumeros = mutableListOf<String>()

    fun añadirContacto(contacto:String){
        //Esta variable se pondrá en true si encuentra en la lista el contacto introducido
        var igualEncontrado: Boolean = false
        //Esta variable guardara la posición en la que esta el contacto repetido si igualEncontrado se pone en true
        var posicionIgual: Int = 0
        listaContactos.forEach {if (it==contacto) {igualEncontrado = true; posicionIgual = listaContactos.indexOf(it)}}
        //Creo una variable Introducido para usarlo abajo. Esta variable cuando es true indicará que se ha metido en el primer vacio o null de la lista
        var Introducido: Boolean = false
        if (igualEncontrado == true) { println("El contacto ya existe y este es su número ${listaNumeros[posicionIgual]}")}
        else {println("Introduce un número para registrarlo con el contacto: "); var numero = readLine().toString(); while (Introducido != true) {var i = 0;if (listaContactos[i].isNullOrEmpty()) {listaNumeros[i] = numero; listaContactos[i] = contacto} else {i++}} }}

    fun añadirNumero(numero: String){
        //El funcionamiento es igual que en añadirContacto pero intercambiando Numero y Contacto
        var igualEncontrado: Boolean = false
        var posicionIgual: Int = 0
        listaContactos.forEach {if (it==numero) {igualEncontrado = true; posicionIgual = listaNumeros.indexOf(it)}}
        var Introducido: Boolean = false
        if (igualEncontrado == true) { println("El número ya existe y este es su contacto ${listaContactos[posicionIgual]}")}
        else {println("Introduce un número para registrarlo con el contacto: "); var contacto = readLine().toString(); while (Introducido != true) {var i = 0;if (listaNumeros[i].isNullOrEmpty()) {listaNumeros[i] = numero; listaContactos[i] = contacto} else {i++}} }
    }

}


fun main() {

    //Introduzco 10 nombres y 10 números para el funcionamiento del programa


    var input: String = ""
    println("Introduce un nombre o número: ")
    input = readLine().toString()

    //Para comprobar si es un número compruebo con un while si contiene alguna letra, si es así esNombre saldrá true y lo meteré en el método de Contacto sino lo meteré en el de número
    var esNombre = false; var i = 0; var Input = Agenda()
    while (esNombre != true || i == input.length && esNombre == false) {if (input[i].isLetter()) {esNombre = true} else {i++}}
    if (esNombre == true) {Input.añadirContacto(input)} else {Input.añadirNumero(input)}


    //Comandos especiales con switch

}

/*
Crear un programa para gestionar una agenda de contactos. El funcionamiento será el siguiente:

- El programa pedirá introducir algo por teclado:
o Si se introduce un número de teléfono comprobará si existe, si es así mostrará a quién pertenece. Si no existe pedirá el nombre del contacto para darlo de alta.

o Si se introduce un contacto debe comprobar si existe, si es así mostrará el número de teléfono. Si no existe pedirá el número de teléfono para darlo de alta.

- Debe reconocer números de teléfono con espacios entre los dígitos o no y con el símbolo + al principio para indicar prefijo de país.
- Los nombres deben comenzar por letras y pueden contener números y caracteres especiales imprimibles.

- Comandos especiales:
o adios: Sale del programa
o listado: Muestra el listado completo de contactos ordenados por nombre
o filtra texto_a_buscar: Muestra el listado de los contactos que contengan texto_a_buscar o “Ningún
contacto” si no hubiera ninguno.

- Se deben crear funciones cuando sea adecuado (por ejemplo, comprobar si existe un contacto en la agenda, comprobar si un texto puede ser un número de teléfono, etc).
 */