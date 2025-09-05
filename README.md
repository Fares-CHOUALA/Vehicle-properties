# Vehicle Properties Reader (AAOS)

**Android application developed in Kotlin to read non-privileged Android system properties on AAOS via VHAL.**

## English version

---

## Overview
This application allows reading of non-privileged Android properties on Android Automotive OS (AAOS) devices through the Vehicle Hardware Abstraction Layer (VHAL).  
VHAL acts as the **sole intermediary between AAOS and the vehicle bus (e.g., CAN bus)**, providing structured and secure access to vehicle data.  
The app provides clear insights into selected vehicle properties for monitoring and analysis.

---

## Features
- Read **non-privileged Android properties** on AAOS only  
- Access selected vehicle data via VHAL  
- VHAL is the **sole intermediary between AAOS and the vehicle bus (e.g., CAN)**  
- Lightweight and optimized for performance  
- User-friendly interface for clear monitoring of vehicle data

---

## Installation
1. Clone the repository:  
```bash
git clone https://github.com/Fares-CHOUALA/Vehicle-properties.git
```
2.Open the project in Android Studio

3.Ensure your environment targets AAOS-compatible devices or emulator

4.Build the application

5.Install the APK on your device using ADB:
```bash
adb -s <device_serial> install -t "<path_to_your_project>/automotive/build/intermediates/apk/debug/automotive-debug.apk"
```
Note: You might see an error when launching the application. You can ignore it and proceed with running the ADB install command.
6. Grant any necessary permissions to access Android properties

---

## Usage
Launch the application on the automotive system to begin diagnostics.

---

## Future Enhancements
Explore access to privileged vehicle properties for expanded diagnostics.


---


## License

This project is licensed under the **MIT License** – see the [LICENSE](LICENSE) file for details.

---


## Version francaise

# Lecteur de Propriétés Véhicule (AAOS)

**Application Android développée en Kotlin pour lire les propriétés Android non privilégiées sur AAOS via VHAL.**

---

## Aperçu
Cette application permet de lire les propriétés Android non privilégiées sur les appareils Android Automotive OS (AAOS) via le Vehicle Hardware Abstraction Layer (VHAL).  
Le VHAL agit comme **le seul intermédiaire entre AAOS et le bus véhicule (ex. bus CAN)**, offrant un accès structuré et sécurisé aux données du véhicule.  
L’application fournit des informations claires sur certaines propriétés du véhicule pour le suivi et l’analyse.

---

## Fonctionnalités
- Lecture des **propriétés Android non privilégiées** uniquement sur AAOS  
- Accès aux données sélectionnées du véhicule via VHAL  
- VHAL est **le seul intermédiaire entre AAOS et le bus véhicule (ex. CAN)**  
- Application légère et optimisée pour la performance  
- Interface conviviale pour un suivi clair des données du véhicule

---

## Installation
1. Cloner le dépôt :  
```bash
git clone https://github.com/Fares-CHOUALA/Vehicle-properties.git
```
2. Ouvrir le projet dans **Android Studio**

3. Vérifier que votre environnement cible des **appareils ou émulateurs compatibles AAOS**

4. Compiler l’application

5. Installer l’APK sur votre appareil via ADB :
```bash
adb -s <device_serial> install -t "<path_to_your_project>/automotive/build/intermediates/apk/debug/automotive-debug.apk"
```
Remarque : Vous pourriez voir une erreur lors du lancement de l’application. Vous pouvez l’ignorer et continuer en exécutant la commande d’installation ADB.

6. Accorder toutes les permissions nécessaires pour accéder aux propriétés Android

---

## Utilisation
- Lancer l’application sur le système automobile pour commencer le diagnostic.

---

## Améliorations Futures
- Explorer l’accès aux propriétés véhicules privilégiées pour étendre les diagnostics.

---

## Licence
Ce projet est sous licence **MIT** – voir le fichier [LICENSE](LICENSE) pour les détails.

---
