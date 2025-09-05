
//package com.example.cargearviewer


/*import android.annotation.SuppressLint
import android.car.Car
import android.car.VehiclePropertyIds
import android.car.hardware.property.CarPropertyManager
import android.car.hardware.CarPropertyValue
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var car: Car
    private lateinit var carPropertyManager: CarPropertyManager

    private lateinit var textResult: TextView

    companion object {
        const val ENGINE_COOLANT_TEMP = VehiclePropertyIds.ENGINE_COOLANT_TEMP
        const val ABS_ACTIVE = VehiclePropertyIds.ABS_ACTIVE
        const val ENGINE_OIL_TEMP = VehiclePropertyIds.ENGINE_OIL_TEMP
        const val HAZARD_LIGHTS_SWITCH = VehiclePropertyIds.HAZARD_LIGHTS_SWITCH
        const val TIRE_PRESSURE = VehiclePropertyIds.TIRE_PRESSURE
        const val FUEL_LEVEL = VehiclePropertyIds.FUEL_LEVEL
        const val EV_BATTERY_LEVEL = 291504905

    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonReadAbs: Button = findViewById(R.id.button_read_abs)
        val buttonReadTemp: Button = findViewById(R.id.button_read_temp)
        val buttonReadOilTemp: Button = findViewById(R.id.button_read_oil_temp)
        val buttonReadHazard: Button = findViewById(R.id.button_read_hazard)
        val buttonReadTire: Button = findViewById(R.id.button_read_tire_pressure)
        val buttonReadFuel: Button = findViewById(R.id.button_read_fuel)
        val buttonReadBattery: Button = findViewById(R.id.button_read_ev_battery)


        textResult = findViewById(R.id.text_result)
  // ça connecte direct
// plus besoin de car.connect()

        car = Car.createCar(this)
        if (!car.isConnected) {
            car.connect()
        }


        carPropertyManager = car.getCarManager(Car.PROPERTY_SERVICE) as CarPropertyManager

        buttonReadAbs.setOnClickListener {
            readAbsState()
        }

        buttonReadTemp.setOnClickListener {
            readEngineCoolantTemp()
        }
        buttonReadOilTemp.setOnClickListener {
            readEngineCoolantOilTemp()
        }
        buttonReadHazard.setOnClickListener {
            readHazardLightState()
        }
        buttonReadTire.setOnClickListener {
            readTirePressure()
        }
        buttonReadFuel.setOnClickListener {
            readFuelLevel()
        }
        buttonReadBattery.setOnClickListener {
            readEvBatteryLevel()
        }

    }

    @SuppressLint("SetTextI18n")
    private fun readAbsState() {
        val absActiveValue: CarPropertyValue<Boolean>? =
            carPropertyManager.getProperty(Boolean::class.java, ABS_ACTIVE, 0)
        textResult.text = "État de l'ABS: ${absActiveValue?.value}"
    }

    @SuppressLint("SetTextI18n")
    private fun readEngineCoolantTemp() {
        val coolantTempValue: CarPropertyValue<Float>? =
            carPropertyManager.getProperty(Float::class.java, ENGINE_COOLANT_TEMP, 0)
        textResult.text = "Température du liquide de refroidissement: ${coolantTempValue?.value} °C"
    }

    @SuppressLint("SetTextI18n")
    private fun readEngineCoolantOilTemp() {
        val coolantOilTempValue: CarPropertyValue<Float>? =
            carPropertyManager.getProperty(Float::class.java, ENGINE_OIL_TEMP, 0)
        textResult.text = "Température d’huile moteur: ${coolantOilTempValue?.value} °C"
    }
    @SuppressLint("SetTextI18n")
    private fun readHazardLightState() {
        val value: CarPropertyValue<Int>? =
            carPropertyManager.getProperty(Int::class.java, HAZARD_LIGHTS_SWITCH, 0)
        val state = if (value?.value == 1) "Activés" else "Désactivés"
        textResult.text = "Feux de détresse : $state"
    }

    @SuppressLint("SetTextI18n")
    private fun readTirePressure() {
        val config = carPropertyManager.propertyList
            .find { it.propertyId == TIRE_PRESSURE }

        val tireAreaIds = config?.areaIds
        if (tireAreaIds != null) {
            val pressures = tireAreaIds.map { areaId ->
                val pressure = carPropertyManager.getProperty(Float::class.java, TIRE_PRESSURE, areaId)
                "Zone $areaId : ${pressure?.value} kPa"
            }
            textResult.text = pressures.joinToString("\n")
        } else {
            textResult.text = "Pression des pneus non dispo"
        }

    }
    @SuppressLint("SetTextI18n")
    private fun readFuelLevel() {
        try {
            val value = carPropertyManager.getProperty(Float::class.java, FUEL_LEVEL, 0)
            textResult.text = "Niveau de carburant : ${value?.value ?: "Inconnu"} mL"
        } catch (e: SecurityException) {
            textResult.text = "⚠️ Permission refusée pour lire le niveau de carburant"
        } catch (e: Exception) {
            textResult.text = "Erreur carburant : ${e.message}"
        }
    }

    @SuppressLint("SetTextI18n")
    private fun readEvBatteryLevel() {
        try {
            val value = carPropertyManager.getProperty(Float::class.java, 291504905, 0) // EV_BATTERY_LEVEL constant
            textResult.text = "Niveau batterie EV : ${value?.value ?: "Inconnu"} Wh"
        } catch (e: SecurityException) {
            textResult.text = "⚠️ Permission refusée pour lire le niveau batterie EV"
        } catch (e: Exception) {
            textResult.text = "Erreur lecture batterie EV : ${e.message}"
        }
    }




    override fun onDestroy() {
        super.onDestroy()
        car.disconnect()
    }
}

private fun CarPropertyManager.getPropertyConfig(i: Int) {}*/

