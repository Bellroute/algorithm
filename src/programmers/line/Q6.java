package programmers.line;

import java.util.*;

public class Q6 {

    public String[] solution(String[] companies, String[] applicants) {
        Map<String, Company> companyMap = new HashMap<>();
        Map<String, Applicant> applicantMap = new HashMap<>();

        for (String company : companies) {
            StringTokenizer token = new StringTokenizer(company);
            companyMap.put(token.nextToken(), new Company(token.nextToken(), Integer.parseInt(token.nextToken())));
        }

        for (String applicant : applicants) {
            StringTokenizer token = new StringTokenizer(applicant);
            applicantMap.put(token.nextToken(), new Applicant(token.nextToken(), Integer.parseInt(token.nextToken())));
        }

        Map<String, List<String>> listMap = new HashMap<>();

        for (String key : applicantMap.keySet()) {
            Applicant applicant = applicantMap.get(key);

            String company = Character.toString(applicant.prefer.charAt(applicant.tries));

            List<String> list;

            if (listMap.containsKey(company)) {
                list = listMap.get(company);
            } else {
                list = new ArrayList<>();
            }

            list.add(key);
            listMap.put(company, list);

            applicant.tries++;
        }

        while (!isFinished(companyMap)) {
            List<String> rejectedApplicants = new LinkedList<>();

            for (String key : companyMap.keySet()) {
                Company company = companyMap.get(key);

                if (company.isEnd) {
                    continue;
                }

                List<String> applymentList = listMap.get(company);
                List<String> passList = new ArrayList<>();

                for (int i = 0; i < company.prefer.length(); i++) {
                    String prior = Character.toString(company.prefer.charAt(i));

                    if (applymentList.contains(prior)) {
                        passList.add(prior);
                    }

                    if (applymentList.size() == company.count) {
                        company.isEnd = true;
                        break;
                    }
                }

                applymentList.removeAll(passList);
                rejectedApplicants.addAll(applymentList);
                listMap.put(key, passList);
            }

            for (String rejectedApplicant :  rejectedApplicants) {
                Applicant applicant = applicantMap.get(rejectedApplicant);

                if (applicant.tries == applicant.count) {
                    continue;
                }

                String company = Character.toString(applicant.prefer.charAt(applicant.tries));

                List<String> list;

                if (listMap.containsKey(company)) {
                    list = listMap.get(company);
                } else {
                    list = new ArrayList<>();
                }

                list.add(rejectedApplicant);
                listMap.put(company, list);

                applicant.tries++;
            }
        }

        String[] answer = new String[companies.length];

        int i = 0;
        for (String key : companyMap.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(key);
            sb.append('_');

            List<String> list = listMap.get(key);
            if (list != null) {
                for (String s : list) {
                    sb.append(s);
                }
            }

            answer[i] = sb.toString();
            i++;
        }

        return answer;
    }

    private boolean isFinished(Map<String, Company> companies) {
        return companies.values().stream().anyMatch(company -> !company.isEnd);
    }

    class Applicant {
        private String prefer;
        private int tries;
        private int count;

        public Applicant(String prefer, int count) {
            this.prefer = prefer;
            this.count = count;
            this.tries = 0;
        }
    }

    class Company {
        private String prefer;
        private int count;
        private boolean isEnd;

        public Company(String prefer, int count) {
            this.prefer = prefer;
            this.count = count;
            this.isEnd = false;
        }
    }
}
