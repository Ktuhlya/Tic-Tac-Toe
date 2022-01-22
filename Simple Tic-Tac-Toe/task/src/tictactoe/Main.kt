package tictactoe


val mainField = mutableListOf(mutableListOf("|"," "," "," ","|"),
    mutableListOf("|"," "," "," ","|"), mutableListOf("|"," "," "," ","|"))
var stateField : Int = 0
var win = ""
var charArray = charArrayOf()
var coordRow = 0
var coordCol = 0
var oORx = 1

fun main() {

showField()

}

fun showField() {
    println("---------")
    for (i in 0..2) {
        println(mainField[i].joinToString(" "))
    }
    println("---------")

    userMove()


}

fun userMove() {
    stateField = 0
    print("Enter the coordinates: ")
   val str = readLine()!!

    try {
        coordRow = str.substring(0, 1).toInt()
        coordCol = str.substring(2).toInt()
    } catch (e: NumberFormatException) {
        println("You should enter numbers!")
        userMove()
    }
    if (coordRow in 1..3) {
        if (coordCol in 1..3) {
            if (mainField[coordRow - 1][coordCol] != " ") {
                println("This cell is occupied! Choose another one!")
                userMove()
            } else {
                updateField()
            }
        } else {
            println("Coordinates should be from 1 to 3!")
            userMove()
        }
    }else{
            println("Coordinates should be from 1 to 3!")
        userMove()
        }
    }


fun updateField() {

  if (oORx > 0) {
      mainField[coordRow.toInt() - 1][coordCol.toInt()] = "X"
  }else{
      mainField[coordRow.toInt() -1][coordCol.toInt()] = "O"
      }
    oORx = oORx *(-1)

          println("---------")

    for (i in 0..2){
       println( mainField[i].joinToString(" "))
    }
    println("---------")
    analyze()
}

fun analyze() {

    val a = mainField[0][1]
    val b = mainField[0][2]
    val c = mainField[0][3]
    val d = mainField[1][1]
    val e = mainField[1][2]
    val f = mainField[1][3]
    val g = mainField[2][1]
    val h = mainField[2][2]
    val k = mainField[2][3]

    var count_X = 0
    var count_O = 0

 
    for (i in 0..charArray.size-1) {

        if (charArray[i].toString() == "X") count_X = count_X + 1
        if (charArray[i].toString() == "O") count_O = count_O + 1
    }
     if ((count_X - count_O >1 ) || (count_O - count_X >1)){
         stateField = 12

    }
    if ((count_O + count_X) >8 ) stateField = 137

    //wins
          if ((a==b && a==c) && (a !=" ")){
              stateField =1 + stateField
              win=a}
          if ((d==e && d==f) && (d !=" ")){
              stateField =1 + stateField
              win=d}
          if ((g==h && g==k) && (g !=" ")){
              stateField =1 + stateField
              win=g}
          if ((a==d && a==g) && (a !=" ")){
              stateField =1 + stateField
              win=a}
          if ((b==e && b==h) && (b !=" ")){
              stateField =1 + stateField
              win=b}
          if ((c==f && c==k) && (c !=" ")){
              stateField =1 + stateField
              win=c}
          if ((a==e && a==k) && (a !=" ")){
              stateField =1 + stateField
              win=a}
          if ((c==e && c==g) && (c !=" ")){
              stateField =1 + stateField
              win=c}
    // empty
    if(stateField == 0){
        if ((a==" ") || (b==" ") || (c==" ") || (d==" ") ||
        (e==" ") || (f==" ") || (g==" ") || (h==" ") ||
        (k==" "))  {
            stateField = 10
        }
        }



    printAnalyze()
}

fun printAnalyze() {

    if(stateField == 1){
        println(win + " wins")
        System.exit(0)
    }
    if(stateField == 0) {
        userMove()
    }
        //println("Draw")
    if(stateField == 10) {
        stateField = 0
        userMove()
    }
        //println("Game not finished")
    if((stateField >1 && stateField <10) || stateField== 12){
        println("Impossible")
    }
    if (stateField == 137) {
        println("Draw")
        System.exit(0)
    }
   // if (stateField == 12) println("Impossible")

}



/*

for (i in 0..2){
    for (j in 1..3){
        if {
            (mainField[i][j] == mainField[i][j + 1] &&
                    mainField[i][j] == mainField[i][j + 2])
            win = mainField[i][j]
            stateField = 1
            println("-")
        }
    }
}
for(i in 0..2) {
    for (j in 1..3) {
        if (mainField[i][j] == mainField[mainField.size - 2][j] &&
            mainField[mainField.size - 2][j] == mainField[mainField.size - 1][j])
            win= mainField[i][j]
        stateField = 1
        println("|")
    }
}
for (i in 0..2) {
    for (j in 1..3) {
        if (mainField[i][j] == mainField[mainField.size - 2][j + 1] &&
            mainField[i][j] == mainField[mainField.size - 1][j + 2])
            win= mainField[i][j]
        stateField = 1
        println("/")
    }
}
for (i in 0..2) {
    for (j in 1..3) {
        if (mainField[i][j] == mainField[mainField.size - 2][j - 1] &&
            mainField[i][j] == mainField[mainField.size - 1][j - 2])
            win= mainField[i][j]
        stateField = 1
        println(" \\ ")
    }

}

print("Enter cells: ")
    val str = readLine()!!
     charArray = str.toCharArray()
    for (i in 0..2) {
        for (j in 1..3) {
            mainField[i][j] = charArray[(j-1) + i + (i * 2)].toString()
        }
    }


 */