// Required imports
import java.util.List;
import java.util.ArrayList;

/**
 *  Scheduler class
 *  - it will help us to find if all the courses are doable or not
 */
class Scheduler {
	
    /**
     * 
     * @param numCourses : int : total number of courses
     * @param prerequisites : int[][] : prerequisites[i] = [ai, bi] indicates that you must take the course bi first, if you want to take the course ai
     * @return : boolean : true if all the courses are doable, else false
     */
    public boolean isPossible (int numCourses, int[][] prerequisites) {
    	  
        List<List<Integer>> graph = new ArrayList<>(numCourses); // Adjacency list to represent a directed graph
        
        for(int i = 0; i < numCourses; ++i) {
            graph.add(new ArrayList<>());
        }

        
        boolean[] exploring = new boolean[numCourses]; // to track all nodes which we'll be visiting during backtracking
        
        boolean[] completed = new boolean[numCourses]; // to track all those nodes which we'll traverse successfully and they are not part of any cycle(if any)
        
        
        // creating an directed edge from prerequisites[i][1] to prerequisites[i][0]
        // as we can only access prerequisites[i][0] course from prerequisites[i][1] course
        for (int i = 0; i < prerequisites.length; ++i) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        
        // traversing all the courses/nodes in the graph
        for(int course = 0; course < numCourses; ++course) {
        	
            // if the course/node isn't visited already
            // we will traverse the node and it's connections
            if(!completed[course]) {
            	
                // if the graph contains any cycle return false
                // as at that case we cann't complete all those courses
                // because at that case one course will depend on itself directly or indirectly
                // and it isn't possible to complete that course
                if(isCyclic(graph, exploring, completed, course)) {
                	
                    return false;

                }

            }

        }
        
        // as we traversed all the courses and hasn't found any cycle
        // return true as all the courses are possible to complete
        return true;
        
    }
    
    
    /**
     * 
     * @param graph : List<List<Integer>> : an adjacency list that represents a directed graph
     * @param exploring : boolean[] : track all nodes which we are currently visiting
     * @param completed : boolean[] : track all those nodes which we've traversed successfully and they are not part of any cycle(if any)
     * @param node : int : current visiting node
     * @return : boolean : true if this node is part of any cycle ie the graph is cyclic, else false
     */
    private boolean isCyclic (List<List<Integer>> graph, boolean[] exploring, boolean[] completed, int node) {
        
        // if the node is already present in the current exploring list
        // that means the graph contains a cycle
        if(exploring[node]) return true;
    	
        // if the node is already present in the completed list
        // then we don't need to traverse it again 
        // as we know that this node isn't part of any cycle(if any)
    	if(completed[node]) return false;
    	
        // Add the node to currently exploring list
        exploring[node] = true;
        
        
        // traverse through the neighbours of the current node
        for (int neighbour : graph.get(node)) {
        	
            // If we has not explored the specific neighbour earlier
            // then we will traverse the node and it's connections
            if (!completed[neighbour]) {
            	
                // if the graph contains any cycle
                // return true as the node is a part of a cycle
            	if(isCyclic(graph, exploring, completed, neighbour)) {
                    	
                    return true;
                        
                }
                
            }
            
        }

        // We have explored the node and its complete connections
        // so discarding the node from currently exploring list
        exploring[node] = false;
        
        // We have explored the node and its complete connections
        // It means this node isn't a part any cycle(if any)
        // so marking the node as completed
        completed[node] = true;
        
        // We have explored the node and its complete connections
        // and have not found any cycle,
        // so return false as the node isn't part of any cycle
        return false;
        
    }
    
}


public class CourseSchedule {
	
	public static void main (String[] args){
	  	
	  	Scheduler scheduler = new Scheduler(); // Scheduler object intialization


	  	// TestCase - 1
	  	int numCourses = 4; // Number of courses
	  	
	  	int[][] prerequisites = {
              {1,0},
              {2,0},
              {3,1},
              {3,2}
        };
        // prerequisites[i] = [ai, bi] indicates that you must take the course bi first, if you want to take the course ai
	  	
	  	
	  	/*
	  	// TestCase - 2
	  	int numCourses = 2;
	  	int[][] prerequisites = {
              {1,0},
              {0,1}
        };
	  	*/
	  	
	  	
	  	if(scheduler.isPossible(numCourses, prerequisites))
	  	    System.out.println("True");
	  	else
	  	    System.out.println("False");
	  	
	  }
	  
}