package cl.alonso.pioneerodyssey.core.modules;

import cl.alonso.pioneerodyssey.utils.enums.Category;
import cl.alonso.pioneerodyssey.utils.enums.Tier;
import cl.alonso.pioneerodyssey.utils.enums.WeaponType;

public class Weapon implements Module {
    private final String name;
    private final WeaponType weaponType;
    private final String description;
    private final Tier tier;
    private final Category category;

    private final int accuracy;
    private final int reloadTime;
    private int currentReload;
    private final int energyConsumption;

    private final int kineticPenetration;
    private final int maxKineticDamage;
    private final int minKineticDamage;

    private final int energyPenetration;
    private final int maxEnergyDamage;
    private final int minEnergyDamage;

    private final int thermalPenetration;
    private final int maxThermalDamage;
    private final int minThermalDamage;

    private final int explosivePenetration;
    private final int maxExplosiveDamage;
    private final int minExplosiveDamage;

    public Weapon(
        String name,
        WeaponType weaponType,
        String description,
        Tier tier, 
        Category category,

        int accuracy, 
        int reloadTime, 
        int energyConsumption,

        int kineticPenetration,
        int maxKineticDamage,
        double minKineticDamageFactor,

        int energyPenetration,
        int maxEnergyDamage,
        double minEnergyDamageFactor,

        int thermalPenetration,
        int maxThermalDamage,
        double minThermalDamageFactor,

        int explosivePenetration,
        int maxExplosiveDamage,
        double minExplosiveDamageFactor
    ) 
    {
        int nameLimit = 25;
        if (name.length() > nameLimit) {
            System.out.println("!---ADVERTENCIA: "+name+" Es demasiado largo para el nombre, sera acortado a "+nameLimit+" caracteres.");
            name = name.substring(0, nameLimit);
        }
        this.name = name;

        this.weaponType = weaponType;

        int descriptionLimit = 100;
        if (description.length() > descriptionLimit) {
            System.out.println("!---ADVERTENCIA: "+description+" Es demasiado largo para la descripcion, sera acortado a "+descriptionLimit+" caracteres.");
            description = description.substring(0, descriptionLimit);
        }
        this.description = description;
        
        this.tier = tier;
        this.category = category;

        this.accuracy = accuracy;
        this.reloadTime = reloadTime;
        this.currentReload = 0;
        this.energyConsumption = energyConsumption;

        this.kineticPenetration = kineticPenetration;
        this.maxKineticDamage = maxKineticDamage;
        if (minKineticDamageFactor > 1.0) {minKineticDamageFactor = 1.0;} else if (minKineticDamageFactor < 0) {minKineticDamageFactor = 0;}
        this.minKineticDamage = (int) Math.round(maxKineticDamage * minKineticDamageFactor);

        this.energyPenetration = energyPenetration;
        this.maxEnergyDamage = maxEnergyDamage;
        if (minEnergyDamageFactor > 1.0) {minEnergyDamageFactor = 1.0;} else if (minEnergyDamageFactor < 0) {minEnergyDamageFactor = 0;}
        this.minEnergyDamage = (int) Math.round(maxEnergyDamage * minEnergyDamageFactor);

        this.thermalPenetration = thermalPenetration;
        this.maxThermalDamage = maxThermalDamage;
        if (minThermalDamageFactor > 1.0) {minThermalDamageFactor = 1.0;} else if (minThermalDamageFactor < 0) {minThermalDamageFactor = 0;}
        this.minThermalDamage = (int) Math.round(maxThermalDamage * minThermalDamageFactor);

        this.explosivePenetration = explosivePenetration;
        this.maxExplosiveDamage = maxExplosiveDamage;
        if (minExplosiveDamageFactor > 1.0) {minExplosiveDamageFactor = 1.0;} else if (minExplosiveDamageFactor < 0) {minExplosiveDamageFactor = 0;}
        this.minExplosiveDamage = (int) Math.round(maxExplosiveDamage * minExplosiveDamageFactor);
    }

