# FrogJump

# Overview
This project is an educational game designed to engage elementary students in mathematics through interactive play. The game features a frog navigating a pond by hopping on lily pads, each marked with a math problem. Players must solve these problems to advance, within a time limit. This design aligns with the cognitive development stages of its target age group, featuring vibrant visuals and adaptive challenges that match educational standards.

Key system requirements include a child-friendly interface, an account management system for progress tracking, and a dynamic problem-generation algorithm. The game offers various difficulty levels to accommodate different skill sets and includes an instructor dashboard for educators to monitor and adapt student learning strategies.

## Main Page
<img height="250" alt="main_page" src="https://github.com/AlanRuan0129/FrogJump/assets/109763379/467ccd21-e7dc-4fd6-ae90-6d25290a9794">

<img height="250" alt="new_user" src="https://github.com/AlanRuan0129/FrogJump/assets/109763379/3c61a436-a334-428c-8bef-f185467c8847">

## Game Page
<img height="300" alt="game_page_1" src="https://github.com/AlanRuan0129/FrogJump/assets/109763379/5ff4d1f1-0d88-4694-8ea6-3d83efdf6467">

<img height="300" width="405" alt="game_page_2" src="https://github.com/AlanRuan0129/FrogJump/assets/109763379/315c5085-0ea6-447d-a0e9-b6ad9efdb3e6">

## Prerequisites
Before you can run or build the Frog Jump game, ensure that you have the following prerequisites installed:

- **Java Development Kit (JDK)**
    - Version: 8 or higher
    - Download: [Oracle JDK](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)

- **Libraries**
    - **fastjson2**
        - Version: 2.0.47
        - Purpose: Used for JSON processing within the game.
        - Download: [fastjson2 on GitHub](https://github.com/alibaba/fastjson)
    - **jlayer**
        - Version: 1.0.1
        - Purpose: Facilitates music playback features in the game.
        - Download: Typically available as part of a larger library collection or can be obtained from [JavaZoom](http://www.javazoom.net/javalayer/javalayer.html)
    - **JUnit**
        - Version: 5.8.1
        - Purpose: Used for running unit tests to ensure code quality.
        - Download: [JUnit 5.8.1](https://junit.org/junit5/)

## Building from Source
1. Clone the repository: `https://github.com/AlanRuan0129/FrogJump.git`
2. Navigate to the project directory: `cd src`
3. Run the Starter.java file which serves as the entry point of the application.

## Running Pre-compiled Software
If a pre-compiled version is provided, follow these steps:
1. Ensure Java Runtime Environment (JRE) is installed on your system.
2. Execute the `FrogJump.jar` file.

## Usage
Launch the game and use the arrow keys to control the frog's movement. Answer math questions by typing the answers using your keyboard and press Enter to submit.

## Accounts

### New Players
- Click on the "New Player" button upon starting the game.
- Register by entering your chosen name and password.

### Returning Players
- Click on the "Old Player" button upon starting the game.
- Log in by entering your previously registered name and password.


## Teacher Mode
The game includes a Teacher Mode that allows educators to access progress reports and manage question sets. To log into Teacher Mode, you will only need the following password:
- Password: `123456`

## Additional Information
- Ensure your system's audio is on for the best experience, as the game features background music and sound effects.
- High scores and game data are saved locally in `data/data.json`.

## Technology Stack
- Java: The application is primarily written in Java, ensuring cross-platform compatibility.
- Swing: The graphical user interface is created using Java Swing, which provides a set of lightweight components for building rich desktop applications.
