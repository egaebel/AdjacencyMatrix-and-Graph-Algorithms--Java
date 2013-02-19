package ds.GraphAlgorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import ds.Graph.Graph;

/**
 * Algorithms class with methods which take a Graph interface 
 * 
 * Contains:
 * dfs
 * bfs
 * topological sort
 * 
 * To implement:
 * A*
 * Djikstras
 * Minimum Spanning Tree
 * 
 * (as definded in ds.Graph) as an argument. 
 * 
 * @author Ethan Gaebel (egaebel)
 *
 */
public class Algorithms<T> {

    //~Constants----------------------------------------------


    //~Data Fields--------------------------------------------


    //~Constructors--------------------------------------------


    //~Methods-------------------------------------------------
    /**
     * Depth first search method that takes a starting element, goal element, and graph and finds a path
     * between the start and goal elements.
     * 
     * @param g the Graph to search in.
     * @param cur the starting element.
     * @param end the goal element.
     * @return List of elements from cur to end, null if no path exists.
     */
    public List<T> dfs(Graph<T> g, T cur, T end) {
        
        LinkedList<T> trail = new LinkedList<T>();
        Set<T> set = new HashSet<T>();
        
        set.add(cur);
        trail.add(cur);
        
        if (dfs(g, cur, end, set, trail)) {
            
            return trail;
        }
        
        return null;
    }
    
    /**
     * Helper method for dfs.
     * Recursive.
     * Takes a set, graph, current vertex, and goal vertex and continues the dfs search, adding
     * elements to the trail as it goes.
     * 
     * @param g the graph being searched.
     * @param cur the current element.
     * @param end the goal element.
     * @param set a set to keep track of which elements have been visited.
     * @param trail the trail of elements.
     * @return true if goal found, false otherwise.
     */
    private boolean dfs(Graph<T> g, T cur, T end, Set<T> set, LinkedList<T> trail) {
                
        if (cur.equals(end)) {
            
            return true;
        }
        else {
         
            for (T el : g.getEdgesTo(cur)) {
                
                if (!set.contains(el)) {
        
                    set.add(el);
                    trail.add(el);
                    
                    if (!dfs(g, el, end, set, trail)) {
                        
                        set.remove(el);
                        trail.remove(el);
                    }
                    else {
                        
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    /**
     * Run a breadth first search on the passed in graph to find the shortest
     * path from start to end. 
     * 
     * @param g the Graph to be searched.
     * @param start the starting element.
     * @param end the goal element.
     * @return the trail that leads from start to end, null if there does not exist a path.
     */
    public List<T> bfs(Graph<T> g, T start, T end) {
        
        LinkedList<T> trail = new LinkedList<T>();
        Set<T> set = new HashSet<T>();
        Queue<T> q = new LinkedList<T>();
        Map<T, T> backtracker = new HashMap<T, T>();
        
        q.add(start);
        set.add(start);
        
        T cur;
        while (!q.isEmpty()) {
            
            cur = q.remove();
            
            if (cur.equals(end)) {

                while (!cur.equals(start)) {
                    trail.addFirst(cur);
                    cur = backtracker.get(cur);
                }
                trail.addFirst(start);
                
                return trail;
            }
            else {
                
                for (T edge : g.getEdgesTo(cur)) {
                    
                    if (!set.contains(edge)) {
                        
                        q.add(edge);
                        set.add(edge);
                        backtracker.put(edge, cur);
                    }
                }
            }
        }
        
        return null;
    }
    
    /**
     * Performs a topological sort on the graph, provided it is directed.
     * If null is returns then it means that this graph is acyclic.
     * 
     * @param g the graph to be topologically sorted.
     * @return the topological ordering of the graph, null if none exists.
     */
    public List<T> topoSort(Graph<T> g) {
        
        if (g.isDirected()) {
            
            //copy graph to not destroy the original
            Graph<T> copy = g.makeCopy();
            
            Queue<T> q = new LinkedList<T>();
            LinkedList<T> sort = new LinkedList<T>();

            //find vertices with no edges to them---
            //loop over all vertices
            for (T v : copy.getVertices()) {
                
                //if there are no edges from e to v
                if (copy.getEdgesFrom(v).isEmpty()) {
                    
                    //store v
                    q.add(v);
                }
            }
            
            //Perform topo sort algorithm
            T el;
            while(!q.isEmpty()) {
                
                //get el, add to sort
                el = q.remove(); 
                sort.add(el);
                
                //loop over edges from el to v
                for (T e : copy.getEdgesTo(el)) {
                    
                    copy.removeEdge(el, e);
                    
                    if (copy.getEdgesFrom(e).isEmpty()) {
                        q.add(e);
                    }
                }
            }
            
            //The size of the sort and the graph differ, therefore....
                //there is a cycle, and therefore no valid topological sort
            if (sort.size() != g.size()) {
            
                return null;
            }
            
            return sort;
        }
        
        return null;
    }
}