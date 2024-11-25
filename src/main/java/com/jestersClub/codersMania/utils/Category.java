package com.jestersClub.codersMania.utils;

public enum Category {

    // Programming Languages
    JAVA("Java Programming"),
    PYTHON("Python Programming"),
    C_PLUS_PLUS("C++ Programming"),
    JAVASCRIPT("JavaScript Programming"),
    C_SHARP("C# Programming"),
    RUBY("Ruby Programming"),
    GO("Go Programming"),
    SWIFT("Swift Programming"),
    PHP("PHP Programming"),
    R("R Programming"),

    // Core Computer Science
    DSA("Data Structures and Algorithms"),
    OOPS("Object-Oriented Programming"),
    COMPILER_DESIGN("Compiler Design"),
    OPERATING_SYSTEMS("Operating Systems"),
    DATABASE_MANAGEMENT_SYSTEM("Database Management Systems"),
    COMPUTER_ARCHITECTURE("Computer Architecture"),
    SOFTWARE_ENGINEERING("Software Engineering"),
    ARTIFICIAL_INTELLIGENCE("Artificial Intelligence"),
    MACHINE_LEARNING("Machine Learning"),
    DEEP_LEARNING("Deep Learning"),

    // Web Development
    HTML("HTML"),
    CSS("CSS"),
    REACT_JS("ReactJS"),
    NODE_JS("NodeJS"),
    ANGULAR_JS("AngularJS"),
    FULL_STACK_DEVELOPMENT("Full Stack Development"),

    // Cloud & DevOps
    AWS("Amazon Web Services (AWS)"),
    AZURE("Microsoft Azure"),
    GOOGLE_CLOUD_PLATFORM("Google Cloud Platform"),
    DOCKER("Docker"),
    KUBERNETES("Kubernetes"),
    DEVOPS("DevOps Practices"),

    // Cybersecurity & Networking
    COMPUTER_NETWORKING("Computer Networking"),
    CYBERSECURITY("Cybersecurity"),
    ETHICAL_HACKING("Ethical Hacking"),
    CRYPTOGRAPHY("Cryptography"),
    FIREWALLS("Firewalls"),
    PENETRATION_TESTING("Penetration Testing"),

    // Data & Big Data
    DATA_SCIENCE("Data Science"),
    BIG_DATA("Big Data"),
    HADOOP("Hadoop"),
    APACHE_SPARK("Apache Spark"),
    SQL("SQL"),
    NOSQL("NoSQL"),

    // Mobile Development
    ANDROID_DEVELOPMENT("Android Development"),
    IOS_DEVELOPMENT("iOS Development"),
    FLUTTER("Flutter"),
    REACT_NATIVE("React Native"),

    // Miscellaneous
    BLOCKCHAIN("Blockchain"),
    INTERNET_OF_THINGS("Internet of Things (IoT)"),
    CLOUD_COMPUTING("Cloud Computing"),
    NATURAL_LANGUAGE_PROCESSING("Natural Language Processing"),
    COMPUTER_GRAPHICS("Computer Graphics"),
    HUMAN_COMPUTER_INTERACTION("Human-Computer Interaction");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
