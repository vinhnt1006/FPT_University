
import java.io.File;
import java.io.RandomAccessFile;

public class Graph_Matrix {

    int nVertices;
    int[][] adjMatrix;
    char[] vSet;

    Graph_Matrix() {
        vSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    Graph_Matrix(String vertexNames) {
        vSet = vertexNames.toCharArray();
    }

    void setAdjMatrix(int[][] m) {
        nVertices = m.length;
        adjMatrix = new int[nVertices][nVertices];
        for (int i = 0; i < nVertices; i++) {
            for (int j = 0; j < nVertices; j++) {
                adjMatrix[i][j] = m[i][j];
            }
        }
    }

    void displayAdjMatrix() {
        int i, j;
        System.out.println("\nThe adjacency matrix:");
        for (i = 0; i < nVertices; i++) {
            System.out.println();
            for (j = 0; j < nVertices; j++) {
                System.out.printf("%3d", adjMatrix[i][j]);
            }
        }
    }

    private boolean[] createFlags() {
        boolean[] visited = new boolean[nVertices];
        for (int i = 0; i < nVertices; i++) {
            visited[i] = false;
        }
        return visited;
    }

    void visit(int i) {
        System.out.print(vSet[i] + " ");
    }

    void BF_traverseComponent(int k) {
        MyQueue q = new MyQueue();
        boolean[] visited = createFlags();
        q.enqueue(k);
        visited[k] = true;
        int v;
        while (!q.isEmpty()) {
            v = q.dequeue();
            visit(v);
            for (int i = 0; i < nVertices; i++) {
                if (!visited[i] && adjMatrix[v][i] > 0) {
                    q.enqueue(i);
                    visited[i] = true;
                }
            }
        }
    }

    void BF_traverseAll() {
        MyQueue q = new MyQueue();
        boolean[] visited = createFlags();
        int i, j;
        for (i = 0; i < nVertices; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                q.enqueue(i);
                while (!q.isEmpty()) {
                    int v = q.dequeue();
                    visit(v);
                    for (j = 0; j < nVertices; j++) {
                        if (adjMatrix[v][j] > 0 && !visited[j]) {
                            q.enqueue(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
    }

    void DFS(int v, boolean[] visited) {
        visit(v);
        visited[v] = true;
        for (int j = 0; j < nVertices; j++) {
            if (!visited[j] && adjMatrix[v][j] > 0) {
                DFS(j, visited);
            }
        }
    }

    void DF_traverseComponent(int k) {
        boolean[] visited = createFlags();
        DFS(k, visited);
    }

    void DF_traverseAll() {
        boolean[] visited = createFlags();
        for (int j = 0; j < nVertices; j++) {
            if (visited[j] == false) {
                DFS(j, visited);
            }
        }
    }

    private RandomAccessFile createFile(String fname) throws Exception {
        File f = new File(fname);
        if (f.exists()) {
            f.delete();
        }
        RandomAccessFile rf = new RandomAccessFile(f, "rw");
        return rf;
    }

    void visit_F(RandomAccessFile f, int i) throws Exception {
        f.writeBytes(vSet[i] + " ");
    }

    void BF_traverseComponent_F(String filename, int k) throws Exception {
        RandomAccessFile rf = createFile(filename);
        MyQueue q = new MyQueue();
        boolean[] visited = createFlags();
        q.enqueue(k);
        visited[k] = true;
        int v;
        rf.writeBytes("BF traversal from the vertex " + vSet[k] + ":\r\n");
        while (!q.isEmpty()) {
            v = q.dequeue();
            visit_F(rf, v);
            for (int i = 0; i < nVertices; i++) {
                if (!visited[i] && adjMatrix[v][i] > 0) {
                    q.enqueue(i);
                    visited[i] = true;
                }
            }
        }
        rf.writeBytes("\r\n");
        rf.close();
    }

    void BF_traverseAll_F(String filename) throws Exception {
        RandomAccessFile rf = createFile(filename);
        MyQueue q = new MyQueue();
        boolean[] visited = createFlags();
        rf.writeBytes("BF all vertex, from " + vSet[0] + ":\r\n");
        int i, j;
        for (i = 0; i < nVertices; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                q.enqueue(i);
                while (!q.isEmpty()) {
                    int v = q.dequeue();
                    visit_F(rf, v);
                    for (j = 0; j < nVertices; j++) {
                        if (adjMatrix[v][j] > 0 && !visited[j]) {
                            q.enqueue(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        rf.writeBytes("\r\n");
        rf.close();
    }

    void DFS_F(RandomAccessFile rf, int v, boolean[] visited) throws Exception {
        visit_F(rf, v);
        visited[v] = true;
        for (int j = 0; j < nVertices; j++) {
            if (!visited[j] && adjMatrix[v][j] > 0) {
                DFS_F(rf, j, visited);
            }
        }
    }

    void DF_traverseComponent_F(String filename, int k) throws Exception {
        RandomAccessFile rf = createFile(filename);
        boolean[] visited = createFlags();
        rf.writeBytes("DF from " + vSet[k] + ":\r\n");
        DFS_F(rf, k, visited);
        rf.writeBytes("\r\n");
        rf.close();
    }

    void DF_traverseAll_F(String filename) throws Exception {
        RandomAccessFile rf = createFile(filename);
        boolean[] visited = createFlags();
        rf.writeBytes("DF all vertex, from " + vSet[0] + ":\r\n");
        int j;
        for (j = 0; j < nVertices; j++) {
            visited[j] = false;
        }
        for (j = 0; j < nVertices; j++) {
            if (visited[j] == false) {
                DFS_F(rf, j, visited);
            }
        }
        rf.writeBytes("\r\n");
        rf.close();
    }
}
