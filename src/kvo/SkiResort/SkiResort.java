package kvo.SkiResort;

import kvo.SkiResort.Shoes.ShoeTypes.*;
import kvo.SkiResort.Shoes.Shoes;
import kvo.SkiResort.Ski.Ski;
import kvo.SkiResort.Ski.SkiTypes.*;

import java.util.ArrayList;
import java.util.HashMap;

public class SkiResort {
    private HashMap<SkiModel, ArrayList<Ski>> skiMap = new HashMap<>();
    private HashMap<ShoeModel, ArrayList<Shoes>> shoeMap = new HashMap<>();


    public SkiResort() {

        populate();
    }


    private void populate() {


        for (ShoeModel model : ShoeModel.values()) {
            shoeMap.put(model, new ArrayList<>());
        }
        for (int i = 0; i < 20; i++) {
            shoeMap.get(ShoeModel.Alpine).add(new Alpine(12, 35 + i / 2));
            shoeMap.get(ShoeModel.CrossCountry).add(new CrossCountry(12, 35 + i / 2));
            shoeMap.get(ShoeModel.Telemark).add(new Telemark(12, 35 + i / 2));
        }


        for (SkiModel model : SkiModel.values()) {
            skiMap.put(model, new ArrayList<>());

        }
        for (int i = 0; i < 5; i++) {
            skiMap.get(SkiModel.Snowblades).add(new Snowblades(15, 130 + 15 * i));
            skiMap.get(SkiModel.AllMountainSkis).add(new AllMountainSkis(15, 130 + 15 * i));
            skiMap.get(SkiModel.CarvingSkis).add(new CarvingSkis(15, 130 + 15 * i));
        }
    }

    public void printAllShoesAndSkis() {
        System.out.println("List of all shoes: ");
        System.out.println(" ");
        for (ShoeModel model : ShoeModel.values()) {
            ArrayList<Shoes> shoeArray = shoeMap.get(model);
            System.out.println(model);
            StringBuilder brands = new StringBuilder("Brands for each model are:");
            StringBuilder rentPrices = new StringBuilder("Available prices:");
            StringBuilder shoeSizes = new StringBuilder("Available sizes:");

            for (Shoes shoe : shoeArray) {
                brands.append(" ").append(shoe.getBrand());
                shoeSizes.append(" ").append(shoe.getShoeSize());
                rentPrices.append(" ").append(shoe.getRentPrice());
            }
            System.out.println(brands);
            System.out.println(shoeSizes);
            System.out.println(rentPrices);
            System.out.println();
        }

        System.out.println(" ");

        System.out.println("List of all skis: ");
        System.out.println(" ");

        for (SkiModel model : SkiModel.values()) {
            ArrayList<Ski> skiArray = skiMap.get(model);
            System.out.println(model);

            StringBuilder brands = new StringBuilder("Brands for each model are:");
            StringBuilder rentPrices = new StringBuilder("Available prices:");
            StringBuilder lengths = new StringBuilder("Available lengths:");
            for (Ski ski : skiArray) {
                brands.append(" ").append(ski.getBrand());
                lengths.append(" ").append(ski.getLength());
                rentPrices.append(" ").append(ski.getRentPrice());
            }
            System.out.println(brands);
            System.out.println(lengths);
            System.out.println(rentPrices);
            System.out.println();

        }


    }


    public Ski rentSki(SkiModel model, SkiBrand brand, int length) {
        for (Ski ski : skiMap.get(model)) {
            if (ski.getType().equals(model) && ski.getBrand().equals(brand) && ski.getLength() == length && ski.isAvailable()) {

                ski.setFlag(true);
                System.out.println("ski of type " + model + " and length " + length + " were rented.");
                return ski;

            }
        }
        System.out.println("These are already rented!");
        return null;
    }

    public Ski releaseSki(SkiModel model, SkiBrand brand, int length) {
        for (Ski ski : skiMap.get(model)) {
            if (ski.getType().equals(model) && ski.getBrand().equals(brand) && ski.getLength() == length && ski.isFlag()) {

                ski.setFlag(false);
                System.out.println("ski of type " + model + " and length " + length + " were released.");
                ski.damageAfterUse();
                return ski;

            }
        }
        System.out.println("These are already released!");
        return null;
    }

    public Shoes rentShoes(ShoeModel model, ShoeBrands brand, int shoeSize) {
        for (Shoes pair : shoeMap.get(model)) {
            if (pair.getType().equals(model) && pair.getBrand().equals(brand) && pair.getShoeSize() == shoeSize && pair.isAvailable()) {

                pair.setFlag(true);
                System.out.println("boots of type " + model + " and shoe size " + shoeSize + " were rented.");
                return pair;
            }
        }
        System.out.println("These are already rented!");
        return null;
    }

    public Shoes releaseShoes(ShoeModel model, ShoeBrands brand, int shoeSize) {
        for (Shoes pair : shoeMap.get(model)) {
            if (pair.getType().equals(model) && pair.getBrand().equals(brand) && pair.getShoeSize() == shoeSize && pair.isFlag()) {

                pair.setFlag(false);
                System.out.println("boots of type " + model + " and shoe size " + shoeSize + " were released.");
                return pair;

            }
        }
        System.out.println("These are already released!");
        return null;
    }

    public boolean rentSkisAndShoes(SkiModel skiModel, SkiBrand skiBrand, int length, ShoeModel shoeModel, ShoeBrands shoeBrand, int shoeSize) {
        Ski skiToBeRented = rentSki(skiModel, skiBrand, length);
        Shoes shoesToBeRented = rentShoes(shoeModel, shoeBrand, shoeSize);
        if (skiToBeRented != null && shoesToBeRented != null)
            return true;
        else {

            if (skiToBeRented != null)
                skiToBeRented.setFlag(false);

            if (shoesToBeRented != null)
                shoesToBeRented.setFlag(false);

            return false;
        }
    }
}
