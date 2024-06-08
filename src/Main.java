public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(15000);

        while (true) {
            try {
                account.withDraw(6000);
                System.out.println("Успешно вывел 6000. Оставшийся баланс: " + account.getAmount());
            } catch (LimitException e) {
                System.out.println("LimitException caught: " + e.getMessage());
                try {
                    account.withDraw((int) e.getRemainingAmount());
                    System.out.println("Успешно снята оставшаяся сумма. Баланс теперь равен нулю.");
                } catch (LimitException ex) {
                    System.out.println("Unexpected LimitException: " + ex.getMessage());
                }
                break;
            }
        }
    }
}
