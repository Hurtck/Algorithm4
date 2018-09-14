public class RBTree {
/**    红黑树的实现
 * 红节点只能存在于右侧
 *     插入
 *     删除
 *     右旋
 *        b                        c
 *      /  \         ->         /
 *    a     c（红节点）      b(红节点)
 *                         /
 *                       a
 *     左旋
 *         a                   b
 *      /     \                 \
 *    /        \       ->        a
 *  b(红节点)   c                  \
 *                                 c
 *
 *     变色
 *     **/
    private static Boolean RED = Boolean.TRUE;
    private static Boolean BLACK = Boolean.FALSE;
    private Node root;
    class Node{
        String key;
        int value;
        Node left, right;
        int N;
        boolean color;//与父节点的连接颜色
        public Node(String key, int value, int N, boolean color){
            this.key = key;
            this.value = value;
            this.N = N;
            this.left = null;
            this.right = null;
            this.color = color;
        }
    }

    private int size(Node h){
        if(h==null) return 0;
        return h.N;
    }

    private boolean isRed(Node x){
        if(x == null) return false;
        return x.color == RED;
    }

    Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + h.left.N + h.right.N;
        return x;
    }

    void filpColors(Node h){
        h.color = RED;
        h.right.color = BLACK;
        h.left.color = BLACK;
    }

    private void put(String key, int val){
        root = put(root,key,val);
        root.color = BLACK;
    }

    private Node put(Node h, String key, int val){
        if(h == null) return new Node(key, val, 1, RED);
        int cmp = key.compareTo(h.key);
        if (cmp<0) h.left = put(h.left, key, val);
        else if(cmp>0) h.right = put(h.right,key,val);
        else h.value = val;
        if(isRed(h.right)&&!isRed(h.left)) h = rotateLeft(h);
        if(isRed(h.left)&&isRed(h.left.left)) h = rotateRight(h);
        if(isRed(h.left)&&isRed(h.right)) filpColors(h);
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    private void printTree(Node h){
        if(h==null) return;
        printTree(h.right);
        System.out.print("("+h.key+","+String.valueOf(h.value)+")");
        printTree(h.left);
    }

    public static void main(String[] args) {
        RBTree tree = new RBTree();
        int[][] data = {{1,1},{2,2},{3,3},{4,4},{5,5},{6,6},{7,7},{8,8},{9,9}};
        for(int i=0;i<9;i++){
            tree.put(String.valueOf(data[i][0]),data[i][1]);
            tree.printTree(tree.root);
            System.out.println();
        }

    }

}
