class Planet(Astro):
    def __init__(self):

    def land(self, player):
        player.spaceship.landed = True

    def scan(self, player):
        pass  # lógica del escaneo

    @property
    def interactions(self):
        return {
            "land": self.land,
            "scan": self.scan
        }