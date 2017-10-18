##Generate source code from grammer file

# The grammer file is taken from spark sql.
[SqlBase.g4](https://github.com/apache/spark/blob/master/sql/catalyst/src/main/antlr4/org/apache/spark/sql/catalyst/parser/SqlBase.g4)
Download from above link or alternatively in Spark Source Code browse to... 
sql/catalyst/src/main/antlr4/org/apache/spark/sql/catalyst/parser/SqlBase.g4


#POM File Configurations
1. To clean the generated code for that grammer in pom.xml configure maven-clean plugin. 
<directory>${basedir}/src/main/java/com/impetus/blkch/sql/generated</directory>

2. For antlr maven plugin configure the source and output directory
2.1 <sourceDirectory>${basedir}/antlr/sparksql</sourceDirectory>
2.2 <outputDirectory>${basedir}/src/main/java/com/impetus/blkch/sql/generated</outputDirectory>
2.3 Configure package ( Remove if specified in g4 file)
<arguments>
	<argument>-package</argument>
	<argument>com.impetus.blkch.sql.generated</argument>
</arguments>

#Generate the code.
Run  $mvn clean compile test install
The antlr4 code is generated as it is tied to maven lifecycle. See pom files for details.


TODO:
1. Clean and configure logback.xml 
