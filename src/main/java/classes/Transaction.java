package classes;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

public class Transaction {
    public int id;

    @SerializedName("customer_id")
    private int customerId;

    private ZonedDateTime timestamp;

    private List<Item> items;

    private BigDecimal sum;

    public Transaction(int id, int customerId, ZonedDateTime timestamp, List<Item> items) {
        this.id = id;
        this.customerId = customerId;
        this.timestamp = timestamp;
        this.items = items;
        this.sum = calculateSum();
    }

    public int getId() {
        return id;
    }

    private BigDecimal calculateSum() {
        return items
                .stream()
                .map(item -> item.getTotalPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public int getCustomerId() {
        return customerId;
    }
}
