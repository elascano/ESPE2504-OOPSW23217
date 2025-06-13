from pymongo import MongoClient
from VinylRecord import VinylRecord

uri = "mongodb+srv://Jorge:Jorge@cluster0.ny8bieg.mongodb.net/"

client = MongoClient(uri)
db = client["VinylDB"]
collection = db["Records"]

def registrar_vinyl():
    print("=== Register new Vinyl Record ===")
    title = input("Title: ")
    artist = input("Artist: ")
    year = int(input("Year: "))
    gender = input("Gender: ")
    duration = input("Duration: ")
    label = input("Label: ")
    country = input("Country: ")
    color = input("Color: ")
    track_count = int(input("Track Count: "))
    
    limited = input("Limited Edition (Y/N): ").strip().upper()
    while limited not in ("Y", "N"):
        limited = input("Please only Y or N: ").strip().upper()

    record = VinylRecord(title, artist, year, gender, duration, label, country, color, track_count, limited)
    collection.insert_one(record.to_dict())
    print("✅ Record saved successfully.\n")

def leer_vinyls():
    print("=== VinylRecords List ===")
    for doc in collection.find():
        print("Title:           ", doc.get("title"))
        print("Artist:          ", doc.get("artist"))
        print("Year:            ", doc.get("year"))
        print("Gender:          ", doc.get("gender"))
        print("Duration:        ", doc.get("duration"))
        print("Label:           ", doc.get("label"))
        print("Country:         ", doc.get("country"))
        print("Color:           ", doc.get("color"))
        print("Track Count:     ", doc.get("track_count"))
        print("Limited Edition: ", doc.get("limited_edition"))
        print("------------------------------")

def main():
    print("1. Register a new vinyl record")
    print("2. Read all Vinyl Records")
    opcion = input("Opción: ")

    if opcion == "1":
        registrar_vinyl()
    elif opcion == "2":
        leer_vinyls()
    else:
        print("Invalid option.")

    client.close()

if __name__ == "__main__":
    main()
