package domain;

public class Subscriber {
    private long id;
    private String name;
    private String className;

    public Subscriber() {
    }

    public Subscriber(String name, String className) {
        this.name = name;
        this.className = className;
    }

    public Subscriber(Long id, String name, String className) {
        this.id = id;
        this.name = name;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
