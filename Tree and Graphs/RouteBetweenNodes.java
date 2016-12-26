import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by dinu on 12/26/16.
 */
public class RouteBetweenNodes {

    public static void main(String args[]){

        //==========Creating the Graph===============================================
        Graph graph = new Graph(10);
        GraphNode node1 = new GraphNode("A");
        GraphNode node2 = new GraphNode("B");
        GraphNode node3 = new GraphNode("C");
        GraphNode node4 = new GraphNode("D");
        GraphNode node5 = new GraphNode("E");
        GraphNode node6 = new GraphNode("F");
        GraphNode node7 = new GraphNode("G");
        GraphNode node8 = new GraphNode("H");
        GraphNode node9 = new GraphNode("I");
        GraphNode node10 = new GraphNode("J");

        graph.AddVertex(node1,null,new GraphNode[]{node2,node10});

        graph.AddVertex(node2,new GraphNode[]{node1},new GraphNode[]{node4,node8});

        graph.AddVertex(node3,new GraphNode[]{node1},new GraphNode[]{node5,node8});

        graph.AddVertex(node4,new GraphNode[]{node2},null);

        graph.AddVertex(node5,new GraphNode[]{node3},new GraphNode[]{node6});

        graph.AddVertex(node6,new GraphNode[]{node5},null);

        graph.AddVertex(node7,new GraphNode[]{node8},new GraphNode[]{node3});

        graph.AddVertex(node8,new GraphNode[]{node10,node2,node3},new GraphNode[]{node9,node7});

        graph.AddVertex(node9,new GraphNode[]{node8},null);

        graph.AddVertex(node10,new GraphNode[]{node1},new GraphNode[]{node8});

        //========================= Grapgh Created ==============================================

        boolean isConnected= search(graph,node2,node7);
        System.out.println(isConnected);



    }

    /**
     * This used a BFS based approach
     * Another possibility is DFS based
     * @param graph
     * @param first
     * @param second
     * @return
     */
    private static boolean search(Graph graph, GraphNode first, GraphNode second){
        if(first.out==null){
            return false;
        }
        if(first==second){
            return true;
        }
        Queue<GraphNode> queue = new ArrayBlockingQueue(10,true);
        queue.add(first);
        while(!queue.isEmpty()){
            GraphNode node = queue.remove();
            node.marked = true;
            if(node.out!=null || node.outCounter>=0){
                for (int i = 0; i < node.outCounter; i++) {
                    GraphNode tempNode = node.out[i];
                    if(tempNode == second){
                        return true;
                    }
                    if(!tempNode.marked){
                        queue.add(tempNode);
                    }

                }
            }


        }
        return false;
    }


}

class Graph{
    int maxVertices;
    GraphNode[] vertices;
    int count;

    Graph(int MAX_VERTICES){
        vertices = new GraphNode[MAX_VERTICES];
    }

    void AddVertex(GraphNode node, GraphNode[] in, GraphNode[] out){
        if(count >= maxVertices){
            vertices[count] = node;
            node.addInFullArray(in);
            node.addOutFullArray(out);
            count++;
        }
        else{
            System.out.println("Graph Full");
        }
    }




}

class GraphNode{
    static int MAX_CONNECTIONS = 3;
    GraphNode[] in;
    GraphNode[] out;
    int inCounter;
    int outCounter;
    boolean marked;
    String name;

    GraphNode(String name){
        in = new GraphNode[MAX_CONNECTIONS];
        out = new GraphNode[MAX_CONNECTIONS];
        inCounter = 0;
        outCounter = 0;
        this.name = name;
    }

    void addInNode(GraphNode node){
        if(inCounter >= MAX_CONNECTIONS){
            throw new ArrayIndexOutOfBoundsException();
        }else{
            in[inCounter] = node;
            inCounter++;
        }
    }

    void addOutNode(GraphNode node){
        if(outCounter >= MAX_CONNECTIONS){
            throw new ArrayIndexOutOfBoundsException();
        }else{
            out[outCounter] = node;
            outCounter++;
        }
    }

    void addInFullArray(GraphNode[] inArray){
        if(inArray==null){
            return;
        }
        if(inArray.length <= MAX_CONNECTIONS){
            in = inArray;
            inCounter = inArray.length;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    void addOutFullArray(GraphNode[] outArray){
        if(outArray==null){
            return;
        }
        if(outArray.length <= MAX_CONNECTIONS){
            out = outArray;
            outCounter = outArray.length;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }


}