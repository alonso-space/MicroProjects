class Item:
    def __init__(self, name: str, weight: int):
        self.name = name
        self.weight = weight

    def __repr__(self):
        return f"{self.name}({self.weight}kg)"
