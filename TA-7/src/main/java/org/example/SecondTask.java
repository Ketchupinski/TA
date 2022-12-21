package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Continuous backpack problem
 * A thief can break stolen goods into pieces and put them
 * in the backpack, and not necessarily whole things.
 * The total number of items is 14, you can divide into parts
 * only even items, the maximum sum is 468.
 * Solve this problem using the Greedy algorithm.
 */
public class SecondTask {
    private int maxSum = 468;
    private int maxWeight = 14;
    private int totalSum = 0;

    private List<Item> items;

    public void generateItems() {
        items = List.of(
                new Item(false, 20, 1),
                new Item(true, 40, 2),
                new Item(false, 37, 3),
                new Item(true, 32, 2),
                new Item(false, 21, 3),
                new Item(true, 90, 4),
                new Item(false, 53, 3),
                new Item(true, 27, 3),
                new Item(false, 17, 2),
                new Item(true, 24, 6),
                new Item(false, 45, 5),
                new Item(true, 35, 5),
                new Item(false, 25, 4),
                new Item(true, 15, 3),
                new Item(false, 78, 5),
                new Item(true, 44, 4),
                new Item(false, 33, 3),
                new Item(true, 22, 2),
                new Item(false, 11, 1),
                new Item(true, 100, 2),
                new Item(false, 55, 3),
                new Item(true, 150, 3),
                new Item(false, 66, 4),
                new Item(true, 100, 3),
                new Item(false, 77, 5),
                new Item(true, 88, 4)
        );
        items = new ArrayList<>(items);
    }

    /**
     * Problem solution using the Greedy algorithm.
     * Algorithm:
     * 1. Sort items by ratio (value / weight).
     * 2. Add items to the backpack until the total weight is less than the maximum weight and sum is less than the maximum sum.
     * 3. If the total weight is greater than the maximum weight, then divide the last item into parts
     * 4. If the total weight is less than the maximum weight, then add the last item to the backpack
     *
     * @return sum of items in the backpack
     */
    public int solve() {
        System.out.println("Items to stole: ");
        for (Item item : items) {
            System.out.println(item);
        }
        items.sort(Comparator.comparingDouble(Item::getRatio).reversed());
        int totalWeight = 0;
        for (Item item : items) {
            if (totalWeight + item.getWeight() <= maxWeight && totalSum + item.getValue() <= maxSum) {
                totalWeight += item.getWeight();
                System.out.println("Add item: " + item + " to backpack " + "total weight: " + totalWeight);
                totalSum += item.getValue();
            } else if (item.isDivisible()) {
                int weight = item.getWeight();
                int value = item.getValue();
                while (totalWeight + weight <= maxWeight && totalSum + value <= maxSum) {
                    totalWeight += weight;
                    totalSum += value;
                    System.out.println("Add item: " + item + " to backpack " + "total weight: " + totalWeight);
                }
            }
        }
        return totalSum;
    }
}
