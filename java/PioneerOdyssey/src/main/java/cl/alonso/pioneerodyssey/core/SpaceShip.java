package cl.alonso.pioneerodyssey.core;

import java.util.List;
import java.util.ArrayList;

import cl.alonso.pioneerodyssey.core.slots.WeaponSlot;
import cl.alonso.pioneerodyssey.utils.enums.Category;
import cl.alonso.pioneerodyssey.utils.enums.Tier;
import cl.alonso.pioneerodyssey.utils.enums.WeaponType;
import cl.alonso.pioneerodyssey.utils.Quad;

public class SpaceShip {
    private final String className;
    private String name;
    private final String description;
    
    //private final int requiredLevel;
    private final Tier tier;
    private final Category category;

    private final int baseMaxIntegrity;
    private int maxIntegrity;
    private int currentIntegrity;

    private final int baseMaxSpeed;
    private int maxSpeed;
    private int currentSpeed;

    private final int baseAcceleration;
    private int acceleration;

    private final int baseEnergyRegeneration;
    private int energyRegeneration;

    private final int baseMaxEnergy;
    private int maxEnergy;
    private int currentEnergy;

    private final int cargoCapacity;
    private int currentCargo;

    private final int baseMiningPower;
    private int miningPower;

    private final int baseKineticArmor;
    private int kineticArmor;

    private final int baseEnergyArmor;
    private int energyArmor;

    private final int baseThermalArmor;
    private int thermalArmor;

    private final int baseExplosiveArmor;
    private int explosiveArmor;


    private final List<Object> slots = new ArrayList<>();

