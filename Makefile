.PHONY : all setup classes a b c clean

FILESDIR=cs6890/problemsets/ps03/files

ASRC= \
	$(FILESDIR)/A/Converter.java \
	$(FILESDIR)/A/ConverterStressTest.java \
	$(FILESDIR)/A/ConverterTest.java

BSRC= \
	$(FILESDIR)/B/CompactBooleanArray.java \
	$(FILESDIR)/B/CompactBooleanArrayTest.java

CSRC= \
	$(FILESDIR)/C/Blocks.java \
	$(FILESDIR)/C/BlocksTest.java

ALLSRC= \
	  $(ASRC) \
	  $(BSRC) \
	  $(CSRC)

.SUFFIXES: .java .class

JUNIT=junit-4.12.jar
HAMCREST=hamcrest-core-1.3.jar

JARS=$(HAMCREST):$(JUNIT)
RUNNER=org.junit.runner.JUnitCore
PS03=cs6890.problemsets.ps03.files

JFLAGS = -cp $(JARS):.
JC = javac

default: all

.java.class:
	$(JC) $(JFLAGS) $*.java

classes: $(ALLSRC:.java=.class)

# parallel compile support, first game classes then tests can be built
all: $(JUNIT) $(HAMCREST)
	$(MAKE) setup
	$(MAKE) classes

setup: $(JUNIT) $(HAMCREST)

a: $(JUNIT) $(HAMCREST) $(ASRC:.java=.class)
	java $(JFLAGS) $(RUNNER) $(PS03).A.ConverterTest
	java $(JFLAGS) $(RUNNER) $(PS03).A.ConverterStressTest

b: $(JUNIT) $(HAMCREST) $(BSRC:.java=.class)
	java $(JFLAGS) $(RUNNER) $(PS03).B.CompactBooleanArrayTest

c: $(JUNIT) $(HAMCREST) $(CSRC:.java=.class)
	java $(JFLAGS) $(RUNNER) $(PS03).C.BlocksTest

$(JUNIT):
	wget http://search.maven.org/remotecontent?filepath=junit/junit/4.12/junit-4.12.jar -O $(JUNIT)

$(HAMCREST):
	wget http://search.maven.org/remotecontent?filepath=org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar -O $(HAMCREST)

clean:
	$(RM) $(ALLSRC:.java=.class)
	$(RM) $(JUNIT) $(HAMCREST)
