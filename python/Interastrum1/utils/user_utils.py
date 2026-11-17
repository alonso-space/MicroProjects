import json
from pathlib import Path

BASE_DIR = Path(__file__).resolve().parent.parent
USER_SETTINGS_FILE = BASE_DIR / "user_data" / "settings.json"

DEFAULT_SETTINGS = {
    "username": "Jugador"
}

def load_user_settings():

    USER_SETTINGS_FILE.parent.mkdir(parents=True, exist_ok=True)

    if not USER_SETTINGS_FILE.exists():
        with open(USER_SETTINGS_FILE, "w") as f:
            json.dump(DEFAULT_SETTINGS, f, indent=4)
        return DEFAULT_SETTINGS.copy()
    
    with open(USER_SETTINGS_FILE, "r") as f:
        data = json.load(f)

    settings = DEFAULT_SETTINGS.copy()
    settings.update(data)
    
    return settings