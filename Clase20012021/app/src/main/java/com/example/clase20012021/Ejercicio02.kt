package com.example.clase20012021

// 2. crea clase
data class Librosescolares (var nombre: String, var isbn: String, var numpag: Int, var precio:Int,var autor: String, var tipo: Char){

    //3.- crea funcion precioformateado
    fun precioFormateado():String {
        return "$" + precio.toString()
    }

    //4.- crea funcion imprimir libros
    fun imprimirLibros() {
        println(" Nombre: ${nombre} , " +
                " ISBN: ${isbn} , " +
                " Páginas: ${numpag} , " +
                " Precio: ${precioFormateado()} , " +
                " Autor: ${autor} ," +
                " Tipo: ${tipo}")

    }
}
    // 5.- crea funcion main
fun main() {

    // 6.- Declara 4 viariables
    var libro1= Librosescolares("Principito1","abc123",30, 100,"Exupery",'I')
    var libro2= Librosescolares("Principito2","abc123",35,200,"Exupery",'I')
    var libro3= Librosescolares("Principito3","abc123",20,300,"Exupery",'I')
    val libro4= Librosescolares("Principito4","abc123",25,400,"Exupery",'I')

    //llama funcion imprimir
    libro1.imprimirLibros()
    libro2.imprimirLibros()
    libro3.imprimirLibros()
    libro4.imprimirLibros()

}







