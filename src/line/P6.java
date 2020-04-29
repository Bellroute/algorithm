package line;

import java.util.ArrayList;
import java.util.List;

public class P6 {
    private static Node root = new Node("");

    public static void main(String[] args) {
        String[] dirctory1 = {"/",
                "/hello",
                "/hello/tmp",
                "/root",
                "/root/abcd",
                "/root/abcd/etc",
                "/root/abcd/hello"};


    }

    public static String[] solution(String[] directory, String[] command) {
        String[] answer = {};

        for (int i = 0; i < directory.length; i++) {
            String[] dir = directory[i].split("/");

            Node cd = root;
            for (int j = 1; j < dir.length; j++) {
                String dirName = dir[j];

                if (!cd.isContainDirName(dirName)) {
                    cd.children.add(new Node(dirName));
                } else {
                    cd = changeDirectory(cd, dirName);
                }
            }
        }

        return answer;
    }

    private static Node changeDirectory(Node cd, String dirName) {
        return cd.children.stream().filter(child -> child.name.equals(dirName)).findFirst().get();
    }
}

class Node {
    String name;
    List<Node> children = new ArrayList<>();

    public Node(String name) {
        this.name = name;
    }

    public boolean isContainDirName(String dirName) {
       return children.stream().anyMatch(child -> child.name.equals(dirName));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name)
                     .append("/");

        if (children.size() != 0) {
            children.forEach(child -> stringBuilder.append(child.toString()));
        }

        stringBuilder.append("\n");

        return stringBuilder.toString();
    }
}
