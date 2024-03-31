package facultad;

import org.junit.Assert;
import org.junit.Test;

public class InscripcionTest {

    @Test
    public void seApruebaLaInscripcion() {
        //Tiene aprobadas todas las materias necesarias para cursar dds

        Materia algoritmos = new Materia("Algoritmos y Estructuras de Datos");

        Materia syo = new Materia("Sistemas y Organizaciones");

        Materia ads = new Materia("Analisis de Sistemas");
        ads.agregarCorrelativas(syo);

        Materia pdp = new Materia("Paradigmas de Programacion");
        pdp.agregarCorrelativas(algoritmos);

        Materia dds = new Materia("Diseño de Sistemas");
        dds.agregarCorrelativas(pdp, ads);

        Alumno alumno = new Alumno("Pepe");
        alumno.agregarMateriasAprobadas(syo,ads,pdp,algoritmos);

        Inscripcion inscripcion = new Inscripcion(alumno);
        inscripcion.agregarMaterias(dds);

        Assert.assertTrue(inscripcion.aprobada());
    }

    @Test
    public void noSeApruebaLaInscripcion() {
        //Falta aprobar paradigmas en este caso

        Materia algoritmos = new Materia("Algoritmos y Estructuras de Datos");

        Materia syo = new Materia("Sistemas y Organizaciones");

        Materia ads = new Materia("Analisis de Sistemas");
        ads.agregarCorrelativas(syo);

        Materia pdp = new Materia("Paradigmas de Programacion");
        pdp.agregarCorrelativas(algoritmos);

        Materia dds = new Materia("Diseño de Sistemas");
        dds.agregarCorrelativas(pdp, ads);

        Alumno alumno = new Alumno("Pepe");
        alumno.agregarMateriasAprobadas(syo,ads,algoritmos);

        Inscripcion inscripcion = new Inscripcion(alumno);
        inscripcion.agregarMaterias(dds);

        Assert.assertFalse(inscripcion.aprobada());
    }

}
