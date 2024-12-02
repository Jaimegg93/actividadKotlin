
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