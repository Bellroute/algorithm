package programmers.kakao.blindRecruitment2021;

import java.util.*;

public class Q3 {

    public int[] solution(String[] infos, String[] queries) {

        List<Integer> answer = new LinkedList<>();
        Tree tree = new Tree();
        for (int i = 0; i < infos.length; i++) {
            String[] splited = infos[i].split(" ");
            Person person = new Person(splited[0], splited[1], splited[2], splited[3], Integer.parseInt(splited[4]));
            tree.insert(person);
        }

        for (int i = 0; i < queries.length; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(queries[i]);

            String code = stringTokenizer.nextToken();
            stringTokenizer.nextToken();
            String field = stringTokenizer.nextToken();
            stringTokenizer.nextToken();
            String career = stringTokenizer.nextToken();
            stringTokenizer.nextToken();
            String food = stringTokenizer.nextToken();
            int score = Integer.parseInt(stringTokenizer.nextToken());

            List<Language> languages = new LinkedList<>();
            if (code.equals("-")) {
                for (Map.Entry<String, Language> entry : tree.languageList.entrySet())
                    languages.add(entry.getValue());
            } else {
                if (tree.languageList.containsKey(code)) {
                    languages.add(tree.languageList.get(code));
                }
            }

            List<Field> fields = new LinkedList<>();
            for (Language l : languages) {
                if (field.equals("-")) {
                    for (Map.Entry<String, Field> entry : l.fieldList.entrySet())
                        fields.add(entry.getValue());
                } else {
                    if (l.fieldList.containsKey(field)) {
                        fields.add(l.fieldList.get(field));
                    }
                }
            }

            List<Career> Careers = new LinkedList<>();
            for (Field f : fields) {
                if (career.equals("-")) {
                    for (Map.Entry<String, Career> entry : f.careerList.entrySet())
                        Careers.add(entry.getValue());
                } else {
                    if (f.careerList.containsKey(career)) {
                        Careers.add(f.careerList.get(career));
                    }
                }
            }

            List<Food> Foods = new LinkedList<>();
            for (Career c : Careers) {
                if (food.equals("-")) {
                    for (Map.Entry<String, Food> entry : c.foodList.entrySet())
                        Foods.add(entry.getValue());
                } else {
                    if (c.foodList.containsKey(food)) {
                        Foods.add(c.foodList.get(food));
                    }
                }
            }


            int count = 0;
            for (Food f : Foods) {
                for (Person p : f.personList) {
                    if (p.scores >= score) {
                        count++;
                    }
                }
            }

            answer.add(count);
        }

        int[] arr = new int[queries.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = answer.get(i);
        }
        return arr;
    }

    class Tree {
        private HashMap<String, Language> languageList = new HashMap();

        public void insert(Person person) {
            if (languageList.containsKey(person.code)) {
                Language code = languageList.get(person.code);
                code.insert(person);
                languageList.put(person.code, code);
            } else {
                Language language = new Language();
                language.insert(person);
                languageList.put(person.code, language);
            }
        }

    }

    class Language {
        private HashMap<String, Field> fieldList = new HashMap<>();

        public void insert(Person person) {
            if (fieldList.containsKey(person.field)) {

                Field field = fieldList.get(person.field);
                field.insert(person);
                fieldList.put(person.field, field);
            } else {
                Field field = new Field();
                field.insert(person);
                fieldList.put(person.field, field);
            }
        }

    }

    class Field {
        private HashMap<String, Career> careerList = new HashMap<>();

        public void insert(Person person) {
            if (careerList.containsKey(person.career)) {
                Career career = careerList.get(person.career);
                career.insert(person);
                careerList.put(person.career, career);
            } else {
                Career career = new Career();
                career.insert(person);
                careerList.put(person.career, career);
            }
        }
    }

    class Career {
        private HashMap<String, Food> foodList;

        public Career() {
            foodList = new HashMap<>();
        }

        public void insert(Person person) {
            if (foodList.containsKey(person.food)) {
                Food food = foodList.get(person.food);
                food.insert(person);
                foodList.put(person.food, food);
            } else {
                Food food = new Food();
                food.insert(person);
                foodList.put(person.food, food);
            }
        }

    }

    class Food {
        private List<Person> personList = new LinkedList<>();

        public void insert(Person person) {
            personList.add(person);
        }

    }

    class Person {
        private String code;
        private String field;
        private String career;
        private String food;
        private int scores;

        public Person(String code, String field, String career, String food, int scores) {
            this.code = code;
            this.field = field;
            this.career = career;
            this.food = food;
            this.scores = scores;
        }
    }
}
