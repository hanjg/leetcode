package exam._260609.coupang;

import java.util.List;

/**
 * @author hanjigang
 * @date 2026/6/9 14:05
 */
public interface FileSystem {

    // Input: The absolute path of the file name, for example, path=/a/b/c/d

    // If this path is a directory, return the names of all files (and directories) in this directory, sorted in lexicographical order

    // If this path is a file, return the name of this file

    List<String> ls(String path); // Input: The absolute path of the file name, for example, path=/a/b/c/d


    // Input: The absolute path of the file name, for example, path=/a/b/c/d

    // If this path does not exist, create this path. If intermediate directory nodes do not exist, create them as well, such as /b/c

    void mkdir(String path); // Input: The absolute path of the file name, for example, path=/a/b/c/d. content file content, string


    // If this file does not exist, create this file. If the file already exists, append the file content

    void addContentToFile(String path, String content);
}
