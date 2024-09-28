package ForgottenValleyGame.java.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class Character {
    protected String name;
    protected int health;
   protected int magic;
   protected int level;



    public abstract void displayStats();
}





