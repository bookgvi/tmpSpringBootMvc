package templates.factory;

import templates.factory.poligons.IPolicgon;
import templates.factory.poligons.OctagonImpl;
import templates.factory.poligons.TriangleImpl;

import java.util.Map;
import java.util.function.Function;

public class Factory {
    private final Map<Integer, IPolicgon> poligons = Map.of(
            3, new TriangleImpl(),
            8, new OctagonImpl()
    );
    private final Function<Integer, IPolicgon> poligonConsumer = poligons::get;

    public IPolicgon getPoligon(int numOfSides) {
        return poligonConsumer.apply(numOfSides);
    }

}
