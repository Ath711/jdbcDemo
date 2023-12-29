# JDBC CRUD Operations

This repository contains Java programs demonstrating basic CRUD (Create, Read, Update, Delete) operations using JDBC (Java Database Connectivity) with PostgreSQL. The programs showcase the interaction with a PostgreSQL database named "Demo" and a sample table named "student."

## Prerequisites

- Java Development Kit (JDK)
- Maven (for dependency management)
- PostgreSQL Database

## Setup

1. **Database Configuration:**
   - Create a PostgreSQL database named "Demo" (or replace it with your preferred database name).
   - Update the `url`, `username`, and `password` variables in the code with your database connection details.

2. **Maven Dependency:**
   - If you are using Maven for your project, add the following dependency to your `pom.xml` file to include the PostgreSQL JDBC Driver:
  
      ```xml
      <dependencies>
          <!-- Other dependencies -->

          <!-- PostgreSQL JDBC Driver -->
          <dependency>
              <groupId>org.postgresql</groupId>
              <artifactId>postgresql</artifactId>
              <version>INSERT_VERSION_HERE</version>
          </dependency>
      </dependencies>
      ```

      Replace `INSERT_VERSION_HERE` with the version of the PostgreSQL JDBC Driver you want to use. You can find the latest version on the [Maven Central Repository](https://search.maven.org/artifact/org.postgresql/postgresql).

## Code Overview

### CRUD.java

This program demonstrates the fundamental CRUD operations using JDBC with PostgreSQL. It includes:

- Connection establishment with the database.
- Execution of INSERT, UPDATE, and DELETE statements.
- Usage of PreparedStatement to prevent SQL injection.
- Reading and printing the contents of the "student" table.

### Main.java

This program provides a simplified version of connecting to the database, executing queries, and processing results. It includes:

- Loading and registering the PostgreSQL JDBC driver.
- Establishing a connection and creating a statement.
- Executing SELECT queries to retrieve specific data and all records from the "student" table.
