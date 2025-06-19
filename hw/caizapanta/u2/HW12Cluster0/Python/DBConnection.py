from pymongo import MongoClient
import json
from bson.objectid import ObjectId # Included for potential use with MongoDB's default _id, though not strictly needed for your 'id' field

# --- MongoDB Connection String ---
# This is your unique connection string to your MongoDB Atlas cluster.
# It uses the provided username, password, and cluster address.
connection_string = "mongodb+srv://tacaizapanta:tacaizapanta@cluster0.ircnkvg.mongodb.net/"

# --- Functions for Cable Management ---

def insert_cable():
    try:
        # Get input from the user for the new cable's details
        cable_id = input("Enter Cable ID: ")
        brand = input("Enter Brand: ")
        length = float(input("Enter Length (in meters): "))
        cable_type = input("Enter Type (e.g., HDMI, USB-C): ")

        # Create a Python dictionary (document) with the collected data
        document = {
            "id": cable_id,
            "brand": brand,
            "length": length,
            "type": cable_type
        }

        # Establish connection to MongoDB Atlas and perform the insert operation
        with MongoClient(connection_string) as client:
            db = client["dbmongo"]       # Access the 'dbmongo' database
            collection = db["cable"]     # Access the 'cable' collection within 'dbmongo'
            collection.insert_one(document) # Insert the new document
            print("\nCable inserted successfully!")

    except ValueError:
        print("\nInvalid input for length. Please enter a number.")
    except Exception as e:
        print(f"\nError connecting to MongoDB or inserting data: {e}")

def show_cables():
    """
    Retrieves and displays all cable documents from the 'cable' collection
    in your MongoDB Atlas database.
    """
    try:
        # Establish connection to MongoDB Atlas
        with MongoClient(connection_string) as client:
            db = client["dbmongo"]
            collection = db["cable"]

            print("\n--- Cables in the Database ---")
            found_cables = False
            # Iterate through all documents found in the 'cable' collection
            for doc in collection.find():
                # Print each document in a readable JSON format
                print(json.dumps(doc, indent=4, default=str))
                found_cables = True

            if not found_cables:
                print("No cables found in the database.")

    except Exception as e:
        print(f"\nError retrieving data from MongoDB: {e}")

def update_cable():
    """
    Prompts the user to provide an ID, finds the corresponding cable,
    and allows updating its details in the 'cable' collection.
    """
    try:
        cable_id_to_update = input("Enter the ID of the cable to update: ")

        # Establish connection to MongoDB Atlas
        with MongoClient(connection_string) as client:
            db = client["dbmongo"]
            collection = db["cable"]

            # Query to find the document by its 'id' field
            query = {"id": cable_id_to_update}
            existing_cable = collection.find_one(query)

            if not existing_cable:
                print(f"\nNo cable found with ID: {cable_id_to_update}.")
                return

            print(f"\n--- Current details for Cable ID: {cable_id_to_update} ---")
            print(json.dumps(existing_cable, indent=4, default=str))

            print("\nEnter new values (leave blank to keep current value):")
            new_brand = input(f"New Brand (current: {existing_cable.get('brand', 'N/A')}): ")
            new_length_str = input(f"New Length (current: {existing_cable.get('length', 'N/A')} meters): ")
            new_type = input(f"New Type (current: {existing_cable.get('type', 'N/A')}): ")

            update_fields = {} # Dictionary to store fields that will be updated
            if new_brand:
                update_fields["brand"] = new_brand
            if new_length_str:
                try:
                    update_fields["length"] = float(new_length_str)
                except ValueError:
                    print("Invalid length value. Keeping original length.")
            if new_type:
                update_fields["type"] = new_type

            if not update_fields:
                print("\nNo changes specified. Cable not updated.")
                return

            # Perform the update operation using the $set operator
            update_result = collection.update_one(query, {"$set": update_fields})

            if update_result.matched_count > 0:
                print(f"\nCable with ID {cable_id_to_update} updated successfully!")
            else:
                print(f"\nCould not update cable with ID {cable_id_to_update}. It might no longer exist.")

    except Exception as e:
        print(f"\nError updating cable: {e}")

def delete_cable():
    """
    Prompts the user to provide an ID, finds the corresponding cable,
    and deletes it from the 'cable' collection.
    """
    try:
        cable_id_to_delete = input("Enter the ID of the cable to delete: ")

        # Establish connection to MongoDB Atlas
        with MongoClient(connection_string) as client:
            db = client["dbmongo"]
            collection = db["cable"]

            query = {"id": cable_id_to_delete}
            existing_cable = collection.find_one(query)

            if not existing_cable:
                print(f"\nNo cable found with ID: {cable_id_to_delete}.")
                return

            # Ask for confirmation before deleting
            confirm = input(f"Are you sure you want to delete cable with ID '{cable_id_to_delete}'? (yes/no): ").lower()
            if confirm == 'yes':
                delete_result = collection.delete_one(query)
                if delete_result.deleted_count > 0:
                    print(f"\nCable with ID {cable_id_to_delete} deleted successfully!")
                else:
                    print(f"\nCould not delete cable with ID {cable_id_to_delete}.")
            else:
                print("\nDeletion cancelled.")

    except Exception as e:
        print(f"\nError deleting cable: {e}")

# --- Main Menu for Interaction ---

def menu():
    """
    Displays the main menu to the user and handles their selection
    to perform various cable management operations.
    """
    while True:
        print("\n--- CABLE MANAGEMENT MENU ---")
        print("1. Insert New Cable")
        print("2. Show All Cables")
        print("3. Update Cable Details")
        print("4. Delete Cable")
        print("0. Exit")

        option = input("Select an option: ")

        if option == '1':
            insert_cable()
        elif option == '2':
            show_cables()
        elif option == '3':
            update_cable()
        elif option == '4':
            delete_cable()
        elif option == '0':
            print("\nExiting program. Goodbye!")
            break
        else:
            print("\nInvalid option, please try again.")

# --- Program Entry Point ---

if __name__ == "__main__":
    menu() # Start the main menu when the script is executed