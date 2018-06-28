Overview
=========
[![Join the chat at https://gitter.im/Impetus/blkchn-sql-driver](https://badges.gitter.im/Impetus/blkchn-sql-driver.svg)](https://gitter.im/Impetus/blkchn-sql-driver?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

blkchn-sql-driver project parses the SQL query using [Antlr4](http://www.antlr.org/) and converts it into logical plan 
and/or optimized physical plan, which can be used by different blockchain driver implementations.
It uses Antlr4's visitor pattern to create a logical plan and optionally an optimized physical plan. 
Blockchain drivers use these logical plan and physical plan along with corresponding blockchain clients 
to get the data in and out of the network.

# Tested with
| Dependency | Version |
|---|---|
| maven | 3.3.3 |
|java | 1.8 |



Building blkchn-sql-driver
==========================

blkchn-sql-driver is built using [Apache Maven](http://maven.apache.org/). To build blkchn-sql-driver run:

    mvn clean install
    
To rebuild antlr generated java source files:

    mvn clean install -Pgen-sources
    
Available Drivers
=================

* [Hyperledger Fabric JDBC Driver](https://github.com/Impetus/fabric-jdbc-connector)

* [Ethereum JDBC Driver](https://github.com/Impetus/eth-jdbc-connector)
    
Important Links
===============

* [Blkchn SQL Driver wikis](https://github.com/Impetus/blkchn-sql-driver/wiki)

Contribution
============
* [Contribution Guidelines](https://github.com/Impetus/blkchn-sql-driver/blob/master/CONTRIBUTING.md)

About Us
========
blkchn-sql-driver is backed by Impetus Labs - iLabs. iLabs is a R&D consulting division of [Impetus Technologies](http://www.impetus.com). iLabs focuses on innovations with next generation technologies and creates practice areas and new products around them. iLabs is actively involved working on blockchain technologies, neural networking, distributed/parallel computing and advanced analytics using spark and big data ecosystem. iLabs is also working on various other Open Source initiatives.
