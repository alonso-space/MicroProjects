package cl.alonso.pioneerodyssey.utils;

import java.util.concurrent.ThreadLocalRandom;

import cl.alonso.pioneerodyssey.core.Sector;
import cl.alonso.pioneerodyssey.utils.enums.Tier;

public class worldUtils {
    
    private static final String[] nameBank = {
        "Zyron", "Orion", "Nebulon", "Astra", "Vortex",
        "Quasar", "Lunaris", "Galaxia", "Cosmo", "Andromeda",
        "Polaris", "Altair", "Sirius", "Vega", "Rigel",
        "Proxima", "Titan", "Europa", "Callisto", "Ganymede",
        "Phobos", "Deimos", "Io", "Enceladus", "Mimas",
        "Hyperion", "Tethys", "Rhea", "Dione", "Ceres",
        "Sedna", "Makemake", "Haumea", "Eris", "Charon",
        "Aldebaran", "Betelgeuse", "Capella", "Deneb", "Fomalhaut",
        "Altairis", "Lyra", "Cygnus", "Andros", "Nebulus",
        "Xenon", "Zyphor", "Orialis", "Veltor", "Quorax",
        "Lumina", "Stellara", "Cosmion", "Astrolis", "Vortexus",
        "Nebulis", "Galacton", "Exon", "Polaria", "Cryon",
        "Aurelia", "Celestia", "Ecliptor", "Solaris", "Novae",
        "Pulsar", "Quintar", "Vantor", "Oberon", "Titanis",
        "Lunara", "Orbiton", "Astera", "Vireon", "Cosmica",
        "Zorion", "Neptara", "Jovian", "Mercuron", "Saturnis",
        "Uranix", "Plutaris", "Cometis", "Meteoron", "Galactis",
        "Orbis", "Stellaris", "Aether", "Zenith", "Aphelion",
        "Perseon", "Aurora", "Lyricon", "Celara", "Nexon",
        "Virelia", "Astrion", "Cosmara", "Solara", "Nebulix"
    };
    
    public static String getRandomName() {
        int position = ThreadLocalRandom.current().nextInt(0, nameBank.length);
        String selection = nameBank[position];
        return selection;
    }

    public static void setupWorld(Sector[][][] world) {
        Tier[] allTiers = Tier.values();
        int maxTierIndex = allTiers.length - 1;
        int number = 0;
        for (int x = 0; x < world.length; x++) {
            for (int y = 0; y < world[x].length; y++) {
                for (int z = 0; z < world[x][y].length; z++) {
                    int tierIndex = Math.min(z, maxTierIndex);
                    Tier tierForLayer = allTiers[tierIndex];
                    world[x][y][z] = new Sector(getRandomName() + " " + number, x, y, z, tierForLayer);
                    number++;
                }
            }
        }

        for (int x = 0; x < world.length; x++) {
            for (int y = 0; y < world[x].length; y++) {
                for (int z = 0; z < world[x][y].length; z++) {
                    Sector current = world[x][y][z];
                    current.setNorth(world[(x - 1 + world.length) % world.length][y][z]);
                    current.setSouth(world[(x + 1) % world.length][y][z]);
                    current.setWest(world[x][(y - 1 + world[x].length) % world[x].length][z]);
                    current.setEast(world[x][(y + 1) % world[x].length][z]);
                }
            }
        }
    }
}
