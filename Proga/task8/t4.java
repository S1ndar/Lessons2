package Proga.task8;

class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}

class User {
    private String email;
    private String password;
    private int age;

    public User(String email, String password, int age) {
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public void validate() {
        if (!email.contains("@")) {
            throw new ValidationException("Email должен содержать символ '@'");
        }
        if (password.length() < 6) {
            throw new ValidationException("Пароль должен быть не менее 6 символов");
        }
        if (age < 18) {
            throw new ValidationException("Возраст должен быть 18 лет или старше");
        }
        System.out.println("Пользователь валиден: " + email);
    }
}

public class t4 {
    public static void main(String[] args) {
        User[] users = {
                new User("ivan@mail.ru", "pass123", 25),
                new User("petr.mail.ru", "123456", 20),
                new User("olga@mail.ru", "123", 30),
                new User("sveta@mail.ru", "qwerty", 16)
        };

        for (User user : users) {
            try {
                user.validate();
            } catch (ValidationException e) {
                System.out.println("Ошибка валидации: " + e.getMessage());
            }
        }
    }
}
