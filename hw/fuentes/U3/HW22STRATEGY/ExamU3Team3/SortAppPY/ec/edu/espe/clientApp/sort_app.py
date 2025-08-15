import tkinter as tk
from tkinter import messagebox
from model.sorting_context import SortingContext
from utils.MongoConnection import MongoConnection

def save_to_mongo(unsorted, size, algorithm, sorted_list):
    db_name = "strategyLastName"  # Replace LastName with your actual last name
    collection_name = "arrayFirstName"  # Replace FirstName with your actual first name
    client = MongoConnection.get_connection()
    db = client[db_name]
    collection = db[collection_name]
    doc = {
        "unsorted": unsorted,
        "size": size,
        "sort algorithm": algorithm,
        "sorted": sorted_list
    }
    collection.insert_one(doc)

def gui_sort():
    input_str = entry.get()
    try:
        data = [int(x.strip()) for x in input_str.split(",") if x.strip()]
    except ValueError:
        messagebox.showerror("Input Error", "Please enter only integers separated by commas.")
        return
    if len(data) <= 1:
        messagebox.showerror("Input Error", "Please enter at least 2 numbers.")
        return
    context = SortingContext()
    sorted_data, algorithm = context.sort(data, return_algorithm=True)
    result_msg = f"Unsorted: {data}\nSize: {len(data)}\nSort algorithm: {algorithm}\nSorted: {sorted_data}"
    messagebox.showinfo("Sort Result", result_msg)
    save_to_mongo(
        unsorted=", ".join(map(str, data)),
        size=len(data),
        algorithm=algorithm,
        sorted_list=", ".join(map(str, sorted_data))
    )

def run_gui():
    global entry
    root = tk.Tk()
    root.title("Strategy Pattern Sorter")
    tk.Label(root, text="Enter numbers separated by commas:").pack(padx=10, pady=5)
    entry = tk.Entry(root, width=40)
    entry.pack(padx=10, pady=5)
    tk.Button(root, text="Sort", command=gui_sort).pack(padx=10, pady=10)
    root.mainloop()

if __name__ == "__main__":
    run_gui()
    
