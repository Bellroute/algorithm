package naverwebtoon;

public class Test1 {

//    Q. 정수를 입력 받아 3자리 마다 콤마(,) 를 추가하는 함수를 작성하여라. 예 를 들어 1234가 입력되면 1,234를 반환하여야 하고 123456789가 입 력되면 123,456,789를 반환하여야 한다. 

    public static void main(String[] args) {
        System.out.println(function(1234));
        System.out.println(function(-12345));
        System.out.println(function(123456789));
        System.out.println(function(-123456789));
    }

    private static String function(int number) {
        String numberToString = String.valueOf(number);
        StringBuilder stringBuilder = new StringBuilder();

        int i = numberToString.length() - 1;
        while (i > 2) {
            stringBuilder.append(numberToString.substring(i - 2, i));
            stringBuilder.append(",");

            i -= 3;
        }

        if (i != 0) {
            stringBuilder.append(numberToString.substring(0, i));
        }

        String result = stringBuilder.reverse().toString();

        if (stringBuilder.charAt(0) == ',') {
            result = result.substring(1);
        }

        if (stringBuilder.charAt(0) == '-' && stringBuilder.charAt(1) == ',') {
            result = "-" + result.substring(2);
        }

        return result;
    }
}
