JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	GestorAcademico.java \
	GestorAcademicoClienteTCP.java \
	GestorAcademicoServidorIterativo.java \
	Alumno.java \
	Asignatura.java \
	Examen.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