/*
package com.example.cargearviewer

import android.annotation.SuppressLint
import android.car.Car
import android.car.VehiclePropertyIds
import android.car.hardware.CarPropertyValue
import android.car.hardware.property.CarPropertyManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var car: Car
    private lateinit var carPropertyManager: CarPropertyManager
    private lateinit var textResult: TextView

    private val handler = Handler(Looper.getMainLooper())
    private val TAG = "CarGearViewer"

    companion object {
        const val ENGINE_COOLANT_TEMP = VehiclePropertyIds.ENGINE_COOLANT_TEMP
        const val ABS_ACTIVE = VehiclePropertyIds.ABS_ACTIVE
        const val ENGINE_OIL_TEMP = VehiclePropertyIds.ENGINE_OIL_TEMP
        const val HAZARD_LIGHTS_SWITCH = VehiclePropertyIds.HAZARD_LIGHTS_SWITCH
        const val TIRE_PRESSURE = VehiclePropertyIds.TIRE_PRESSURE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonReadAbs: Button = findViewById(R.id.button_read_abs)
        val buttonReadTemp: Button = findViewById(R.id.button_read_temp)
        val buttonReadOilTemp: Button = findViewById(R.id.button_read_oil_temp)
        val buttonReadHazard: Button = findViewById(R.id.button_read_hazard)
        val buttonReadTire: Button = findViewById(R.id.button_read_tire_pressure)
        textResult = findViewById(R.id.text_result)

        car = Car.createCar(this)
        car.connect()

        // Attente asynchrone de la connexion
        handler.postDelayed(object : Runnable {
            override fun run() {
                if (car.isConnected) {
                    try {
                        carPropertyManager = car.getCarManager(Car.PROPERTY_SERVICE) as CarPropertyManager

                        // Connecter les boutons
                        buttonReadAbs.setOnClickListener { readAbsState() }
                        buttonReadTemp.setOnClickListener { readEngineCoolantTemp() }
                        buttonReadOilTemp.setOnClickListener { readEngineCoolantOilTemp() }
                        buttonReadHazard.setOnClickListener { readHazardLightState() }
                        buttonReadTire.setOnClickListener { readTirePressure() }

                        textResult.text = "Voiture connectée ✅"
                        Log.d(TAG, "Voiture connectée")
                    } catch (e: Exception) {
                        textResult.text = "Erreur : ${e.message}"
                        Log.e(TAG, "Erreur lors de l'init du car manager", e)
                    }
                } else {
                    handler.postDelayed(this, 500) // réessaie plus tard
                }
            }
        }, 500)
    }

    @SuppressLint("SetTextI18n")
    private fun readAbsState() {
        val value = carPropertyManager.getProperty(Boolean::class.java, ABS_ACTIVE, 0)
        textResult.text = "ABS actif : ${value?.value ?: "Inconnu"}"
    }

    @SuppressLint("SetTextI18n")
    private fun readEngineCoolantTemp() {
        val value = carPropertyManager.getProperty(Float::class.java, ENGINE_COOLANT_TEMP, 0)
        textResult.text = "Température liquide refroidissement : ${value?.value ?: "Inconnu"} °C"
    }

    @SuppressLint("SetTextI18n")
    private fun readEngineCoolantOilTemp() {
        val value = carPropertyManager.getProperty(Float::class.java, ENGINE_OIL_TEMP, 0)
        textResult.text = "Température huile moteur : ${value?.value ?: "Inconnu"} °C"
    }

    @SuppressLint("SetTextI18n")
    private fun readHazardLightState() {
        val value = carPropertyManager.getProperty(Int::class.java, HAZARD_LIGHTS_SWITCH, 0)
        val state = if (value?.value == 1) "Activés" else "Désactivés"
        textResult.text = "Feux de détresse : $state"
    }

    @SuppressLint("SetTextI18n")
    private fun readTirePressure() {
        val config = carPropertyManager.propertyList.find { it.propertyId == TIRE_PRESSURE }
        val tireAreaIds = config?.areaIds

        if (tireAreaIds != null) {
            val pressures = tireAreaIds.map { areaId ->
                val pressure = carPropertyManager.getProperty(Float::class.java, TIRE_PRESSURE, areaId)
                "Zone $areaId : ${pressure?.value ?: "Inconnu"} kPa"
            }
            textResult.text = pressures.joinToString("\n")
        } else {
            textResult.text = "Pression des pneus non disponible"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::car.isInitialized) {
            car.disconnect()
        }
    }
}

*/
package com.example.cargearviewer

