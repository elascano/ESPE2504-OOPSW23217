from VinylRecord import VinylRecord
from ConnectMongo import VinylRecordDAO

def main():
    dao = VinylRecordDAO()

    while True:
        print("\n=== VINYL RECORD MENU ===")
        print("1. Register a vinyl record")
        print("2. Show all records")
        print("3. Search by title")
        print("4. Delete by title")
        print("5. Exit")
        option = input("Choose an option: ")

        if option == '1':
            title = input("Title: ")
            artist = input("Artist: ")
            year = int(input("Year: "))
            genre = input("Genre: ")
            duration = input("Duration: ")
            label = input("Label: ")
            country = input("Country: ")
            color = input("Color: ")
            base_price = float(input("Base price: "))
            limited_input = input("Limited edition? (Y/N): ").strip().upper()
            limited_edition = limited_input == 'Y'

            record = VinylRecord(title, artist, year, genre, duration, label, country, color, base_price, limited_edition)
            dao.insert(record.to_dict())
            print("Vinyl record saved successfully.")

        elif option == '2':
            print("\n--- ALL VINYL RECORDS ---")
            for doc in dao.find_all():
                print("----------------------------")
                for key, value in doc.items():
                    if key != "_id":
                        print(f"{key}: {value}")

        elif option == '3':
            title = input("Enter title to search: ")
            record = dao.find_by_title(title)
            if record:
                print("--- RECORD FOUND ---")
                for key, value in record.items():
                    if key != "_id":
                        print(f"{key}: {value}")
            else:
                print("No record found with that title.")

        elif option == '4':
            title = input("Enter title to delete: ")
            if dao.delete_by_title(title):
                print("Record deleted successfully.")
            else:
                print("No record found to delete.")

        elif option == '5':
            print("Exiting program...")
            break

        else:
            print("Invalid option. Try again.")

if __name__ == "__main__":
    main()
