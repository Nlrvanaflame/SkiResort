package kvo.SkiResort.Shoes.ShoeTypes;

import kvo.SkiResort.Shoes.Shoes;

public class CrossCountry extends Shoes {
    public CrossCountry(double rentPrice, int shoeSize) {
        super(ShoeModel.CrossCountry, ShoeBrands.Nordica, rentPrice, shoeSize);
    }

    @Override
    public void damageAfterUse() {
        this.damage();
    }
}
