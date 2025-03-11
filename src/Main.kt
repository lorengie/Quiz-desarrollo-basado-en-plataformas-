//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val listaProductos = mutableListOf<Producto>()

    var opcion=0

    do{
        println("""
            Bienvenido al supermercado selecione una de las siguientes opciones:  
            1 Ingresar nuevo producto 
            2 vender producto 
            3 Reponer Stock 
            4 Aplicar descuento 
            5 Aumentar precio 
            6 mostrar la informacion de un producto
            7 Calcular el valor del inventario 
            8 Mostrar productos 
            9 Eliminar por codigo
            10 Salir
            """.trimIndent())
        opcion= readln()?.toInt()?:0
        when(opcion){
            1->{
                println("Ingrese el codigo del producto\n")
                val codigo= readln()
                print("Ingrese el nombre del producto\n")
                val nombre= readln()
                println("ingrese el precio del producto\n")
                val precio= readln().toDouble()
                println("ingrese la cantidad del producto\n")
                val cantidad= readln().toInt()
                listaProductos.add(Producto(codigo,nombre,precio,cantidad))

            }
            2->{
                println("Ingrese el numero del producto")
                val codigo = readln()
                val producto = listaProductos.find { it.codigo == codigo  }
                if (producto != null) {
                    println("Ingrese cantidad a vender:")
                    val cantidad = readln().toInt()
                    producto.venderProducto(cantidad)
                } else {
                    println("Producto no encontrado.")
                }
            }
            3->{
                println("Ingrese codigo del producto para reponer")
                val codigo = readln()
                val producto = listaProductos.find { it.codigo == codigo }
                if (producto != null) {
                    println("Ingrese cantidad a reponer:")
                    val cantidad = readln().toInt()
                    producto.reponerStock(cantidad)
                } else {
                    println("Producto no encontrado")
                }
            }
            4->{
                println("Ingrese el producto que va a tener descuento")
                val codigo = readln()
                listaProductos.find { it.codigo == codigo }?.aplicarDescuento(porcentajeDescuento = 0.2)
            }
            5->{
                println("Ingrese código del producto para aumentar precio:")
                val codigo = readln()
                listaProductos.find { it.codigo == codigo }?.aumentarPrecio(porcentajeAumento = 0.6)
                    ?: println("Producto no encontrado.")
            }
            6->{
                println("Ingrese código del producto para ver la información:")
                val codigo = readln()
                listaProductos.find { it.codigo == codigo }?.informacionProducto()
                    ?: println("Producto no encontrado.")
            }
            7->{
                val totalInventario = listaProductos.sumOf { it.calcularValorTotalInventario() }
                println("El valor total del inventario es: $totalInventario")

            }
            8->{
                println("Lista de productos en inventario:")
                listaProductos.forEach { it.informacionProducto()}

            }
            9->{
                println("Ingrese código del producto a eliminar:")
                val codigo = readln()
                if (listaProductos.removeIf { it.codigo == codigo }) {
                    println("Producto eliminado")
                } else {
                    println("Producto no encontrado.")
                }

            }
            10->{
                println("Saliendo del programa, gracias por usar este programa (:")

            }

        }

    }while(opcion!=10)
}