package cl.alonso.pioneerodyssey.utils;

import cl.alonso.pioneerodyssey.core.SpaceShip;
import cl.alonso.pioneerodyssey.core.modules.Weapon;
import cl.alonso.pioneerodyssey.core.slots.WeaponSlot;
import cl.alonso.pioneerodyssey.utils.enums.WeaponType;

public class equipUtils {
    public static void equipWeapon(SpaceShip ship, Weapon weapon, int slotIndex) {
        if (slotIndex < 0 || slotIndex >= ship.getSlots().size()) {
            System.out.println("Índice de slot("+slotIndex+") inválido. "+"Tienes slots desde el 0 hasta el "+(ship.getSlots().size()-1)+".");
            return;
        }

        Object slot = ship.getSlots().get(slotIndex);
        if (!(slot instanceof WeaponSlot)) {
            System.out.println("El slot en el índice("+slotIndex+") proporcionado no es para Armas.");
            return;
        }

        WeaponSlot weaponSlot = (WeaponSlot) slot;
        if (weapon.getCategory().ordinal() > weaponSlot.getMaxCategory().ordinal()) {
            System.out.println("La categoría del arma "+ weapon.getName() +" es demasiado alta para este slot("+slotIndex+").");
            return;
        }

        if (!matches(weaponSlot, weapon)) {
            System.out.println("El tipo del arma "+ weapon.getWeaponType() +" no es compatible con este slot("+slotIndex+") de tipo "+weaponSlot.getWeaponType()+".");
            return;
        }
        
        weaponSlot.setWeapon(new Weapon(weapon));
    }

    public static boolean matches(WeaponSlot slot, Weapon weapon) {
        WeaponType slotType = slot.getWeaponType();
        WeaponType weaponType = weapon.getWeaponType();
    
        if (slotType == null || weaponType == null) {
            return false;
        }

        if (slotType == WeaponType.All || weaponType == WeaponType.All) {
            return true;
        }
        return slotType == weaponType;
    }
}
