package cl.alonso.pioneerodyssey.core.slots;

import cl.alonso.pioneerodyssey.core.modules.Weapon;
import cl.alonso.pioneerodyssey.utils.enums.Category;
import cl.alonso.pioneerodyssey.utils.enums.WeaponType;

public class WeaponSlot implements Slot {
    private final Category maxCategory;
    private final WeaponType weaponType;
    private Weapon weapon;

    public WeaponSlot(Category maxCategory, WeaponType weaponType) {
        this.maxCategory = maxCategory;
        this.weaponType = weaponType;
        this.weapon = null;
    }


    public Category getMaxCategory() {return maxCategory;}

    public WeaponType getWeaponType() {return weaponType;}
    public String getWeaponTypeValue() {return weaponType.getValue();}

    public Weapon getWeapon() {return weapon;}
    public void setWeapon(Weapon weapon) {this.weapon = weapon;}

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Informacion de ranura:\n");
        info.append("Tipo de arma: ").append(weaponType.getValue()).append("\n");
        info.append("Categoría máxima: ").append(maxCategory.getValue()).append("\n");
        if (weapon != null) {
            info.append("Arma equipada: ").append(weapon.getName()).append(", Categoría: ").append(weapon.getCategory());
        } else {
            info.append("No hay arma equipada en este slot.");
        }
        return info.toString();
    }
}
