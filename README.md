# Algorithms

Java Implementations of algorithms and data structures learned in my first year at ETH Zurich. The primary goal was learning how the different algorithms work, hence I decided to (partially) avoid importing external libraries. 

![Alt text](/wallpaper.jpg?raw=true "Title")


## Graph Theory

In this list we mention the implemented algorithms, together with their goal and runtime. In the [graphs](/graphs) repository, you may find additional implementations using different data structures and no imports. 

Algorithm  | Goal | Runtime
------------- | ------------- | -------------
[Articulation Nodes](/graphs/ArticulationNodes.java)  | Find nodes that ensure graph connectivity. | **O(n+m)**
[BFS](/graphs/BFSAdjacencyList.java)  | Perform Breadth-First-Search on the graph. | **O(n+m)**
[Bellman Ford](/graphs/BellmanFordAdjacencyList.java)  | One-to-all shortest path, even with negative weights. | **O(nm)**
[DFS](/graphs/DFSAdjacencyList.java)  | Perform Depth-First-Search on the graph. | **O(n+m)**
[Dijkstra](/graphs/DijkstraAdjacencyList.java)  | One-to-all shortest path, weights must be non-negative. | **O(n log n + m)** (with Fibonacci-Heaps, this version is less efficient)
[Euler Tour](/graphs/EulerTour.java)  | Decide if the graph contains an Euler Tour. | **O(m)** 
[Floyd Warshall](/graphs/FloydWarshallAdjacencyList.java)  | All-to-all shortest path. | **O(n^3)** 
[Kruskal](/graphs/KruskalAdjacencyList.java)  | MST by applying the blue rule. | **O(m log m)** 
[Prim](/graphs/PrimAdjacencyList.java)  | MST by applying the blue/ red rule. | **O(m log n)**
[Topological Sorting](/graphs/TopologicalSortAdjacencyList.java)  | Determine if the graph has a topological order | **O(n + m)**

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

## Data Structures

Data Structure  | Supported Operations 
------------- | -------------
[Binary Search Tree](/data-structures/BinarySearchTree.java)  | Add, find, dele: everything **O(h)** (h is the height of the tree)
[Priority Queue](/data-structures/PriorityQueue.java)  | Enque, Deque: both **O(log n)**
[Queue](/data-structures/Queue.java)  | Enque, Deque: both **O(1)** 
[Stack](/data-structures/Stack.java)  | Push, Pop, Top: everything **O(1)** 
[Union Find](/data-structures/UnionFind.java)  | Find, Union: both **O(log n)** using path compression 
