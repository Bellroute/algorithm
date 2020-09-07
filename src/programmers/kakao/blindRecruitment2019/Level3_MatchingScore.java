package programmers.kakao.blindRecruitment2019;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class Level3_MatchingScore {

    @Test
    public void test() {
        assertEquals(0, solution("blind", new String[] {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"}));
        assertEquals(1, solution("Muzi", new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"}));
    }

    public int solution(String word, String[] pages) {
        List<WebPage> webPageList = new ArrayList<>();
        Map<String, Double> linkScoreHashMap = new HashMap<>();

        for (int i = 0; i < pages.length; i++) {
            String html = pages[i];
            String url = crawlUrl(html.toLowerCase());
            List<String> outerLinks = crawlOuterLinks(html.toLowerCase());
            int basicScore = getBasicScore(word, html.toLowerCase());

            webPageList.add(new WebPage(i, url, outerLinks, basicScore));
            linkScoreHashMap.put(url, 0.0);
        }

        for (WebPage webPage : webPageList) {
            List<String> outerLinks = webPage.outerLinks;

            for (String outerLink : outerLinks) {
                linkScoreHashMap.put(outerLink, linkScoreHashMap.getOrDefault(outerLink, 0.0) + ((double) webPage.basicScore / webPage.outerLinks.size()));
            }
        }

        for (WebPage webPage : webPageList) {
            webPage.linkScore = linkScoreHashMap.get(webPage.url);
        }

        Collections.sort(webPageList);
        int answer = webPageList.get(0).index;

        return answer;
    }

    class WebPage implements Comparable<WebPage> {
        private int index;
        private String url;
        private List<String> outerLinks;
        private int basicScore;
        private double linkScore = 0;

        public WebPage(int index, String url, List<String> outerLinks, int basicScore) {
            this.index = index;
            this.url = url;
            this.outerLinks = outerLinks;
            this.basicScore = basicScore;
        }

        @Override
        public int compareTo(WebPage o) {
            return Double.compare(o.basicScore + o.linkScore, this.basicScore + this.linkScore);
        }
    }

    public String crawlUrl(String html) {
        String meta = "<meta property=\"og:url\" content=\"";
        int startIndex = html.indexOf(meta) + meta.length();

        return html.substring(startIndex, html.indexOf("\"", startIndex));
    }

    public List<String> crawlOuterLinks(String html) {
        String meta = "<a href=\"";
        List<String> result = new ArrayList<>();

        while (html.contains(meta)) {
            int start = html.indexOf(meta) + meta.length();
            int end = html.indexOf("\"", start);

            result.add(html.substring(start, end));
            html = html.substring(end);
        }

        return result;
    }

    public int getBasicScore(String searchingWord, String html) {
        int count = 0;
        String body = html.substring(html.indexOf("<body>"), html.indexOf("</body>"));

        LinkedList<String> words = splitWords(body);

        for (String word : words) {
            if (word.equals(searchingWord.toLowerCase())) {
                count++;
            }
        }

        return count;
    }

    private LinkedList<String> splitWords(String body) {
        LinkedList<String> words = new LinkedList<>();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < body.length(); i++) {
            char character = body.charAt(i);

            if ((character >= 97 && character <= 122) || (character >= 65 && character <= 90)) {
                stringBuilder.append(character);
                continue;
            }

            words.add(stringBuilder.toString().toLowerCase());
            stringBuilder.delete(0, stringBuilder.length());
        }

        return words;
    }
}
