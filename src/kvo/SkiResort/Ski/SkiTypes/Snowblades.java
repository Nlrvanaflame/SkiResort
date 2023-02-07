package kvo.SkiResort.Ski.SkiTypes;

import kvo.SkiResort.Ski.Ski;

public class Snowblades extends Ski {


    public Snowblades(double rentPrice, int length) {
        super(SkiModel.Snowblades, SkiBrand.bleue, rentPrice, length);
    }

    @Override
    public void damageAfterUse() {
        this.damage();

    }
}
