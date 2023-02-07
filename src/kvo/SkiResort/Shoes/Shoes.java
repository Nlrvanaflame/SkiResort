package kvo.SkiResort.Shoes;

import kvo.SkiResort.Constants;
import kvo.SkiResort.Shoes.ShoeTypes.ShoeBrands;
import kvo.SkiResort.Shoes.ShoeTypes.ShoeModel;

public abstract class Shoes {
    private ShoeModel type;
    private ShoeBrands brand;
    private double rentPrice;
    private int shoeSize;
    private boolean flag;
    private int durability;

    public Shoes(ShoeModel type, ShoeBrands brand, double rentPrice, int shoeSize) {
        this.type = type;
        this.brand = brand;
        this.rentPrice = rentPrice;
        this.shoeSize = shoeSize;
        this.flag = false;
        this.durability = 100;
    }

    public ShoeModel getType() {
        return type;
    }

    public ShoeBrands getBrand() {
        return brand;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public int getShoeSize() {
        return shoeSize;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getDurability() {
        return durability;
    }

    public boolean isAvailable() {
        return !isFlag() && getDurability() >= Constants.MIN_DURABILITY;
    }

    protected void damage() {
        this.durability -= Constants.DURABILITY_LOSE_AFTER_USE;
    }

    protected void damage(int damage) {
        this.durability -= damage;
    }

    public abstract void damageAfterUse();
}
