from core.Item import Item

class Inventory:
    def __init__(self, max_weight: int):
        self.max_weight = max_weight
        self.contents = {}

    def total_weight(self):
        return sum(item.weight * qty for item, qty in self.contents.values())

    def can_add(self, item: Item, qty: int = 1):
        return self.total_weight() + item.weight * qty <= self.max_weight

    def add(self, item: Item, qty: int = 1):
        if not self.can_add(item, qty):
            return False, "No hay suficiente capacidad de peso."
        if item.name in self.contents:
            stored_item, stored_qty = self.contents[item.name]
            self.contents[item.name] = (stored_item, stored_qty + qty)
        else:
            self.contents[item.name] = (item, qty)
        return True, "Item agregado."

    def remove(self, item_name: str, qty: int = 1):
        if item_name not in self.contents:
            return False, "Item no está en el inventario."
        item, stored_qty = self.contents[item_name]
        if qty >= stored_qty:
            del self.contents[item_name]
        else:
            self.contents[item_name] = (item, stored_qty - qty)
        return True, "Item removido."

    def __repr__(self):
        items = ", ".join(f"{name} x{qty}" for name, (item, qty) in self.contents.items())
        return f"<Inventory {items} | {self.total_weight():.2f}/{self.max_weight}kg>"