import android.annotation.SuppressLint
import android.car.Car
import android.car.VehiclePropertyIds
import android.car.hardware.CarPropertyValue
import android.car.hardware.property.CarPropertyManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.pm.PackageManager


class MainActivity : AppCompatActivity() {

    private lateinit var car: Car
    private lateinit var carPropertyManager: CarPropertyManager

    private lateinit var textResult: TextView

    companion object {
        const val ENGINE_COOLANT_TEMP = VehiclePropertyIds.ENGINE_COOLANT_TEMP
        const val ABS_ACTIVE = VehiclePropertyIds.ABS_ACTIVE
        const val ENGINE_OIL_TEMP = VehiclePropertyIds.ENGINE_OIL_TEMP
        const val HAZARD_LIGHTS_SWITCH = VehiclePropertyIds.HAZARD_LIGHTS_SWITCH
        const val TIRE_PRESSURE = VehiclePropertyIds.TIRE_PRESSURE
        const val FUEL_LEVEL = VehiclePropertyIds.FUEL_LEVEL
        const val EV_BATTERY_LEVEL = 291504905
        const val ENV_OUTSIDE_TEMPERATURE = 291505923

        private const val PERMISSION_REQUEST_CODE = 1234
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textResult = findViewById(R.id.text_result)

        val buttonReadAbs: Button = findViewById(R.id.button_read_abs)
        val buttonReadTemp: Button = findViewById(R.id.button_read_temp)
        val buttonReadOilTemp: Button = findViewById(R.id.button_read_oil_temp)
        val buttonReadHazard: Button = findViewById(R.id.button_read_hazard)
        val buttonReadTire: Button = findViewById(R.id.button_read_tire_pressure)
        val buttonReadFuel: Button = findViewById(R.id.button_read_fuel)
        val buttonReadBattery: Button = findViewById(R.id.button_read_ev_battery)
        val buttonReadOutsideTemp: Button = findViewById(R.id.button_read_outside_temp)

        // Permission CAR_ENERGY (dangerous) à demander au runtime
        if (checkSelfPermission("android.car.permission.CAR_ENERGY") != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf("android.car.permission.CAR_ENERGY"), PERMISSION_REQUEST_CODE)
        } else {
            setupCar()
        }

