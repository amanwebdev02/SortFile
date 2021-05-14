# Getting Started


# springboot-sortfile-app

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

##  Setting up

Assuming your project is in a folder named "Downloads".


    cd ~/Users/mmt7465/Downloads
    git clone link
    cd SortFile

 
The files customer.txt and output.txt are stored at file path mentioned in "AppConstant.java" file.
 Go to This file (AppConstant.java) and change the prefix (FILE_PATH_PREFIX) in this file to point current local path where project is cloned.
```shell
FILE_PATH_PREFIX : /Users/mmt7465/Downloads/SortFile
File : src/main/java/com/intercom/filesort/constants/AppConstant.java
```

## What is being done

This project sorts file using External Merge Sort method.
Sorting is basically composed of two phases:

    Partition: partition the input file into a bunch of smaller sorted files.
    Merge: merge the sorted files into a single one, which is the output.



## Implementation Overview

```shell
The basic idea of this implementation is that we logically partition 
the file into smaller slices, each of which will sorted in memory and written to a temporary file. 
MinHeap or Min Priority Queue is used to pick first p (if p represents number of partitions) Customer objects.
Idea is to fetch the Customer which will be minimum according to userid, add it to the output file and then refetch the next line from this partition.
At the end we will have a complete sorted Output File.
```


Test cases have been added in the project in test folder.
```shell
Input File is customer.txt, outputfile is output.txt. It will be regenerated when run locally.
```


## Running the application locally


You can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
cd SortFile
mvn spring-boot:run
```


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/#build-image)

