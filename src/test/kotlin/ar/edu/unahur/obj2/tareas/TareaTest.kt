package ar.edu.unahur.obj2.tareas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class TareaTest : DescribeSpec({
  describe("Una tarea") {
    val empleado1 = Empleado(66)
    val empleado2 = Empleado(45)
    val empleado3 = Empleado(62)
    val empleado4 = Empleado(79)
    val empleado5 = Empleado(55)
    val tarea1 = Tarea(7, empleado1)
    tarea1.asignarEmpleado(empleado2)
    tarea1.asignarEmpleado(empleado3)
    tarea1.asignarEmpleado(empleado4)
    tarea1.asignarEmpleado(empleado5)

    describe("saber cuanto tarda en finalizar una tarea"){
      it("cantidad de horas estimadas / cantidad de empleados asignados"){
        tarea1.horasNecesariasParaFinalizar().shouldBe(1)
      }
    }
  }
})