        buttonReadAbs.setOnClickListener { readAbsState() }
        buttonReadTemp.setOnClickListener { readEngineCoolantTemp() }
        buttonReadOilTemp.setOnClickListener { readEngineCoolantOilTemp() }
        buttonReadHazard.setOnClickListener { readHazardLightState() }
        buttonReadTire.setOnClickListener { readTirePressure() }
        buttonReadFuel.setOnClickListener { readFuelLevel() }
        buttonReadBattery.setOnClickListener { readEvBatteryLevel() }
        buttonReadOutsideTemp.setOnClickListener { readOutsideTemperature() }
    }

    private fun setupCar() {
        car = Car.createCar(this)
        if (!car.isConnected) car.connect()
        carPropertyManager = car.getCarManager(Car.PROPERTY_SERVICE) as CarPropertyManager
    }

    @SuppressLint("SetTextI18n")
    private fun readAbsState() {
        val absActiveValue: CarPropertyValue<Boolean>? =
            carPropertyManager.getProperty(Boolean::class.java, ABS_ACTIVE, 0)
        textResult.text = "État de l'ABS: ${absActiveValue?.value ?: "Inconnu"}"
    }

    @SuppressLint("SetTextI18n")
    private fun readEngineCoolantTemp() {
        val coolantTempValue: CarPropertyValue<Float>? =
            carPropertyManager.getProperty(Float::class.java, ENGINE_COOLANT_TEMP, 0)
        textResult.text = "Température liquide refroidissement : ${coolantTempValue?.value ?: "Inconnu"} °C"
    }

    @SuppressLint("SetTextI18n")
    private fun readEngineCoolantOilTemp() {
        val coolantOilTempValue: CarPropertyValue<Float>? =
            carPropertyManager.getProperty(Float::class.java, ENGINE_OIL_TEMP, 0)
        textResult.text = "Température huile moteur : ${coolantOilTempValue?.value ?: "Inconnu"} °C"
    }

    @SuppressLint("SetTextI18n")
    private fun readHazardLightState() {
        val value: CarPropertyValue<Int>? =
            carPropertyManager.getProperty(Int::class.java, HAZARD_LIGHTS_SWITCH, 0)
        val state = if (value?.value == 1) "Activés" else "Désactivés"
        textResult.text = "Feux de détresse : $state"
    }

    @SuppressLint("SetTextI18n")
    private fun readTirePressure() {
        val config = carPropertyManager.propertyList.find { it.propertyId == TIRE_PRESSURE }
        val tireAreaIds = config?.areaIds
        if (tireAreaIds != null && tireAreaIds.isNotEmpty()) {
            val pressures = tireAreaIds.map { areaId ->
                val pressure = carPropertyManager.getProperty(Float::class.java, TIRE_PRESSURE, areaId)
                "Zone $areaId : ${pressure?.value ?: "N/A"} kPa"
            }
            textResult.text = pressures.joinToString("\n")
        } else {
            textResult.text = "Pression des pneus non disponible"
        }
    }

    @SuppressLint("SetTextI18n")
    private fun readFuelLevel() {
        try {
            val value = carPropertyManager.getProperty(java.lang.Float::class.java, FUEL_LEVEL, 0)
            textResult.text = "Niveau de carburant : ${value?.value ?: "Inconnu"} mL"
        } catch (e: SecurityException) {
            textResult.text = "⚠️ Permission refusée pour lire le niveau de carburant"
        } catch (e: Exception) {
            textResult.text = "Erreur carburant : ${e.message}"
        }
    }

    @SuppressLint("SetTextI18n")
    private fun readEvBatteryLevel() {
        try {
            val value = carPropertyManager.getProperty(java.lang.Float::class.java, EV_BATTERY_LEVEL, 0)
            textResult.text = "Niveau batterie EV : ${value?.value ?: "Inconnu"} Wh"
        } catch (e: SecurityException) {
            textResult.text = "⚠️ Permission refusée pour lire le niveau batterie EV"
        } catch (e: Exception) {
            textResult.text = "Erreur lecture batterie EV : ${e.message}"
        }
    }

    @SuppressLint("SetTextI18n")
    private fun readOutsideTemperature() {
        try {
            val value = carPropertyManager.getProperty(Float::class.javaObjectType, ENV_OUTSIDE_TEMPERATURE, 0)
            textResult.text = "Température extérieure : ${value?.value ?: "Inconnue"} °C"
        } catch (e: SecurityException) {
            textResult.text = "⚠️ Permission refusée pour lire la température extérieure"
        } catch (e: Exception) {
            textResult.text = "Erreur température : ${e.message}"
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                textResult.text = "✅ Permission CAR_ENERGY accordée"
                setupCar()
            } else {
                textResult.text = "❌ Permission CAR_ENERGY refusée"
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::car.isInitialized && car.isConnected) {
            car.disconnect()
        }
    }
}
