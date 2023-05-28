public class Formatter {

    String getCurrency(float sum) {
        int lastToDigits = ((int) Math.floor(sum)) % 100;
        if (lastToDigits > 10 && lastToDigits < 15) {
            return "рублей";
        }
        int lastDigit = lastToDigits % 10;
        if (lastDigit == 1) {
            return "рубль";
        } else if (lastDigit > 1 && lastDigit < 5) {
            return "рубля";
        } else {
            return "рублей";
        }
    }

    String getFormattedSum(float sum) {
        return String.format("%.2f %s", sum, getCurrency(sum));
    }
}
