import ar.edu.unahur.obj2.tareas.Empleado
import ar.edu.unahur.obj2.tareas.Tarea

// Pueden usar este archivo para hacer pruebas rápidas,
// de la misma forma en que usaban el REPL de Wollok.

// OJO: lo que esté aquí no será tenido en cuenta
// en la corrección ni reemplaza a los tests.

listOf(1, 8, 10).average()
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

tarea1.nominaDeEmpleados()