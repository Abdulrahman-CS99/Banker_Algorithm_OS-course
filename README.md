# Banker_Algorithm_OS_CS322


(Banker Algorithm)<br />

Objective<br />

The purpose of this programming project is to explore resource allocation<br />
algorithms. This can be achieved by implementing the banker's algorithm as described in our textbook and discussed in class.<br />

Description<br />

Review the banker's algorithm discussed in class. Your program must be named "banker" and will read the allocation, max, available, and request vectors from a file. The name of the file will be passed to your program as a command line argument. The input file format is the following:<br />

•	number of processes: n<br />
•	number of resource types: m<br />
•	An n x m allocation matrix<br />
•	An n x m max matrix<br />
•	A 1 x m available vector<br />
•	A i : 1 x m request vector<br />

Your program will output the following in a standardized format.<br />

a.	Echo the number of processes.<br />
b.	Echo the number of resource types.<br />
c.	Echo the allocation matrix. Label the processes and resource types (see sample output).<br />
d.	Echo the max matrix. Label the processes and resource types (see sample output).<br />
e.	Compute and print the need matrix. Label the processes and resource types (see sample output).<br />
f.	Echo the available vector. Label the resource types.<br />
 
g.	Compute if the system is in a safe state.<br />
h.	Echo the request vector. Label the process making the request and resource types (see sample output).<br />
i.	Compute if the request can be granted.<br />
j.	Compute the new available vector (see sample output).<br />

Here is the Sample input file:<br /><br />

5	<br />
4	<br />
0	0	1	2<br />
1	0	0	0<br />
1	3	5	4<br />
0	6	3	2<br />
0	0	1	4<br />
0	0	1	2<br />
1	7	5	0<br />
2	3	5	6<br />
0	6	5	2<br />
0	6	5	6<br />
1	5	2	0<br />
1:0	4	2	0<br />


Here is how the program should be run.<br />

Here is the sample output.<br /><br />






There are 5 processes in the system.<br />
There are 4 resource types.<br />
The Allocation Matrix is...<br />
&nbsp A B C D<br />
0: 0 0 1 2<br />
1: 1 0 0 0<br />
2: 1 3 5 4<br />
3: 0 6 3 2<br />
4: 0 0 1 4<br />
The Max Matrix is...<br />
     A B C D<br />
0: 0 0 1 2<br />
1: 1 7 5 0<br />
2: 2 3 5 6<br />
