Overview
=========

blkchn-sql-driver project parses the sql query using [Antlr4](http://www.antlr.org/) and converts it into Logical plan and/or physical plan, which can be used by different blockchain driver implementations.

Currently following Blockchain drivers are implemented.

[Hyperledger Fabric JDBC Driver](http://git-impetus/RND-LABS/fabric-jdbc-connector)

[Ethereum JDBC Driver](http://git-impetus/RND-LABS/eth-jdbc-connector)

Building blkchn-sql-driver
==========================

blkchn-sql-driver is built using [Apache Maven](http://maven.apache.org/). To build blkchn-sql-driver run:

    mvn clean install
    
To rebuild antlr generated java source files:

    mvn clean install -Pgen-sources

Contribution
============
* [Contribution Ideas]()
* [Contribution Guidelines]()

About Us
========
blkchn-sql-driver is backed by Impetus Labs - iLabs. iLabs is a R&D consulting division of [Impetus Technologies](http://www.impetus.com). iLabs focuses on innovations with next generation technologies and creates practice areas and new products around them. iLabs is actively involved working on blockchain technologies, neural networking, distributed/parallel computing and advanced analytics using spark and big data ecosystem. iLabs is also working on various other Open Source initiatives.
