package ForgottenValleyGame.java.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class InventoryItem {
    private String itemName;
    private int quantity;

    public void increaseQuantity(int amount ) {
        this.quantity += amount;
    }
    public void decreaseQuantity(int amount) {
        this.quantity = Math.max(0, this.quantity - amount);
    }
}