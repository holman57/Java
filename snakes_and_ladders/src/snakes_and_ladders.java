import java.util.AbstractMap;

class snakes_and_ladders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        AbstractMap.SimpleEntry[] cells = new AbstractMap.SimpleEntry[n * n + 1];
        int label = 1;
        Integer[] columns = new Integer[n];
        for (int i = 0; i < n; i++) {
            columns[i] = i;
        }
        for (int row = n - 1; row >= 0; row--) {
            for (int column : columns) {
                cells[label++] = new AbstractMap.SimpleEntry<>(row, column);
            }
            java.util.Collections.reverse(java.util.Arrays.asList(columns));
        }
        int[] dist = new int[n * n + 1];
        java.util.Arrays.fill(dist, -1);
        class Vertex implements Comparable<Vertex> {
            final int distance;
            final int label;

            public Vertex(int distance, int label) {
                this.distance = distance;
                this.label = label;
            }

            public int compareTo(Vertex v) {
                return this.distance - v.distance;
            }
        }
        java.util.PriorityQueue<Vertex> q = new java.util.PriorityQueue<>();
        dist[1] = 0;
        q.add(new Vertex(0, 1));
        while (!q.isEmpty()) {
            Vertex vertex = q.remove();
            int d = vertex.distance, curr = vertex.label;
            if (d != dist[curr]) {
                continue;
            }
            for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {
                int row = (int) cells[next].getKey(), column = (int) cells[next].getValue();
                int destination = board[row][column] != -1 ? board[row][column] : next;
                if (dist[destination] == -1 || dist[curr] + 1 < dist[destination]) {
                    dist[destination] = dist[curr] + 1;
                    q.add(new Vertex(dist[destination], destination));
                }
            }
        }
        return dist[n * n];
    }
}