    public Weapon(Weapon other) {
        this.name = other.name;
        this.weaponType = other.weaponType;
        this.description = other.description;
        this.tier = other.tier;
        this.category = other.category;

        this.accuracy = other.accuracy;
        this.reloadTime = other.reloadTime;
        this.currentReload = other.currentReload;
        this.energyConsumption = other.energyConsumption;

        this.kineticPenetration = other.kineticPenetration;
        this.maxKineticDamage = other.maxKineticDamage;
        this.minKineticDamage = other.minKineticDamage;

        this.energyPenetration = other.energyPenetration;
        this.maxEnergyDamage = other.maxEnergyDamage;
        this.minEnergyDamage = other.minEnergyDamage;

        this.thermalPenetration = other.thermalPenetration;
        this.maxThermalDamage = other.maxThermalDamage;
        this.minThermalDamage = other.minThermalDamage;

        this.explosivePenetration = other.explosivePenetration;
        this.maxExplosiveDamage = other.maxExplosiveDamage;
        this.minExplosiveDamage = other.minExplosiveDamage;
    }

    public String getName() {return name;}
    public WeaponType getWeaponType() {return weaponType;}
    public String getDescription() {return description;}
    public Tier getTier() {return tier;}
    public Category getCategory() {return category;}

    public int getAccuracy() {return accuracy;}
    public int getReloadTime() {return reloadTime;}

    public int getCurrentReload() {return currentReload;}
    public void setCurrentReload(int currentReload) {this.currentReload = currentReload;}

    public int getEnergyConsumption() {return energyConsumption;}

    public int getKineticPenetration() {return kineticPenetration;}
    public int getMaxKineticDamage() {return maxKineticDamage;}
    public int getMinKineticDamage() {return minKineticDamage;}

    public int getEnergyPenetration() {return energyPenetration;}
    public int getMaxEnergyDamage() {return maxEnergyDamage;}
    public int getMinEnergyDamage() {return minEnergyDamage;}

    public int getThermalPenetration() {return thermalPenetration;}
    public int getMaxThermalDamage() {return maxThermalDamage;}
    public int getMinThermalDamage() {return minThermalDamage;}

    public int getExplosivePenetration() {return explosivePenetration;}
    public int getMaxExplosiveDamage() {return maxExplosiveDamage;}
    public int getMinExplosiveDamage() {return minExplosiveDamage;}
    
    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Informacion de Arma/ Atributos :\n")
            .append(" --- ").append(name).append(" --- \n")
            .append("Tipo de arma: ").append(weaponType.getValue()).append("\n")
            .append("Descripcion: ").append(description).append("\n")
            .append("Tier: ").append(tier).append("\n")
            .append("Categoria: ").append(category).append("\n")
            .append("Precision: ").append(accuracy).append("\n")
            .append("Carga: ").append(currentReload).append("/").append(reloadTime).append("\n")
            .append("Consumo de energia: ").append(energyConsumption).append("\n")
            .append(String.format("Penetración cinética: %d | Daño cinético máximo: %d | Daño cinético mínimo: %d%n", kineticPenetration, maxKineticDamage, minKineticDamage))
            .append(String.format("Penetración energetica: %d | Daño energetico máximo: %d | Daño energetico mínimo: %d%n", energyPenetration, maxEnergyDamage, minEnergyDamage))
            .append(String.format("Penetración termica: %d | Daño termico máximo: %d | Daño termico mínimo: %d%n", thermalPenetration, maxThermalDamage, minThermalDamage))
            .append(String.format("Penetración explosiva: %d | Daño explosivo máximo: %d | Daño explosivo mínimo: %d%n", explosivePenetration, maxExplosiveDamage, minExplosiveDamage))
            .append(" ---------- \n");
        return info.toString();
    }
}
