package programmers.kakao.blindRecruitment2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoadSearching {

    private static int[] preOderResult;
    private static int[] postOderResult;
    private static int index = 0;

    public static void main(String[] args) {
        int[][] nodeinfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        int[][] answer = solution(nodeinfo);

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];

        List<Node> nodeList = new ArrayList<>();
        preOderResult = new int[nodeinfo.length];
        postOderResult = new int[nodeinfo.length];

        for (int i = 0; i < nodeinfo.length; i++) {
            nodeList.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }

        Collections.sort(nodeList);
        Node root = nodeList.get(0);

        for (int i = 0; i < nodeList.size(); i++) {
            Node nowNode = nodeList.get(i);
            setNodes(root, nowNode);
        }

        preOrder(root);
        index = 0;
        postOrder(root);

        answer[0] = preOderResult;
        answer[1] = postOderResult;

        return answer;
    }

    private static void setNodes(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                if (parent.left.y < child.y) {
                    Node temp = parent.left;
                    parent.left = child;
                    setNodes(parent.left, temp);
                    return;
                }

                setNodes(parent.left, child);
            }
        }

        if (child.x > parent.x) {
            if (parent.right == null) {
                parent.right = child;
            } else {
                if (parent.right.y < child.y) {
                    Node temp = parent.right;
                    parent.right = child;
                    setNodes(parent.right, temp);
                    return;
                }

                setNodes(parent.right, child);
            }
        }
    }


    private static void preOrder(Node node) {
        if (node != null) {
            preOderResult[index++] = node.index;
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private static void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            postOderResult[index++] = node.index;
        }
    }
}

class Node implements Comparable<Node> {
    Node left;
    Node right;
    int x;
    int y;
    int index;

    public Node(int index, int x, int y) {
        this.left = null;
        this.right = null;
        this.index = index;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node o) {
        if (this.y == o.y) {
            return this.x - o.x;
        } else {
            return o.y - this.y;
        }
    }
}