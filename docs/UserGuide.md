---
  layout: default.md
  title: "User Guide"
  pageNav: 3
---

# Furiends User Guide

Furiends is a **desktop app tailored towards animal lovers, specifically individuals who are tasked to feed stray animals.** It is optimized for use via a **Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, Furiends can help you manage people and animals, as well as allocate people to certain animals for scheduled feeding, faster than traditional GUI apps.

<!-- * Table of Contents -->
<page-nav-print />

--------------------------------------------------------------------------------------------------------------------

<div style="page-break-after: always;"></div>

## Quick start

1. Ensure you have Java `17` or above installed in your Computer.<br>
   **Mac users:** Ensure you have the precise JDK version prescribed [here](https://se-education.org/guides/tutorials/javaInstallationMac.html).

2. Download the latest `.jar` file from [here](https://github.com/AY2526S1-CS2103T-W14-3/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your Furiends application.

4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar furiends.jar` command 
   to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)
   For more details on the GUI, refer to the [Overview of GUI](#overview-of-gui) section.

5. Type the command in the command box (displaying "Enter command here...") and press Enter to execute it.<br>
   Some simple commands you can try:

   * `help` : Shows the help page with the full list of commands.
   
   * `list` : Lists all contacts.

   * `clear` : Deletes all contacts.

   * `exit` : Exits the app.

6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

<div style="page-break-after: always;"></div>

## Overview of GUI
![Ui](images/Ui_explanation.png)

The GUI is made up of the following components:
1. **Options Panel**: Contains menu bars to exit (File > Exit) and open the help panel (Help > Help).
2. **Command Box**: Commands are entered in this text box. Press the Enter key to execute the command.
3. **Feedback Box**: The app displays the result of the executed command in this box.
4. **Person View**: Displays the list of persons stored in the address book.
5. **Animal View**: Displays the list of animals stored in the address book.

--------------------------------------------------------------------------------------------------------------------

<div style="page-break-after: always;"></div>

## Features

<box type="info" seamless>

**Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add person n/NAME...`, `NAME` is a parameter which can be used as `add person n/John Doe...`.

* Items in square brackets are optional.<br>
  e.g `n/NAME ... [t/TAG]` can be used as `n/John Doe ... t/friend` (friend tag added) 
  or as `n/John Doe ... `(no tag provided).

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters 
  (such as `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `list 123`, it will be interpreted as `list`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</box>

### Viewing help : `help`

Displays a window, which links to the user guide, as well as a list of commands. <br>

Format: `help [command]` <br>

The general help window (in the image below) can be opened by entering `help` in the command box.

![help message](images/helpMessage.png)

Each command is clickable to open another window, which shows additional details regarding the command's usage. <br>
This window can also be opened by entering `help <command>` in the command box. <br>
In the example below, when clicking the `help` command (as shown in the image above), a new window will pop up to show
the details of the `help` command and its usage. 
(The below window can also be opened by entering `help help` in the command box.)

![help window](images/helpWindowExample.png)

Clicking on the command format template will copy the command format to the command box in the main application window
and close this window. For example, clicking on the command format template `help <command name>` will copy 
the corresponding command format to the command box as shown below.

![automatic copying](images/helpAutomaticInput.png)

### Adding a person: `add person`

Adds a person to the address book.

Format: `add person n/NAME p/PHONE_NUMBER e/EMAIL [t/TAG]…​`

<box type="tip" seamless>

**Tip:** A person can have any number of tags (including 0)
</box>

Examples:
* `add person n/John Doe p/98765432 e/johnd@example.com`
* `add person n/Betsy Crowe t/friend e/betsycrowe@example.com p/1234567 t/criminal`

### Adding an animal: `add animal`

Adds an animal to the address book.

Format: `add animal n/NAME d/DESCRIPTION l/LOCATION [t/TAG]…​`

Examples:
* `add animal n/Fluffy d/White cat l/Ang Mo Kio t/shy`

### Listing all persons : `list`

Shows a list of all persons and animals in the address book.

Format: `list`

### Editing a person : `edit person`

Edits an existing person in the address book.

Format: `edit person NAME [n/NAME] [p/PHONE] [e/EMAIL] [t/TAG]… [f/ANIMAL_NAME dt/YYYY-MM-DD HH:MM]…​`

* Edits the person with the specified `NAME`. The name is case-sensitive.
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the person will be removed i.e adding of tags is not cumulative.
* You can remove all the person’s tags by typing `t/` without
    specifying any tags after it.
* To assign an animal to a person for feeding, include the `f/ANIMAL_NAME dt/YYYY-MM-DD HH:MM` field. <br>
The `ANIMAL_NAME` is the name of the animal to be assigned, and `YYYY-MM-DD HH:MM` is the date and time of feeding.

Examples:
*  `edit person John Doe p/91234567 e/johndoe@example.com` Edits the phone number and email address of the person 
    with name `John Doe` to be `91234567` and `johndoe@example.com` respectively.
*  `edit person Betty Crower n/Betsy Crower t/` Edits the name of the 2nd person to be `Betsy Crower` and 
    clears all existing tags.
*  `edit person Alice f/Fluffy dt/2024-07-01 10:00` Assigns the animal `Fluffy` to the person `Alice` for feeding on `1st July 2024, 10am`.

### Editing an animal : `edit animal`

Edits an existing animal in the address book.

Format: `edit animal NAME [n/NAME] [d/DESCRIPTION] [l/LOCATION] [t/TAG]…​`

* Edits the animal with the specified `NAME`. The name is case-sensitive.
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.

Examples:
*  `edit animal Fluffy l/Void Deck` Edits the location of the animal with name `Fluffy` to be `Void Deck`.
*  `edit animal Kitty n/Catty t/` Edits the name of the animal with name `Kitty` to be `Catty` and clears all existing tags.

### Locating persons by name: `find person`

Finds persons whose names contain any of the given keywords.

Format: `find person KEYWORD [MORE_KEYWORDS]...`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Substrings can be searched. e.g. `an` will match `Hans`, `Andy`
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `find person alex david` returns `Alex Yeoh`, `David Li`. Note that the 'animal' portion is still shown.<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)

### Locating animals by name: `find animal`

Finds animals whose names contain any of the given keywords.

Format: `find animal KEYWORD [MORE_KEYWORDS]...`

* The search is case-insensitive. e.g `fluffy` will match `Fluffy`
* The order of the keywords does not matter. e.g. `Cutie Pie` will match `Pie Cutie`
* Only the name is searched.
* Substrings can be matched e.g. `Fluff` will match `Fluffy` and `Kerfluff`
* Animals matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Cutie` will return `Cutie Pie`, `Cutie Patootie` (if both animals are stored in the application)

Examples:
* `find animal max luna` returns `Max`, `Luna`. Note that the 'person' portion is still shown.<br>
  ![result for 'find max luna'](images/findMaxLunaResult.png)

### Deleting a person : `delete person`

Deletes the specified person from the address book.

Format: `delete person n/NAME`

* Deletes the person with the specified `NAME`.
* The name is case-sensitive.

Examples:
* `delete person n/John Doe` Deletes the person with name `John Doe` from the address book.

### Deleting an animal : `delete animal`

Deletes the specified animal from the address book.

Format: `delete animal n/NAME`

* Deletes the animal with the specified `NAME`.
* The name is case-sensitive.

Examples:
* `delete animal n/Fluffy` Deletes the animal with name `Fluffy` from the address book.

### Clearing all entries : `clear`

Clears all entries from the address book.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

Furiends data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

AddressBook data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<box type="warning" seamless>

**Caution:**
If your changes to the data file makes its format invalid, Furiends will discard all data and start with an empty data file at the next run.  Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the AddressBook to behave in unexpected ways (e.g., if a value entered is outside the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</box>

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
2. **If you minimize the Help Window** and then run the `help` command (or use the `Help` menu, or the keyboard shortcut `F1`) again, the original Help Window will remain minimized, and no new Help Window will appear. The remedy is to manually restore the minimized Help Window.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action                | Format, Examples
----------------------|------------------------------------------------------------------------------------------------
**Add Person**        | `add person n/NAME p/PHONE_NUMBER e/EMAIL [t/TAG]…​`<br>e.g.,`add person n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague`
**Add Animal**        | `add animal n/NAME d/DESCRIPTION l/LOCATION [t/TAG]…​` <br> e.g., `add animal n/Fluffy d/White cat l/Ang Mo Kio`
**Clear**             | `clear`
**Delete Person**     | `delete person n/NAME`<br> e.g., `delete person n/John Doe`
**Delete Animal**     | `delete animal n/NAME`<br> e.g., `delete animal n/Fluffy`
**Edit Person**       | `edit person NAME [n/NAME] [p/PHONE] [e/EMAIL] [t/TAG]… [f/ANIMAL_NAME dt/YYYY-MM-DD HH:MM]…​`<br> e.g.,`edit person John Doe n/James Lee e/jameslee@example.com`
**Edit Animal**       | `edit animal NAME [n/NAME] [d/DESCRIPTION] [l/LOCATION] [t/TAG]…`<br> e.g., `edit animal Fluffy l/Void Deck`
**Exit**              | `exit`
**Find Person**       | `find person KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**Find Animal**       | `find animal KEYWORD [MORE_KEYWORDS]`<br> e.g., `find Fluffy Max`
**List**              | `list`
**Help**              | `help [COMMAND]`<br> e.g. `help` <br> e.g. `help add person`
