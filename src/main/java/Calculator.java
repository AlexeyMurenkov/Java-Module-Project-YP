public class Calculator {

    int countPersons;
    String names = "";
    float sum;

    Calculator(int countPersons) {
        this.countPersons = countPersons;
    }

    void addGood(Good good) {
        names += good.name + "\n";
        sum += good.price;
    }

    float sumByPerson() {
        return sum / countPersons;
    }

}
