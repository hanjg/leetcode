package test._260609.coupang;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author hanjigang
 * @date 2026/6/9 14:05
 */
public class FileSystemImpl implements FileSystem {

    private Node root;

    public class Node {
        String fullPath;
        List<Node> children;
        boolean isFile;
        String content;

        public Node() {

        }

        public Node(String fullPath, boolean isFile) {
            this.fullPath = fullPath;
            this.isFile = isFile;
            this.children = new ArrayList<>();
            content = "";
        }

        public String name() {
            String[] paths = findParts(fullPath);
            return paths[paths.length - 1];
        }
    }

    public FileSystemImpl() {
        root = new Node("/", false);
    }

    private static String[] findParts(String path) {
        String[] parts = path.split("/");
        String[] result = new String[parts.length - 1];
        for (int i = 1; i < parts.length; i++) {
            result[i - 1] = parts[i];
        }
        return result;
    }

    @Override
    public List<String> ls(String path) {
        Node current = findNodeByPath(path);
        if (current == null || current.isFile) {
            // 文件 或者不存在
            return new ArrayList<>();
        }
        List<String> fileNames = new ArrayList<>();
        for (Node child : current.children) {
            fileNames.add(child.name());
        }
        return fileNames;
    }

    private Node findNodeByPath(String path) {
        String[] parts = findParts(path);
        Node current = root;
        for (String part : parts) {
            boolean hasChild = false;
            for (Node child : current.children) {
                if (Objects.equals(child.name(), part)) {
                    hasChild = true;
                    current = child;
                }
            }
            if (!hasChild) {
                return null;
            }
        }
        return current;
    }


    public Node createDirByPath(String path) {
        String[] parts = findParts(path);
        Node current = root;
        String currentPath = "";
        for (String part : parts) {
            boolean hasChild = false;
            for (Node child : current.children) {
                if (Objects.equals(child.name(), part)) {
                    current = child;
                    currentPath += "/" + part;
                    hasChild = true;
                    break;
                }
            }
            if (!hasChild) {
                currentPath += "/" + part;
                Node newNode = new Node(currentPath, false);
                current.children.add(newNode);
                current = newNode;
            }
        }
        return current;
    }

    @Override
    public void mkdir(String path) {
        createDirByPath(path);
    }

    @Override
    public void addContentToFile(String path, String content) {
        Node cur = createDirByPath(path);
        if (cur.isFile) {
            cur.content += content;
        } else {
            cur.isFile = true;
            cur.content = content;
        }
        System.out.println("content: " + cur.content);
    }
}