    @SafeVarargs
    public SpaceShip(
        String className,
        String description,
        //int requiredLevel,
        Tier tier, 
        Category category,
        int baseMaxIntegrity,
        int baseMaxSpeed,
        int baseAcceleration,
        int baseEnergyRegeneration,
        int baseMaxEnergy,
        int cargoCapacity,
        int baseMiningPower,
        int baseKineticArmor,
        int baseEnergyArmor,
        int baseThermalArmor,
        int baseExplosiveArmor,
        Quad<Class<?>, Category, Integer, Enum<?>>... slotsToAdd //TypeofSlot, MaxCategory, Quantity, Can accept any Xtype, WeaponType, StructureType, etc...
        )
        {
        int nameLimit = 25;
        if (className.length() > nameLimit) {
            System.out.println("!---ADVERTENCIA: "+className+" Es demasiado largo para el nombre, sera acortado a "+nameLimit+" caracteres.");
            className = className.substring(0, nameLimit);
        }
        this.className = className;
        this.name = className;
        
        int descriptionLimit = 100;
        if (description.length() > descriptionLimit) {
            System.out.println("!---ADVERTENCIA: "+description+" Es demasiado largo para la descripcion, sera acortado a "+descriptionLimit+" caracteres.");
            description = description.substring(0, descriptionLimit);
        }
        this.description = description;
        
        //this.requiredLevel = requiredLevel;
        this.tier = tier;
        this.category = category;

        this.baseMaxIntegrity = baseMaxIntegrity;
        this.maxIntegrity = baseMaxIntegrity;
        this.currentIntegrity = baseMaxIntegrity;

        this.baseMaxSpeed = baseMaxSpeed;
        this.maxSpeed = baseMaxSpeed;
        this.currentSpeed = 0;

        this.baseAcceleration = baseAcceleration;
        this.acceleration = baseAcceleration;

        this.baseMaxEnergy = baseMaxEnergy;
        this.maxEnergy = baseMaxEnergy;
        this.currentEnergy = 0;

        this.cargoCapacity = cargoCapacity;
        this.currentCargo = 0;

        this.baseMiningPower = baseMiningPower;
        this.miningPower = baseMiningPower;

        this.baseKineticArmor = baseKineticArmor;
        this.kineticArmor = baseKineticArmor;

        this.baseEnergyRegeneration = baseEnergyRegeneration;
        this.energyRegeneration = baseEnergyRegeneration;

        this.baseEnergyArmor = baseEnergyArmor;
        this.energyArmor = baseEnergyArmor;

        this.baseThermalArmor = baseThermalArmor;
        this.thermalArmor = baseThermalArmor;

        this.baseExplosiveArmor = baseExplosiveArmor;
        this.explosiveArmor = baseExplosiveArmor;

        for (Quad<Class<?>, Category, Integer, Enum<?>> slotInfo : slotsToAdd) {
            Class<?> slotType = slotInfo.getFirst();
            Category maxCategory = slotInfo.getSecond();
            int quantity = slotInfo.getThird();
            Enum<?> weaponType = slotInfo.getFourth();

            for (int i = 0; i < quantity; i++) {
                try {
                    if (slotType == WeaponSlot.class) {
                        slots.add(new WeaponSlot(maxCategory, (WeaponType) weaponType));
                    } 
                    // Future slot types will be added here
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getClassName() {return className;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}

    //public int getRequiredLevel() {return requiredLevel;}
    public Tier getTier() {return tier;}
    public Category getCategory() {return category;}

    public int getBaseMaxIntegrity() {return baseMaxIntegrity;}
    public int getMaxIntegrity() {return maxIntegrity;}
    public void setMaxIntegrity(int maxIntegrity) {this.maxIntegrity = maxIntegrity;}

    public int getCurrentIntegrity() {return currentIntegrity;}
    public void setCurrentIntegrity(int currentIntegrity) {this.currentIntegrity = currentIntegrity;}

    public int getBaseMaxSpeed() {return baseMaxSpeed;}
    public int getMaxSpeed() {return maxSpeed;}
    public void setMaxSpeed(int maxSpeed) {this.maxSpeed = maxSpeed;}

    public int getCurrentSpeed() {return currentSpeed;}
    public void setCurrentSpeed(int currentSpeed) {this.currentSpeed = currentSpeed;}

    public int getBaseAcceleration() {return baseAcceleration;}
    public int getAcceleration() {return acceleration;}
    public void setAcceleration(int acceleration) {this.acceleration = acceleration;}

    public int getBaseMaxEnergy() {return baseMaxEnergy;}
    public int getMaxEnergy() {return maxEnergy;}
    public void setMaxEnergy(int maxEnergy) {this.maxEnergy = maxEnergy;}

    public int getBaseEnergyRegeneration() {return baseEnergyRegeneration;}
    public int getEnergyRegeneration() {return energyRegeneration;}
    public void setEnergyRegeneration(int energyRegeneration) {this.energyRegeneration = energyRegeneration;}

    public int getCurrentEnergy() {return currentEnergy;}
    public void setCurrentEnergy(int currentEnergy) {this.currentEnergy = currentEnergy;}

    public int getCargoCapacity() {return cargoCapacity;}

    public int getCurrentCargo() {return currentCargo;}
    public void setCurrentCargo(int currentCargo) {this.currentCargo = currentCargo;}

    public int getBaseMiningPower() {return baseMiningPower;}
    public int getMiningPower() {return miningPower;}
    public void serMiningPower(int miningPower) {this.miningPower = miningPower;}

    public int getBaseKineticArmor() {return baseKineticArmor;}
    public int getKineticArmor() {return kineticArmor;}
    public void setKineticArmor(int kineticArmor) {this.kineticArmor = kineticArmor;}

    public int getBaseEnergyArmor() {return baseEnergyArmor;}
    public int getEnergyArmor() {return energyArmor;}
    public void setEnergyArmor(int energyArmor) {this.energyArmor = energyArmor;}

    public int getBaseThermalArmor() {return baseThermalArmor;}
    public int getThermalArmor() {return thermalArmor;}
    public void setThermalArmor(int thermalArmor) {this.thermalArmor = thermalArmor;}

    public int getBaseExplosiveArmor() {return baseExplosiveArmor;}
    public int getExplosiveArmor() {return explosiveArmor;}
    public void setExplosiveArmor(int explosiveArmor) {this.explosiveArmor = explosiveArmor;}
    
    public List<Object> getSlots() {return slots;}

    public String getBaseInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Informacion de nave/ Atributos base:\n")
            .append(" --- ").append(name).append(" --- \n")
            .append(description).append("\n")
            .append("Clase: ").append(className).append("\n")
            //.append("Nivel Requerido: ").append(requiredLevel).append("\n")
            .append("Tier: ").append(tier).append("\n")
            .append("Categoría: ").append(category).append("\n")
            .append("Integridad base: ").append(baseMaxIntegrity).append("\n")
            .append("Velocidad base: ").append(baseMaxSpeed).append("\n")
            .append("Aceleración base: ").append(baseAcceleration).append("\n")
            .append("Regeneracion de energía base: ").append(baseEnergyRegeneration).append("\n")
            .append("Almacen de energía base: ").append(baseMaxEnergy).append("\n")
            .append("Capacidad de Carga: ").append(cargoCapacity).append("\n")
            .append("Poder de Mineria base: ").append(baseMiningPower).append("\n")
            .append("Blindaje Cinetico base: ").append(baseKineticArmor).append("\n")
            .append("Blindaje Energetico base: ").append(baseEnergyArmor).append("\n")
            .append("Blindaje Termico base: ").append(baseThermalArmor).append("\n")
            .append("Blindaje Explosivo base: ").append(baseExplosiveArmor).append("\n")
            .append(" ---------- \n");
        return info.toString();
    }

    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Informacion de nave/ Atributos actuales:\n")
            .append(" --- ").append(name).append(" --- \n")
            .append("Clase: ").append(className).append("\n")
            //.append("Nivel Requerido: ").append(requiredLevel).append("\n")
            .append("Tier: ").append(tier).append("\n")
            .append("Categoría: ").append(category).append("\n")
            .append("Integridad: ").append(currentIntegrity).append("/").append(maxIntegrity).append("\n")
            .append("Velocidad: ").append(currentSpeed).append("/").append(maxSpeed).append("\n")
            .append("Aceleración: ").append(acceleration).append("\n")
            .append("Regeneracion de energía: ").append(energyRegeneration).append("\n")
            .append("Almacen de Energía: ").append(currentEnergy).append("/").append(maxEnergy).append("\n")
            .append("Capacidad de Carga: ").append(currentCargo).append("/").append(cargoCapacity).append("\n")
            .append("Poder de Mineria: ").append(miningPower).append("\n")
            .append("Blindaje Cinetico: ").append(kineticArmor).append("\n")
            .append("Blindaje Energetico: ").append(energyArmor).append("\n")
            .append("Blindaje Termico: ").append(thermalArmor).append("\n")
            .append("Blindaje Explosivo: ").append(explosiveArmor).append("\n")
            .append("Ranuras:\n");

        for (int i = 0; i < slots.size(); i++) {
            Object slot = slots.get(i);
            if (slot instanceof WeaponSlot) {
                WeaponSlot weaponSlot = (WeaponSlot) slot;
                String weaponName = (weaponSlot.getWeapon() != null) ? weaponSlot.getWeapon().getName() : "Vacío";
                String weaponCat = (weaponSlot.getWeapon() != null) ? weaponSlot.getWeapon().getCategory().toString() : "-";
                String maxCat = weaponSlot.getMaxCategory().toString();
                String weaponTypeValue = weaponSlot.getWeaponTypeValue().toString();

                info.append("  - ").append(i)
                    .append(" Arma: ").append(weaponName)
                    .append(" (").append(weaponCat).append("/").append(maxCat).append(")\n")
                    .append(" Tipo: ").append(weaponTypeValue).append("\n");
            } // Future slot types can be added here
        }
        info.append(" ---------- \n");
        return info.toString();
    }
}
