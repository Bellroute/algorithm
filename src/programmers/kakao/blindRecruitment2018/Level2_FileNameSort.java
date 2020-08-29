package programmers.kakao.blindRecruitment2018;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Level2_FileNameSort {

    @Test
    public void test() {
        assertEquals(6, solution(new String[]{"f12", "F12.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"}).length);
    }

    public String[] solution(String[] files) {
        String[] answer;

        List<File> fileList = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            String file = files[i];

            String head = separateHead(file);
            String number = separateNumber(file.substring(head.length()));
            String tail = file.substring(head.length() + number.length());

            fileList.add(new File(file, head, number, tail));
        }

        Collections.sort(fileList);
        answer = new String[fileList.size()];

        for (int i = 0; i < fileList.size(); i++) {
            answer[i] = fileList.get(i).name;
            System.out.println(answer[i]);
        }

        return answer;
    }

    private String separateNumber(String file) {
        int i;
        int count = 5;
        StringBuilder result = new StringBuilder();

        if (file.length() < 5) {
            count = file.length();
        }

        for (i = 0; i < count; i++) {
            if (!isNumber(file.charAt(i))) {
                break;
            }

            result.append(file.charAt(i));
        }

        return result.toString();
    }

    private boolean isNumber(char character) {
        return character >= 48 && character <= 57;
    }

    private String separateHead(String file) {
        int i;
        for (i = 0; i < file.length(); i++) {
            if (isNumber(file.charAt(i))) {
                break;
            }
        }

        return file.substring(0, i);
    }

    class File implements Comparable<File> {
        String name;
        String head;
        String number;
        String tail;

        public File(String name, String head, String number, String tail) {
            this.name = name;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        @Override
        public int compareTo(File o) {
            int headCompareValue = this.head.toUpperCase().compareTo(o.head.toUpperCase());

            if (headCompareValue == 0) {
                return Integer.parseInt(this.number) - Integer.parseInt(o.number);
            }

            return headCompareValue;
        }
    }
}
