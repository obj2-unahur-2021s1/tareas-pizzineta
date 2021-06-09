package ar.edu.unahur.obj2.tareas

import kotlin.math.floor
import kotlin.math.roundToInt

interface Tarea{
    fun costoDeTarea(): Double
    fun nominaDeEmpleados(): Set<Empleado>
    fun horasNecesariasParaFinalizar(): Double
}

class TareaSimple(val horasEstimadas: Double, val responsable: Empleado, val costoInfraestructura: Double): Tarea{
    val empleadosAsignados = mutableSetOf<Empleado>()

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

    override fun horasNecesariasParaFinalizar() =
        this.horasNecesariasDeSubtareas() + this.horasDePlanificacion()

    fun horasDePlanificacion() =
        floor(this.horasNecesariasDeSubtareas() / 8)

    override fun costoDeTarea() =
         (costoDeSubtareas() * 1.03).roundToInt().toDouble()

    fun costoDeSubtareas() = subtareas.sumByDouble { it.costoDeTarea() }

    override fun nominaDeEmpleados() =
        subtareas.flatMap { it.nominaDeEmpleados() }.toSet() + responsable





}