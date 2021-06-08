import ar.edu.unahur.obj2.tareas.Empleado
import ar.edu.unahur.obj2.tareas.Tarea
import ar.edu.unahur.obj2.tareas.TareaSimple

// Pueden usar este archivo para hacer pruebas rápidas,
// de la misma forma en que usaban el REPL de Wollok.

// OJO: lo que esté aquí no será tenido en cuenta
// en la corrección ni reemplaza a los tests.

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

tarea1.horasNecesariasParaFinalizar()
tarea2.horasNecesariasParaFinalizar()
tarea3.horasNecesariasParaFinalizar()