package kvo.SkiResort.Ski.SkiTypes;

import kvo.SkiResort.Ski.Ski;

public class AllMountainSkis extends Ski {
    public AllMountainSkis(double rentPrice, int length) {
        super(SkiModel.AllMountainSkis, SkiBrand.verte, rentPrice, length);
    }

    @Override
    public void damageAfterUse() {
        this.damage();

    }
}
