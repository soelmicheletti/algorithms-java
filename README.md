# Algorithms

Java Implementations of algorithms and data structures learned in my first year at ETH Zurich. The primary goal was learning how the different algorithms work, hence I decided to (partially) avoid importing external libraries. 


## Searching

Algorithm  | Key Idea | Runtime
------------- | ------------- | -------------
[Linear Search](/searching/LinearSearch.java)  | Check every element. | **O(n)** (worst-case)
[Binary Search](/searching/BinarySearch.java)  | Searching in a dictionary of a foreign language. | **O(log n)** (worst-case)
[Interpolation Search](/searching/InterpolationSearch.java)  | Searching in a dictionary when you have an estimate of the words distribution. | **O(log n)** (worst-case)
[Exponential Search](/searching/ExponentialSearch.java)  | Find range and use binary search. | **O(log n)** (worst-case)

## Sorting

Algorithm  | Key Idea | Runtime
------------- | ------------- | -------------
[Bubble Sort](/sorting/BubbleSort.java)  | Double for loop. | **O(n^2)** (worst-case)
[Insertion Sort](/sorting/InsertionSort.java)  | Sorting a deck of card. | **O(n^2)** (worst-case)
[Selection Sort](/sorting/SelectionSort.java)  | Pick the maximum of the unsorted part of the array and put it at the end. | **O(n^2)** (worst-case)
[Merge Sort](/sorting/MergeSort.java)  | Divide and conquer. | **O(n log n)** (worst-case)
[Quick Sort](/sorting/QuickSort.java)  | Use a (random) pivot to partition the array. | **O(n log n)** average-case, but **O(n^2)** worst-case
