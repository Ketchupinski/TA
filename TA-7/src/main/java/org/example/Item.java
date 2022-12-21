package org.example;

import java.util.Objects;

/**
 * Continuous backpack problem
 * A thief can break stolen goods into pieces and put them
 * in the backpack, and not necessarily whole things.
 * The total number of items is 14, you can divide into parts
 * only even items, the maximum sum is 468.
 * Solve this problem using the Greedy algorithm.
 */
public class Item {
    private boolean isDivisible;
    private final int value;

    private final int weight;

    public Item(boolean isDivisible, int value, int weight) {
        this.isDivisible = isDivisible;
        this.value = value;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isDivisible() {
        return isDivisible;
    }

    public int getValue() {
        return value;
    }

    public double getRatio() {
        return (double) value / weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return isDivisible == item.isDivisible && value == item.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isDivisible, value);
    }

    @Override
    public String toString() {
        return "Item{" +
                "isDivisible=" + isDivisible +
                ", value=" + value +
                ", ratio=" + getRatio() +
                '}';
    }
}
