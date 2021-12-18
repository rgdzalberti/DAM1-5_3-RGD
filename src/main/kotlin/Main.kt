
class Agenda(contacto: String = "", numero: String = ""){

    val listaContactos = mutableListOf<String>("Juan","Pedro","Helena")
    val listaNumeros = mutableListOf<String>("+34634581940","+34947102064","+34634539940")

    fun añadirContacto(contacto:String){
        //Esta variable se pondrá en true si encuentra en la lista el contacto introducido
        var igualEncontrado: Boolean = false
        //Esta variable guardara la posición en la que esta el contacto repetido si igualEncontrado se pone en true
        var posicionIgual: Int = 0
        listaContactos.forEach {if (it==contacto) {igualEncontrado = true; posicionIgual = listaContactos.indexOf(it)}}
        //Creo una variable Introducido para usarlo abajo. Esta variable cuando es true indicará que se ha metido en el primer vacio o null de la lista
        var Introducido: Boolean = false; var i = 0; var numero = ""
        //Voy a introducirlo buscando si hay un null, como en la lista no hay nulls soltará un IndexoutOfBoundsException así que le hago un try catch para simplemente añadirlo con un .add en ese caso
        try{if (igualEncontrado == true) { println("El contacto ya existe y este es su número: ${listaNumeros[posicionIgual]}")}
        else {println("Introduce un número para registrarlo con el contacto: "); numero = readLine().toString();while (Introducido != true) {if (listaContactos[i].isNullOrEmpty()) {listaNumeros[i] = numero; listaContactos[i] = contacto; Introducido = true} else {i++}} }}
        catch (e: IndexOutOfBoundsException) {listaContactos.add(contacto); listaNumeros.add(numero)}
    }

    fun añadirNumero(numero: String){
        //El funcionamiento es igual que en añadirContacto pero intercambiando Numero y Contacto
        var igualEncontrado: Boolean = false
        var posicionIgual: Int = 0
        listaNumeros.forEach {if (it==numero) {igualEncontrado = true; posicionIgual = listaNumeros.indexOf(it)}}
        var Introducido: Boolean = false; var i = 0; var contacto = ""
        try{if (igualEncontrado == true) { println("El número ya existe y este es su contacto: ${listaContactos[posicionIgual]}")}
        else {println("Introduce un contacto para registrarlo con el número: "); contacto = readLine().toString(); while (Introducido != true) {if (listaNumeros[i].isNullOrEmpty()) {listaNumeros[i] = numero; listaContactos[i] = contacto; Introducido = true} else {i++}} }}
        catch (e: IndexOutOfBoundsException) {listaContactos.add(contacto); listaNumeros.add(numero)}
    }

    fun listaContactosOrdenados(): List<Pair<String,String>>{
        val listaAmbos = mutableListOf<Pair<String,String>>()
        listaContactos.forEach {listaAmbos.add(Pair(it,listaNumeros.elementAt(listaContactos.indexOf(it))))}
        return listaAmbos.sortedBy { it.first }
    }

    fun textoSimilar(textoABuscar: String): List<Pair<String,String>>{
        val listaAmbos = mutableListOf<Pair<String,String>>()
        //Hago lo mismo que en listaContactosOrdenados pero con un paso más. Solo añado aquellos cuyos pairs contiene algo del textoABuscar
        val listaSimilar = mutableListOf<Pair<String,String>>()
        listaContactos.forEach {listaAmbos.add(Pair(it,listaNumeros.elementAt(listaContactos.indexOf(it))))}
        for (i in 0 until listaAmbos.size) {if (listaAmbos[i].first.contains(textoABuscar) || listaAmbos[i].second.contains(textoABuscar)) {listaSimilar.add(listaAmbos[i])}}
        return listaSimilar
    }

}


fun main() {

    //Utilizare esta variable para acceder a Agenda en adelante
    var Input = Agenda()

    var input: String = ""
    println("Introduce un nombre o número: ")
    input = readLine().toString()


    //Primero elimino los espacios dejados en el input (si hay) para que no haya problemas al compararlos
    input = input.filter { !it.isWhitespace() }

    //En las instrucciones ponia que la primera posición de una palabra tenia que ser una letra, así que si no es una letra será un número.
    var esNombre = false
    if (input[0].isLetter()) {esNombre = true} else esNombre = false
    if (esNombre == true) {Input.añadirContacto(input)} else {Input.añadirNumero(input)}


    //No he terminado de entender como meter los comandos especiales. Como viene después de la explicación de tener que introducir un número o nombre en el programa
    //voy a dar por hecho que es un switch después de terminar el algoritmo de haber introducido el número/nombre
    //Tampoco termino de entender lo de filtrar texto a buscar. Texto a buscar de nombre? numero? Voy a dar por hecho que son ambos

    println("----------------------------------------------------------")
    println("Introduce un número referente a los comandos especiales:  ")
    println("----------------------------------------------------------")
    println("         1 - Adios (Terminar el programa)                 ")
    println("                    2 - Listado                           ")
    println("             3 - Filtrar Texto a buscar                   ")
    println("----------------------------------------------------------")
    var eleccion = readLine()?.toInt()

    when(eleccion){

        1 -> {println("Se acabó el programa.")}
        2 -> {println(Input.listaContactosOrdenados())
            println("----------------------------------------------------------")
            println("Introduce un número referente a los comandos especiales:  ")
            println("----------------------------------------------------------")
            println("         1 - Adios (Terminar el programa)                 ")
            println("                    2 - Listado                           ")
            println("             3 - Filtrar Texto a buscar                   ")
            println("----------------------------------------------------------")
            eleccion = readLine()?.toInt()
        }

        3->{
            println("Introduce el texto a buscar")
            var textoABuscar: String = readLine().toString()
            if (Input.textoSimilar(textoABuscar).isEmpty()) println("No hay ningún contacto") else println(Input.textoSimilar(textoABuscar))
            println("----------------------------------------------------------")
            println("Introduce un número referente a los comandos especiales:  ")
            println("----------------------------------------------------------")
            println("         1 - Adios (Terminar el programa)                 ")
            println("                    2 - Listado                           ")
            println("             3 - Filtrar Texto a buscar                   ")
            println("----------------------------------------------------------")
            eleccion = readLine()?.toInt()
        }

        else -> {println("No has introducido una opción válida, por favor introduce uno de los siguientes números:")
            println("----------------------------------------------------------")
            println("Introduce un número referente a los comandos especiales:  ")
            println("----------------------------------------------------------")
            println("         1 - Adios (Terminar el programa)                 ")
            println("                    2 - Listado                           ")
            println("             3 - Filtrar Texto a buscar                   ")
            println("----------------------------------------------------------")
            eleccion = readLine()?.toInt()
        }
    }

}
