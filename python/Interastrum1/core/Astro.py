from abc import ABC, abstractmethod

class Astro(ABC):

    def interact(self, player, action: str):
        interactions = self.interactions
        if action not in interactions:
            return False

        interactions[action](player)
        return True

    @property
    @abstractmethod
    def interactions(self) -> dict:
        pass