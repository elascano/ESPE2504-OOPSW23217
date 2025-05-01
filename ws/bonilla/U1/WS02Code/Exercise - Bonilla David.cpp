/*CONSTRUYE UN PROGRAMA QUE AL RECIBIR COMO DATOS EL PESO, LA ALTURA Y EL GENERO DE N PERSONAS; OBTENGA EL PRIMEDIO
DEL PESO Y EL PROMEDIO DE LA ALTURA TANTO DE LA POBLACION MASCULINA COMO DE LA FEMENINA;
*/

#include<iostream>

using namespace std;

int main() {
    int totalPeople;
    double personWeight, personHeight;
    double sumWeightWomen = 0, averageWeightWomen = 0, sumHeightWomen = 0, averageHeightWomen = 0;
    double sumWeightMen = 0, averageWeightMen = 0, sumHeightMen = 0, averageHeightMen = 0;
    char personGender;
    int countMen = 0, countWomen = 0;

    cout << "Enter the number of people: ";
    cin >> totalPeople;
    cout << endl;

    for (int i = 1; i <= totalPeople; i++) {
        cout << "PERSON " << i << " DATA\n";

        // Gender validation
        do {
            cout << "Enter the gender of the person (M/F): ";
            cin >> personGender;
            if (personGender != 'M' && personGender != 'm' && personGender != 'F' && personGender != 'f') {
                cout << "Please enter a valid gender (M/F)" << endl;
            }
        } while (personGender != 'M' && personGender != 'm' && personGender != 'F' && personGender != 'f');

        // Collecting data based on gender
        if (personGender == 'M' || personGender == 'm') {
            cout << "Enter the weight (kg) of person " << i << ": ";
            cin >> personWeight;
            sumWeightMen += personWeight;
            cout << "Enter the height (m) of person " << i << ": ";
            cin >> personHeight;
            sumHeightMen += personHeight;
            cout << endl;
            countMen++;

        } else if (personGender == 'F' || personGender == 'f') {
            cout << "Enter the weight (kg) of person " << i << ": ";
            cin >> personWeight;
            sumWeightWomen += personWeight;
            cout << "Enter the height (m) of person " << i << ": ";
            cin >> personHeight;
            sumHeightWomen += personHeight;
            cout << endl;
            countWomen++;
        }
    }

    // Calculating averages
    if (countWomen > 0) {
        averageWeightWomen = sumWeightWomen / countWomen;
        averageHeightWomen = sumHeightWomen / countWomen;
    }
    if (countMen > 0) {
        averageWeightMen = sumWeightMen / countMen;
        averageHeightMen = sumHeightMen / countMen;
    }

    // Display results
    cout << "\nThe average weight of women is: " << averageWeightWomen << endl;
    cout << "The average height of women is: " << averageHeightWomen << endl;
    cout << "\nThe average weight of men is: " << averageWeightMen << endl;
    cout << "The average height of men is: " << averageHeightMen << endl;

    return 0;
}
