import json

def registrerVinyl():
    vinyl_record = {
        "title": input("Insert title: "),
        "artist": input("Insert Artist: "),
        "year": int(input("Insert year: ")),
        "gener": input("Insert Gener: "),
        "timeline": input("Insert timeline (example. 47:23): "),
        "label": input("Insert label: "),
        "country": input("Insert country: "),
        "color": input("Insert color: "),
        "trackCount": int(input("Number of Tracks: ")),
        "LimitedEdition": input("¿Is a limited edition? (y/n): ").lower() == 'y'
    }

    with open("vinyl_record.json", "w", encoding="utf-8") as file:
        json.dump(vinyl_record, file, ensure_ascii=False, indent=4)

    print("✅ Registro guardado en vinyl_record.json")

registrerVinyl()