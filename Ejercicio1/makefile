JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	ProcesadorYodafy.java \
	YodafyClienteTCP.java \
	YodafyServidorIterativo.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

