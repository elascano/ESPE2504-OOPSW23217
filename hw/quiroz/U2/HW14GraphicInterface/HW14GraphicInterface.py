
from tkinter import *
from tkinter import messagebox
from pymongo import MongoClient

# Connect to MongoDB (replace with your actual URI)
client = MongoClient("mongodb+srv://mlquiroz:<Mlqh2006>@cluster0.vpeg1ly.mongodb.net/")
db = client["Maria"]
collection = db["Person"]

# CRUD Functions
def create_user():
    user_id = entry_id.get()
    name = entry_name.get()
    age = entry_age.get()
    salary = entry_salary.get()

    if user_id and name and age and salary:
        # Check if user with same ID exists
        if collection.find_one({"id": user_id}):
            messagebox.showwarning("Warning", "User ID already exists!")
        else:
            collection.insert_one({
                "id": user_id,
                "name": name,
                "age": int(age),
                "salary": float(salary)
            })
            messagebox.showinfo("Success", "User created successfully")
            show_users()
    else:
        messagebox.showwarning("Error", "Please fill in all fields")

def read_users():
    show_users()

def update_user():
    user_id = entry_id.get()
    name = entry_name.get()
    age = entry_age.get()
    salary = entry_salary.get()

    if user_id and name and age and salary:
        result = collection.update_one(
            {"id": user_id},
            {"$set": {"name": name, "age": int(age), "salary": float(salary)}}
        )
        if result.modified_count > 0:
            messagebox.showinfo("Success", "User updated successfully")
        else:
            messagebox.showinfo("Info", "User ID not found for update")
        show_users()
    else:
        messagebox.showwarning("Error", "Please fill in all fields")

def delete_user():
    user_id = entry_id.get()

    if user_id:
        result = collection.delete_one({"id": user_id})
        if result.deleted_count > 0:
            messagebox.showinfo("Success", "User deleted successfully")
        else:
            messagebox.showinfo("Info", "User ID not found for deletion")
        show_users()
    else:
        messagebox.showwarning("Error", "Please enter User ID to delete")

def show_users():
    listbox.delete(0, END)
    for user in collection.find():
        listbox.insert(END, f"ID: {user.get('id')} | Name: {user.get('name')} | Age: {user.get('age')} | Salary: ${user.get('salary'):.2f}")

# GUI Setup
window = Tk()
window.title("MongoDB CRUD Application")
window.geometry("500x450")

Label(window, text="User ID (e.g. national ID):").pack()
entry_id = Entry(window)
entry_id.pack()

Label(window, text="Name:").pack()
entry_name = Entry(window)
entry_name.pack()

Label(window, text="Age:").pack()
entry_age = Entry(window)
entry_age.pack()

Label(window, text="Salary:").pack()
entry_salary = Entry(window)
entry_salary.pack()

Button(window, text="Create", command=create_user).pack(pady=5)
Button(window, text="Read", command=read_users).pack(pady=5)
Button(window, text="Update", command=update_user).pack(pady=5)
Button(window, text="Delete", command=delete_user).pack(pady=5)

listbox = Listbox(window)
listbox.pack(pady=10, fill=BOTH, expand=True)

window.mainloop()
