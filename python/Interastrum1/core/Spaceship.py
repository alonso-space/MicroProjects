from utils import math_utils

class Spaceship:
    def __init__(self,
                 name: str, description: str, max_integrity: int, max_damage: int, 
                 min_damage: float, accuracy: int, reload_time: int, stealth: int, 
                 max_speed: int, acceleration: float, deceleration: float, cargo_space: int, 
                 warp_time: int, warp_chance: int, warp_interception: int, repair: float):

        self.name = name
        self.description = description
        self.max_integrity = max_integrity
        self.current_integrity = max_integrity
        self.max_damage = max_damage
        self.min_damage = round(max_damage * math_utils.clamp(min_damage))
        self.accuracy = accuracy
        self.reload_time = reload_time
        self.current_reload = 0
        self.stealth = stealth
        self.max_speed = max_speed
        self.current_speed = 0
        self.acceleration = round(max_speed * math_utils.clamp(acceleration))
        self.deceleration = round(max_speed * math_utils.clamp(deceleration))
        self.cargo_space = cargo_space
        self.warp_time = warp_time
        self.warp_chance = warp_chance
        self.warp_interception = warp_interception
        self.repair = round(max_integrity * math_utils.clamp(repair))
        self.landed = False