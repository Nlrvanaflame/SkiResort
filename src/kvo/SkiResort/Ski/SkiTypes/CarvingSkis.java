package kvo.SkiResort.Ski.SkiTypes;

import kvo.SkiResort.Ski.Ski;

public class CarvingSkis extends Ski {
    public CarvingSkis(double rentPrice, int length) {
        super(SkiModel.CarvingSkis, SkiBrand.rouge, rentPrice, length);
    }

    @Override
    public void damageAfterUse() {
        this.damage();
    }
}
