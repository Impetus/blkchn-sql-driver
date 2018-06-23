# Generate source code from grammer file   

Grammer file.   
The grammar file for this project is [BlkchnSql.g4](https://github.com/Impetus/blkchn-sql-driver/blob/master/blkchn-antlr4-gen/antlr/blkchn/BlkchnSql.g4). It has features for basic sql syntax and some constructs applicable only to blockchain. Antlr4 is used to generate the lexer and parser based on this grammer file.    

POM File Configurations to generate the code.   
1. A maven profile gen-sources is defined to generate the code.   
   
2. To clean the generated code for that grammer in pom.xml configure maven-clean plugin.    
<directory>${basedir}/src/main/java/com/impetus/blkch/sql/generated</directory>
   
3. For antlr maven plugin configure the source and output directory   
3.1 <sourceDirectory>${basedir}/antlr/blkchn</sourceDirectory>   
3.2 <outputDirectory>${basedir}/src/main/java/com/impetus/blkch/sql/generated</outputDirectory>   
3.3 Configure package ( Remove if specified in g4 file)   
<arguments>   
	<argument>-package</argument>   
	<argument>com.impetus.blkch.sql.generated</argument>   
</arguments>   
   
4. To activte this profile and generate code run     
$mvn -P gen-sources clean compile test install   
The antlr4 code is generated as it is tied to maven lifecycle. See pom files for details.   


