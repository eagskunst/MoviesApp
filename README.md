# MoviesApp
An application that show a list of categories, a list of movies,the details of the movie and let the user save it on his own list.

The app follows the MVVM architecture with the repository pattern, alongside Dagger for DI.

### Compiling
After cloning and opening the project, you would need to create the `ApiKeys.kt` file under the `utils` folder, and add your proper API key from the [movie DB API](https://developers.themoviedb.org). After that, you can run the project.

### Modifying
#### Folder structure
There are 4 main folders: app, db, ui, utils.
* app: Contains Application and dependencies related stuff, such as Dagger Modules, API and local models, adapters, etc.
* db: Contains the Room database related stuff, such a Entities, daos, typeconverters, etc.
* ui: Contains the Activities and the MVVM implementations for then. Also, the epoxy controllers and callback classes.
* utils: Contains utilities, views and base classes. 
#### Contributing
I made this app for pratice/profesional porpouses, so I won't be accepting pull requests. Though, I will read and accept any issues, from code smells to suggestions.

### Desing, libraries and other stuff applied
* Room
* Data binding
* Material Components
* ViewModel and LiveData
* Coroutines
* Dagger for dependecy injection
* Retrofit
* Epoxy
* MVVM architecture + Repository pattern

### Check the app!
You could download the .apk file from the release tab.
