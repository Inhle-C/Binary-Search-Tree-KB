JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES= \
BinarySearchTreeKB.java \
BSTNode.java \
Generic.java \
GenericsKbArrayApp.java \
GenericsKbBSTApp.java

default: classes run

classes: $(CLASSES:.java=.class)

compile: 
	$(JC) $(JFLAGS) $(CLASSES)
clean:
	$(RM) *.class

run:
	java GenericsKbArrayApp
	java GenericsKbBSTApp