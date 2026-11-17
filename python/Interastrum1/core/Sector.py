import random
from utils import sector_utils
from utils import math_utils

class Sector:
    def __init__(self):
        self.name = sector_utils.random_name()

        self.north: Sector | None = None
        self.east: Sector | None = None
        self.west: Sector | None = None
        self.south: Sector | None = None
        
        self.faction_presence = math_utils.normalize_dict({
            "police": random.randint(0, 100),
            "pirates": random.randint(0, 100),
            "traders": random.randint(0, 100),
            "outsiders": random.randint(0, 100),
            "nothing": random.randint(0, 100),
        })

        self.asteroids_presence = math_utils.normalize_dict({
            "metals": random.randint(0, 25),
            "silicon": random.randint(0, 25),
            "ice": random.randint(0, 25),
            "gases": random.randint(0, 25),
            "nothing": random.randint(0, 100),
        })