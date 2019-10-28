package ui;

import model.MustHaveList;
import model.items.Item;

public class PersonalSettings {
    protected double budget;
    protected MustHaveList listMustHaves;

    public PersonalSettings() {
        this.budget = 0;
        this.listMustHaves = new MustHaveList();
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void addMustHaves(String item) {
        listMustHaves.addItemToMHList(item);
    }
}
