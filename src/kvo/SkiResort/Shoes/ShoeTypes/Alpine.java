package kvo.SkiResort.Shoes.ShoeTypes;

import kvo.SkiResort.Shoes.Shoes;

public class Alpine extends Shoes {
    public Alpine(double rentPrice, int shoeSize) {
        super(ShoeModel.Alpine, ShoeBrands.Atomic, rentPrice, shoeSize);

    }

    @Override
    public void damageAfterUse() {
        this.damage();
    }
}
