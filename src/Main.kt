fun main() {
    val r = arrayOf("saltar", "saltar", "saltar", "correr", "saltar", "saltar", "saltar")
    val x = ("|||_|_")

    print("   "+carrera(r,x))
}

fun carrera(acciones: Array<String>, obstaculos: String): Boolean {

    var vaBien = true;
    var indice = 1

    if(acciones.size > obstaculos.length){
        indice = obstaculos.length
    }
    else{
        indice = acciones.size
    }

    for(i in 0 until indice ){
        if(acciones.get(i) == "correr" &&  obstaculos.get(i) == '|'){
            print("/")
             vaBien = false;
        }
        else if(acciones.get(i) == "saltar" &&  obstaculos.get(i) == '_'){
            print("x")
             vaBien = false;
        }
        else if(acciones.get(i)=="correr" && obstaculos.get(i) == '_'){
            print("_")
        }
        else if(acciones.get(i)=="saltar" && obstaculos.get(i) == '|'){
            print("|")
        }else{
            print("?")
            vaBien = false
        }
    }
    for(i in 0 until Math.abs(acciones.size-obstaculos.length)){
        print("?")
        vaBien = false
    }

    return vaBien
}