package ar.edu.unahur.obj2.tareas

class Tarea(val horasEstimadas: Int, val responsable: Empleado){
    val empleadosAsignados = mutableListOf<Empleado>()

    fun asignarEmpleado(unEmpleado: Empleado) =
        empleadosAsignados.add(unEmpleado)

    fun cantidadDeAsignados() =
        empleadosAsignados.size

    fun horasNecesariasParaFinalizar() =
        (this.horasEstimadas / this.cantidadDeAsignados())

}
