package com.example.ejercicio3

fun main() {
//Ejercicio clase del 19-01-2021
 //   1. Crear archivo “Main.kt” con la función main

    // 2. Imprimir “Mi nombre es: {Nombre del alumno}".
    println("2. Mi nombre es: " + getnombre())

// 3.-  Declarar 3 variables numéricas con los valores
//10, 20 y 30.
    var num1 = 10
    var num2 = 20
    var num3 = 30

// 4. Imprimir la suma de las 3 variables.
   println("4. La suma de $num1 + $num2 + $num3 es: ${num1+num2+num3} ")

 //   5. Declarar 1 variable String y otra variable Char
    var mstring:String

    var mchar:Char

 //   6. Asignarle el valor “Ark Reigen” a la variable String y “A” a la variable Char .
    mstring =  "Ark Reigen"
    mchar = 'A'

/*    7. Imprimir la cantidad de caracteres que tiene la  variable String y
    modificar la variable char a otro valor distinto.*/
    println("7.- El largo de “$mstring“ es ${mstring.length}")
     mchar ='B'

//    8. Declarar una variable de tipo Float de forma  explícita.
       var mfloat:Float

//     9. Asignar un valor a la variable Float.
            mfloat=10.5f

//    10. Imprimir los valores máximos que pueden  almacenar las variables Byte y Short.
     // Byte
      var   maxbyte= Byte.MAX_VALUE
    val maxshort = Short.MAX_VALUE
    println("10. Máximo valor Byte es: $maxbyte, y el Máximo valor short es: $maxshort")


//    11.- Imprimir los valores mínimos que pueden almacenar las variables Int y Long.
    var minInt = Int.MIN_VALUE
    var maxInt = Int.MAX_VALUE      //2,147,483,647
    println("11.1 Mínmimo valor Integer es: $minInt, Máximo valor Integer es: $maxInt") //-2,147,483,647

    var minLong= Long.MIN_VALUE
    var maxLong= Long.MAX_VALUE
    println("11.2 Mínmimo valor Long es: $minLong, Máximo valor Long es: $maxLong") //-2,147,483,647//-9223372036854775807

    //12.- Declarar una variable Boolean con true o false e imprimir su valor.
     var mboolean:Boolean = true
     println("12. valor booleano $mboolean")

/*    13.- Crear una función llamada     “imprimiendoParametros” que recibe 2
    parámetros String y imprime el total de     caracteres de los dos parámetros.*/
       imprimiendoParametros("Garcy", "valenzuela")

//    14.- Crear una función llamada “obtieneIVA” que devuelve el valor del IVA (19%).
           println("14. El IVA de 100 es ${obtieneIVA(100)}")

//    15.- Desde la función main llamar a estas dos funciones de forma correcta.
    // realizado en puntos 13 y 14
}

fun getnombre(): String {
    return "Garcy Valenzuela P."
}

fun obtieneIVA(monto: Int):Float {
    return monto*0.19f
}

fun imprimiendoParametros(s: String, s1: String) = println("12. Largo de “$s$s1“ : ${ s.length + s1.length}")

