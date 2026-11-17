package cl.alonso.pioneerodyssey.core.modules;

import cl.alonso.pioneerodyssey.utils.enums.Category;
import cl.alonso.pioneerodyssey.utils.enums.Tier;
import cl.alonso.pioneerodyssey.utils.enums.UtilityType;

public class Utility implements Module {
    private final String name;
    private final UtilityType utilityType;
    private final String description;
    private final Tier tier;
    private final Category category;

    public Utility(
        String name,
        UtilityType utilityType,
        String description,
        Tier tier, 
        Category category
    ) {
        int nameLimit = 25;
        if (name.length() > nameLimit) {
            System.out.println("!---ADVERTENCIA: "+name+" Es demasiado largo para el nombre, sera acortado a "+nameLimit+" caracteres.");
            name = name.substring(0, nameLimit);
        }
        this.name = name;

        this.utilityType = utilityType;

        int descriptionLimit = 100;
        if (description.length() > descriptionLimit) {
            System.out.println("!---ADVERTENCIA: "+description+" Es demasiado largo para la descripcion, sera acortado a "+descriptionLimit+" caracteres.");
            description = description.substring(0, descriptionLimit);
        }
        this.description = description;

        this.tier = tier;
        this.category = category;
    }

    public String getName() {return name;}
    public UtilityType getUtilityType() {return utilityType;}
    public String getDescription() {return description;}
    public Tier getTier() {return tier;}
    public Category getCategory() {return category;}

    @Override
    public String getInfo() {return null;}

    public void applyEffects() {}

}
