.PHONY : all c t clean

DIR=cs6890/problemsets/ps02/files

SOURCES=$(DIR)/MinMaxStack.java \
$(DIR)/MinMaxStackTest.java \
$(DIR)/HashSetTest.java \
$(DIR)/MineSweeper.java \
$(DIR)/MineSweeperTest.java \
$(DIR)/AllTests.java

JARS=hamcrest-core-1.3.jar:junit-4.12.jar

c:
	javac -cp $(JARS) $(SOURCES)
t:
	java -cp $(JARS):. org.junit.runner.JUnitCore cs6890.problemsets.ps02.files.AllTests

all:
	javac -cp $(JARS) $(SOURCES)
	java -cp $(JARS):. org.junit.runner.JUnitCore cs6890.problemsets.ps02.files.AllTests

clean:
	find . -name '*.class' -print0 | xargs -0 rm
