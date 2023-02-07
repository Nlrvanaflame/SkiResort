package kvo.SkiResort.Shoes.ShoeTypes;

import kvo.SkiResort.Shoes.Shoes;

public class Telemark extends Shoes {
    public Telemark(double rentPrice, int length) {
        super(ShoeModel.Telemark, ShoeBrands.Dynafit, rentPrice, length);
    }

    @Override
    public void damageAfterUse() {
        this.damage();
    }
}
