public class Main {
    public static void main(String[] args) {
        Record r1 = new Record(1, "1", "a");
        Record r2 = new Record(2, "2", "b");

        // Некорректно заполнены
        Record r3 = new Record(1, "", "123");
        Record r33 = new Record(1, "123", null);

        Record r4 = new Record(4, "4", "d");
        PhoneBook phoneBook = new PhoneBook();

        // Добавляем 2 записи
        phoneBook.createRecord(r1);
        phoneBook.createRecord(r2);
        System.out.println("2 если добавилось верно: " + phoneBook.getAllRecords().size());

        // Проверка 1 функции, исключение существующего номера
        System.out.println("PhoneNumberAlreadyExists исключение, если верно: ");
        phoneBook.createRecord(r1); // PhoneNumberAlreadyExists

        // Проверка 2 функции, исключение ненайденной записи, незаполненной записи
        System.out.println("x2 RecordNotValid, x1 RecordNotFound, если верно:");
        phoneBook.updateRecord(r3); // RecordNotValid
        phoneBook.updateRecord(r33); // RecordNotValid
        phoneBook.updateRecord(r4); // RecordNotFound
        phoneBook.updateRecord(new Record(1, "11", "aa" ));
        System.out.println("11 если изменилась первая запись: "
                +phoneBook.getAllRecords().get(0).phoneNumber);

        phoneBook.deleteRecord(1);
        System.out.println("1 если первая запись удалилась: " + phoneBook.getAllRecords().size());
        System.out.println("x1 RecordNotFound, если верно:");
        phoneBook.deleteRecord(3); // RecordNotFound
    }
}