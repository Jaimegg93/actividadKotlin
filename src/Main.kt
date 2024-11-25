fun main() {
    val ecu1 = ""
    val ecu2 = "{ [ a * ( c + d ) ] - 5 }"
    val ecu3 = "{ a * ( c + d ) ] - 5 }"
    val ecu4 = "{a^4 + (((ax4)}"
    print(balanceada(ecu1))
}

fun balanceada(ecuacion: String): Boolean{
    val signos:MutableList<Char> = mutableListOf('c')//no se crearlo vacio

    var abren = 0
    var cierran = 0

    for(i in 0..ecuacion.length-1){
        if(ecuacion.get(i) == '{' || ecuacion.get(i) == '(' || ecuacion.get(i) == '[') {
            signos.add(ecuacion.get(i))
            abren++
        }else{
            if(signos.last()== '{' && ecuacion.get(i) == '}'){
                signos.removeAt(signos.size-1)
            }
            if(signos.last()== '(' && ecuacion.get(i) == ')'){
                signos.removeAt(signos.size-1)
            }
            if(signos.last()== '[' && ecuacion.get(i) == ']'){
                signos.removeAt(signos.size-1)
            }
        }
    }

    for(i in 0..ecuacion.length-1){
        if(ecuacion.get(i) == '}' || ecuacion.get(i) == ')' || ecuacion.get(i) == ']') {
            cierran++
        }
    }
    signos.remove('c')

    if( signos.isEmpty() && (cierran == abren)){
        return true
    }
    return false
}