# CodeBeans-Day2
Day 2 of 5 day Coding Challenge &lt;C{o}deBeans/> 1.0 by CoffeeBeans Consulting

# The Course Schedule Problem
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1. 

You are given an array of prerequisites where prerequisites[i] = [ai, bi] indicates that you must take the course bi first, if you want to take the course ai.
For example, the pair [1, 0], indicates that to take course 1 you have to first take course 0.

Return true if you can finish all courses. Otherwise, return false. You can consider all the pairs to be unique.

# Requirements
 * Java 8+

# Run
```
javac CourseSchedule.java
java CourseSchedule
```

# Example outcome

Example 1
```
Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]

Output: true

Explanation: There are a total of 4 courses to take 0, 1, 2 and 3. 
To take course 1 & 2 you should have finished course 0 and to finish course 3, you should have finished course 1 & 2. You can finish the courses in [0,1,2,3] order.
```

Example 2
```
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]

Output: false

Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
```
