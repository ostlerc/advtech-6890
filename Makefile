.PHONY : all c t

DIR=cs6890/problemsets/ps02/files

SOURCES=$(DIR)/MinMaxStack.java $(DIR)/MinMaxStackTest.java 

JARS=hamcrest-core-1.3.jar:junit-4.12.jar

c:
	javac -cp $(JARS) $(SOURCES)
t:
	java -cp $(JARS):. org.junit.runner.JUnitCore cs6890.problemsets.ps02.files.MinMaxStackTest

all:
	javac -cp $(JARS) $(SOURCES)
	java -cp $(JARS):. org.junit.runner.JUnitCore cs6890.problemsets.ps02.files.MinMaxStackTest
