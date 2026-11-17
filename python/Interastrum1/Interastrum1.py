from utils import sector_utils
from utils import user_utils
from utils import math_utils
import textwrap

def presentation():
    print("""
    Interastrum
    v1.0.0

    Bienvenido a Interastrum, un juego de exploración espacial en tu terminal.

    Q/1: Iniciar nueva partida
    W/2: Ajustes
    E/3: Novedades
    A/4: Como jugar
    S/5: Creditos
    D/6: Salir
    """)

def game():
    print("Iniciando nueva partida...")
    universe = sector_utils.generate_universe()
    test_dict = math_utils.normalize_dict({
        "1": 0.25, "2": 0.25, "3": 0.25
    })
    print(test_dict)
    print(sum(test_dict.values()))

def open_settings():
    print("Ajustes… próximamente.")

def show_news():
    print("""
    Esta es la primera versión de Interastrum. Ve a Ayuda para entender cómo jugar.
    """)

def show_help():
    print(textwrap.dedent("""
    Interastrum es un juego de exploración espacial en terminal donde tomas el control de una nave con recursos limitados...
    """))

def show_credits():
    print("Créditos… próximamente.")

def exit_game():
    print("Saliendo del juego")
    exit()

def user_choice():
    actions = {
        'q': game, '1': game,
        'w': open_settings, '2': open_settings,
        'e': show_news, '3': show_news,
        'a': show_help, '4': show_help,
        's': show_credits, '5': show_credits,
        'd': exit_game, '6': exit_game
    }

    while True:
        choice = input("Acción: ").strip().lower()
        action = actions.get(choice)
        if action:
            action()
            if action == exit_game:
                break
        else:
            print("Opción no reconocida.\n")
            presentation()

def main():
    settings = user_utils.load_user_settings()
    presentation()
    user_choice()

if __name__ == "__main__":
    main()
