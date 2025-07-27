# 🛫 Yatra Calendar Automation - Lowest Fare Finder

This project automates the process of finding the **lowest available flight fares** on the [Yatra](https://www.yatra.com/) website for both the **current** and **next month**.  

Inspired by a real-world automation challenge shared by **Amod Mahajan**, this project showcases handling complex web elements like dynamic calendars, unpredictable pop-ups, and DOM-based data extraction.

## 📌 Problem Statement

**Objective:**  
- Automate flight search flow to extract flight prices from the Departure Date calendar.  
- Compare prices for the current and next month.  
- Identify the **cheapest travel date** from each of the two months.

## 🛠 Tech Stack

- **Language:** Java 11  
- **Automation Tool:** Selenium WebDriver 4.33.0  
- **Build Tool:** Maven  
- **IDE:** Eclipse  
- **Locators:** XPath  
- **Testing Framework:** (Optional - can integrate with TestNG or JUnit if extended further)

## ✅ Key Operations Performed

1. Launches the Yatra website using Selenium WebDriver  
2. Handles unexpected login/signup pop-up gracefully  
3. Opens and interacts with the Departure Date calendar  
4. Extracts flight prices and corresponding dates from current and next month  
5. Compares extracted data to find the lowest fares  
6. Displays the cheapest fare for both months in the console output

## 🚀 How to Run

1. Clone the repository  
   ```bash
   git clone https://github.com/NitishBahe/Yatra-Automation-Solution.git

2. Navigate to the project directory and open it in your IDE

3. Ensure all dependencies are downloaded via Maven
   mvn clean install
4. Run the main Java class: YatraLowestFareFinder.java

💡 Future Enhancements (Optional)
Integrate test framework like TestNG

Convert to a full-fledged test suite

Add logging and reporting support

Include support for multiple browsers via WebDriverManager

🙏 Acknowledgements
Challenge inspired by Amod Mahajan

Special thanks to Jatin Sharma for guidance and support

Disclaimer: This project is intended for educational and skill demonstration purposes only. It does not involve any commercial use of the Yatra website.

📎 Related Tags
#selenium #java #automation #xpath #calendarautomation #sdet #yatra
