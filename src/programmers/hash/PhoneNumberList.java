package programmers.hash;

import java.util.*;

public class PhoneNumberList {

    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        for (String phoneNumber:phone_book) {
            for (int i = 0; i < phoneNumber.length(); i++) {
                if (set.contains(phoneNumber.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }

}
