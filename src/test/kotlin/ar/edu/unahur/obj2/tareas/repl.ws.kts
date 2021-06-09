import ar.edu.unahur.obj2.tareas.Empleado
import ar.edu.unahur.obj2.tareas.Tarea
import ar.edu.unahur.obj2.tareas.TareaDeIntegracion
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

tarea2.costoDeTarea()
tarea3.costoDeTarea()
tarea1.costoDeTarea()

val tareaDeIntegracion1 = TareaDeIntegracion(empleado5)
tareaDeIntegracion1.agregarSubtarea(tarea1)
tareaDeIntegracion1.agregarSubtarea(tarea2)
tareaDeIntegracion1.agregarSubtarea(tarea3)
tareaDeIntegracion1.horasNecesariasParaFinalizar()
tareaDeIntegracion1.nominaDeEmpleados()

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

tareaDeIntegracion2.costoDeTarea()
tareaDeIntegracion1.costoDeSubtareas()
tareaDeIntegracion1.costoDeTarea()

tarea4.horasNecesariasParaFinalizar()
tareaDeIntegracion2.horasNecesariasParaFinalizar()
tareaDeIntegracion1.horasNecesariasDeSubtareas()
tareaDeIntegracion1.horasNecesariasParaFinalizar()