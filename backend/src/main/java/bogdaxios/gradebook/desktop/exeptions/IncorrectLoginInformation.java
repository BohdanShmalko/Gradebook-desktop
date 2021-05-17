package bogdaxios.gradebook.desktop.exeptions;

public class IncorrectLoginInformation extends Exception {
    public IncorrectLoginInformation() {
        super("Incorrect login or password");
    }
}
