class Cafetera(val ubicacion : String){
    var capacidad : Int = 1000
    var cantidad : Int = 0
    constructor(ubicacion : String, capacidad : Int) : this(ubicacion){
        this.capacidad = capacidad
        this.cantidad = capacidad
    }
    constructor(ubicacion: String, capacidad : Int, cantidad : Int) : this(ubicacion) {
        this.capacidad = capacidad
        this.cantidad = if (cantidad > capacidad) capacidad else cantidad
    }
    fun llenar(){
        cantidad = capacidad
    }
    fun servirTaza(taza: Taza) {
        if (cantidad >= taza.capacidad){
            taza.cantidad = taza.capacidad
            cantidad -= taza.capacidad
        }else {
                taza.cantidad = cantidad
                cantidad = 0
        }
    }
    fun vaciar(){
        cantidad = 0
    }
    fun agregarCafe(cantidadIndicada : Int = 200){
        if (cantidad + cantidadIndicada > capacidad){
            cantidad = capacidad
        }else{
            cantidad += cantidadIndicada
        }
    }
    override fun toString() : String{
        return "Cafetera(ubicacion=$ubicacion, capacidad=$capacidad c.c, cantidad=$cantidad c.c)"
    }
}

class Taza(var color: String = "Blanco", var capacidad: Int = 50, var cantidad : Int= 0) {
    fun llenar() {
        cantidad = capacidad
    }
    fun llenar(cantidadIndicada : Int){
        this.cantidad = if(cantidadIndicada <= capacidad) cantidadIndicada else capacidad
    }
    override fun toString() : String {
        return "Taza(color= $color, capacidad= $capacidad c.c, cantidad=$cantidad c.c)"
    }
}

enum class Color(){
    Blanco,
    Negro,
    Gris,
    Azul,
    Verde
}

fun main() {

    //TODO: Crear 3 cafeteras en la Sala, Cocina y Oficina

    val cafetera1 = Cafetera("Sala")
    val cafetera2 = Cafetera("Cocina", capacidad = 750)
    val cafetera3 = Cafetera("Oficina", capacidad = 500, cantidad = 200)

    //TODO: Crear una lista de 20 tazas con capacidades aleatorias

    val listaTazas = List(20){
        val capacidadAleatoria = listOf(50, 75, 100).random()
        val colorAleatorio = Color.values().random().toString()
        Taza(color = colorAleatorio, capacidad = capacidadAleatoria)
    }

    println("**********************************************")
    //TODO: Mostrar por pantalla el contenido de las 3 cafeteras y las tazas.
    println(cafetera1)
    println(cafetera2)
    println(cafetera3)

    listaTazas.forEach { println(it) }

    println("**********************************************")
    println("Llenar la cafetera1 de café...")
    println("Vaciar la cafetera2...")
    println("Agregar café a la cafetera2 a la mitad de su capacidad...")
    println("Agregar 400 c.c. de café a la cafereta3...")

    //TODO: Llenar la cafetera1 de café.
    cafetera1.llenar()

    //TODO: Vaciar la cafetera2.
    cafetera2.vaciar()


    //TODO: Agregar café a la cafetera2 a la mitad de su capacidad.
    cafetera2.agregarCafe(375)


    //TODO: Agregar 400 c.c. de café a la cafetera
    cafetera3.agregarCafe(400)


    println("**********************************************")
    //TODO: Mostrar por pantalla el contenido de las 3 cafeteras
    println(cafetera1)
    println(cafetera2)
    println(cafetera3)


    println("**********************************************")
    println("Servir café en las tazas...")

    //TODO: Servir café en las tazas... siempre que haya café en la cafetera y en el orden cafetera1, cafetera2 y cafetera3.
    for (taza in listaTazas) {
        when {
            cafetera1.cantidad > 0 -> cafetera1.servirTaza(taza)
            cafetera2.cantidad > 0 -> cafetera2.servirTaza(taza)
            cafetera3.cantidad > 0 -> cafetera3.servirTaza(taza)
            else -> taza.cantidad = 0
        }
    }

    println("**********************************************")
    //TODO: Mostrar por pantalla el contenido de las 3 cafeteras y las tazas.
    println(cafetera1)
    println(cafetera2)
    println(cafetera3)
    listaTazas.forEach { println(it) }

}