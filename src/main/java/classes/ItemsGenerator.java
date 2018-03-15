package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ItemsGenerator {
    private final IntegerGenerator itemCountGenerator;
    private final IntegerGenerator itemQuantityGenerator;
    private final ArrayList<Product> products;

    public ItemsGenerator(IntegerGenerator itemCountGenerator, IntegerGenerator itemQuantityGenerator, ArrayList<Product> products) {
        this.itemCountGenerator = itemCountGenerator;
        this.itemQuantityGenerator = itemQuantityGenerator;
        this.products = products;
    }

    public List<Item> generate() {
        return IntStream.range(0, itemCountGenerator.generate())
                .mapToObj(i -> new Item(
                        products.get(i % products.size()).getName(),
                        itemQuantityGenerator.generate(),
                        products.get(i % products.size()).getPrice()
                )).collect(Collectors.toCollection(ArrayList::new));
    }
}
