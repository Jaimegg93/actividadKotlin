
fun main() {
    println("Cuantos contactos va tener la agenda")
    var numeroContactos: Int? = readLine()?.toInt()

    if(numeroContactos== null){
        numeroContactos = 10
    }
    var agenda:MutableList<Contacto> = mutableListOf()
    var agenda1: Agenda = Agenda(
        agenda = agenda,
        tamaño = numeroContactos
    )
    agenda1.menu()
}

class Agenda( var agenda:MutableList<Contacto>, var tamaño: Int){

    fun menu(){
        while (true){
        println("\n\n1. Añadir contacto")
        println("2. Listar contactos")
        println("3. Buscar contacto")
        println("4. Existe contacto")
        println("5. Eliminar contacto")
        println("6. Contactos disponibles")
        println("7. Agenda llena")
        println("8. Salir")
        var n = readLine()
            when(n){
                "1" -> añadirContacto()
                "2" -> for(i in agenda){ println("Nombre: " + i.Nombre + " Telefono: " + i.telefono)}
                "3" -> buscarContacto()
                "4" -> existeContacto()
                "5" -> eliminarContacto()
                "6" -> println("Hay "+ (tamaño-agenda.size)+" contacto/s libre/s")
                "7" -> if(agenda.size-tamaño < 0){
                        println("Aun se pueden meter contactos")
                    }
                    else{
                        println("La agenda esta llena")
                    }
                "8" -> break
                else ->  println("opcion no valida")
            }
        }
    }
    fun añadirContacto(){
        println("Escribe un nombre")
        var nombre: String = readLine().toString()
        println("Escribe un telefono")
        var telefono: String = readLine().toString()
        var existe: Boolean = false

        for(i in agenda){
            if(i.Nombre == nombre)  existe= true
        }
        if(existe){
            println("Contacto con ese nombre ya existe")
        }
        else if(agenda.size-tamaño < 0){
            var contactoNuevo = Contacto(Nombre = nombre, telefono = telefono)
            agenda.add(contactoNuevo)
            println("Se ha añadido el contacto")
        }
        else{
            println("La agenda esta llena")
        }
    }

    fun buscarContacto(){
        var contacto = indiceContacto()
        if(contacto!= -1){
            println("Su telefono es " + agenda[contacto].telefono)

        }else{
            println("No se ha encontrado el contacto")
        }
    }


    fun existeContacto(){
        var contacto = indiceContacto()
        if(contacto!= -1){
            println("Existe contacto")
        }else{
            println("No existe contacto")
        }
    }

    fun eliminarContacto(){
        var contacto = indiceContacto()
        if(contacto!= -1){
            agenda.removeAt(contacto)
            println("Se ha eliminado el contacto")
        }else{
            println("No se ha eliminado el contacto")
        }
    }

    fun indiceContacto():Int{
        println("Escribe un nombre")
        var nombre: String = readLine().toString()
        var encontrado: Boolean =false

        for(i in agenda.indices){
            if(agenda[i].Nombre == nombre){
                encontrado = true
                return i
            }
        }
      return -1
    }
}
