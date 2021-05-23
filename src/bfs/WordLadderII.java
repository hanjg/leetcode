package bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * problems-126 https://leetcode-cn.com/problems/word-ladder-ii/
 */
public class WordLadderII {

    private List<List<String>> res = new ArrayList<>();

    /**
     * 从初始到每个单词的最短距离。因为求最短路径上的单词，不需考虑相同单词的不同距离
     */
    private HashMap<String, Integer> minDistance = new HashMap<>();

    /**
     * 每个单词的邻接单词
     */
    private HashMap<String, List<String>> neighbours = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        bfs(beginWord, endWord, new HashSet<>(wordList));
        dfs(beginWord, new ArrayList<>(), endWord);
        return res;
    }

    /**
     * dfs 构造所有最短距离的路径
     *
     * @param cur 当前节点
     * @param path 已经遍历的路径
     */
    private void dfs(String cur, List<String> path, String endWord) {
        if (Objects.equals(minDistance.get(cur), minDistance.get(endWord))) {
            if (cur.equals(endWord)) {
                //是到达终点的最短路径
                path.add(cur);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        for (String next : neighbours.get(cur)) {
            //遍历距离加一的节点，过滤成环的路径
            if (minDistance.get(next).equals(minDistance.get(cur) + 1)) {
                path.add(cur);
                dfs(next, path, endWord);
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * bfs层次遍历 求邻接单词列表、从初始单词变化的最短距离
     */
    private void bfs(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        int distance = 0;
        boolean find = false;
        minDistance.put(beginWord, distance);
        queue.add(beginWord);
        while (!find && !queue.isEmpty()) {
            distance++;
            int levelNum = queue.size();
            //层次遍历
            for (int i = 0; i < levelNum; i++) {
                String cur = queue.poll();
                List<String> neiList = findNeighbours(cur, endWord, wordList);
                neighbours.put(cur, neiList);
                for (String nei : neiList) {
                    if (minDistance.containsKey(nei)) {
                        //已经遍历过
                        continue;
                    }
                    minDistance.put(nei, distance);
                    queue.add(nei);
                    if (nei.equals(endWord)) {
                        //找到目标单词
                        find = true;
                    }
                }
            }
        }
    }

    private List<String> findNeighbours(String cur, String endWord, Set<String> wordList) {
        List<String> neiList = new ArrayList<>();
        char[] cs = cur.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char old = cs[i];
            for (char newChar = 'a'; newChar <= 'z'; newChar++) {
                if (old == newChar) {
                    continue;
                }
                cs[i] = newChar;
                String nextWord = String.valueOf(cs);
                if (endWord.equals(nextWord) || wordList.contains(nextWord)) {
                    neiList.add(nextWord);
                }
            }
            cs[i] = old;
        }
        return neiList;
    }

    public static void main(String[] args) {
        String[] list = {"kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay", "sip", "kay", "per",
                "val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay", "eco", "pub", "lob", "rue",
                "fry", "lit", "rex", "jan", "cot", "bid", "ali", "pay", "col", "gum", "ger", "row", "won", "dan", "rum",
                "fad", "tut", "sag", "yip", "sui", "ark", "has", "zip", "fez", "own", "ump", "dis", "ads", "max", "jaw",
                "out", "btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy", "fat", "cal", "lie",
                "noh", "sew", "ono", "tam", "flu", "mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too", "tax", "jim",
                "san", "pan", "map", "ski", "ova", "wed", "non", "wac", "nut", "why", "bye", "lye", "oct", "old", "fin",
                "feb", "chi", "sap", "owl", "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax",
                "hip", "jib", "mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot", "tom", "sax",
                "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far", "mew", "wit", "doe", "gas", "rte", "ian", "pot",
                "ask", "wag", "hag", "amy", "nag", "ron", "soy", "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave",
                "buy", "sop", "but", "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew",
                "web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib", "rub", "ere", "dig",
                "era", "cat", "fox", "bee", "mod", "day", "apr", "vie", "nev", "jam", "pam", "new", "aye", "ani", "and",
                "ibm", "yap", "can", "pyx", "tar", "kin", "fog", "hum", "pip", "cup", "dye", "lyx", "jog", "nun", "par",
                "wan", "fey", "bus", "oak", "bad", "ats", "set", "qom", "vat", "eat", "pus", "rev", "axe", "ion", "six",
                "ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop", "may", "shy",
                "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den", "fla", "auk",
                "cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let",
                "see", "zit", "maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow",
                "cod", "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe", "bah", "hal",
                "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who", "bet", "gos", "son", "ear", "spy", "kit", "boy",
                "due", "sen", "oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit", "fix", "sad", "rib",
                "eye", "hop", "haw", "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our",
                "ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi",
                "yep", "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee", "wig", "sly", "rip", "geo",
                "cog", "pas", "zen", "odd", "nan", "lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg",
                "put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc", "moe", "caw",
                "eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid", "pun", "ton", "sol",
                "din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub", "low", "did", "tin", "get", "gte", "sox",
                "lei", "mig", "fig", "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir", "sty", "lap", "two", "ins",
                "con", "ant", "net", "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic",
                "ted", "wot", "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism", "err", "him", "all",
                "pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac", "baa", "min", "com", "ill", "was", "cab", "ago",
                "ina", "big", "ilk", "gal", "tap", "duh", "ola", "ran", "lab", "top", "gob", "hot", "ora", "tia", "kip",
                "han", "met", "hut", "she", "sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape",
                "rig", "cid", "god", "duo", "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref", "aha", "fib", "oho",
                "tho", "her", "nor", "ace", "adz", "fun", "ned", "coo", "win", "tao", "coy", "van", "man", "pit", "guy",
                "foe", "hid", "mai", "sup", "jay", "hob", "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb", "len",
                "air", "pug", "pox", "vow", "got", "meg", "zoe", "amp", "ale", "bud", "gee", "pin", "dun", "pat", "ten",
                "mob"};
        List<String> wordList = new ArrayList<>();
        for (String string : list) {
            wordList.add(string);
        }
        System.out.println(new WordLadderII().findLadders("cet", "ism", wordList));

    }
}
