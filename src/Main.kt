fun main() {
    val tablero: Array<Array<String>> = arrayOf(arrayOf("X", "O", "X"), arrayOf("O", "X", "O"), arrayOf("O", "O", "X"))
    val tablero2: Array<Array<String>> = arrayOf(arrayOf("", "O", "X"), arrayOf("", "X", "O"), arrayOf("", "O", "X"))
    val tablero3: Array<Array<String>> = arrayOf(arrayOf("O", "O", "O"), arrayOf("O", "X", "X"), arrayOf("O", "X", "X"))
    val tablero4: Array<Array<String>> = arrayOf(arrayOf("X", "O", "X"), arrayOf("O", "X", "O"), arrayOf("X", "O", "X"))

    println(tresEnRaya(tablero))
    println(tresEnRaya(tablero2))
    println(tresEnRaya(tablero3))
    println(tresEnRaya(tablero4))

}

fun tresEnRaya(tablero:Array<Array<String>>): String{

    if(tablero[0].size != 3 || tablero[1].size != 3 || tablero[2].size != 3){
        return "nulo"
    }

    var x = 0
    var o = 0
    for(i in 0 until 3){
        for( j in 0 until 3){
            if(tablero[i][j] == "X"){
                x++
            }
            else if(tablero[i][j] == "O"){
                o++
            }
        }
    }
    if((x-o)>1 || (x-o)<-1 ){
        return "nulo"
    }

    var gananX = false
    var gananO = false

    for(i in 0  until  3){
        if(tablero[i][0]=="X" && tablero[i][1] == "X" && tablero[i][2] == "X"){
            gananX = true
        }else if(tablero[i][0]=="O" && tablero[i][1] == "O" && tablero[i][2] == "O")
            gananO = true
    }

    for(i in 0  until  3){
        if(tablero[0][i]=="X" && tablero[1][i] == "X" && tablero[2][i] == "X"){
            gananX = true
        }else if(tablero[0][i]=="O" && tablero[1][i] == "O" && tablero[2][i] == "O")
            gananO = true
    }

    if((tablero[0][0]=="X" && tablero[1][1] == "X" && tablero[2][2] == "X")||(tablero[0][2]=="X" && tablero[1][1] == "X" && tablero[2][0] == "X")){
        gananX = true
    }else if((tablero[0][0]=="O" && tablero[1][1] == "O" && tablero[2][2] == "O")||(tablero[0][2]=="O" && tablero[1][1] == "O" && tablero[2][0] == "O")){
        gananO = true
    }

    if(gananX && gananO){
        return "nulo"
    }else if(gananX){
        return "X"
    }else if(gananO){
        return "O"
    }else{
        return "empate"
    }
}