package cl.alonso.pioneerodyssey.core.slots;

import cl.alonso.pioneerodyssey.utils.enums.Category;
import cl.alonso.pioneerodyssey.utils.enums.UtilityType;

public class UtilitySlot implements Slot {
    private final Category maxCategory;
    private final UtilityType utilityType;

    public UtilitySlot(Category maxCategory, UtilityType utilityType) {
        this.maxCategory = maxCategory;
        this.utilityType = utilityType;
    }

    public Category getMaxCategory() {return maxCategory;}
    public UtilityType getUtilityType() {return utilityType;}

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Informacion de ranura:\n");
        info.append("Categoría máxima: ").append(maxCategory.getValue()).append("\n");
        return info.toString();
    }
    
}