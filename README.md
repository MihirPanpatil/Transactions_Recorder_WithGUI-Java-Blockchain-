## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


# Adding Further

The project requires installation of Some Dependencies for using JavaFx. These dependencies are crucial for running the program.

## Step - 1 : 
[Download](https://openjfx.io/) the latest version of JavaFx SDK. Extract the files to the desired location.

## Step - 2 : 
In your VS Code, at the Bottom Left corner, Click on `JAVA PROJECTS` > `Referenced Libraries` > Click on `+`.
Now Add the all the JAR files located in `javafx-sdk-version\lib` (Inside your Extracted Files) to the `Referenced Libraries`.

## Step - 3 : 
Now, in the Tabs menu in VS Code, click on `Run` > `Add Configuration`. A `launch.json` file will be created.
Add VM arguments to the `launch.json` right under `"projectName"`.
To do so Add `"vmArgs": "--module-path "Path" --add-modules javafx.controls,javafx.fxml"`.
The path needs to be replaced with the Path of your `lib` folder in your extracted files. 

### The necessary Dependencies have now been added to the Project.

