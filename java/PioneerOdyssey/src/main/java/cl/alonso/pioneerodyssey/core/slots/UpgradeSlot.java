package cl.alonso.pioneerodyssey.core.slots;

import cl.alonso.pioneerodyssey.utils.enums.Category;
import cl.alonso.pioneerodyssey.utils.enums.UpgradeType;

public class UpgradeSlot implements Slot {
    private final Category maxCategory;
    private final UpgradeType upgradeType;

    public UpgradeSlot(Category maxCategory, UpgradeType upgradeType) {
        this.maxCategory = maxCategory;
        this.upgradeType = upgradeType;
    }

    public Category getMaxCategory() {return maxCategory;}
    public UpgradeType getUpgradeType() {return upgradeType;}

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Informacion de ranura:\n");
        info.append("Categoría máxima: ").append(maxCategory.getValue()).append("\n");
        return info.toString();
    }
    
}