This project tasked me with implementing my own Priority queue. I have implemented every method 
in the Java priorityQueue class that we were supposed to emulate except for comparator and iterator,
which was exactly what the specifications asked me to do. I also implemented a merge method that can
merge a priority queue into another in O(n) time, which is considered 'efficient' and can possibly
qualify for extra credit according to the assignment. 
Currently all methods have been tested
for around 5 test cases each using the randomized driver function in main() and no bugs have been found;
however, one way the class could be improved is to generalize it to all comparable data types instead of
simply Integer. 
The class essentially emulates the standard Java priorityQueue class, so the structure
is almost the same; however, the structure used to store values is an ArrayList instead of a heap, which
sacrifices efficiency for ease of implementation. However, the merge() method was my own creation; by
taking advantage of the fact that both queues were sorted, I essentially performed a variation of heap sort
to merge the queues, which in general is very efficient. 
Some major challenges involved getting a custom
Comparator to work with the code and trying to get the class to generalize to all comparable data types
(which was later abandoned due to the sheer difficulty and the realization that it wasn't part of the
specifications). 
I should thank my tablemates Caleb and Jonathan for reminding me that the queue need not generalize to all
data types; they saved me a lot of work! I referenced the Java documentation online to determine the 
methods I had to include in my project.