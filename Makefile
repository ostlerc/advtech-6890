.PHONY : all setup classes clean
.PHONY : ps3 ps3a ps3b ps3c
.PHONY : cp2 cp2a cp2b cp2c cp2d

PSDIR=cs6890/problemsets
CPDIR=cs6890/classproject

PS3ASRC := $(wildcard $(PSDIR)/ps03/files/A/*.java)
PS3BSRC := $(wildcard $(PSDIR)/ps03/files/B/*.java)
PS3CSRC := $(wildcard $(PSDIR)/ps03/files/C/*.java)

CP2ASRC := $(wildcard $(CPDIR)/cp02/files/A/*.java)
CP2BSRC := $(wildcard $(CPDIR)/cp02/files/B/*.java)
CP2CSRC := $(wildcard $(CPDIR)/cp02/files/C/*.java)
CP2DSRC := $(wildcard $(CPDIR)/cp02/files/D/*.java)

ALLSRC:= $(shell find . -name '*.java')

.SUFFIXES: .java .class

JUNIT=junit-4.12.jar
HAMCREST=hamcrest-core-1.3.jar

JARS=$(HAMCREST):$(JUNIT)
RUNNER=org.junit.runner.JUnitCore
PS=cs6890.problemsets
CP=cs6890.classproject

JFLAGS = -cp $(JARS):.
JC = javac
JR = java

default: all

.java.class:
	$(JC) $(JFLAGS) $*.java

classes: $(ALLSRC:.java=.class)

# parallel compile support, first setup then classes can be built
all: $(JUNIT) $(HAMCREST)
	$(MAKE) setup
	$(MAKE) classes

setup: $(JUNIT) $(HAMCREST)

ps3:
	$(MAKE) ps3a
	$(MAKE) ps3b
	$(MAKE) ps3c

ps3a: $(JUNIT) $(HAMCREST) $(PS3ASRC:.java=.class)
	$(JR) $(JFLAGS) $(RUNNER) $(PS).ps03.files.A.ConverterTest
	$(JR) $(JFLAGS) $(RUNNER) $(PS).ps03.files.A.ConverterStressTest

ps3b: $(JUNIT) $(HAMCREST) $(PS3BSRC:.java=.class)
	$(JR) $(JFLAGS) $(RUNNER) $(PS).ps03.files.B.CompactBooleanArrayTest

ps3c: $(JUNIT) $(HAMCREST) $(PS3CSRC:.java=.class)
	$(JR) $(JFLAGS) $(RUNNER) $(PS).ps03.files.C.BlocksTest

cp2:
	$(MAKE) cp2a
	$(MAKE) cp2b
	$(MAKE) cp2c
	$(MAKE) cp2d

cp2a: $(JUNIT) $(HAMCREST) $(CP2ASRC:.java=.class)
	$(JR) $(JFLAGS) $(RUNNER) $(CP).cp02.files.A.PuzzleSolverTest

cp2b: $(JUNIT) $(HAMCREST) $(CP2BSRC:.java=.class)
	$(JR) $(JFLAGS) $(RUNNER) $(CP).cp02.files.B.PuzzleGeneratorTest

cp2c: $(JUNIT) $(HAMCREST) $(CP2CSRC:.java=.class)
	$(JR) $(JFLAGS) $(RUNNER) $(CP).cp02.files.C.PuzzleStatsTest

cp2d: $(JUNIT) $(HAMCREST) $(CP2CSRC:.java=.class)
	$(JR) $(JFLAGS) $(RUNNER) $(CP).cp02.files.D.PuzzleTest

$(JUNIT):
	wget http://search.maven.org/remotecontent?filepath=junit/junit/4.12/junit-4.12.jar -O $(JUNIT)

$(HAMCREST):
	wget http://search.maven.org/remotecontent?filepath=org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar -O $(HAMCREST)

clean:
	$(RM) $(ALLSRC:.java=.class)
	$(RM) $(JUNIT) $(HAMCREST)
