# Ten ping bowling java challenge

This is a maven console java app for score a game of ten-pin bowling from txt file.

### Installation

For this project you need to have Java 8+ maven installed [Maven](https://maven.apache.org/)

### Make sure to have JDK8 installed
The latest binary can be found [here](http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html)

You can download a preview version [here](https://jdk8.java.net/)

### Run
```sh
$ git clone https://github.com/ronniemh/ten-pin-bowling-challenge.git
$ cd ten-pin-bowling-challenge/
$ mvn clean package
## If you want to test a file send as param ${LocationFile}
$ java -cp target/ten-pin-bowling-1.0-SNAPSHOT.jar dev.ronniemoncayo.App "${LocationFile}"
```
