# Algorithms

Java Implementations of algorithms learned in my first year at ETH Zurich. The code was written at the beginning of my studies with the primary goal of learning how the different algorithms work. To take the maximum out of the experience, some algorithms are implemented without importing any external library. 

## Sorting

Algorithm  | Key Idea | Runtime
------------- | ------------- | -------------
[Bubble Sort](/sorting/BubbleSort.java)  | Content Cell. | **O(n^2)** (worst-case)
[Insertion Sort](/sorting/InsertionSort.java)  | Sorting a deck of card. | **O(n^2)** (worst-case)
[Selection Sort](/sorting/SeletionSort.java)  | Pick the maximum of the unsorted part of the array and put it at the end. | **O(n^2)** (worst-case)
[Merge Sort](/sorting/MergeSort.java)  | Divide and conquer. | **O(n log n)** (worst-case)
[Quick Sort](/sorting/QuickSort.java)  | Use a (random) pivot to partition the array. | **O(n log n)** average-case, but **O(n^2)** worst-case
