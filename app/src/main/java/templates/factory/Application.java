package templates.factory;

import templates.factory.poligons.IPolicgon;

public class Application {
    public static void main(String[] args) {
        Factory f = new Factory();
        IPolicgon poligon = f.getPoligon(3);
    }
}
