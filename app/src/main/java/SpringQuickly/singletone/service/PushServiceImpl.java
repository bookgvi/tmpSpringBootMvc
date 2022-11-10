package SpringQuickly.singletone.service;


import org.springframework.stereotype.Component;

@Component("pushServiceSingletoneScope1")
public class PushServiceImpl implements IService {
    public static IService INSTANCE = getINSTANCE();
    private String chf = "QQQ";

    public  PushServiceImpl() {}

    private static IService getINSTANCE() {
        IService instance = null;
        if (INSTANCE == null) {
            synchronized (PushServiceImpl.class) {
                if (INSTANCE == null) {
                    instance = new PushServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public void send(String text) {
        System.out.printf("\"%s\" has been pushed\n", text);
    }

    public String getChf() {
        return chf;
    }

    public void setChf(String chf) {
        this.chf = chf;
    }
}
