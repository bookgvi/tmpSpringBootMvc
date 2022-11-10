package SpringQuickly.singletone.service;

public class MailServiceImpl implements IService {
    public static IService INSTANCE = getInstance();

    private MailServiceImpl() {
    }

    private static IService getInstance() {
        IService instance = null;
        if (INSTANCE == null) {
            synchronized (MailServiceImpl.class) {
                if (INSTANCE == null) {
                    instance = new MailServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public void send(String text) {
        System.out.printf("\"%s\" has been sent by e-mail\n", text);
    }
}
