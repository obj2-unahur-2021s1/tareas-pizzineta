package ar.edu.unahur.obj2.tareas

class Tarea(val horasEstimadas: Double, val responsable: Empleado, val costoInfraestructura: Double){
    val empleadosAsignados = mutableListOf<Empleado>()

    fun asignarEmpleado(unEmpleado: Empleado) =
        empleadosAsignados.add(unEmpleado)

    fun cantidadDeAsignados() =
        empleadosAsignados.size

    fun horasNecesariasParaFinalizar() =
        (this.horasEstimadas / this.cantidadDeAsignados())

    fun obtenerCostoDeUnaTarea() =
        (this.horasNecesariasParaFinalizar() * sueldoDeAsignados()) + (horasEstimadas * responsable.sueldoPorHora) + costoInfraestructura

    fun sueldoDeAsignados() = empleadosAsignados.sumBy{it.sueldoPorHora}

    fun nominaDeEmpleados() = empleadosAsignados + responsable
}


