/*

This is a script to replace Text with links in README.md file.

Example:
"1. TwoSum" will be replaced with below string:
"1. [Leetcode](https://leetcode.com/problems/two-sum) | [TwoSum](TwoSum.java)"

It does not work vice-versa.

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ScriptReplaceLinks {

    private String fileName = "README.md";

    public static void main(String[] args) throws IOException {
        ScriptReplaceLinks lc = new ScriptReplaceLinks();

        lc.replaceTextLinks(0);
        //         System.out.println(lc.replace("4. LongestPalindromicSubstring"));
        //        System.out.println(lc.replace("1. [Leetcode](https://leetcode.com/problems/two-sum) | [TwoSum](TwoSum.java)"));
    }

    private void replaceTextLinks(int fromProbNumber) throws IOException {
        FileReader fr = new FileReader(fileName);
        String tmp;
        StringBuilder fileContent = new StringBuilder();

        try (BufferedReader br = new BufferedReader(fr)) {
            while ((tmp = br.readLine()) != null) {
                fileContent.append(tmp).append("\n");
            }

            String[] lines = fileContent.toString().split("\\n");
            for (int i = 6 + fromProbNumber; i < lines.length; i++) {
                tmp = replace(lines[i]);

                if (tmp != null) {
                    lines[i] = tmp;
                }
            }

            fileContent = new StringBuilder(String.join("\n", lines));

            System.out.println(fileContent);

            FileWriter fw = new FileWriter(fileName);
            fw.write(fileContent.toString());
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String replace(String str) throws IOException {
        String[] s1 = str.split("\\s+");
        String[] s2 = str.split("\\s+", 2);

        if (!s1[1].contains("https://")) {
            String filename = s1[1].trim() + ".java";
            String linkText = s2[1].trim();

            int lineNo = 3;
            String link = "";
            FileReader fr = new FileReader(filename);
            try (BufferedReader br = new BufferedReader(fr)) {
                while (lineNo-- > 0 && !link.startsWith("https://")) {
                    link = br.readLine();
                }

                if (link.startsWith("https://")) {
                    return String.format("%s [Leetcode](%s) | [%s](%s)", s2[0], link, linkText, filename);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

}
