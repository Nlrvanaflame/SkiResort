package kvo.SkiResort.Ski;

import kvo.SkiResort.Constants;
import kvo.SkiResort.Ski.SkiTypes.SkiBrand;
import kvo.SkiResort.Ski.SkiTypes.SkiModel;

public abstract class Ski {
    private SkiModel type;
    private SkiBrand brand;
    private double rentPrice;
    private int length;
    private boolean flag;
    private int durability;

    public Ski(SkiModel type, SkiBrand brand, double rentPrice, int length) {
        this.type = type;
        this.brand = brand;
        this.rentPrice = rentPrice;
        this.length = length;
        this.flag = false;
        this.durability = 100;
    }

    public SkiModel getType() {
        return type;
    }

    public SkiBrand getBrand() {
        return brand;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public int getLength() {
        return length;
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
