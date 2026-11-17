from core.Sector import Sector
from core.Spaceship import Spaceship
from core.Species import Species

class Player:
    def __init__(self, name: str, in_sector: Sector, spaceship: Spaceship, species: Species):
        self.name = name
        self.in_sector = in_sector
        self.spaceship = spaceship
        self.species = species