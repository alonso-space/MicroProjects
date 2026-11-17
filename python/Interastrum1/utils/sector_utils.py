import random
from core.Sector import Sector

name_pool = [
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
        ]

def random_name():
    return random.choice(name_pool)

def generate_universe(X=10, Y=10, Z=10):
    universe = [[[Sector() for x in range(X)]
                     for y in range(Y)]
                     for z in range(Z)]

    for z in range(Z):
        for y in range(Y):
            for x in range(X):
                current = universe[z][y][x]

                current.north = universe[z][(y + 1) % Y][x]
                current.south = universe[z][(y - 1) % Y][x]
                current.east  = universe[z][y][(x + 1) % X]
                current.west  = universe[z][y][(x - 1) % X]

    return universe
