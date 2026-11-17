package cl.alonso.pioneerodyssey.core.modules;

import cl.alonso.pioneerodyssey.utils.enums.Category;
import cl.alonso.pioneerodyssey.utils.enums.Tier;
import cl.alonso.pioneerodyssey.utils.enums.UpgradeType;

public class Upgrade implements Module {
    private final String name;
    private final UpgradeType upgradeType;
    private final String description;
    private final Tier tier;
    private final Category category;

    private final int integrityUpdate;
    private final int speedUpdate;
    private final int accelerationUpdate;
    private final int energyRegenerationUpdate;
    private final int maxEnergyUpdate;
    private final int kineticArmorUpdate;
    private final int energyArmorUpdate;
    private final int thermalArmorUpdate;
    private final int explosiveArmorUpdate;

    private final int speedPenalty;
    private final int accelerationPenalty;
    private final int energyRegenerationPenalty;
    private final int maxEnergyPenalty;
    private final int kineticArmorPenalty;
    private final int energyArmorPenalty;
    private final int thermalArmorPenalty;
    private final int explosiveArmorPenalty;

    public Upgrade(
        String name,
        UpgradeType upgradeType,
        String description,
        Tier tier, 
        Category category,
        int integrityUpdate,
        int speedUpdate,
        int accelerationUpdate,
        int energyRegenerationUpdate,
        int maxEnergyUpdate,
        int kineticArmorUpdate,
        int energyArmorUpdate,
        int thermalArmorUpdate,
        int explosiveArmorUpdate,

        int speedPenalty,
        int accelerationPenalty,
        int energyRegenerationPenalty,
        int maxEnergyPenalty,
        int kineticArmorPenalty,
        int energyArmorPenalty,
        int thermalArmorPenalty,
        int explosiveArmorPenalty
    ) {
        int nameLimit = 25;
        if (name.length() > nameLimit) {
            System.out.println("!---ADVERTENCIA: "+name+" Es demasiado largo para el nombre, sera acortado a "+nameLimit+" caracteres.");
            name = name.substring(0, nameLimit);
        }
        this.name = name;

        this.upgradeType = upgradeType;

        int descriptionLimit = 100;
        if (description.length() > descriptionLimit) {
            System.out.println("!---ADVERTENCIA: "+description+" Es demasiado largo para la descripcion, sera acortado a "+descriptionLimit+" caracteres.");
            description = description.substring(0, descriptionLimit);
        }
        this.description = description;

        this.tier = tier;
        this.category = category;

        this.integrityUpdate = integrityUpdate;
        this.speedUpdate = speedUpdate;
        this.accelerationUpdate = accelerationUpdate;
        this.energyRegenerationUpdate = energyRegenerationUpdate;
        this.maxEnergyUpdate = maxEnergyUpdate;
        this.kineticArmorUpdate = kineticArmorUpdate;
        this.energyArmorUpdate = energyArmorUpdate;
        this.thermalArmorUpdate = thermalArmorUpdate;
        this.explosiveArmorUpdate = explosiveArmorUpdate;

        this.speedPenalty = speedPenalty;
        this.accelerationPenalty = accelerationPenalty;
        this.energyRegenerationPenalty = energyRegenerationPenalty;
        this.maxEnergyPenalty = maxEnergyPenalty;
        this.kineticArmorPenalty = kineticArmorPenalty;
        this.energyArmorPenalty = energyArmorPenalty;
        this.thermalArmorPenalty = thermalArmorPenalty;
        this.explosiveArmorPenalty = explosiveArmorPenalty;
    }

    public String getName() {return name;}
    public UpgradeType getUpgradeType() {return upgradeType;}
    public String getDescription() {return description;}
    public Tier getTier() {return tier;}
    public Category getCategory() {return category;}

    public int getIntegrityUpdate() {return integrityUpdate;}
    public int getSpeedUpdate() {return speedUpdate;}
    public int getAccelerationUpdate() {return accelerationUpdate;}
    public int getEnergyRegenerationUpdate() {return energyRegenerationUpdate;}
    public int getMaxEnergyUpdate() {return maxEnergyUpdate;}
    public int getKineticArmorUpdate() {return kineticArmorUpdate;}
    public int getEnergyArmorUpdate() {return energyArmorUpdate;}
    public int getThermalArmorUpdate() {return thermalArmorUpdate;}
    public int getExplosiveArmorUpdate() {return explosiveArmorUpdate;}

    public int getSpeedPenalty() {return speedPenalty;}
    public int getAccelerationPenalty() {return accelerationPenalty;}
    public int getEnergyRegenerationPenalty() {return energyRegenerationPenalty;}
    public int getMaxEnergyPenalty() {return maxEnergyPenalty;}
    public int getKineticArmorPenalty() {return kineticArmorPenalty;}
    public int getEnergyArmorPenalty() {return energyArmorPenalty;}
    public int getThermalArmorPenalty() {return thermalArmorPenalty;}
    public int getExplosiveArmorPenalty() {return explosiveArmorPenalty;}

    @Override
    public String getInfo() {return null;}

    public void applyEffects() {}

}
