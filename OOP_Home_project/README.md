# Exam 3

An exam to check your knowledge of basic programming techniques, the pillars of object-oriented programming, and the delightful idiosyncracies of the Java programming language.

## Instructions

This exam contains several separate source code files. For each one:

- read the instructions written as comments within the file
- complete the code as instructed
- all lines of printed text should have a line break at the end.

The files are inter-related and together create an application. Once the files have been coded correctly, running the given file named `App.java` will make use of the other files to create a complete program. Here is an overview of the files that must be completed by you:

1. `Home.java` - an abstract class representing a home.
1. `Cottage.java` - a class that represents rustic cottages, with no bathrooms.
1. `MobileHome.java` - a class that represents a prefabricated mobile home.
1. `HomeBuilder.java` - a useful class for instantiating and performing batch operations on Homes.
1. `Examinable.java` - an interface indicating methods that must be implemented by the `HomeBuilder` class.
1. `InvalidHomeException.java` - exceptions of this type must be thrown any time an invalid setting is applied to a `Home` object.
1. `App.java` - contains the `main` method that starts the program. The complete code for this file is given to you.

## Folder structure

This project has several important directories:

- `src` - contains the Java source code for the project (i.e. `.java` files)
- `bin` - contains the compiled code (i.e. `.class` files)
- `lib` - contains any dependencies (other libraries of code that the project depends upon to work)

If your project has no dependencies and has not been compiled, you may not see the `lib` or `bin` directories.

## How to submit this exam

Once you have completed the changes to the code, you are ready to submit it. Do this from within Visual Studio Code.

1. Click on the `Source Control` icon in the left activity bar in Visual Studio Code.
1. In the Source Control side bar, you will see a field named `Message` - type in a unique message about what you have done, e.g. "_Finished assignment!_" or whatever you want to write as a short note to yourself.
1. Hover over the words `Source Control`. You will see a `...` icon appear - click it to see a menu. In that menu, click `Commit`->`Commit`. This logs the changes you've made to the Git project - remember Git is used to keep track of changes.
1. Go to the same menu and click `Push` to submit your assignment - this uploads your updated files to the copy of your respository on GitHub.

![Push changes to GitHub](./images/how_to_push_changes_to_github_from_vscode.png)

That's it... you're done.

## Double-check your submission

Prove to yourself that you have correctly submitted by viewing your repository on the GitHub website - you should see your completed README.md file there.

## Resubmit as many times as you want

You can re-submit as many times as you want before the deadline. Just make changes to the files on your own computer and repeat the process outlined above to upload them to GitHub.
