# Banker_Algorithm_OS_CS322


Project 1

(Banker Algorithm)

Objective

The purpose of this programming project is to explore resource allocation
algorithms. This can be achieved by implementing the banker's algorithm as described in our textbook and discussed in class.

Description

Review the banker's algorithm discussed in class. Your program must be named "banker" and will read the allocation, max, available, and request vectors from a file. The name of the file will be passed to your program as a command line argument. The input file format is the following:

•	number of processes: n
•	number of resource types: m
•	An n x m allocation matrix
•	An n x m max matrix
•	A 1 x m available vector
•	A i : 1 x m request vector

Your program will output the following in a standardized format.

a.	Echo the number of processes.
b.	Echo the number of resource types.
c.	Echo the allocation matrix. Label the processes and resource types (see sample output).
d.	Echo the max matrix. Label the processes and resource types (see sample output).
e.	Compute and print the need matrix. Label the processes and resource types (see sample output).
f.	Echo the available vector. Label the resource types.
 
g.	Compute if the system is in a safe state.
h.	Echo the request vector. Label the process making the request and resource types (see sample output).
i.	Compute if the request can be granted.
j.	Compute the new available vector (see sample output).

Here is the Sample input file:
5
4
0 0 1 2
1 0 0 0
1 3 5 4
0 6 3 2
0 0 1 4
0 0 1 2
1 7 5 0
2 3 5 6
0 6 5 2
0 6 5 6
1 5 2 0
1:0 4 2 0
Here is how the program should be run.
Here is the sample output.
There are 5 processes in the system.
There are 4 resource types.
The Allocation Matrix is...
A B C D
0: 0 0 1 2
1: 1 0 0 0
2: 1 3 5 4
3: 0 6 3 2
4: 0 0 1 4
The Max Matrix is...
A B C D
0: 0 0 1 2
1: 1 7 5 0
2: 2 3 5 6
3: 0 6 5 2
4: 0 6 5 6
The Need Matrix is...
A B C D
0: 0 0 0 0
1: 0 7 5 0
2: 1 0 0 2
3: 0 0 2 0
4: 0 6 4 2
The Available Vector is...
A B C D
1 5 2 0
THE SYSTEM IS IN A SAFE STATE!
The Request Vector is...
A B C D
1:0 4 2 0
THE REQUEST CAN BE GRANTED!
The Available Vector is...
A B C D
1 1 0 0
