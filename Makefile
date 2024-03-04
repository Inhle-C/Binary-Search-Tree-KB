JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

SRC_FILES = BinarySearchTreeKB.java BSTNode.java Generic.java GenericsKbArrayApp.java GenericsKbBSTApp.java
JAVADOC = doc


CLASSES= \
BinarySearchTreeKB.java \
BSTNode.java \
Generic.java \
GenericsKbArrayApp.java \
GenericsKbBSTApp.java

default: classes run

classes: $(CLASSES:.java=.class)
javadoc: $(SRC_FILES)
	mkdir -p $(JAVADOC)
	javadoc -d $(JAVADOC) $(SRC_FILES) 
	
compile: 
	$(JC) $(JFLAGS) $(CLASSES)
clean:
	$(RM) *.class

run:
	java GenericsKbArrayApp
	java GenericsKbBSTApp