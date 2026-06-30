package exam._260609.coupang;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystemImpl();
        fileSystem.mkdir("/a/b/c/d");
        fileSystem.mkdir("/a/b/c/e");
        List<String> list = fileSystem.ls("/a/b/c");
        System.out.println(list);
        fileSystem.addContentToFile("/a/b/c/file.file", "content");
        list = fileSystem.ls("/a/b/c");
        System.out.println(list);
        fileSystem.addContentToFile("/a/b/c/file.file", "content");
        System.out.println(list);
    }

}
