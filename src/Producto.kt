class Producto (
    var codigo: String,
    var nombre: String,
    var precio: Double,
    var cantidad: Int

){
    /*
    * Crea una clase llamada Producto que represente un producto en una tienda. La clase debe tener:

- Un codigo del producto
- Un nombre del producto.
- Un precio del producto.
- Una cantidad en stock.

Implementa los siguientes métodos:

1. Crear producto
2. Vender producto: Reduce la cantidad en stock si hay suficiente disponibilidad.
3. Reponer stock: Aumenta la cantidad en stock cuando llega nueva mercancía.
4. Aplicar descuento: Reduce el precio del producto en un porcentaje dado(2%).
5. Mostrar información: Imprime los detalles del producto. (NO toString)
6. Aumentar precio: Incrementa el precio del producto en un porcentaje dado.(6%)
7. Calcular valor total en inventario: Multiplica la cantidad en stock por el precio del producto. ( Mostrar total de inventario)
8. Eliminar productos por codigo.

Los productos se deben guardar en una lista*/
    fun venderProducto(cantidadVendida: Int) {
        if (cantidadVendida <= cantidad) {
            cantidad -= cantidadVendida
            println("Se vendieron $cantidadVendida unidades de $nombre.")
        } else {
            println("No hay suficiente stock de $nombre para vender $cantidadVendida unidades.")
        }
    }
    fun reponerStock(cantidadReponer: Int) {
        cantidad += cantidadReponer
        println("Se repusieron $cantidadReponer unidades de $nombre.")
    }

    fun aplicarDescuento(porcentajeDescuento: Double) {
        val descuento = precio * (porcentajeDescuento / 100)
        precio -= descuento
        println("Se aplicó un descuento del $porcentajeDescuento% a $nombre. Nuevo precio: $precio")
    }

    fun informacionProducto() {
        println("Código: $codigo, Nombre: $nombre, Precio: $precio, Cantidad en stock: $cantidad")
    }


    fun aumentarPrecio(porcentajeAumento: Double) {
        val aumento = precio * (porcentajeAumento / 100)
        precio += aumento
        println("Se aumentó el precio de $nombre en un $porcentajeAumento%. Nuevo precio: $precio")
    }

    fun calcularValorTotalInventario(): Double {
        val valorTotal = cantidad * precio
        println("El valor total en inventario de $nombre es: $valorTotal")
        return valorTotal
    }

}