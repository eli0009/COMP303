package code;

public class Factory {
    public static void main(String[] args) {
        Payment student_pay = Payment.createPaymentWithStudentID(123456, "John");
        Payment credit_card_pay = Payment.createPaymentWithCreditCard(123456789, "John");
    }
}

class Payment {
    int id;
    String name;

    private Payment(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Payment createPaymentWithStudentID(int id, String name) {
        return new Payment(id, name);
    }

    public static Payment createPaymentWithCreditCard(int card_number, String name) {
        return new Payment(card_number, name);
    }
}