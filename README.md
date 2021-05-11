# Triangle Paths

## Task
Write a command-line program that reads a text-format triangle from standard input and outputs a minimal path to the 
standard output as follows:

```
$ cat << EOF | java MinTrianglePath 
> 7
> 6 3
> 3 8 5
> 11 2 10 9
> EOF
Minimal path is: 7 + 6 + 3 + 2 = 18
```