# User Registration Application

User Registration Application using Java, made with proper use of Java classes.

## List of Files as per Layouts Attached

- **MainActivity** & `activity_main.xml`
- **DataView** & `activity_data_view.xml`
- **RecyclerViewDisplay** & `activity_recycler_view_display.xml`

## List of Standalone Layouts

- `dialogue_layout.xml`
- `recycler_layout_item.xml`

## List of Standalone Files

- `UserModel.java`
- `LocalDatabase.java`
- `RecyclerViewAdapter.java`

## Launcher Activity

- **RecyclerViewDisplay** (`RecyclerViewDisplay.java`)

## Working of Each File as per App Workflow

- **RecyclerViewDisplay** fetches data stored in the local database (`LocalDatabase.java`) and sends them to the recycler view adapter (`RecyclerViewAdapter.java`) for further processing and attaching the data to the recycler items layout (`recycler_layout_item.xml`) and shows them on the recycler view. It also has an **ADD** button that opens the add new user activity (`MainActivity.java`).

- **MainActivity** takes input for the new user details and sends the data to the confirm activity (`DataView.java`). It also has a **CLEAR** button that clears all the data in the input fields.

- **DataView** shows all data it received from the entry activity (`MainActivity.java`) and passes it to the database handler file (`LocalDatabase.java`) for saving it to the database. It also has a **GO BACK** button to return to the previous activity for re-entering data. It serves as a confirmation page for the users.

- **LocalDatabase** is the SQLite local database file for the application; it contains all the database implementation and methods to fetch and store data.

- **RecyclerViewAdapter** contains the adapter implementation for the recycler view.

- **UserModel** contains the entire class details for the user, including constructors, getter and setter methods, and static methods.

## Future Implementations

- User profile image upload system is not added currently, but it will be added in future versions.
- More UI enhancements will be done later.
- All `ArrayLists` used in different files to fetch all the registered users will be removed. Instead, a single static method will be created inside the `UserModel` file to fetch all registered users. This way, there will be no need to create multiple `ArrayLists`; calling this one method will be sufficient.
- More details of the users will be added, and there will be an entire profile for them.

---

**Note:** There is no real intended working of this application for me so far; I am creating this for my learning purpose.
