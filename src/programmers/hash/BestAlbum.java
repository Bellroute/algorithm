package programmers.hash;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class BestAlbum {

    private String[] genresArray;
    private int[] playsArray;

    @Test
    public void test() {
        assertEquals(4, solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})[0]);
        assertEquals(1, solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})[1]);
        assertEquals(3, solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})[2]);
        assertEquals(0, solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})[3]);
    }

    public int[] solution(String[] genres, int[] plays) {
        genresArray = genres;
        playsArray = plays;

        Map<String, List<Album>> hashMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (hashMap.containsKey(genres[i])) {
                List<Album> list = hashMap.get(genres[i]);
                list.add(new Album(i, plays[i]));

                hashMap.put(genres[i], list);
            } else {
                List<Album> list = new ArrayList<>();
                list.add(new Album(i, plays[i]));

                hashMap.put(genres[i], list);
            }
        }

        List<Map.Entry<String, List<Album>>> entryList = sort(hashMap);
        List<Integer> result = new ArrayList<>();

        for (Map.Entry<String, List<Album>> entry : entryList) {
            List<Album> list = entry.getValue();
            Collections.sort(list);

            if (list.size() == 0) {
                continue;
            }

            result.add(list.get(0).getNo());

            if (list.size() >= 2) {
                result.add(list.get(1).getNo());
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    private List<Map.Entry<String, List<Album>>> sort(Map<String, List<Album>> hashMap) {
        List<Map.Entry<String, List<Album>>> entryList = new ArrayList<>(hashMap.entrySet());

        entryList.sort(new Comparator<Map.Entry<String, List<Album>>>() {
            @Override
            public int compare(Map.Entry<String, List<Album>> o1, Map.Entry<String, List<Album>> o2) {
                int genrePlays1 = calculatePlaysOfGenre(o1.getValue());
                int genrePlays2 = calculatePlaysOfGenre(o2.getValue());

                return genrePlays2 - genrePlays1;
            }

            private int calculatePlaysOfGenre(List<Album> list) {
                int count = 0;

                for (Album album : list) {
                    count += album.getPlay();
                }

                return count;
            }
        });

        return entryList;
    }
}

class Album implements Comparable<Album> {
    private int no;
    private int play;

    public Album(int no, int play) {
        this.no = no;
        this.play = play;
    }

    public int getNo() {
        return no;
    }

    public int getPlay() {
        return play;
    }
    @Override
    public int compareTo(Album o) {
        return o.play - this.play;
    }
}
