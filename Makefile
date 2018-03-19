all:
	mvn clean package
	mkdir -p output
	cp -rf "API/target/sikulixapi-1.1.2-SNAPSHOT.jar" output
	cp -rf "IDE/target/sikulix-1.1.2-SNAPSHOT.jar" output
	cp -rf "Setup/target/sikulixsetup-1.1.2-SNAPSHOT-forsetup.jar" output
	cp -rf "SetupAPI/target/sikulixsetupAPI-1.1.2-SNAPSHOT-forsetup.jar" output
	cp -rf "SetupIDE/target/sikulixsetupIDE-1.1.2-SNAPSHOT-forsetup.jar" output