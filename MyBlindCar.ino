#define NUMBER_OF_SENSORS 5
#define SERIAL_SPEED 9600
// Macro for performing common actions along sensors.
#define FOR_EACH(ACTION, ARR) for(int i = 0; i < NUMBER_OF_SENSORS; i++) (*ACTION)(ARR[i]);

typedef struct sensor{
    int portNumber;
    int state;
}Sensor;

Sensor SENSORS[NUMBER_OF_SENSORS] = {
    {A0, 0.0d},
    {A1, 0.0d},
    {A2, 0.0d},
    {A3, 0.0d},
    {A4, 0.0d}
};

void updateSensor(Sensor* sensor){sensor -> state = analogRead(sensor -> portNumber);}

void updatesSensors(){
    FOR_EACH(&updateSensor, &SENSORS);
}

void printSensor(Sensor* sensor){
    Serial.print(sensor -> state);
    Serial.print(";");
}
void printSensors(){
    FOR_EACH(&printSensor, &SENSORS);
    Serial.print("\n");
}


void setup(){
    Serial.begin(9600);
}

void loop() {
    printSensors();
    delay(50);
    updatesSensors();
}

