package models.charackter;

import enums.Item;
import enums.Mood;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Character {
    protected String name;
    protected List<Mood> mood;
    protected Boolean isBalanceOk;

    protected List<Item> items;

    public String getName() {
        return name;
    }

    public List<Mood> getMoods() {
        return mood;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setBalance(Boolean value) {
        this.isBalanceOk = value;
    }

    private Character(Builder builder) {
        this.name = builder.name;
        this.mood = builder.moods;
        this.isBalanceOk = builder.isBalanceOk;
        this.items = builder.items;
    }

    public static class Builder {
        private String name;
        private List<Mood> moods;
        private Boolean isBalanceOk = true;
        private List<Item> items = Collections.emptyList();

        public Builder() {
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setMoods(Mood... moods) {
            this.moods = Arrays.asList(moods);
            return this;
        }

        public Builder setIsBalanceOk(Boolean isBalanceOk) {
            this.isBalanceOk = isBalanceOk;
            return this;
        }

        public Builder setItems(List<Item> items) {
            this.items = items;
            return this;
        }

        public Character build() {
            return new Character(this);
        }
    }

}
