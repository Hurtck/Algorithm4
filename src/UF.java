
/**
 * Union find 算法，用来判断图中两个节点是否联通
 * quickUF算法，将在同一个联通分量中的节点放在同一棵树下
 */
class UF{
    int[] id;
    int[] size;
    int count = 0;

    public UF(int N){
        for (int i = 0; i<N; i++){
            id[i] = i;
            size[i] = 1;
        }
        count = N;
    }
    public void union(int p , int q){
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ){
            return;
        }
        if (size[rootP] > size[rootQ]){
            id[q] = rootP;
            size[rootP] += size[rootQ];
        }else {
            id[p] = rootQ;
            size[rootQ] += size[rootP];
        }
    }
    int find(int p){
        int rootP = p;
        while (id[rootP] != rootP){
            rootP = id[rootP];
        }
        return rootP;
    }
    boolean connected(int p ,int q){
        return id[p] == id[q];
    }
    int count(){
        return count;
    }

    public static void main(String[] args) {
//        int N = StdIn.readInt();
//        UF uf = new UF(N);
//        while(!StdIn.isEmpty()){
//            int p = StdIn.readInt();
//            int q = StdIn.readInt();
//            if(uf.connected(p,q)) continue;
//            StdOut.print(p + "  "+q);
//        }
//        StdOut.print(uf.count+" components");
    }
}