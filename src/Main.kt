import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    println("Introduzca una palabra:")
    val palabra1 = scanner.next()
    println("Introduzca otra palabra:")
    val palabra2 = scanner.next()

    val r = palabras(palabra1,palabra2)
    println("¿Las palabras $palabra1 y $palabra2 son anagramas? =  $r")
}
fun palabras(palabra1: String, palabra2: String): Boolean{
    if(palabra1.length != palabra2.length){
        return false
    }
    if(palabra1.equals(palabra2) ){
        return false
    }
    var num = 0;
    for(i in palabra1){
        for(j in palabra2){
            if(i == j){
                num++;
                break;
            }
        }
    }
    if(num != palabra1.length){
        return false
    }

    return true
}