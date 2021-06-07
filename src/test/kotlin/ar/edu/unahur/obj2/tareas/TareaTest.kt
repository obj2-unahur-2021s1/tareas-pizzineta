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
    val tarea1 = Tarea(7.0, empleado1, 250.0)
    tarea1.asignarEmpleado(empleado2)
    tarea1.asignarEmpleado(empleado3)
    tarea1.asignarEmpleado(empleado4)
    tarea1.asignarEmpleado(empleado5)

    describe("saber cuanto tarda en finalizar una tarea") {
      it("cantidad de horas estimadas / cantidad de empleados asignados") {
        tarea1.horasNecesariasParaFinalizar().shouldBe(1.75)
      }
    }

    describe("el costo de una tarea") {
      it("total de tarea1") {
        tarea1.obtenerCostoDeUnaTarea().shouldBe(1133.75)
      }
    }
    describe("la nomina de empleados de una tarea") {
      it("nomina de empleados de tarea1") {
        tarea1.nominaDeEmpleados().shouldBe(listOf(empleado2, empleado3, empleado4, empleado5,empleado1))
      }
    }
  }
})

