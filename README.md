# MultipleCommands - 1.7.10
MultipleCommands ist eine Minecraft Mod für die Version 1.7.10,
die mehrere QOL features durch Befehle implementiert. Das
hauptfeature ist hierbei, das es dem Spieler ermöglicht, 
durch Befehle Teleportpunkte zu setzen und sich jederzeit dorthin zurückzuteleportieren können.


## Befehle
/sethome <name>   # Setzt einen Teleportationspunkt
/home <name>      # Teleportiert sich zu einem Teleportationspunkt
/homelist         # Zeigt eine Liste aller Teleportationspunkte an
/delhome <name>   # Löscht einen Teleportationspunkt
/back             # Teleportiert sich zum letzten teleportierten Teleportationspunkt oder zum letzten Todespunkt
/day              # Setzt die Zeit auf den Tag zurück
/night            # Setzt die Zeit auf die Nacht zurück
/rain             # Lässt es regnen
/sun              # Stoppt den Regen


## Teleportationssystem
Wenn ein Spieler einen Teleportationspunkt erstellt, 
werden alle notwendigen Informationen, wie  SpielerID, Name, X, Y, Z, DimensionsID
in einer .txt Datei gespeichert. Wenn der Spieler sich zum Teleportationspunkt
teleportieren möchten, werden die Daten aus der .txt Datei ausgelesen.
Die Teleportationspunkte befinden sich in "world\multiplecommands\multiplecommands.txt"
und werden im folgenden Format abgespeichert [SpielerID, Name, X, Y, Z, DimensionsID].
