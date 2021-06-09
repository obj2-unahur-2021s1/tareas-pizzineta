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
    val tarea1 = TareaSimple(7.0, empleado1, 250.0)
    tarea1.asignarEmpleado(empleado2)
    tarea1.asignarEmpleado(empleado3)
    tarea1.asignarEmpleado(empleado4)
    tarea1.asignarEmpleado(empleado5)
    val tarea2 = TareaSimple(12.0, empleado2, 120.0)
    tarea2.asignarEmpleado(empleado1)
    tarea2.asignarEmpleado(empleado3)
    val tarea3 = TareaSimple(9.0, empleado3, 310.0)
    tarea3.asignarEmpleado(empleado2)
    tarea3.asignarEmpleado(empleado4)
    tarea3.asignarEmpleado(empleado5)

    describe("una tarea simple") {
      describe("saber cuanto tarda en finalizar una tarea") {
        it("cantidad de horas estimadas / cantidad de empleados asignados") {
          tarea1.horasNecesariasParaFinalizar().shouldBe(1.75)
        }
      }
      describe("el costo de una tarea") {
        it("horas de trabajo de cada empleado + costo de instrafestructura + horas trabajadas del responsable") {
          tarea1.costoDeTarea().shouldBe(1133.75)
        }
      }
      describe("la nomina de empleados de una tarea") {
        it("nomina de empleados de tarea1") {
          tarea1.nominaDeEmpleados().shouldBe(listOf(empleado2, empleado3, empleado4, empleado5, empleado1))
        }
      }
    }
    describe("una tarea de integración"){
      val empleado6 = Empleado(70)
      val tareaDeIntegracion1 = TareaDeIntegracion(empleado6)
      tareaDeIntegracion1.agregarSubtarea(tarea1)
      tareaDeIntegracion1.agregarSubtarea(tarea2)
      tareaDeIntegracion1.agregarSubtarea(tarea3)
      describe("horas necesarias para finalizar"){
        it("suma de subtareas + 1 cada 8 horas"){
          tareaDeIntegracion1.horasNecesariasParaFinalizar().shouldBe(11.75)
        }
      }
      describe("costo de tarea de integracion"){
        it("suma de costos de subtareas + bonus del 3% del sueldo del responsable"){
          tareaDeIntegracion1.costoDeTarea().shouldBe(4086.0)

        }
      }
      describe("nomina de empleados"){
        it("nomina de empleados de la tareaDeIntegracion1 + su responsable"){
          tareaDeIntegracion1.nominaDeEmpleados().shouldBe(setOf(empleado1, empleado2, empleado3, empleado4, empleado5, empleado6))
        }
      }
      describe("sumar otras tareas de integracion"){
        val miguel = Empleado(21)
        val franco = Empleado(34)
        val luis = Empleado(23)
        val samanta = Empleado(11)
        val marisa = Empleado(40)
        val tarea4 = TareaSimple(12.0, samanta, 400.0)
        tarea4.asignarEmpleado(miguel)
        tarea4.asignarEmpleado(franco)
        tarea4.asignarEmpleado(luis)
        val tareaDeIntegracion2 = TareaDeIntegracion(marisa)
        tareaDeIntegracion2.agregarSubtarea(tarea4)
        tareaDeIntegracion1.agregarSubtarea(tareaDeIntegracion2)
        it("horas necesarias para terminar de tareaDeIntegracion1 si agregamos otra tarea de integracion"){
          tareaDeIntegracion1.horasNecesariasParaFinalizar().shouldBe(15.75)
        }
        it("costo de tareaDeIntegracion1 si agregamos otra tarea de integracion"){
          tareaDeIntegracion1.costoDeTarea().shouldBe(4981.0)
        }
        it( "nomina de la tareaDeIntegracion1 si agregamos otra tarea de integracion"){
          tareaDeIntegracion1.nominaDeEmpleados().shouldBe(setOf(franco,samanta,luis,marisa,miguel,empleado1,empleado2,empleado3,empleado4,empleado5,empleado6))
        }
      }
    }
  }
})

