# NewYorkDev
NewYorkDev is an Android project that mainly use MVP as architecture pattern.
it deals with high-level organization of the code and also, the separation of functionalities the code into different concerns which aids re-usability amongst other peculiar functions.
the project is divided in into these parts:
Model Package is responsible for managing data.
View as ui package all interactions are done in this package.
Presenter inside ui the base package is where application logic is stored in.
The project uses retrofit as type-safe HTTP client for android. 
The Structure uses generic type in its views and activities.
There are base classes using abstracted methods to implement - these classes are critical for managing code. 
in addition there is a utils package contains useful methods to use in the application.
