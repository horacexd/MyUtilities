package MyUtilities.TimeLineTool;

import java.io.*;

public class Timeline {
    public static void main(String[] args) throws IOException {
        FileInputStream stamp = new FileInputStream("D:\\JavaPractice\\src\\ClassTest\\timestamp.txt");
        BufferedReader stampBr = new BufferedReader(new InputStreamReader(stamp));

        FileInputStream translation = new FileInputStream("D:\\JavaPractice\\src\\ClassTest\\translation.txt");
        BufferedReader transBr = new BufferedReader(new InputStreamReader(translation));

        FileOutputStream fout = new FileOutputStream("D:\\JavaPractice\\src\\ClassTest\\out.txt");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fout));

        String sLine = null;
        while ((sLine = stampBr.readLine()) != null) {
            if (isDialogue(sLine)) {
                bw.write(sLine);
                bw.write(nextLine(transBr));
                bw.newLine();
                bw.write(sLine);
                bw.write(nextLine(transBr));
                bw.newLine();
            } else {
                bw.write(sLine);
                bw.newLine();
            }
        }
        stampBr.close();
        transBr.close();
        bw.close();
    }
    private static String nextLine(BufferedReader br) throws IOException{
        String line = br.readLine();
        while (line != null && line.length() == 0) {
            line = br.readLine();
        }
        return line == null ? "" : line;
    }
    private static boolean isDialogue(String input) {
        return input.length() >= 8 && input.substring(0, 8).equals("Dialogue");
    }
}
