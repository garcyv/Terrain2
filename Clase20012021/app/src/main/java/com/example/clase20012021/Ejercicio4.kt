package com.example.clase20012021

fun main(){

println(message = "la suma de 10 + 20 + 40 es: ${calcular(10,20,40,::sumar)}")
val multi = calcular(4,5,6,{a,b,c-> a*b*c})

    val up2: (String) -> String ={ str: String ->
        str.toUpperCase()
    }
    val up : (String) -> String = { it.toUpperCase()}

    println(up2("garcy"))
    println(up("esto"))

    data class Circle (var radio: Int, var color: String)
    val circle = Circle(2, "red").also(::println)

    circle.radio = 3
    circle.color = "blue"

    println(circle)

    //Listas mutables
    val listam : MutableList<Int> = mutableListOf(1,2,3,4)
    val listastrings = mutableListOf("1,2","3,4")
    val listastringsnomutable = listOf("A","b")
listam.add(9)
listam.forEach{println("$it")}

    setm.add("u3")

    //mapas
    val mapam = mutableMapOf((1 to 2),(2 to 3))
    mapam.put(3 , 5)
    println(mapam)

    var listaNumeros= listOf(1,2,3,4,5)


  var   mayor3 = listaNumeros.filter{it > 3}
    println(mayor3)

    val str = "Hello"
    // this
    str.run {
        println("The receiver string length: $length")
        //println("The receiver string length: ${this.length}") // does the same
    }

    // it
    str.let {
        println("The receiver string's length is ${it.length}")
    }

    BigBen.getBongs(12)

    val numeros = mutableListOf("uno", "dos", "tres")
    with(numeros) {
        println("'with' es llamado con los argumentos $this")
        println("Contiene $size elements")
    }

}  // main
val setm = mutableSetOf("u1","u2")

fun addu(uniu:String): Boolean {
    return setm.add(uniu)
}

fun calcular(n1:Int,n2:Int,n3:Int,funcion: (Int,Int,Int)->Int):Int{
    return funcion(n1,n2,n3)}

fun sumar(n1:Int, n2:Int,n3:Int)=n1+n2+n3

class BigBen{
    companion object {
        fun getBongs(ntimes:Int){
            for(i in 1..ntimes){
               if(i != ntimes) {print("Bong, ")}
                else{println("Bong")}
            }
        }
    }
}