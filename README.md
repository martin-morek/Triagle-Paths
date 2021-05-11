# Minimum triangle Path

## Task
Write a command-line program that reads a text-format triangle from standard input and outputs a minimal path to the 
standard output as follows:

```shell
$ cat << EOF | java MinTrianglePath 
> 7
> 6 3
> 3 8 5
> 11 2 10 9
> EOF
Minimal path is: 7 + 6 + 3 + 2 = 18
```


Triangle visualization:
```shell
            7

        6       3

    3       8       5

11      2       10      9
```


## Running
To run the program java version 1.8 and Scala 2.13. are required to be installed.

### Running tests
To run tests execute in terminal:

```shell
sbt test
```

### Building jar
To build a fat jar execute in terminal:

```shell
sbt assembly
```

### Running program
Program expect above mentioned input. 

To run program execute in terminal:

```shell
$ cat << EOF | java -jar target/scala-2.13/MinTrianglePath.jar 
> 7
> 6 3
> 3 8 5
> 11 2 10 9
> EOF
```
#### Program output

Correct output has the format:
```shell
Minimal path is: 7 + 6 + 3 + 2 = 18
```
In a case of incorrect user input program ends with output:
```shell
Triangle cannot be constructed
```



