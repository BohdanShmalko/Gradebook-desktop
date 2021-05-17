package bogdaxios.gradebook.desktop.exeptions;

public class NotAuthorizedUser extends Exception {
    public NotAuthorizedUser(String msg) {
        super(msg);
    }
}
