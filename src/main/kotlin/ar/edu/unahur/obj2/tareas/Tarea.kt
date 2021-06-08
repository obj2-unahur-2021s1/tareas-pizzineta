package ar.edu.unahur.obj2.tareas

import kotlin.math.ceil
import kotlin.math.roundToInt

interface Tarea{
    fun costoDeTarea(): Double
    fun nominaDeEmpleados(): List<Empleado>
    fun horasNecesariasParaFinalizar(): Double
}

class TareaSimple(val horasEstimadas: Double, val responsable: Empleado, val costoInfraestructura: Double): Tarea{
    val empleadosAsignados = mutableListOf<Empleado>()

    fun asignarEmpleado(unEmpleado: Empleado) =
        empleadosAsignados.add(unEmpleado)

    fun cantidadDeAsignados() =
        empleadosAsignados.size

    override fun horasNecesariasParaFinalizar() =
        (this.horasEstimadas / this.cantidadDeAsignados())

    override fun costoDeTarea() =
        (this.horasNecesariasParaFinalizar() * sueldoDeAsignados()) + (horasEstimadas * responsable.sueldoPorHora) + costoInfraestructura

    fun sueldoDeAsignados() = empleadosAsignados.sumBy{it.sueldoPorHora}

    override fun nominaDeEmpleados() = empleadosAsignados + responsable
}

class TareaDeIntegracion(val responsable: Empleado) : Tarea {
    val subtareas = mutableListOf<Tarea>()

    fun agregarSubtarea(unaTarea: Tarea) =
        subtareas.add(unaTarea)
    fun horasNecesariasDeSubtareas() =
        subtareas.sumByDouble { it.horasNecesariasParaFinalizar()}

    override fun horasNecesariasParaFinalizar(): Double {
        return (this.horasNecesariasDeSubtareas() + (this.horasNecesariasDeSubtareas() / 8).roundToInt().toDouble())
    }
    override fun costoDeTarea() : Double{
        TODO("Not yet implemented")
    }

    override fun nominaDeEmpleados(): List<Empleado> {
        TODO("Not yet implemented")
    }




}