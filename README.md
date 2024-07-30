Steps to work with JavaFx on Eclipse
Download the SDK attached.
Right-click on your project in Eclipse and go to Properties.
Navigate to Java Build Path and click on the Libraries tab.
Click on Modulepath and then Add External JARs.
Select all the JAR files from the lib directory of your downloaded JavaFX SDK.
Go to Run > Run Configurations.
Select your Java application under Java Application.
Go to the Arguments tab.
--module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml
Replace /path/to/javafx-sdk/lib with the actual path to the lib directory of your JavaFX SDK.
