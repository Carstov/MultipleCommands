# MultipleCommands - 1.7.10
MultipleCommands ist eine Minecraft Mod für die Version 1.7.10,
die mehrere QOL features durch Befehle implementiert. Das
hauptfeature ist hierbei, das es dem Spieler ermöglicht, 
durch Befehle Teleportpunkte zu setzen und sich jederzeit dorthin zurückzuteleportieren können.
__
__
## Befehle
/sethome <name>   # Setzt einen Teleportationspunkt__
/home <name>      # Teleportiert sich zu einem Teleportationspunkt__
/homelist         # Zeigt eine Liste aller Teleportationspunkte an__
/delhome <name>   # Löscht einen Teleportationspunkt__
/back             # Teleportiert sich zum letzten teleportierten Teleportationspunkt oder zum letzten Todespunkt__
/day              # Setzt die Zeit auf den Tag zurück__
/night            # Setzt die Zeit auf die Nacht zurück__
/rain             # Lässt es regnen__
/sun              # Stoppt den Regen__
__
__
## Teleportationssystem
Wenn ein Spieler einen Teleportationspunkt erstellt, 
werden alle notwendigen Informationen, wie  SpielerID, Name, X, Y, Z, DimensionsID
in einer .txt Datei gespeichert. Wenn der Spieler sich zum Teleportationspunkt
teleportieren möchten, werden die Daten aus der .txt Datei ausgelesen.
Die Teleportationspunkte befinden sich in "world\multiplecommands\multiplecommands.txt"
und werden im folgenden Format abgespeichert [SpielerID, Name, X, Y, Z, DimensionsID].
